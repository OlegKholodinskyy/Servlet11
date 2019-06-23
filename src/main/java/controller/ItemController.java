package controller;

import exception.ItemExistException;
import model.Item;
import repository.DAOInterface;
import repository.ItemDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 23.06.2019.
 */
public class ItemController {

    DAOInterface repo;
    List<Item> items;

    public ItemController(){
        repo= ItemDao.getInstanceItemDao();
    }

    public Item saveItem(Item item) throws ItemExistException {
        items=getAllItems();
        for(Item itemFromDB:items) {
            if (itemFromDB.getName().equals(item.getName())) {
                throw new ItemExistException("Item with same name : " + item.getName() + " is already present in base");
            }
        }
        return repo.saveItem(item);
    }

    public List<Item> getAllItems() {
        return repo.getAllItems();
    }

    public Item getItemById(Long id) {
        return repo.getItemById(id);
    }

    public Item updateItem(Item item, String descriptionEdited) {
        item.setLastUpdatedDate(LocalDate.now() );
        item.setDescription(descriptionEdited);
        return repo.updateItem(item);
    }

    public void deleteItem(Long id) {
        repo.deleteItem(id);
    }
}
