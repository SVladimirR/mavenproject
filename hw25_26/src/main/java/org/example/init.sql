CREATE DATABASE db;

CREATE TABLE homework (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    description VARCHAR(1024)
);

CREATE TABLE lesson (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    updatedAt TIMESTAMP,
    homework_id INT

);

CREATE TABLE schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128),
    updatedAt TIMESTAMP

);



CREATE TABLE schedule_lesson (
    schedule_id INT,
    lesson_id INT,
    PRIMARY KEY (schedule_id, lesson_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(id),
    FOREIGN KEY (lesson_id) REFERENCES lesson(id)
);

ALTER TABLE lesson
ADD
CONSTRAINT FK_lesson_schedule FOREIGN KEY
(
id
) REFERENCES schedule (id);

ALTER TABLE schedule
ADD
CONSTRAINT FK_schedule_lesson FOREIGN KEY
(
id
) REFERENCES lesson (id);

ALTER TABLE schedule_lesson
ADD CONSTRAINT FK_schedule_lesson_schedule FOREIGN KEY
(schedule_id)
REFERENCES schedule(id),
ADD CONSTRAINT FK_schedule_lesson_lesson FOREIGN KEY
(lesson_id)
REFERENCES lesson(id);


