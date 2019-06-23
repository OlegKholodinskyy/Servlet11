package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 12.06.2019.
 */
public interface DAOInterface {
    public ArrayList<Item> getAllItems();

    public Item getItemById(long id);

    public void deleteItem(long id);

    public Item saveItem(Item item);

    public Item updateItem(Item item);

  //  public boolean isExist(String name);
}
