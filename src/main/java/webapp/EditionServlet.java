package webapp;

import webapp.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editions")
public class EditionServlet extends HttpServlet {
    private EditionService editionService = new EditionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("editions", editionService.getAllEdition());
        request.getRequestDispatcher("/WEB-INF/views/editions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String edition = request.getParameter("edition");
        if ("".equals(edition)) {
            request.setAttribute("errorMessage", "Enter a valid edition");
        } else {
            editionService.addEditionName(edition);
        }
        request.setAttribute("editions", editionService.getAllEdition());
        request.getRequestDispatcher("/WEB-INF/views/editions.jsp").forward(request, response);
    }
}
