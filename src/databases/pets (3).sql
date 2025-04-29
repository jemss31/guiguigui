-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2025 at 07:24 PM
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
  `haircut_id` int(11) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`a_id`, `date`, `time`, `pet_name`, `haircut_id`, `cost`, `user_id`) VALUES
(1, '2025-04-30', '10:00:00', 'Pet Name', 2, 30.00, 1),
(2, '2025-04-30', '10:00:00', 'Jaypee', 3, 20.00, NULL),
(3, '2025-04-30', '10:00:00', 'Nutella', 1, 25.00, NULL),
(4, '2025-05-01', '10:00:00', 'kabayo', 2, 30.00, NULL),
(5, '2025-05-02', '10:00:00', 'Pet Name', 6, 22.00, NULL),
(6, '2025-05-03', '10:00:00', 'Doggo', 1, 25.00, 1),
(7, '2025-05-14', '10:00:00', 'nut', 7, 27.00, 26),
(8, '2025-05-06', '10:00:00', 'Andre', 3, 20.00, 33),
(9, '2025-05-07', '10:00:00', 'Itlog', 4, 28.00, 26),
(10, '2025-05-07', '15:30:00', 'Sabio', 6, 22.00, 26);

-- --------------------------------------------------------

--
-- Table structure for table `haircuts`
--

CREATE TABLE `haircuts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cost` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `haircuts`
--

INSERT INTO `haircuts` (`id`, `name`, `cost`) VALUES
(1, 'Edgar Cut', 25.00),
(2, 'Mohowk', 30.00),
(3, 'Mushroom', 20.00),
(4, 'Croptop', 28.00),
(5, 'Lion Cut', 35.00),
(6, 'Top Knot', 22.00),
(7, 'Flat Top', 27.00),
(8, 'Teddy Bear Cut', 24.00);

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
(5, 1, 'Admin updated user info: jemss31 (User ID: 1)', '2025-04-29 14:57:18');

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
(1, 'james sven', 'ansali', 'jamessvenansali@gmail.com', 'Admin', '999999999999', 'jemss31', 'bbd79e22702a1e046b0e59a292b81973d4380edcdfb5dba2322cc86f59c1b5be', 'Aprroved', 'how many finger?', '5', 'src/Profiles/23.png', '555555'),
(26, 'kevin', 'Kevinn', 'kevin@gmail.com', 'Customer', '8764323456', 'kevin1', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Aprroved', '', '', '', '123456'),
(29, 'gwapo', 'gwapooo', 'kevinn@gmail.com', 'Customer', '0', 'kevin', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Pending', '', '', '', NULL),
(31, 'double', 'mint', 'mint@gmail.com', 'Customer', '09392265335', 'kevin2', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Aprroved', 'are you gay?', 'no no no', '', '555555'),
(32, 'khyl', 'Khyl', 'khyl@gmail.com', 'Customer', '09392265335', 'khyl2', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Pending', '', '', '', NULL),
(33, 'charles', 'mala', 'mala@gmail.com', 'Customer', '09392265335', 'charles', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Approved', '', '', '', '111111'),
(42, 'ansali', 'ansali', 'ansali@gmail.com', 'Admin', '095263426343', 'ansali1', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Pending', 'how many shits?', 'gwapo', '', NULL),
(43, 'rasil', 'ansali', 'razhielansali@gmail.com', 'Customer', '093922653151', 'rasil', '5ae4b6d4af4e10776281bb948f6b66b0babc41bc73f96f70abc93d807f5095a9', 'Approved', 'humot ako ilok jeven?', 'humot kaayo', '', NULL),
(44, 'khyl', 'ansali', 'khylcanonigoansali@gmail.com', 'Admin', '092352524523', 'khyl123', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Approved', 'shesh?', 'no', '', NULL),
(45, 'test', 'test', 'test@gmail.com', 'Admin', '924156163633', 'test1', '8776f108e247ab1e2b323042c049c266407c81fbad41bde1e8dfc1bb66fd267e', 'Aprroved', 'is it pink?', 'yes', 'src/profileImages/hanna.jpg', '111111');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `haircut_id` (`haircut_id`),
  ADD KEY `fk_user` (`user_id`);

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
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `haircuts`
--
ALTER TABLE `haircuts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
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
