package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Personne;
import service.Annuaire;


@WebServlet("/inserer")
public class InsererPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsererPersonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
private Annuaire annuaire;
    
    @Override
    public void init() throws ServletException {
        annuaire = Annuaire.getInstance();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/inserer.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        
        try {

            if (Annuaire.champ_vide(nom, adresse, telephone, email)) {
                request.setAttribute("erreur", "Remplir les champs vides !");
                request.getRequestDispatcher("/inserer.jsp").forward(request, response);
                return;
            }

            if (!Annuaire.nm_tel_valid(telephone)) {
                request.setAttribute("erreur", "Le numéro de téléphone doit être une valeur numérique !");
                request.getRequestDispatcher("/inserer.jsp").forward(request, response);
                return;
            }

            if (!Annuaire.email_valid(email)) {
                request.setAttribute("erreur", "L'adresse email n'est pas valide !");
                request.getRequestDispatcher("/inserer.jsp").forward(request, response);
                return;
            }

            Personne personne = new Personne(nom.trim(), adresse.trim(), telephone.trim(), email.trim());
            Annuaire.ajouterPersonne(personne);
            
            request.setAttribute("succes", "Personne ajoutée avec succès !");
            request.getRequestDispatcher("/inserer.jsp").forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
            request.getRequestDispatcher("/inserer.jsp").forward(request, response);
        }
    }
}
