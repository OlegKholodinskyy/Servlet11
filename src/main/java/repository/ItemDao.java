package repository;

import model.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

/**
 * Created by oleg on 12.06.2019.
 */
public class ItemDao extends SessionFactoryBuilder implements DAOInterface {
    ArrayList<Item> items = null;

    public ArrayList<Item> getAllItems() {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            items = (ArrayList<Item>) session.createQuery("From Item ").list();
            tr.commit();
            System.out.println("getAllItems");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null)
                session.close();
        }
        return items;
    }

    public Item getItemById(long id) {
        return null;
    }

    public void deleteItem(long id) {

    }

    public Item saveItem(Item item) {
        return null;
    }

    public Item updateItem(long id) {
        return null;
    }
}

