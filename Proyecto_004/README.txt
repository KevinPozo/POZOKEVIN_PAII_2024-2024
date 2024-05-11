## Script utilizado en Proyecto_004, creación de una BD en MySQL ("institute"):
USE institute;
-- Crear la tabla Student
CREATE TABLE IF NOT EXISTS Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    lastName VARCHAR(50),
    age INT
);

-- Crear la tabla Teacher
CREATE TABLE IF NOT EXISTS Teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    lastName VARCHAR(50),
    age INT
);

-- Crear la tabla Subject
CREATE TABLE IF NOT EXISTS Subject (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    level VARCHAR(20)
);

-- Crear la tabla Schedule
CREATE TABLE IF NOT EXISTS Schedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idSubject INT,
    idStudent INT,
    idTeacher INT,
    timeStart TIME,
    timeEnd TIME,
    day VARCHAR(20),
    FOREIGN KEY (idSubject) REFERENCES Subject(id),
    FOREIGN KEY (idStudent) REFERENCES Student(id),
    FOREIGN KEY (idTeacher) REFERENCES Teacher(id)
);

