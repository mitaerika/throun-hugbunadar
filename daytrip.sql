PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;
CREATE TABLE Daytrip {
	title VARCHAR(100),
	date_trip DATE,
	start_time TIME,
	end_time TIME,
	description VARCHAR(1000),
	price INT,
	photo VARCHAR(50),
	available_seats INT,
	activity_name VARCHAR(50),
	location_name VARCHAR(50),
	review_rating INT,
	review_text VARCHAR(1000),
	hotel_name VARCHAR(120),
	PRIMARY KEY(title, date_trip, start_time),
	FOREIGN KEY(activity_name) REFERENCES Activity(name),
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name),
	FOREIGN KEY(review_rating, review_text) REFERENCES Review(rating, text),
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Booking {
	number INT(3),
	booked_seats INT,
	total_cost INT,
	daytrip_title INT(100),
	daytrip_date DATE,
	daytrip_start_time TIME,
	daytrip_end_time TIME,
	daytrip_price INT,
	hotel_name INT(120),
	cust_id CHAR(4),
	PRIMARY KEY(number)
	FOREIGN KEY(daytrip_title,daytrip_date, daytrip_start_time, daytrip_end_time, daytrip_price) REFERENCES Daytrip(title, date_trip, start_time, end_time, price)
	FOREIGN KEY(hotel_name) REFERENCES Hotel(name),
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Customer {
	id CHAR(4) PRIMARY KEY,
	name VARCHAR(100),
	email VARCHAR(50),
	phone INT,
	booking_number CHAR(3),
	FOREIGN KEY (booking_number) REFERENCES Booking(number),
	FOREIGN KEY (review_number) REFERENCES Review(number)
}
INSERT INTO Daytrip VALUES();

CREATE TABLE Review {
	number CHAR(4) PRIMARY KEY,
	daytrip_title VARCHAR(100),
	cust_id CHAR(4),
	rating INT(2),
	text VARCHAR(800),
	FOREIGN KEY(daytrip_title) REFERENCES Daytrip(title),
	FOREIGN KEY(cust_id) REFERENCES Customer(id)
}


CREATE TABLE Activity {
	name VARCHAR(50) PRIMARY KEY,
	daytrip_title VARCHAR(50),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
}


CREATE TABLE Hotel {
	name VARCHAR(120) PRIMARY KEY,
	daytrip_title VARCHAR(50),
	FOREIGN KEY (daytrip_title) REFERENCES Daytrip(title)
}

COMMIT;
