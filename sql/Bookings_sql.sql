CREATE DATABASE IF NOT EXISTS hotelusers;
USE hotelusers;

CREATE TABLE IF NOT EXISTS hotelusersdatabase (
    PhoneNumber VARCHAR(11) NOT NULL,
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    GuestName VARCHAR(100),
    Address VARCHAR(200),
    RoomType VARCHAR(50),
    RoomPrice DECIMAL(10,2),
    BookingSched DATE,
    TotalAmount DECIMAL(10,2),
    PaymentMethod VARCHAR(50)
);