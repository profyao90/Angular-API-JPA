package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.Person;

public class PersonServlet extends HttpServlet{

	
	private EntityManager manager;
	private EntityManagerFactory factory;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.factory = Persistence.createEntityManagerFactory("hsqlbd");
		this.manager = factory.createEntityManager();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		manager.close();
		factory.close();
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		personsView(resp); //Affiche la liste des personnes
		
		
    }
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String residence = request.getParameter("residence");
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin(); // Ouverture de la transaction
		
		manager.persist(new Person(nom, prenom, email));
		
		tx.commit(); // Fermeture de la transaction
		
		/*List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		request.setAttribute("nbpersons", resultList.size());
				
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("persons.jsp");
		dispatcher.forward(request, response);
		*/
		
		personsView(response); //Affiche la liste des personnes
		
//		response.sendRedirect("persons.jsp");
//		return;
		
	}
	
	private void personsView(HttpServletResponse resp) throws IOException{
		
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
//		req.setAttribute("nbpersons", resultList.size());
//		req.setAttribute("persons", resultList);
		
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Liste des personnes</h1>");
		out.println("<h3>Nombre de personnes:</h3>" + resultList.size());
		out.println("<ul>");
		for (Person next : resultList) {
			out.println("<li><ul>");
				out.println("<li>Nom: " + next.getName());
				out.println("<li>Prenom: " + next.getPrenom());
				out.println("<li>Mail: " + next.getMail());
			out.println("</ul></li>");
		}
		out.println("</ul>");
		out.println("<a href='personform.html'>Ajouter</a>");
		
	}
}
