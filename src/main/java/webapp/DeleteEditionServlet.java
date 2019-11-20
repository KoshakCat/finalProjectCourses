package webapp;

import webapp.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-edition")
public class DeleteEditionServlet extends HttpServlet {

    private EditionService editionService = new EditionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int result = editionService.deleteEdition(Integer.parseInt(request.getParameter("edition")));
        if (result != 1) {
            request.setAttribute("errorMessage", "Cant delete subscribed edition");
            request.setAttribute("editions", editionService.getAllEdition());
            request.getRequestDispatcher("/WEB-INF/views/editions.jsp").forward(request, response);
        } else {
            response.sendRedirect("/editions");
        }
    }
}
