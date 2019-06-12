import model.Item;
import repository.DAOInterface;
import repository.ItemDao;

import java.util.ArrayList;

/**
 * Created by oleg on 12.06.2019.
 */
public class Main {
    public static void main(String[] args) {
        DAOInterface dao = new ItemDao();
        ArrayList<Item> items = dao.getAllItems();
        for (Item item: items) {
            System.out.println(item);
        }
    }
}
