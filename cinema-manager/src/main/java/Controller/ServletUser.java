package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.entities.User;
import modele.metier.ModeleUser;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ModeleUser modeleUser = new ModeleUser();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            User user = modeleUser.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("ModifierUser.jsp").forward(request, response);
            return;
        }
        List<User> list = modeleUser.getAllUsers();
        request.setAttribute("list", list);
        request.getRequestDispatcher("ListUsers.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(id, email, password);
            modeleUser.setUser(user);
            modeleUser.updateUser();
            response.sendRedirect("ServletUser");
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            modeleUser.deleteUser(id);
            response.sendRedirect("ServletUser");
        } else if (action.equals("add")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            modeleUser.setUser(new User(0, email, password));
            modeleUser.addUser();
            response.sendRedirect("ServletUser");
        } else if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = modeleUser.getUserByEmailAndPassword(email, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("ListFilm.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        }
    }
}
