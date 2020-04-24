-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 24 apr 2020 kl 13:48
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

--
-- Dumpning av Data i tabell `booked_rooms`
--

INSERT INTO `booked_rooms` (`booking_id`, `room_id`, `extra_bed`, `start_date`, `end_date`) VALUES
(1, 1, 1, '2020-06-19 15:00:00', '2020-06-25 11:00:00'),
(2, 2, 2, '2020-06-24 15:00:00', '2020-06-29 11:00:00'),
(3, 3, 0, '2020-06-01 15:00:00', '2020-06-25 12:00:00'),
(4, 3, 2, '2020-06-12 15:00:00', '2020-07-05 11:00:00'),
(5, 2, 1, '2020-07-01 15:00:00', '2020-07-04 11:00:00'),
(6, 6, 1, '2020-06-19 00:00:00', '2020-06-25 00:00:00');

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
  `active_booking` bit(1) NOT NULL,
  `full_pension` int(3) UNSIGNED NOT NULL,
  `Half_pension` int(3) UNSIGNED NOT NULL,
  `all_inclusive` int(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `bookings`
--

INSERT INTO `bookings` (`id`, `customer_id`, `person_count`, `children_count`, `small_children_count`, `active_booking`, `full_pension`, `Half_pension`, `all_inclusive`) VALUES
(1, 1, 2, 2, 1, b'0', 0, 0, 0),
(2, 2, 2, 1, 1, b'1', 0, 0, 0),
(3, 3, 2, 2, 1, b'1', 0, 0, 0),
(4, 4, 2, 0, 2, b'1', 0, 0, 0),
(5, 5, 1, 0, 0, b'1', 0, 0, 0),
(6, 6, 2, 2, 1, b'1', 0, 0, 0);

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
(5, 'banyumas'),
(6, 'Royceshire'),
(7, 'Lake Toby');

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
(5, 'test', 'test', '0739990855', 'test@mail.com', '$2a$10$B789zZwhK1dWpie0CkVCvOfPVLBiky7iaQ2/41KnfwPZr.gGHYbaW', '9999999'),
(6, 'vanya', 'atyea', '6578857057', 'vatyea4@purevolume.com', 'jizozevgzzsk', '1986505981'),
(7, 'Tyree', 'Bednar', '005-503-8853', 'Waldo52@hotmail.com', 'MHhCeXp6ZGnVuXx', '1989203832');

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
  `distance_to_beach` double(22,0) UNSIGNED NOT NULL,
  `distance_to_center` double(22,0) UNSIGNED NOT NULL,
  `pension_half_price` double(22,0) UNSIGNED NOT NULL,
  `pension_full_price` double(22,0) UNSIGNED NOT NULL,
  `all_inclusive` double(22,0) UNSIGNED NOT NULL,
  `extra_bed` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `hotels`
--

INSERT INTO `hotels` (`id`, `name`, `stars`, `city_id`, `picture`, `phone`, `e_mail`, `address`, `postal_code`, `pool`, `night_entertainment`, `restaurant`, `children_club`, `distance_to_beach`, `distance_to_center`, `pension_half_price`, `pension_full_price`, `all_inclusive`, `extra_bed`) VALUES
(1, 'roberts-heller', 1, 1, '', '647 946 9787', 'gglendinning0@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 200, 300, 400, 0),
(2, 'gorczany inc', 1, 2, '', '458 249 3466', 'fstrowger1@mayoclinic.com', 'ohio', '26787', b'1', b'0', b'0', b'0', 8, 2, 200, 300, 400, 0),
(3, 'bartoletti and sons', 3, 3, '', '208 116 2957', 'asyers2@people.com.cn', 'john wall', '26467', b'1', b'0', b'0', b'0', 11, 7, 200, 300, 400, 0),
(4, 'hessel group', 2, 4, '', '613 631 2948', 'xmulvaney3@cargocollective.com', 'hoepker', '26683', b'0', b'1', b'0', b'1', 15, 5, 200, 300, 400, 0),
(5, 'predovic-cassin', 3, 5, '', '800 863 4709', 'ebownes4@issuu.com', 'farmco', '26685', b'1', b'1', b'0', b'0', 20, 11, 200, 300, 400, 0),
(6, 'Dach - Lehner', 4, 7, '', '498-955-8002', 'Garrett.Lang90@gmail.com', '13th', '52253', b'1', b'1', b'1', b'0', 4, 20, 200, 300, 400, 0);

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
(5, 2, 'dålig service', 5),
(6, 2, 'dfggfsdsdfgfsgdfgsd', 6);

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
(4, 4, 4),
(5, 5, 5),
(6, 14, 3);

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
(8, 3, 'dubbelrum', 1500),
(9, 3, 'dubbelrum', 1500),
(10, 3, 'dubbelrum', 1500),
(11, 2, 'enkelrum', 1000),
(12, 1, 'enkelrum', 1000),
(13, 2, 'enkelrum', 1000),
(14, 4, 'enkelrum', 1000),
(15, 2, 'enkelrum', 1000),
(16, 2, 'enkelrum', 1000),
(17, 1, 'enkelrum', 1000),
(18, 2, 'enkelrum', 1000),
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
(29, 2, 'familjerum', 2000),
(30, 4, 'familjerum', 2000),
(31, 4, 'dubbelrum', 2000);

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
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `cities`
--
ALTER TABLE `cities`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT för tabell `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT för tabell `hotels`
--
ALTER TABLE `hotels`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `room_types`
--
ALTER TABLE `room_types`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

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
  ADD CONSTRAINT `FK_152` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
