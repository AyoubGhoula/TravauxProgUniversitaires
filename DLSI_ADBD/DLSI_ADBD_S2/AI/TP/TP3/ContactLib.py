format_adresse="numero,nom,code postal,region"
class  Personne:
    def __init__(self, nom, prenom, telephone=None, email=None, adresse=None):
        self.nom = nom
        self.prenom = prenom
        self.telephone = telephone
        self.email = email
        self.__adresse = adresse 
   
    def region(self):
        if self.__adresse is not None:
            parts=self.__adresse.split(",")
            if "region" in format_adresse:
                index_region=format_adresse.split(",").index("region")
                if index_region<len(parts):
                    region =parts[index_region].strip()
                    return f"region:{region} commue"
                return"region inconnue"
        else:
            return "region inconnue"      
        
    def __str__(self):
        return f"{self.nom} {self.prenom} - {self.region()}"
def inf_Personne ():
    nom,pernom,tele,mail,adresse=map(str,input("enter les information de personne avec espace : ").split())
    personne=Personne(nom,pernom,tele,mail,adresse)
    return personne
def afiiche(list_personnes):
    for personne in list_personnes:
        print(personne)
def sup_personne(list_personnes):
    nom=input("donner le nome de persoone qui supprime : ")
    prenom=input("donner le prenome de persoone qui supprime : ")
    for personne in list_personnes:
        if personne.nom == nom and prenom == personne.prenom:
            list_personnes.remove(personne)
            print("supprime avec secee")
            break
        
if __name__=="__main__":
    n=int(input("donner nb de personne : "))
    list_personnes=[inf_Personne () for _ in range(n)]
    afiiche(list_personnes)
    sup_personne(list_personnes)
    afiiche(list_personnes)





