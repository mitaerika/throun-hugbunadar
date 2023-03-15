PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;
CREATE TABLE Daytrip {
	title varchar(100),
	date Date,
	start_time Time,
	end_time Time,
	description varchar(1000),
	price int,
	photo varchar(50),
	available_seats int,
	activity_name varchar(50),
	location_name varchar(50),
	review_rating int,
	review_text varchar(1000),
	hotel_name varchar(120),
	PRIMARY KEY(title, date, start_time),
	FOREIGN KEY(activity_name) REFERENCES Activity(name),
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name),
	FOREIGN KEY(review_rating, review_text) REFERENCES Review(rating, text),
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Booking {
	number int(3), 
	booked_seats int,
	total_cost int,
	daytrip_title varchar(100),
	daytrip_date Date,
	daytrip_start_time Time,
	daytrip_end_time Time,
	daytrip_price int,
	hotel_name varchar(120),
	cust_id char(4),
	PRIMARY KEY(number)
	FOREIGN KEY(daytrip_title,daytrip_date, daytrip_start_time, daytrip_end_time, daytrip_price) REFERENCES Daytrip(title, date, start_time, end_time, price)
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name),
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Customer {
	id char(4) PRIMARY KEY,
	name varchar(100),
	email varchar(50),
	phone int,
	booking_number char(3),
	FOREIGN KEY (booking_number) REFERENCES Booking(number),
	FOREIGN KEY (review_number) REFERENCES Review(number)
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Review {
	number char(4) PRIMARY KEY,
	daytrip_title varchar(100),
	cust_id char(4),
	rating int(2),
	text varchar(800),
	FOREIGN KEY(daytrip_title) REFERENCES Daytrip(title),
	FOREIGN KEY(cust_id) REFERENCES Customer(id)
}


CREATE TABLE Activity {
	name varchar(50) PRIMARY KEY,
	daytrip_title varchar(50),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
}


CREATE TABLE Hotel {
	name varchar(120) PRIMARY KEY,
	daytrip_title varchar(50),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
}

COMMIT;
