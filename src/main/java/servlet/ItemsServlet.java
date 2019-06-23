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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by oleg on 12.06.2019.
 */

@WebServlet(urlPatterns = "/items")
public class ItemsServlet extends HttpServlet {

    DAOInterface repo;

    @Override
    public void init() throws ServletException {
        String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + JDBC_DRIVER + " not found");
            return;
        }
        repo = ItemDao.getInstanceItemDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Test1");

        List<Item> items = repo.getAllItems();
        req.setAttribute("items", items);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/ItemsJSP.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        repo.saveItem(new Item (name, LocalDate.now(), LocalDate.now(), description));

        doGet(req,resp);
    }
}
