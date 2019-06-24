package repository;

import model.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by oleg on 12.06.2019.
 */
public class ItemDao extends SessionFactoryBuilder implements DAOInterface {
    private ItemDao() {
    }

    private static ItemDao instanceItemDao;

    public static ItemDao getInstanceItemDao() {
        if (instanceItemDao == null) {
            instanceItemDao = new ItemDao();
        }
        return instanceItemDao;
    }


    ArrayList<Item> items = null;
    Item item = null;

    public ArrayList<Item> getAllItems() {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
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
        }
        return items;
    }

    public Item getItemById(long id) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            item = (Item) session.get(Item.class, id);
            tr.commit();
            System.out.println("getAllItems");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
        return item;
    }

    public void deleteItem(long id) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(getItemById(id));
            tr.commit();
            System.out.println("deleteItem" + id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
    }

    public Item saveItem(Item item) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(item);
            tr.commit();
            System.out.println("saveItem");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
        return item;
    }

    public Item updateItem(Item item) {
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.update(item);
            tr.commit();
            System.out.println("updateItem");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        }
        return item;
    }
}

