package test_prototype;

public class Main {

	
	
	public static void main(String[] args) {
		Prototype prototypeDoc = new Document("Modèle", "Texte par défaut");
		Document copie1 = (Document) prototypeDoc.clonePrototype();
		copie1.setTitre("Rapport A");
		Document copie2 = (Document) prototypeDoc.clonePrototype();
		copie2.setTitre("Rapport B");
		System.out.println("Prototype : " + prototypeDoc);
		System.out.println("Copie 1 : " + copie1);
		System.out.println("Copie 2 : " + copie2);
	}

}

/* interface prototype  
qui va implementer formule     
les obj qui va modif est touchhey      */
