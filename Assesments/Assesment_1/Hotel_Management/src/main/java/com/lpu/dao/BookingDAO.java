package com.lpu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lpu.entity.Booking;

public class BookingDAO {

    private SessionFactory factory;

    // constructor → create SessionFactory once
    public BookingDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    // ================= SAVE =================
    public void saveBooking(Booking booking) {

        Session session = factory.openSession();
        session.beginTransaction();

        session.persist(booking);

        session.getTransaction().commit();
        session.close();
    }

    // ================= VIEW ALL =================
    public List<Booking> getAllBookings() {

        Session session = factory.openSession();

        List<Booking> list =
                session.createQuery("from Booking", Booking.class).list();

        session.close();
        return list;
    }

    // ================= UPDATE =================
    public boolean updateRoomType(int id, String newRoom) {

        Session session = factory.openSession();
        Booking booking = session.get(Booking.class, id);

        if (booking == null) {
            session.close();
            return false;
        }

        session.beginTransaction();
        booking.setRoomType(newRoom);
        session.getTransaction().commit();

        session.close();
        return true;
    }

    // ================= DELETE =================
    public boolean deleteBooking(int id) {

        Session session = factory.openSession();
        Booking booking = session.get(Booking.class, id);

        if (booking == null) {
            session.close();
            return false;
        }

        session.beginTransaction();
        session.remove(booking);
        session.getTransaction().commit();

        session.close();
        return true;
    }

    // close factory when app ends
    public void closeFactory() {
        factory.close();
    }
}
