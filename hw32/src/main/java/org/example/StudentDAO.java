package org.example;


import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    private final SessionFactory sessionFactory;

    public StudentDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Student getStudentById(int studentId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Student.class, studentId);
        } finally {
            session.close();
        }
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        try {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            return query.list();
        } finally {
            session.close();
        }
    }
}
