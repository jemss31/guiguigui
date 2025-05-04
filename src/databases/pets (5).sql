-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2025 at 05:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pets`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `a_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `pet_name` varchar(255) NOT NULL,
  `u_fname` varchar(255) DEFAULT NULL,
  `u_lname` varchar(255) DEFAULT NULL,
  `u_email` varchar(255) DEFAULT NULL,
  `cont` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `groom` varchar(255) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  `haircut_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`a_id`, `date`, `time`, `pet_name`, `u_fname`, `u_lname`, `u_email`, `cont`, `user_id`, `groom`, `cost`, `haircut_id`) VALUES
(16, '2025-05-05', '08:30:00', 'gwapo', 'kevin', 'Kevinn', 'kevin@gmail.com', NULL, 26, NULL, NULL, NULL),
(17, '2025-05-15', '16:12:00', 'late', 'kevin', 'Kevinn', 'kevin@gmail.com', NULL, 26, NULL, NULL, NULL),
(18, '2025-05-30', '12:14:00', 'Rosalita', 'kevin', 'Kevinn', 'kevin@gmail.com', NULL, 26, NULL, NULL, NULL),
(19, '2025-05-05', '13:00:00', 'shit', 'kevin', 'Kevinn', 'kevin@gmail.com', NULL, 26, NULL, NULL, NULL),
(20, '2025-05-13', '06:25:00', 'sabio', 'kevin', 'Kevinn', 'kevin@gmail.com', '8764323456', 26, NULL, NULL, NULL),
(21, '2025-05-05', '18:00:00', 'tae', 'kevin', 'Kevinn', 'kevin@gmail.com', '8764323456', 26, NULL, 25.00, 1),
(22, '2025-05-06', '06:55:00', 'dadsadsa', 'kevin', 'Kevinn', 'kevin@gmail.com', '8764323456', 26, NULL, 35.00, 5),
(23, '2025-05-20', '06:00:00', 'dsadsadsadsad', 'kevin', 'Kevinn', 'kevin@gmail.com', '8764323456', 26, '2', 30.00, NULL),
(24, '2025-05-12', '00:01:00', 'gwapo', 'kevin', 'Kevinn', 'kevin@gmail.com', '8764323456', 26, 'Mohowk', 30.00, 2),
(25, '2025-05-06', '20:06:00', 'siomai nga iring', 'kevin', 'Ansali', 'kevin@gmail.com', '8764323456', 26, 'Mohowk', 30.00, 2),
(26, '2025-05-04', '08:00:00', 'iring', 'kevin', 'Ansali', 'kevin@gmail.com', '8764323456', 26, 'Mohowk', 30.00, 2),
(27, '2025-05-04', '20:00:00', 'shabo', 'kevin', 'Ansali', 'kevin@gmail.com', '8764323456', 26, 'Mohowk', 30.00, 2),
(28, '2025-05-04', '21:58:00', 'SDASFDF', 'double', 'mint', 'mint@gmail.com', '09392265335', 31, 'Lion Cut', 35.00, 5);

-- --------------------------------------------------------

--
-- Table structure for table `haircuts`
--

CREATE TABLE `haircuts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `haircuts`
--

INSERT INTO `haircuts` (`id`, `name`, `cost`, `duration`) VALUES
(1, 'Edgar Cut', 25.00, 45),
(2, 'Mohowk', 30.00, 60),
(3, 'Mushroom', 20.00, 60),
(4, 'Croptop', 28.00, 75),
(5, 'Lion Cut', 35.00, 90),
(6, 'Top Knot', 22.00, 60),
(7, 'Flat Top', 27.00, 60),
(8, 'Teddy Bear Cut', 24.00, 65);

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `id`, `log_action`, `log_date`) VALUES
(1, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 13:58:20'),
(2, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 14:05:33'),
(3, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 14:13:06'),
(4, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 14:57:05'),
(5, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 14:57:18'),
(6, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-03 11:24:59'),
(7, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:40:31'),
(8, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:40:41'),
(9, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:40:45'),
(10, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:52:54'),
(11, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:55:19'),
(12, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:55:27'),
(13, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:56:03'),
(14, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:59:36'),
(15, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 14:59:49'),
(16, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:00:18'),
(17, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:03:29'),
(18, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:03:31'),
(19, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:03:39'),
(20, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:03:49'),
(21, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:05:21'),
(22, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:05:25'),
(23, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:05:36'),
(24, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:08:44'),
(25, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:08:48'),
(26, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:15:16'),
(27, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:15:21'),
(28, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:20:28'),
(29, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:20:36'),
(30, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:24:47'),
(31, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:24:53'),
(32, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:28:55'),
(33, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:28:57'),
(34, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-05-04 15:29:01'),
(35, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:33:19'),
(36, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:33:24'),
(37, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:37:12'),
(38, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:37:19'),
(39, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:41:12'),
(40, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:41:15'),
(41, 26, 'Admin updated user info: kevin1 (User ID: 26)', '2025-05-04 15:41:20');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `u_fname` varchar(50) DEFAULT NULL,
  `u_lname` varchar(50) DEFAULT NULL,
  `u_email` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `cont` varchar(20) DEFAULT NULL,
  `u_username` varchar(50) DEFAULT NULL,
  `u_pass` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Pending',
  `SecurityQuestion` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `image` varchar(55) DEFAULT NULL,
  `PIN` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `u_fname`, `u_lname`, `u_email`, `type`, `cont`, `u_username`, `u_pass`, `status`, `SecurityQuestion`, `answer`, `image`, `PIN`) VALUES
(1, 'james sven', 'Canonigo', 'jamessvenansali@gmail.com', 'Admin', '999999999999', 'jemss31', 'bbd79e22702a1e046b0e59a292b81973d4380edcdfb5dba2322cc86f59c1b5be', 'Aprroved', 'how many finger?', '5', 'C:\\Users\\admin\\Pictures\\Screenshots\\2.png', '555555'),
(26, 'kevin', 'Ansali', 'kevin@gmail.com', 'Customer', '8764323456', 'kevin1', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Aprroved', 'Niggas?', 'oo', 'C:\\Users\\admin\\Desktop\\1st Year\\21.png', '123456'),
(29, 'gwapo', 'gwapooo', 'kevinn@gmail.com', 'Customer', '0', 'kevin', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Pending', '', '', '', NULL),
(31, 'double', 'mint', 'mint@gmail.com', 'Customer', '09392265335', 'kevin2', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Aprroved', 'are you gay?', 'no no no', '', '555555'),
(32, 'khyl', 'Khyl', 'khyl@gmail.com', 'Customer', '09392265335', 'khyl2', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Pending', '', '', '', NULL),
(33, 'charles', 'mala', 'mala@gmail.com', 'Customer', '09392265335', 'charles', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Approved', '', '', '', '111111'),
(42, 'ansali', 'ansali', 'ansali@gmail.com', 'Admin', '095263426343', 'ansali1', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Pending', 'how many shits?', 'gwapo', '', NULL),
(43, 'rasil', 'ansali', 'razhielansali@gmail.com', 'Customer', '093922653151', 'rasil', '5ae4b6d4af4e10776281bb948f6b66b0babc41bc73f96f70abc93d807f5095a9', 'Approved', 'humot ako ilok jeven?', 'humot kaayo', '', NULL),
(44, 'khyl', 'ansali', 'khylcanonigoansali@gmail.com', 'Admin', '092352524523', 'khyl123', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Approved', 'shesh?', 'no', '', NULL),
(45, 'test', 'test', 'test@gmail.com', 'Admin', '924156163633', 'test1', '8776f108e247ab1e2b323042c049c266407c81fbad41bde1e8dfc1bb66fd267e', 'Aprroved', 'is it pink?', 'yes', 'src/profileImages/hanna.jpg', '111111'),
(48, 'khyl', 'pogi', 'khyl321@gmail.com', 'Admin', '09123456780', 'khyl321', '3fbfeb0ee307127bbd4ef7da33f7b57a9ff3c7357da182c5bfccc2a4f599c6f9', 'Aprroved', 'bahog bilat?', 'Jven', NULL, NULL),
(49, 'carlo', 'ababan', 'carlo@gmail.com', 'Customer', '123456789121', 'carlolo', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Pending', '2. What is your mother\'s maiden name?', 'jaypee', NULL, NULL),
(50, 'andre', 'estrera', 'andre@gmail.com', 'Customer', '123456789161', 'andregwapo', '2fa755af79b4b8440d2f265f14ce41325fa8325eb2d1debe0edb55752f57a2cf', 'Pending', 'nigaass?', 'of course', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `fk_user` (`user_id`),
  ADD KEY `fk_haircut_id` (`haircut_id`);

--
-- Indexes for table `haircuts`
--
ALTER TABLE `haircuts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_username` (`u_username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `haircuts`
--
ALTER TABLE `haircuts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `fk_haircut_id` FOREIGN KEY (`haircut_id`) REFERENCES `haircuts` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
