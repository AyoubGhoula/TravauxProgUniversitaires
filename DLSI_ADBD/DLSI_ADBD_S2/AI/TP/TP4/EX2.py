class CompteBancaire:
    def __init__(self,nmCompte,nom,solde):
        self.nmCompte=nmCompte
        self.nom=nom
        self.sold=solde
        
    def Versement(self):
        montant=float(input("donner le montant de versement : "))
        if montant > 0:
            self.sold += montant
            print(f"Versement de {montant} effectué avec succès.")
        else:
            print("Le montant du versement doit être supérieur à zéro.")
    def Retrait(self):
        montant=float(input("donner le montant de retrait : "))
        if 0 < montant <= self.sold:
            self.sold -= montant
            print(f"Retrait de {montant} effectué avec succès.")
        else:
            print("Le montant du retrait est invalide ou dépasse le solde.")
    def Agios(self):
        agios = self.sold * 0.05
        self.sold -= agios
        print(f"Agios de {agios} appliqués avec succès.")
    def afficher(self):
        return f"numeroCompte: {self.nmCompte}, nom: {self.nom}, solde {self.sold}."
if __name__=="__main__":
    compteBancaire=CompteBancaire(1233221,"Ayoub",1200)
    print(compteBancaire.afficher())
    compteBancaire.Versement()
    print(compteBancaire.afficher())
    compteBancaire.Retrait()
    print(compteBancaire.afficher())
    compteBancaire.Agios()
    print(compteBancaire.afficher())
