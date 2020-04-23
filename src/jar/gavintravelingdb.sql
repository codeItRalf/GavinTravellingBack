-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 23 apr 2020 kl 11:14
-- Serverversion: 10.4.11-MariaDB
-- PHP-version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `gavintravelingdb`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `booked_rooms`
--

CREATE TABLE `booked_rooms` (
  `booking_id` int(11) UNSIGNED NOT NULL,
  `room_id` int(11) UNSIGNED NOT NULL,
  `extra_bed` int(11) UNSIGNED NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Dumping data for table gavintravelingdb.booked_rooms: ~3 rows (approximately)
/*!40000 ALTER TABLE `booked_rooms` DISABLE KEYS */;
INSERT IGNORE INTO `booked_rooms` (`booking_id`, `room_id`, `extra_bed`, `start_date`, `end_date`) VALUES
	(2, 2, 3, '2020-06-19 00:00:00', '2020-06-24 00:00:00'),
	(3, 3, 0, '2020-06-01 15:00:00', '2020-06-25 12:00:00'),
	(5, 2, 1, '2020-07-01 15:00:00', '2020-07-04 11:00:00');
/*!40000 ALTER TABLE `booked_rooms` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.bookings
CREATE TABLE IF NOT EXISTS `bookings` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned NOT NULL,
  `person_count` int(11) unsigned NOT NULL,
  `children_count` int(11) unsigned NOT NULL,
  `small_children_count` int(11) unsigned NOT NULL,
  `active_booking` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdx_135` (`customer_id`),
  CONSTRAINT `FK_135` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.bookings: ~6 rows (approximately)
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT IGNORE INTO `bookings` (`id`, `customer_id`, `person_count`, `children_count`, `small_children_count`, `active_booking`) VALUES
	(1, 1, 2, 2, 1, b'1'),
	(2, 2, 2, 1, 1, b'0'),
	(3, 3, 2, 2, 1, b'0'),
	(5, 5, 1, 0, 0, b'0'),
	(6, 1, 2, 2, 1, b'1'),
	(7, 5, 1, 0, 0, b'0');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.cities
CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.cities: ~5 rows (approximately)
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT IGNORE INTO `cities` (`id`, `name`) VALUES
	(1, 'gagarin'),
	(2, 'tubel'),
	(3, 'dallas'),
	(4, 'sheregesh'),
	(5, 'banyumas');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,

--
-- Dumpning av Data i tabell `booked_rooms`
--

INSERT INTO `booked_rooms` (`booking_id`, `room_id`, `extra_bed`, `start_date`, `end_date`) VALUES
(1, 1, 1, '2020-06-19 15:00:00', '2020-06-25 11:00:00'),
(2, 2, 2, '2020-06-24 15:00:00', '2020-06-29 11:00:00'),
(3, 3, 0, '2020-06-01 15:00:00', '2020-06-25 12:00:00'),
(4, 3, 2, '2020-06-12 15:00:00', '2020-07-05 11:00:00'),
(5, 2, 1, '2020-07-01 15:00:00', '2020-07-04 11:00:00');

-- --------------------------------------------------------

--
-- Tabellstruktur `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) UNSIGNED NOT NULL,
  `customer_id` int(11) UNSIGNED NOT NULL,
  `person_count` int(11) UNSIGNED NOT NULL,
  `children_count` int(11) UNSIGNED NOT NULL,
  `small_children_count` int(11) UNSIGNED NOT NULL,
  `active_booking` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `bookings`
--

INSERT INTO `bookings` (`id`, `customer_id`, `person_count`, `children_count`, `small_children_count`, `active_booking`) VALUES
(1, 1, 2, 2, 1, b'1'),
(2, 2, 2, 1, 1, b'1'),
(3, 3, 2, 2, 1, b'1'),
(4, 4, 2, 0, 2, b'1'),
(5, 5, 1, 0, 0, b'1');

-- --------------------------------------------------------

--
-- Tabellstruktur `cities`
--

CREATE TABLE `cities` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `cities`
--

INSERT INTO `cities` (`id`, `name`) VALUES
(1, 'gagarin'),
(2, 'tubel'),
(3, 'dallas'),
(4, 'sheregesh'),
(5, 'New Hilberttown'),
(6, 'Moentown');

-- --------------------------------------------------------

--
-- Tabellstruktur `customers`
--

CREATE TABLE `customers` (
  `id` int(11) UNSIGNED NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `person_number` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `e_mail` (`e_mail`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.customers: ~14 rows (approximately)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT IGNORE INTO `customers` (`id`, `first_name`, `last_name`, `phone_number`, `e_mail`, `password`, `person_number`) VALUES
	(1, 'lonnard', 'BananMannen', '1974177936', 'lsamwell0@scribd.com', 'eilkoip', '1987604839'),
	(2, 'raquel', 'ygoe', '7702878342', 'rygoe1@github.com', '1nvqg7zvrzfd', '1975967927'),
	(3, 'paulita', 'harverson', '9978691640', 'pharverson2@prlog.org', 'ownjzsu', '1990150778'),
	(4, 'garfield', 'tremellier', '1555529808', 'gtremellier3@microsoft.com', '7rx5r7dl', '1974401779'),
	(5, 'vanya', 'atyea', '6578857057', 'vatyea4@purevolume.com', 'jizozevgzzsk', '1986505981'),
	(6, 'Lisa', 'Hansson', '0739990854', 'Lisa@mail.com', 'hemligt', '1980030920'),
	(7, 'Kurt', 'Hansson', '0739990854', 'Kurt@mail.com', 'hemligt', '1980030920'),
	(8, 'test', 'test', '0739990855', 'test@mail.com', '$2a$10$B789zZwhK1dWpie0CkVCvOfPVLBiky7iaQ2/41KnfwPZr.gGHYbaW', '9999999'),
	(9, 'Lennart', 'Banan', '0739990855', 'banan@mail.com', '$2a$10$D.NqvLFC85IFKxU6Cq2DieapKRw6vyA06y9vNTBD9JSk.BtV2M8q6', '8709277'),
	(10, 'Lennart', 'Banan', '0739990855', 'banan3@mail.com', '$2a$10$dU3Uu1Pmp4I6cnuH3wYUe.xByyASEbeEe7BtPf7K5b1q3pqcQE1XC', '8709277'),
	(11, 'Hans', 'Banan', '0739990855', 'banan5@mail.com', '$2a$10$qwKiGk9qVxf/1kyr1P0MieNjNxe.S1yqYN21cgEwo/Dg8G8a1sWWe', '8709277'),
	(12, 'Bengan', 'Banan', '0739990855', 'banan27@mail.com', '$2a$10$D01DSgWKYm4v6QmaIzgCAuGc/wjbNaUyWGK7c1IcNhytH4o46oSRq', '8709277'),
	(14, 'Bengan', 'Banan', '0739990855', 'banan17@mail.com', '$2a$10$FVixqfoXh4aXPGXoE9tUwO0q8pjL0yXF6wvaucySE3hhzXVG6Xzau', '8709277'),
	(16, 'Bengan', 'Banan', '0739990855', 'banan37@mail.com', '$2a$10$bnRwYTfSvBIUpcEX6cRFhOZTvCxZF11V5kwOnHnOWxcAitcIjvr9K', '8709277');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.hotels
CREATE TABLE IF NOT EXISTS `hotels` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `person_number` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `customers`
--

INSERT INTO `customers` (`id`, `first_name`, `last_name`, `phone_number`, `e_mail`, `password`, `person_number`) VALUES
(1, 'lonnard', 'samwell', '1974177936', 'lsamwell0@scribd.com', 'eilkoip', '1987604839'),
(2, 'raquel', 'ygoe', '7702878342', 'rygoe1@github.com', '1nvqg7zvrzfd', '1975967927'),
(3, 'paulita', 'harverson', '9978691640', 'pharverson2@prlog.org', 'ownjzsu', '1990150778'),
(4, 'garfield', 'tremellier', '1555529808', 'gtremellier3@microsoft.com', '7rx5r7dl', '1974401779'),
(5, 'vanya', 'atyea', '6578857057', 'vatyea4@purevolume.com', 'jizozevgzzsk', '1986505981'),
(6, 'test', 'test', '0739990855', 'test@mail.com', '$2a$10$pgEKcxBskfIPhPxs057c5eubpjKa03Jp7jdJF9yQ4PIOtTCYt0Pum', '9999999');

-- --------------------------------------------------------

--
-- Tabellstruktur `hotels`
--

CREATE TABLE `hotels` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL,
  `stars` int(11) UNSIGNED NOT NULL,
  `city_id` int(11) UNSIGNED NOT NULL,
  `picture` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `pool` bit(1) NOT NULL,
  `night_entertainment` bit(1) NOT NULL,
  `restaurant` bit(1) NOT NULL,
  `children_club` bit(1) NOT NULL,
  `distance_to_beach` double(22,0) unsigned NOT NULL,
  `distance_to_center` double(22,0) unsigned NOT NULL,
  `pension_half_price` double(22,0) unsigned NOT NULL,
  `pension_full_price` double(22,0) unsigned NOT NULL,
  `all_inclusive` double(22,0) unsigned NOT NULL,
  `extra_bed` double unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdx_152` (`city_id`),
  CONSTRAINT `FK_152` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.hotels: ~7 rows (approximately)
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT IGNORE INTO `hotels` (`id`, `name`, `stars`, `city_id`, `picture`, `phone`, `e_mail`, `address`, `postal_code`, `pool`, `night_entertainment`, `restaurant`, `children_club`, `distance_to_beach`, `distance_to_center`, `pension_half_price`, `pension_full_price`, `all_inclusive`, `extra_bed`) VALUES
	(1, 'roberts-heller', 1, 1, '', '647 946 9787', 'gglendinning0@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 250, 431, 849, 0),
	(2, 'gorczany inc', 1, 2, '', '458 249 3466', 'fstrowger1@mayoclinic.com', 'ohio', '26787', b'1', b'0', b'0', b'0', 8, 2, 239, 562, 943, 0),
	(3, 'bartoletti and sons', 3, 3, '', '208 116 2957', 'asyers2@people.com.cn', 'john wall', '26467', b'1', b'0', b'0', b'0', 11, 7, 238, 467, 839, 0),
	(4, 'hessel group', 2, 4, '', '613 631 2948', 'xmulvaney3@cargocollective.com', 'hoepker', '26683', b'0', b'1', b'0', b'1', 15, 5, 274, 546, 999, 0),
	(5, 'predovic-cassin', 3, 5, '', '800 863 4709', 'ebownes4@issuu.com', 'farmco', '26685', b'1', b'1', b'0', b'0', 20, 11, 247, 430, 930, 0),
	(6, 'banana hotel', 1, 1, '', '647 946 9787', 'banana2@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 250, 431, 849, 0),
	(7, 'new banana hotel', 1, 1, '', '647 946 9787', 'banana2@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 250, 431, 849, 0);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.reviews
CREATE TABLE IF NOT EXISTS `reviews` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `rating` int(11) unsigned NOT NULL,
  `comment` varchar(255) NOT NULL,
  `booking_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3p9j9vyr1qofbcxju65es206r` (`booking_id`),
  KEY `fkIdx_210` (`booking_id`),
  CONSTRAINT `FK_210` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.reviews: ~4 rows (approximately)
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT IGNORE INTO `reviews` (`id`, `rating`, `comment`, `booking_id`) VALUES
	(1, 5, 'Good hotel :)', 1),
	(2, 1, 'Bad hotel :)', 2),
	(3, 3, 'Jag gillar ost', 3),
	(5, 2, 'dålig service', 5);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `room_type_id` int(11) unsigned NOT NULL,
  `rooms_number` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdx_147` (`room_type_id`),
  CONSTRAINT `FK_147` FOREIGN KEY (`room_type_id`) REFERENCES `room_types` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.rooms: ~6 rows (approximately)
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT IGNORE INTO `rooms` (`id`, `room_type_id`, `rooms_number`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5),
	(6, 6, 1000);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

-- Dumping structure for table gavintravelingdb.room_types
CREATE TABLE IF NOT EXISTS `room_types` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) unsigned NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `price` double(22,0) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdx_144` (`hotel_id`),
  CONSTRAINT `FK_144` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table gavintravelingdb.room_types: ~31 rows (approximately)
/*!40000 ALTER TABLE `room_types` DISABLE KEYS */;
INSERT IGNORE INTO `room_types` (`id`, `hotel_id`, `room_type`, `price`) VALUES
	(1, 4, 'dubbelrum', 1999),
	(2, 1, 'dubbelrum', 1782),
	(3, 2, 'dubbelrum', 1514),
	(4, 1, 'dubbelrum', 1647),
	(5, 5, 'dubbelrum', 1634),
	(6, 3, 'dubbelrum', 1629),
	(7, 3, 'dubbelrum', 1728),
	(8, 3, 'dubbelrum', 1384),
	(9, 3, 'dubbelrum', 1416),
	(10, 3, 'dubbelrum', 1693),
	(11, 2, 'enkelrum', 1300),
	(12, 1, 'enkelrum', 1086),
	(13, 2, 'enkelrum', 1177),
	(14, 4, 'enkelrum', 1215),
	(15, 2, 'enkelrum', 1331),
	(16, 5, 'enkelrum', 841),
	(17, 1, 'enkelrum', 807),
	(18, 5, 'enkelrum', 1227),
	(19, 1, 'enkelrum', 1176),
	(20, 4, 'enkelrum', 894),
	(21, 1, 'familjerum', 1596),
	(22, 3, 'familjerum', 3000),
	(23, 2, 'familjerum', 1516),
	(24, 5, 'familjerum', 2055),
	(25, 4, 'familjerum', 2989),
	(26, 1, 'familjerum', 1748),
	(27, 2, 'familjerum', 1958),
	(28, 1, 'familjerum', 2835),
	(29, 4, 'familjerum', 1429),
	(30, 5, 'familjerum', 1817),
	(31, 4, 'President Suite', 1999);
/*!40000 ALTER TABLE `room_types` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
=======
  `distance_to_beach` double(22,0) UNSIGNED NOT NULL,
  `distance_to_center` double(22,0) UNSIGNED NOT NULL,
  `pension_half_price` double(22,0) UNSIGNED NOT NULL,
  `pension_full_price` double(22,0) UNSIGNED NOT NULL,
  `all_inclusive` double(22,0) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `hotels`
--

INSERT INTO `hotels` (`id`, `name`, `stars`, `city_id`, `picture`, `phone`, `e_mail`, `address`, `postal_code`, `pool`, `night_entertainment`, `restaurant`, `children_club`, `distance_to_beach`, `distance_to_center`, `pension_half_price`, `pension_full_price`, `all_inclusive`) VALUES
(1, 'roberts-heller', 1, 1, '', '647 946 9787', 'gglendinning0@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 250, 431, 849),
(2, 'gorczany inc', 1, 2, '', '458 249 3466', 'fstrowger1@mayoclinic.com', 'ohio', '26787', b'1', b'0', b'0', b'0', 8, 2, 239, 562, 943),
(3, 'bartoletti and sons', 3, 3, '', '208 116 2957', 'asyers2@people.com.cn', 'john wall', '26467', b'1', b'0', b'0', b'0', 11, 7, 238, 467, 839),
(4, 'hessel group', 2, 4, '', '613 631 2948', 'xmulvaney3@cargocollective.com', 'hoepker', '26683', b'0', b'1', b'0', b'1', 15, 5, 274, 546, 999),
(5, 'Test-Hotel', 4, 5, '', '913-200-8235', 'TestarHotellet@hoteltest.com', '23th', '42053', b'1', b'1', b'1', b'0', 4, 20, 200, 500, 900),
(6, 'monkaS', 3, 6, '', '586-218-3476', 'monkaS@twitch.com', '43th', '52353', b'1', b'0', b'0', b'1', 5, 5, 100, 200, 300),
(7, 'Ankunding LLC', 4, 6, '', '544-619-3456', 'Quinten54@gmail.com', '23th', '52253', b'1', b'1', b'1', b'0', 4, 20, 200, 500, 900);

-- --------------------------------------------------------

--
-- Tabellstruktur `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) UNSIGNED NOT NULL,
  `rating` int(11) UNSIGNED NOT NULL,
  `comment` varchar(255) NOT NULL,
  `booking_id` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `reviews`
--

INSERT INTO `reviews` (`id`, `rating`, `comment`, `booking_id`) VALUES
(1, 1, 'good hotel :)', 1),
(2, 1, 'Bad hotel :)', 2),
(3, 3, 'Jag gillar ost', 3),
(4, 4, 'bra arbetat!', 4),
(5, 2, 'dålig service', 5);

-- --------------------------------------------------------

--
-- Tabellstruktur `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) UNSIGNED NOT NULL,
  `room_type_id` int(11) UNSIGNED NOT NULL,
  `rooms_number` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `rooms`
--

INSERT INTO `rooms` (`id`, `room_type_id`, `rooms_number`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4);

-- --------------------------------------------------------

--
-- Tabellstruktur `room_types`
--

CREATE TABLE `room_types` (
  `id` int(11) UNSIGNED NOT NULL,
  `hotel_id` int(11) UNSIGNED NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `price` double(22,0) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `room_types`
--

INSERT INTO `room_types` (`id`, `hotel_id`, `room_type`, `price`) VALUES
(1, 4, 'dubbelrum', 1500),
(2, 1, 'dubbelrum', 1500),
(3, 2, 'dubbelrum', 1500),
(4, 1, 'dubbelrum', 1500),
(5, 3, 'dubbelrum', 1500),
(6, 3, 'dubbelrum', 1500),
(7, 3, 'dubbelrum', 1500),
(8, 3, 'enkelrum', 1000),
(9, 3, 'dubbelrum', 1500),
(10, 3, 'dubbelrum', 1500),
(11, 2, 'enkelrum', 1000),
(12, 1, 'enkelrum', 1000),
(13, 2, 'enkelrum', 1000),
(14, 4, 'enkelrum', 1000),
(15, 2, 'enkelrum', 1000),
(16, 3, 'enkelrum', 1000),
(17, 1, 'enkelrum', 1000),
(18, 1, 'enkelrum', 1000),
(19, 1, 'enkelrum', 1000),
(20, 4, 'enkelrum', 1000),
(21, 1, 'familjerum', 2000),
(22, 3, 'familjerum', 2000),
(23, 2, 'familjerum', 2000),
(24, 2, 'familjerum', 2000),
(25, 4, 'familjerum', 2000),
(26, 1, 'familjerum', 2000),
(27, 2, 'familjerum', 2000),
(28, 1, 'familjerum', 2000),
(29, 4, 'familjerum', 2000),
(30, 4, 'familjerum', 2000);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `booked_rooms`
--
ALTER TABLE `booked_rooms`
  ADD PRIMARY KEY (`booking_id`,`room_id`),
  ADD KEY `fkIdx_222` (`booking_id`),
  ADD KEY `fkIdx_229` (`room_id`);

--
-- Index för tabell `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkIdx_135` (`customer_id`);

--
-- Index för tabell `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`id`);

--
-- Index för tabell `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `e_mail` (`e_mail`),
  ADD UNIQUE KEY `person_number` (`person_number`);

--
-- Index för tabell `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `e_mail` (`e_mail`),
  ADD KEY `fkIdx_152` (`city_id`);

--
-- Index för tabell `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3p9j9vyr1qofbcxju65es206r` (`booking_id`),
  ADD KEY `fkIdx_210` (`booking_id`);

--
-- Index för tabell `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkIdx_147` (`room_type_id`);

--
-- Index för tabell `room_types`
--
ALTER TABLE `room_types`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkIdx_144` (`hotel_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT för tabell `cities`
--
ALTER TABLE `cities`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT för tabell `hotels`
--
ALTER TABLE `hotels`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT för tabell `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT för tabell `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT för tabell `room_types`
--
ALTER TABLE `room_types`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `booked_rooms`
--
ALTER TABLE `booked_rooms`
  ADD CONSTRAINT `FK_222` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_229` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Restriktioner för tabell `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `FK_135` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Restriktioner för tabell `hotels`
--
ALTER TABLE `hotels`
  ADD CONSTRAINT `hotels_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restriktioner för tabell `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK_210` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Restriktioner för tabell `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `FK_147` FOREIGN KEY (`room_type_id`) REFERENCES `room_types` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Restriktioner för tabell `room_types`
--
ALTER TABLE `room_types`
  ADD CONSTRAINT `FK_144` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;



