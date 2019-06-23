package servlet;

import controller.ItemController;
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

    ItemController itemController = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        itemController.deleteItem(id);

        resp.sendRedirect("/items");

    }
}
