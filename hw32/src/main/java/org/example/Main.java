package org.example;

import org.example.entity.Student;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();


        Student student1 = new Student();
        student1.setName("gggggggggggggggg 1");
        student1.setEmail("email1@gmail.com");
        studentDAO.addStudent(student1);


        Student studentToUpdate = studentDAO.getStudentById(1);
        if (studentToUpdate != null) {
            studentToUpdate.setName("Новое имя студента");
            studentToUpdate.setEmail("новый.email@example.com");
            studentDAO.updateStudent(studentToUpdate);
        }


        studentDAO.deleteStudent(1);


        Student studentById = studentDAO.getStudentById(1);
        if (studentById != null) {
            System.out.println("Студент по ID: " + studentById.getName());
        }


        List<Student> allStudents = studentDAO.getAllStudents();
        for (Student student : allStudents) {
            System.out.println("Имя студента: " + student.getName() + ", Email: " + student.getEmail());
        }
        HibernateUtil.shutdown();
    }
}