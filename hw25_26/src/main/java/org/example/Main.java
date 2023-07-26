package org.example;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {

            Connection connection = DBConnectivity.getConnection();


            LessonDao lessonDao = new LessonDao(connection);


            Homework homework = new Homework(1, "Math Homework", "Complete exercises 1 to 5.");
            Lesson lesson = new Lesson(1, "Math Lesson", homework);
            lessonDao.addLesson(lesson);


            List<Lesson> allLessons = lessonDao.getAllLessons();
            for (Lesson l : allLessons) {
                System.out.println(l.getId() + " | " + l.getName() + " | " + l.getHomework().getName());
            }


            Lesson lessonById = lessonDao.getLessonById(1);
            if (lessonById != null) {
                System.out.println("Lesson with ID 1: " + lessonById.getName());
            }


            DBConnectivity.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}