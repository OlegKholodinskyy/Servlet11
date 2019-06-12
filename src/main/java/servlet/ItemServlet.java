package servlet;

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
import java.util.List;

/**
 * Created by oleg on 12.06.2019.
 */

@WebServlet(urlPatterns = "/items")
public class ItemServlet extends HttpServlet {

    private DAOInterface itemRepository;

    @Override
    public void init() throws ServletException {
        this.itemRepository = new ItemDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  List<Item> items = itemRepository.getAllItems();
        //  req.setAttribute("items", items);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/itemsJSP.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
