-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2025 at 10:01 PM
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
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `cost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, 'james sven', 'ansali', 'jamessvenansali@gmail.com', 'Admin', '999999999999', 'jemss31', 'bbd79e22702a1e046b0e59a292b81973d4380edcdfb5dba2322cc86f59c1b5be', 'Aprroved', 'how many finger?', '5', 'src/profiles/hanna.jpg', '555555'),
(26, 'kevin', 'Kevinn', 'kevin@gmail.com', 'Customer', '8764323456', 'kevin1', '12380d8e99984534a7031f6f3d2aa63032de3ddd450053306011ba8a0f1a261d', 'Aprroved', '', '', '', NULL),
(29, 'gwapo', 'gwapooo', 'kevinn@gmail.com', 'Customer', '0', 'kevin', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Pending', '', '', '', NULL),
(31, 'double', 'mint', 'mint@gmail.com', 'Customer', '09392265335', 'kevin2', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Aprroved', 'are you gay?', 'no no no', '', '555555'),
(32, 'khyl', 'Khyl', 'khyl@gmail.com', 'Customer', '09392265335', 'khyl2', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Pending', '', '', '', NULL),
(33, 'charles', 'mala', 'mala@gmail.com', 'Customer', '09392265335', 'charles', '151088d7d32987ac3a10e1d462acd20c02a11faa83ec89e45f61ad9b091cd323', 'Pending', '', '', '', NULL),
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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
