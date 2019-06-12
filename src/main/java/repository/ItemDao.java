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
    Item item = null;

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
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
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
        } finally {
            if (session != null)
                session.close();
        }
        return item;
    }

    public void deleteItem(Item item) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(item);
            tr.commit();
            System.out.println("deleteItem");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            if (session != null)
                session.close();
        }
    }

    public Item saveItem(Item item) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
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
        } finally {
            if (session != null)
                session.close();
        }
        return item;
    }

    public Item updateItem(long id) {
        return null;
    }
}

