class Book:
    def __init__(self,titre,auteur,prix):
        self.titre=titre
        self.auteur=auteur
        self.prix=prix
    def view(self):
        print("Title:", self.titre)
        print("Author:", self.auteur)
        print("Price:", self.prix)
if  __name__=="__main__":
    book=Book("mitwahich","ayoub",123)
    book.view()