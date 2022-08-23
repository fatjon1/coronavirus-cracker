import dao.QarkuDao;
import dao.QarkuDaoImpl;
import model.Qarku;
import service.QarkuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class QarkuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QarkuService qarkuService;

    public void init() {
        qarkuService = new QarkuService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
               /* case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;*/
                case "/edit":
                    showEditForm(request, response);
                    break;
                /*case "/update":
                    updateUser(request, response);
                    break;*/
                default:
                    listQarku(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listQarku(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Qarku> listQarku = qarkuService.findAll();
        request.setAttribute("listQarku", listQarku);
        RequestDispatcher dispatcher = request.getRequestDispatcher("qarku-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("qarku-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Qarku existingQark = qarkuService.findById((long) id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("qark", existingQark);
        dispatcher.forward(request, response);

    }

   /* private void insertQark(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        Qarku newQark = new Qarku();
        qarkuService.persist(newQark);
        response.sendRedirect("list");
    }*/

   /* private void updateQark(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);
        userDao.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("list");
    }*/
}
