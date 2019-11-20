package webapp;

import dao.EditionDao;
import webapp.service.EditionService;
import webapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    private EditionService editionService = new EditionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        boolean isValidUser = userService.validateUser(name, password);

        if (isValidUser) {
            /*request.setAttribute("name", name);
            request.setAttribute("editions", editionService.getAllEditionByName());
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);*/
            request.getSession().setAttribute("name", name);
            response.sendRedirect("/editions");
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }


    }
}