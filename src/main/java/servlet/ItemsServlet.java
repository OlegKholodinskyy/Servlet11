package servlet;

import controller.ItemController;
import exception.ItemExistException;
import model.Item;
import repository.DAOInterface;
import repository.ItemDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by oleg on 12.06.2019.
 */

@WebServlet(urlPatterns = "/items")
public class ItemsServlet extends HttpServlet {

    ItemController itemController= new ItemController();

    @Override
    public void init() throws ServletException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = itemController.getAllItems();
        req.setAttribute("items", items);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/ItemsJSP.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        try {
            itemController.saveItem(new Item (name, LocalDate.now(), LocalDate.now(), description));
        } catch (ItemExistException e) {
            System.out.println(e.getMessage());
        }

        doGet(req,resp);
    }
}
