-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2025 at 08:12 PM
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
  `status` varchar(20) DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `u_fname`, `u_lname`, `u_email`, `type`, `cont`, `u_username`, `u_pass`, `status`) VALUES
(1, 'james sven', 'ansali', 'jamessvenansali@gmail.com', 'Admin', '0', 'jemss31', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Aprroved'),
(26, 'kevin', 'Kevinn', 'kevin@gmail.com', 'Customer', '0', 'kevin1', '12380d8e99984534a7031f6f3d2aa63032de3ddd450053306011ba8a0f1a261d', 'Aprroved'),
(29, 'gwapo', 'gwapooo', 'kevinn@gmail.com', 'Customer', '0', 'kevin', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Pending'),
(31, 'double', 'mint', 'mint@gmail.com', 'Customer', '09392265335', 'kevin2', '86dbd4b78445c1ed19a87c8c24062b4bb278ee0d0fbc992a7d738ab5bbdc6792', 'Aprroved'),
(32, 'khyl', 'Khyl', 'khyl@gmail.com', 'Customer', '09392265335', 'khyl2', '38df64d81b9cafcef76c3528799b2ad791cc6e12b304561472f4af28b836f3ec', 'Pending'),
(33, 'charles', 'mala', 'mala@gmail.com', 'Customer', '09392265335', 'charles', '151088d7d32987ac3a10e1d462acd20c02a11faa83ec89e45f61ad9b091cd323', 'Pending'),
(34, 'cher', 'cherr', 'cher@gmail.com', 'Customer', '09392265335', 'cherr', '1cb787c704bb564a2f0ed86ccd323dd05eb0fe5f1d6f5c98dbd446def232aecf', 'Pending'),
(35, 'asda', 'asd', 'asda@gmail.com', 'Admin', '982374234', 'asdss', '4d5631474bb719835d92dfc2ddb24a20b8e2c583edb68ea99857c9294268216d', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
