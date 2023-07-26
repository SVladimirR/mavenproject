package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {

    private final Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    public void addLesson(Lesson lesson) throws SQLException {
        String sql = "INSERT INTO lesson (name,  homework_id) VALUES (?,  ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.executeUpdate();


            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    lesson.setId(generatedId);
                }
            }
        }
    }

    public void deleteLesson(int lessonId) throws SQLException {
        String sql = "DELETE FROM lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        }
    }

    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();
        String sql = "SELECT lesson.*, homework.name AS homework_name, homework.description AS homework_description " +
                "FROM lesson " +
                "LEFT JOIN homework ON lesson.homework_id = homework.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                int homeworkId = resultSet.getInt("homework_id");
                String homeworkName = resultSet.getString("homework_name");
                String homeworkDescription = resultSet.getString("homework_description");

                Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);
                Lesson lesson = new Lesson(id, name, homework);
                lessons.add(lesson);
            }
        }
        return lessons;
    }

    public Lesson getLessonById(int lessonId) throws SQLException {
        String sql = "SELECT lesson.*, homework.name AS homework_name, homework.description AS homework_description " +
                "FROM lesson " +
                "LEFT JOIN homework ON lesson.homework_id = homework.id " +
                "WHERE lesson.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    int homeworkId = resultSet.getInt("homework_id");
                    String homeworkName = resultSet.getString("homework_name");
                    String homeworkDescription = resultSet.getString("homework_description");

                    Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);
                    return new Lesson(id, name,  homework);
                }
            }
        }
        return null;
    }
}
