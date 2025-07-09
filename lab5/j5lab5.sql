CREATE DATABASE j5lab5
GO
USE j5lab5
GO

CREATE TABLE Accounts (
    username NVARCHAR(50) PRIMARY KEY,
    password NVARCHAR(100),
    fullname NVARCHAR(100),
    email NVARCHAR(100),
    photo NVARCHAR(100),
    activated BIT,
    admin BIT
)

CREATE TABLE Categories (
    id NVARCHAR(20) PRIMARY KEY,
    name NVARCHAR(100)
)

CREATE TABLE Products (
    id INT IDENTITY PRIMARY KEY,
    name NVARCHAR(100),
    image NVARCHAR(100),
    price FLOAT,
    Createdate DATE,
    avalilabel BIT,
    Categoryid NVARCHAR(20) FOREIGN KEY REFERENCES Categories(id)
)

CREATE TABLE Orders (
    id INT IDENTITY PRIMARY KEY,
    address NVARCHAR(200),
    Createdate DATE,
    availlable BIT,
    Username NVARCHAR(50) FOREIGN KEY REFERENCES Accounts(username)
)

CREATE TABLE Orderdetails (
    id INT IDENTITY PRIMARY KEY,
    price FLOAT,
    quantity INT,
    Productid INT FOREIGN KEY REFERENCES Products(id),
    Orderid INT FOREIGN KEY REFERENCES Orders(id)
)


INSERT INTO Accounts VALUES 
('admin', '123', 'Admin Name', 'admin@example.com', 'admin.jpg', 1, 1),
('user', '123', 'User Name', 'user@example.com', 'user.jpg', 1, 0)

INSERT INTO Categories VALUES
('C1', N'Điện thoại'),
('C2', N'Laptop'),
('C3', N'Tablet'),
('C4', N'Phụ kiện'),
('C5', N'Đồng hồ'),
('C6', N'Màn hình'),
('C7', N'Bàn phím'),
('C8', N'Chuột'),
('C9', N'Tai nghe'),
('C10', N'TV')

INSERT INTO Products(name, image, price, Createdate, avalilabel, Categoryid) VALUES
('iPhone 14', 'iphone14.jpg', 22000, GETDATE(), 1, 'C1'),
('Samsung Galaxy S23', 's23.jpg', 21000, GETDATE(), 1, 'C1'),
('MacBook Pro M2', 'macbook.jpg', 45000, GETDATE(), 1, 'C2'),
('Dell XPS 13', 'dellxps.jpg', 33000, GETDATE(), 1, 'C2'),
('iPad Air', 'ipadair.jpg', 15000, GETDATE(), 1, 'C3'),
('Apple Watch', 'watch.jpg', 8000, GETDATE(), 1, 'C5'),
('Logitech Mouse', 'mouse.jpg', 500, GETDATE(), 1, 'C8'),
('Sony Headphones', 'sony.jpg', 2500, GETDATE(), 1, 'C9'),
('LG Monitor', 'lgmonitor.jpg', 6000, GETDATE(), 1, 'C6'),
('Smart TV 55"', 'tv.jpg', 12000, GETDATE(), 1, 'C10')

INSERT INTO Orders(address, Createdate, availlable, Username) VALUES
(N'Hà Nội', GETDATE(), 1, 'user'),
(N'Đà Nẵng', GETDATE(), 1, 'user'),
(N'Hồ Chí Minh', GETDATE(), 1, 'user'),
(N'Cần Thơ', GETDATE(), 1, 'admin'),
(N'Hải Phòng', GETDATE(), 1, 'admin'),
(N'Bình Dương', GETDATE(), 1, 'user'),
(N'Nghệ An', GETDATE(), 1, 'admin'),
(N'Bắc Ninh', GETDATE(), 1, 'user'),
(N'Quảng Ninh', GETDATE(), 1, 'user'),
(N'Nam Định', GETDATE(), 1, 'admin')

INSERT INTO Orderdetails(price, quantity, Productid, Orderid) VALUES
(22000, 1, 1, 1),
(21000, 2, 2, 1),
(45000, 1, 3, 2),
(33000, 1, 4, 3),
(15000, 2, 5, 4),
(8000, 1, 6, 5),
(500, 3, 7, 6),
(2500, 1, 8, 7),
(6000, 2, 9, 8),
(12000, 1, 10, 9)
