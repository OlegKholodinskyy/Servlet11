package servlet;

import controller.ItemController;
import model.Item;
import org.hibernate.boot.jaxb.SourceType;
import repository.DAOInterface;
import repository.ItemDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.Enumeration;

/**
 * Created by oleg on 23.06.2019.
 */
@WebServlet(urlPatterns = "/editItem")
public class EditItem extends HttpServlet {
    ItemController itemController = new ItemController();
    Item item = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        Item item = itemController.getItemById(id);
        req.setAttribute("item", item);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/EditItemJSP.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String descriptionEdited = req.getParameter("description");

        item = itemController.getItemById(Long.parseLong(req.getParameter("id")));

        itemController.updateItem(item, descriptionEdited);
        resp.sendRedirect("/items");

    }
}
