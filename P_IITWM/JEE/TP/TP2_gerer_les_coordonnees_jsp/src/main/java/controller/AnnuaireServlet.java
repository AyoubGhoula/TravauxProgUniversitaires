package controller;

import java.io.IOException;
import java.rmi.Naming;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PersonneService;
import model.Personne;
import exception.ExisteDejaException;
import exception.PersonneIntrouvableException;

@WebServlet("/AnnuaireServlet/*")
public class AnnuaireServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonneService service;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            // Connect to RMI service
            service = (PersonneService) Naming.lookup("rmi://localhost:1099/Annuaire");
            System.out.println("✅ Connected to RMI service successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Cannot connect to RMI service: " + e.getMessage(), e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String page;
        String path = request.getPathInfo();
        
        if (path == null) {
            path = "/Menu";
        }
        
        switch(path) {
            case "/Menu":
                page = "/index.jsp";
                break;
            case "/Ajout":
                page = "/Ajout.jsp";
                break;
            case "/Recherche":
                page = "/Recherche.jsp";
                break;
            case "/Supprimer":
                page = "/Recherche.jsp";
                break;
            default:
                page = "/index.jsp";
        }
        
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set UTF-8 encoding for request parameters
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String action = request.getPathInfo();
        
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Menu");
            return;
        }
        
        Personne p = null;
        HttpSession session = request.getSession();
        
        switch(action) {
            case "/Ajout":
                try {
                    String nom = request.getParameter("nom");
                    String adresse = request.getParameter("adresse");
                    String tel = request.getParameter("tel");
                    String email = request.getParameter("email");
                    
                    // Validate inputs
                    if (nom == null || nom.trim().isEmpty() ||
                        adresse == null || adresse.trim().isEmpty() ||
                        tel == null || tel.trim().isEmpty() ||
                        email == null || email.trim().isEmpty()) {
                        
                        request.setAttribute("msg", "Tous les champs sont obligatoires!");
                        request.setAttribute("success", false);
                        getServletContext().getRequestDispatcher("/Ajout.jsp").forward(request, response);
                        return;
                    }
                    
                    p = new Personne(nom.trim(), adresse.trim(), tel.trim(), email.trim());
                    service.insererPersonne(p);
                    
                    request.setAttribute("msg", "✅ Personne ajoutée avec succès!");
                    request.setAttribute("success", true);
                    
                } catch(ExisteDejaException e) {
                    request.setAttribute("msg", "❌ " + e.getMessage());
                    request.setAttribute("success", false);
                } catch(Exception e) {
                    request.setAttribute("msg", "❌ Erreur: " + e.getMessage());
                    request.setAttribute("success", false);
                    e.printStackTrace();
                }
                getServletContext().getRequestDispatcher("/Ajout.jsp").forward(request, response);
                break;
                
            case "/Recherche":
                try {
                    String nom = request.getParameter("nom");
                    
                    if (nom == null || nom.trim().isEmpty()) {
                        request.setAttribute("msg", "❌ Veuillez entrer un nom!");
                        request.setAttribute("success", false);
                        getServletContext().getRequestDispatcher("/Recherche.jsp").forward(request, response);
                        return;
                    }
                    
                    p = service.rechercherPersonne(nom.trim());
                    request.setAttribute("personne", p);
                    request.setAttribute("success", true);
                    
                } catch(PersonneIntrouvableException e) {
                    request.setAttribute("msg", "❌ " + e.getMessage());
                    request.setAttribute("success", false);
                } catch(Exception e) {
                    request.setAttribute("msg", "❌ Erreur: " + e.getMessage());
                    request.setAttribute("success", false);
                    e.printStackTrace();
                }
                getServletContext().getRequestDispatcher("/Recherche.jsp").forward(request, response);
                break;
                
            case "/Supprimer":
                try {
                    String nom = request.getParameter("nom");
                    
                    if (nom == null || nom.trim().isEmpty()) {
                        session.setAttribute("msg", "❌ Nom manquant pour la suppression!");
                        session.setAttribute("success", false);
                        response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Recherche");
                        return;
                    }
                    
                    service.supprimerPersonne(nom.trim());
                    
                    // Use session to store message for redirect
                    session.setAttribute("msg", "✅ Personne '" + nom + "' supprimée avec succès!");
                    session.setAttribute("success", true);
                    
                    // Redirect to avoid form resubmission
                    response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Recherche");
                    
                } catch(PersonneIntrouvableException e) {
                    session.setAttribute("msg", "❌ " + e.getMessage());
                    session.setAttribute("success", false);
                    response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Recherche");
                } catch(Exception e) {
                    session.setAttribute("msg", "❌ Erreur: " + e.getMessage());
                    session.setAttribute("success", false);
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Recherche");
                }
                break;
                
            default:
                response.sendRedirect(request.getContextPath() + "/AnnuaireServlet/Menu");
        }
    }
}