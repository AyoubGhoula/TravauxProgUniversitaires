package test_prototype;

public class Document implements Prototype {
private String titre;
private String contenu;

public Document(String titre, String contenu) {
this.titre = titre;
this.contenu = contenu;}

public void setTitre(String titre) { this.titre = titre; }

public void setContenu(String contenu) { this.contenu = contenu; }

@Override
public Prototype clonePrototype() {

return new Document(this.titre, this.contenu);}}