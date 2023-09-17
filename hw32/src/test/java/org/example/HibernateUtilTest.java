package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateUtilTest {
    private static SessionFactory sessionFactory = null;

    @BeforeAll
    public static void setUp()
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterAll
    public static void tearDown()
    {
        sessionFactory.close();
    }

    @Test
    public void testSaveStudent() {
        System.out.println("testSaveStudent begins ........");
        Student student = new Student();
        student.setName("aaaaaa321");
        student.setEmail("aaaaa@gmail.com");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();
        System.out.println("testSaveStudent ends .......");
    }

    @Test
    public void testRetrieveStudent() {
        System.out.println("testRetrieveStudent begins ........");
        testSaveStudent();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student retrievedStudent = session.get(Student.class, 3);
        tx.commit();
        session.close();

        assertNotNull(retrievedStudent);
        assertEquals("aaaaaa321", retrievedStudent.getName());
        assertEquals("aaaaa@gmail.com", retrievedStudent.getEmail());
        System.out.println("testRetrieveStudent ends .......");
    }
//
    @Test
    public void testUpdateStudent() {
        System.out.println("testUpdateStudent begins ........");
        testSaveStudent();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, 2);
        student.setEmail("bbbbbbb@gmail.com");

        tx.commit();
        session.close();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        Student updatedStudent = session.get(Student.class, 2);

        tx.commit();
        session.close();

        assertNotNull(updatedStudent);
        assertEquals("bbbbbbb@gmail.com", updatedStudent.getEmail());
        System.out.println("testUpdateStudent ends .......");
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("testDeleteStudent begins ........");
        testSaveStudent();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, 4);
        session.delete(student);

        tx.commit();
        session.close();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        Student deletedStudent = session.get(Student.class, 4);

        tx.commit();
        session.close();

        assertNull(deletedStudent);
        System.out.println("testDeleteStudent ends .......");
    }
}