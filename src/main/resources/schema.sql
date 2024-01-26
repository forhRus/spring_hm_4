CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    surname VARCHAR(50),
    age INT NOT NULL,
    course INT NOT NULL
);
INSERT INTO students (firstName, lastName, surname, age,course)
values
    ('Ekaterina', 'Shkaeva', 'Victorovna', 34, 3),
    ('Mariya', 'Shkaeva', 'Sergeevna', 1, 0);
