package servlet;

import repository.DAOInterface;
import repository.ItemDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by oleg on 23.06.2019.
 */
@WebServlet(urlPatterns = "/deleteItem")
public class DeleteItem extends HttpServlet {

    DAOInterface repo = ItemDao.getInstanceItemDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idItem = req.getParameter("id");
        Long id = Long.parseLong(idItem);
        System.out.println("LOG: item " + id + " is going to delete");
        repo.deleteItem(id);
        System.out.println("LOG: item " + id + " was deleted");
//        RequestDispatcher dispatcher =    req.getServletContext().getRequestDispatcher("/jsp/ItemsJSP.jsp");
//        dispatcher.(req,resp);

        resp.sendRedirect("/items");

    }
}
