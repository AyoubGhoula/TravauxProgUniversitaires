class Etudiant:
    def __init__(self,nom,note1,note2):
        self.nom=nom
        self.note1=note1
        self.note2=note2
    def calc_moy(self):
        return (self.note1+self.note2)/2
    def afficher(self):
        print("nom:",self.nom)
        print("note1:",self.note1)
        print("note2:",self.note2)
        print("moyenne:",self.calc_moy())
if __name__=="__main__":
    nom=input("donner nom: ")
    note1=int(input("donner note1: "))
    note2=int(input("donner note2: "))
    e1=Etudiant(nom,note1,note2)
    e1.afficher()