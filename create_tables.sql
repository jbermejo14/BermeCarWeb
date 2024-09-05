CREATE TABLE Cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    license_plate VARCHAR(20) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    country VARCHAR(50),
    year INT,
    price DECIMAL(10, 2),
    photo BLOB
);
CREATE TABLE Reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    datetime DATETIME NOT NULL,
    id_cars INT NOT NULL,
    id_users INT NOT NULL,
    FOREIGN KEY (id_cars) REFERENCES Cars(id),
    FOREIGN KEY (id_users) REFERENCES Users(id)
);
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telephone VARCHAR(20),
    role ENUM('admin', 'user', 'guest') NOT NULL DEFAULT 'user'
);

