-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2025 at 03:43 PM
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
  `u_username` varchar(50) DEFAULT NULL,
  `u_pass` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `u_fname`, `u_lname`, `u_email`, `type`, `u_username`, `u_pass`, `status`) VALUES
(1, 'james sven', 'ansali', 'ansali@gmail.com', 'Admin', 'jemss31', '8ceb97b3e7a3ed6e6afbe95978431f8ff13d1c8b695a1fe7a3ccb41d9c8b19a4', 'Aprroved'),
(10, 'maby', 'ansali', 'maby@gmail.com', 'customer', 'maby1', 'c8820dc89d2ca6e8d7bcbfbb99f97e1197125ccb114f7a1af8b0aaf84a9c5e95', 'Approved'),
(11, 'maby', 'mabys', 'mabyy@gmail.com', 'customer', 'maby2', 'c8820dc89d2ca6e8d7bcbfbb99f97e1197125ccb114f7a1af8b0aaf84a9c5e95', 'Approved'),
(13, 'Kevin', 'Mangoroban', 'kevin@gmail.com', 'customer', 'Kevin', '2865422dd623cc2899fd4dc2585092bb097e05ec69a6fc0ccbd4ad8f9c43b73f', 'Aprroved'),
(14, 'kiven', 'ansali', 'gwapo@gmail.com', 'Customer', 'kevin2', 'ec04613f62cf13619815224e8e418a78e032ca2e26db6e520b17aef72774d5da', 'Approved'),
(15, 'Ansali', 'Canon', 'canon@gmail.com', 'Admin', 'canon', '198117a6641aaa7c2ce581a472ca10520610e8dce23196da24bdb30cdb4e8143', 'Active'),
(16, 'James Sven', 'Ansali', 'Jamessvenansali@gmail.com', 'Admin', 'james', '338c8bf01f4552dff1d4b2eed84c7a38c3a5f001604804fba47e3d28fc6ad4f5', 'Approved'),
(17, 'gwapo', 'SHI', 'shi@gmail.com', 'Customer', 'gwapo', '294012afaad0f7875d978da9ea1625c750f528fc28fd437e01fd9259246c460c', 'Pending'),
(18, 'kevin', 'kevin', 'asd@gmail.com', 'Customer', 'ansali', '75dc08ad7b7d6ea1ee51ca7a2e2cf9917350dec46d37b801e13be94b860c56aa', 'Pending'),
(19, 'rasil', 'rasil', 'rasil@gmail.com', 'Admin', 'rasil', '587f8c1650c1b3d8eede61c3b8588352a46212b7227da3f8983bb970b37d4395', 'Pending');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
