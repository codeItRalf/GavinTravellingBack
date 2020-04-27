-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 24 apr 2020 kl 16:41
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
(5, 2, 1, '2020-06-01 15:00:00', '2020-06-18 11:00:00'),
(6, 6, 1, '2020-06-19 00:00:00', '2020-07-25 00:00:00'),
(7, 7, 1, '2020-07-18 00:00:00', '2020-08-25 00:00:00'),
(8, 8, 1, '2020-06-17 00:00:00', '2020-06-24 00:00:00'),
(9, 9, 1, '2020-07-21 00:00:00', '2020-07-25 00:00:00'),
(10, 10, 1, '2020-06-23 00:00:00', '2020-07-01 00:00:00'),
(11, 11, 1, '2020-06-19 00:00:00', '2020-06-25 00:00:00'),
(12, 12, 1, '2020-07-24 00:00:00', '2020-08-28 00:00:00'),
(13, 13, 1, '2020-06-11 00:00:00', '2020-08-22 00:00:00'),
(14, 14, 1, '2020-08-11 00:00:00', '2020-09-14 00:00:00'),
(15, 15, 1, '2020-08-24 00:00:00', '2020-09-28 00:00:00'),
(16, 16, 1, '2020-06-22 00:00:00', '2020-06-24 00:00:00'),
(17, 17, 1, '2020-09-19 00:00:00', '2020-10-25 00:00:00'),
(18, 18, 1, '2020-08-19 00:00:00', '2020-09-25 00:00:00'),
(19, 19, 1, '2020-04-12 00:00:00', '2020-09-21 00:00:00'),
(20, 20, 1, '2020-08-04 00:00:00', '2020-09-11 00:00:00');

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
(1, 1, 2, 2, 1, b'0'),
(2, 2, 2, 1, 1, b'1'),
(3, 3, 2, 2, 1, b'1'),
(4, 4, 2, 0, 2, b'1'),
(5, 5, 1, 0, 0, b'1'),
(6, 6, 1, 2, 1, b'0'),
(7, 7, 3, 1, 0, b'0'),
(8, 8, 2, 1, 0, b'0'),
(9, 9, 1, 2, 2, b'0'),
(10, 10, 1, 2, 2, b'0'),
(11, 11, 1, 1, 2, b'0'),
(12, 12, 2, 2, 0, b'0'),
(13, 13, 3, 3, 0, b'0'),
(14, 14, 3, 1, 2, b'0'),
(15, 15, 2, 2, 2, b'0'),
(16, 16, 1, 2, 0, b'0'),
(17, 17, 3, 1, 2, b'0'),
(18, 18, 2, 4, 0, b'0'),
(19, 19, 1, 2, 1, b'0'),
(20, 20, 1, 1, 2, b'0');

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
(6, 'West Felicityton'),
(7, 'Corkerybury'),
(8, 'North Nannieport'),
(9, 'East Hassieborough'),
(10, 'South Deon'),
(11, 'Ronnychester'),
(12, 'New Otiliaview'),
(13, 'Port Damian'),
(14, 'Gutmannshire'),
(15, 'North Jaunitaside'),
(16, 'South Haroldfurt'),
(17, 'New Jack'),
(18, 'East Miguelfort'),
(19, 'Kshlerinburgh'),
(20, 'O\'Keefechester');

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
(6, 'Reed', 'Bechtelar', '890-102-8137', 'Delaney33@hotmail.com', 'D0R0e3H4q8vWUHw', '1993746294'),
(7, 'Leola', 'Conroy', '776-519-4548', 'Breana35@gmail.com', 'mOJiwMYyyM7Z2BV', '1992991172'),
(8, 'Elliot', 'Hyatt', '291-303-4807', 'Bryce_Walker2@hotmail.com', 'tASKPVUxocx8GGq', '1991316087'),
(9, 'Bartholome', 'O\'Hara', '015-186-4617', 'Maegan_Bergnaum52@gmail.com', 'baw6k7RD1v7eN8i', '1997898815'),
(10, 'Lawrence', 'Klein', '643-571-9418', 'Justice_Jones@gmail.com', 'rBOwHHLIbxwtvQd', '1998101065'),
(11, 'Danyka', 'Conroy', '990-908-7293', 'Lyric.Gerlach79@hotmail.com', 'tT4oC6BjLEpad10', '1992732616'),
(12, 'Polly', 'Wisoky', '069-897-1896', 'Bernhard_Legros93@yahoo.com', 'Xuy9csfKxkLwXzn', '1996651762'),
(13, 'Nathan', 'Hintz', '185-443-8762', 'Nikita.Auer@hotmail.com', 'Cv8FKYH9R9BknOk', '1990230006'),
(14, 'Richie', 'Berge', '939-543-2575', 'Xavier.Beer64@gmail.com', 'rI7l_pKAWllVv7d', '1995799533'),
(15, 'Armani', 'Okuneva', '958-309-3894', 'Shane.Klein@hotmail.com', 'NdvYY5jNAQAoAjx', '1994111129'),
(16, 'Vidal', 'Breitenberg', '208-205-9042', 'Lucio86@gmail.com', '2GJpJNFWj4H7SVN', '1998538928'),
(17, 'Albina', 'Johnston', '499-929-3348', 'Arely_Wisozk90@hotmail.com', 'FzWzFFSG5ZkaMYv', '1990906305'),
(18, 'Terence', 'Hilpert', '582-659-6359', 'Lisette_Jacobi34@gmail.com', '9ogqBLhxJHPI9sd', '1990722602'),
(19, 'Percival', 'Lemke', '627-229-9042', 'Armand.Harber59@gmail.com', 'W4b2VURpet2PB3G', '1994593304'),
(20, 'Lowell', 'Kertzmann', '895-834-1459', 'Carmelo12@hotmail.com', '0moEId2XzL75kJd', '1997885198');

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
(1, 'roberts-heller', 1, 1, '', '647 946 9787', 'gglendinning0@dagondesign.com', '4th', '26653', b'1', b'1', b'1', b'0', 2, 20, 100, 200, 300, 0),
(2, 'gorczany inc', 1, 2, '', '458 249 3466', 'fstrowger1@mayoclinic.com', 'ohio', '26787', b'1', b'1', b'0', b'0', 8, 2, 100, 200, 300, 0),
(3, 'bartoletti and sons', 3, 3, '', '208 116 2957', 'asyers2@people.com.cn', 'john wall', '26467', b'1', b'1', b'0', b'0', 11, 7, 100, 200, 300, 0),
(4, 'hessel group', 2, 4, '', '613 631 2948', 'xmulvaney3@cargocollective.com', 'hoepker', '26683', b'0', b'1', b'0', b'1', 15, 5, 100, 200, 300, 0),
(5, 'predovic-cassin', 3, 5, '', '800 863 4709', 'ebownes4@issuu.com', 'farmco', '26685', b'1', b'1', b'0', b'0', 20, 11, 100, 200, 300, 0),
(6, 'Johnson Inc', 2, 6, '', '722-251-7531', 'Cesar84@gmail.com', '433th', '22253', b'1', b'0', b'0', b'1', 2, 3, 100, 200, 300, 0),
(7, 'Flatley Group', 2, 7, '', '628-735-4493', 'Alexander.Kautzer54@yahoo.com', '3213th', '42253', b'1', b'1', b'0', b'1', 3, 1, 100, 200, 300, 0),
(8, 'Russel - Halvorson', 2, 8, '', '737-894-7729', 'Kyleigh_Ondricka30@yahoo.com', '33th', '12253', b'1', b'0', b'1', b'1', 1, 3, 100, 200, 300, 0),
(9, 'Robel - Marquardt', 2, 10, '', '317-167-6363', 'Ricardo95@hotmail.com', '631th', '25233', b'1', b'1', b'0', b'1', 15, 15, 100, 200, 300, 0),
(10, 'Robel - Mayert', 2, 10, '', '522-548-2996', 'Hayden_Grady19@yahoo.com', '923th', '25153', b'1', b'0', b'1', b'1', 2, 1, 100, 200, 300, 0),
(11, 'Brekke Inc', 2, 11, '', '982-395-4403', 'Gillian.Stamm@hotmail.com', '4233th', '12253', b'1', b'0', b'0', b'1', 6, 12, 100, 200, 300, 0),
(12, 'Hettinger - Torphy', 2, 12, '', '990-711-3531', 'Nathaniel.Walsh@yahoo.com', '123th', '17253', b'1', b'0', b'1', b'1', 3, 16, 100, 200, 300, 0),
(13, 'Walter and Sons', 2, 14, '', '031-920-4156', 'Letitia_Zulauf14@hotmail.com', '313th', '65253', b'1', b'0', b'1', b'1', 12, 2, 100, 200, 300, 0),
(14, 'Roberts LLC', 2, 15, '', '648-624-5683', 'Madisyn.Witting10@hotmail.com', '223th', '65453', b'1', b'0', b'0', b'1', 3, 6, 100, 200, 300, 0),
(15, 'McGlynn Inc', 2, 15, '', '687-293-1942', 'Caroline79@gmail.com', '133th', '45253', b'1', b'1', b'1', b'1', 2, 12, 100, 200, 300, 0),
(16, 'Wintheiser - Hyatt', 2, 17, '', '048-069-5054', 'Rick.Cole@yahoo.com', '43th', '96253', b'1', b'0', b'0', b'1', 12, 13, 100, 200, 300, 0),
(17, 'Schaefer and Sons', 2, 19, '', '619-764-5992', 'Tyra.Prosacco9@gmail.com', '563th', '97253', b'1', b'0', b'0', b'1', 2, 1, 100, 200, 300, 0),
(18, 'Howell Inc', 2, 20, '', '285-669-0486', 'Mylene_Hintz@yahoo.com', '893th', '33253', b'1', b'1', b'1', b'1', 7, 7, 100, 200, 300, 0),
(19, 'Bins - Schoen', 2, 20, '', '634-277-7528', 'Berry59@yahoo.com', '889th', '46753', b'1', b'1', b'0', b'1', 7, 17, 100, 200, 300, 0),
(20, 'Koelpin - Hamill', 2, 20, '', '299-287-6227', 'Reginald26@hotmail.com', '663th', '13053', b'1', b'1', b'1', b'1', 16, 12, 100, 200, 300, 0);

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
(6, 3, 'quo voluptas nulla pariatur', 6),
(7, 4, 'nulla pariatur', 7),
(8, 1, 'quo voluptas', 8),
(9, 2, 'voluptas nulla', 9),
(10, 4, 'nulla quo', 10),
(11, 3, 'voluptas nice', 11),
(12, 5, 'nicevoluptas', 12),
(13, 1, 'nivoluptasce', 13),
(14, 2, 'npariaturice', 14),
(15, 4, 'nipariaturce', 15),
(16, 3, 'nipariatuturce', 16),
(17, 1, 'ariatu', 17),
(18, 3, 'nquo voluice', 18),
(19, 2, 'niquo voluce', 19),
(20, 4, 'niquice', 20);

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
(3, 14, 2),
(4, 22, 2),
(5, 5, 1),
(6, 6, 2),
(7, 19, 1),
(8, 8, 4),
(9, 9, 3),
(10, 11, 1),
(11, 13, 2),
(12, 17, 4),
(13, 18, 3),
(14, 14, 2),
(15, 20, 1),
(16, 21, 2),
(17, 22, 1),
(18, 24, 1),
(19, 32, 2),
(20, 35, 1);

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
(1, 1, 'dubbelrum', 1500),
(2, 2, 'dubbelrum', 1500),
(3, 3, 'dubbelrum', 1500),
(4, 4, 'dubbelrum', 1500),
(5, 5, 'dubbelrum', 1500),
(6, 6, 'dubbelrum', 1500),
(7, 7, 'dubbelrum', 1500),
(8, 8, 'dubbelrum', 1500),
(9, 9, 'dubbelrum', 1500),
(10, 10, 'dubbelrum', 1500),
(11, 11, 'dubbelrum', 1500),
(12, 12, 'dubbelrum', 1500),
(13, 13, 'dubbelrum', 1500),
(14, 14, 'dubbelrum', 1500),
(15, 15, 'dubbelrum', 1500),
(16, 16, 'dubbelrum', 1500),
(17, 17, 'dubbelrum', 1500),
(18, 18, 'dubbelrum', 1500),
(19, 19, 'dubbelrum', 1500),
(20, 20, 'dubbelrum', 1500),
(21, 1, 'enkelrum', 1500),
(22, 2, 'enkelrum', 1500),
(23, 3, 'enkelrum', 1500),
(24, 4, 'enkelrum', 1500),
(25, 5, 'enkelrum', 1500),
(26, 6, 'enkelrum', 1500),
(27, 7, 'enkelrum', 1500),
(28, 8, 'enkelrum', 1500),
(29, 9, 'enkelrum', 1500),
(30, 10, 'enkelrum', 1500),
(31, 11, 'enkelrum', 1500),
(32, 12, 'enkelrum', 1500),
(33, 13, 'enkelrum', 1500),
(34, 14, 'enkelrum', 1500),
(35, 15, 'enkelrum', 1500),
(36, 16, 'enkelrum', 1500),
(37, 17, 'enkelrum', 1500),
(38, 18, 'enkelrum', 1500),
(39, 19, 'enkelrum', 1500),
(40, 20, 'enkelrum', 1500),
(41, 1, 'familjerum', 2000),
(42, 2, 'familjerum', 2000),
(43, 3, 'familjerum', 2000),
(44, 4, 'familjerum', 2000),
(45, 5, 'familjerum', 2000),
(46, 6, 'familjerum', 2000),
(47, 7, 'familjerum', 2000),
(48, 8, 'familjerum', 2000),
(49, 9, 'familjerum', 2000),
(50, 10, 'familjerum', 2000),
(51, 11, 'familjerum', 2000),
(52, 12, 'familjerum', 2000),
(53, 13, 'familjerum', 2000),
(54, 14, 'familjerum', 2000),
(55, 15, 'familjerum', 2000),
(56, 16, 'familjerum', 2000),
(57, 17, 'familjerum', 2000),
(58, 18, 'familjerum', 2000),
(59, 19, 'familjerum', 2000),
(60, 20, 'familjerum', 2000);

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
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `cities`
--
ALTER TABLE `cities`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `hotels`
--
ALTER TABLE `hotels`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT för tabell `room_types`
--
ALTER TABLE `room_types`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

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
