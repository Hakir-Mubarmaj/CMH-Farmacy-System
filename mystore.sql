-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2022 at 08:18 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mystore`
--

-- --------------------------------------------------------

--
-- Table structure for table `apoint`
--

CREATE TABLE `apoint` (
  `id` int(11) NOT NULL,
  `doctor` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `apoint`
--

INSERT INTO `apoint` (`id`, `doctor`, `user`) VALUES
(5, '234', '456');

-- --------------------------------------------------------

--
-- Table structure for table `consume`
--

CREATE TABLE `consume` (
  `id` int(11) NOT NULL,
  `person_id` varchar(500) NOT NULL,
  `medicine` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `consume`
--

INSERT INTO `consume` (`id`, `person_id`, `medicine`) VALUES
(1, '123', 'Atorvastatin'),
(2, '123', 'Amoxicillin'),
(3, '123', 'Propranol'),
(4, '456', 'Lisinopril'),
(5, '456', 'Levothyroxine'),
(6, '456', 'Albuterol');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dept` varchar(100) NOT NULL,
  `docID` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `dept`, `docID`) VALUES
(1, 'Brig Gen SM Mijanur Rahman', 'Gastroenteriology', '123'),
(2, 'Maj Tarik Hasan', 'Oncology', '234'),
(3, 'Doctor3', 'Cardiology', '345'),
(4, 'Doctor4', 'Urology', '456'),
(5, 'Doctor5', 'Neurology', '567'),
(6, 'Doctor6', 'Orthopedic', '678');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `ID` int(11) NOT NULL,
  `med_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`ID`, `med_name`) VALUES
(1, 'Atorvastatin'),
(2, 'Amoxicillin'),
(3, 'Lisinopril'),
(4, 'Levothyroxine'),
(5, 'Albuterol');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `doctor` varchar(100) DEFAULT NULL,
  `docDept` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phone`, `address`, `password`, `doctor`, `docDept`) VALUES
(1, 'MD. Mizanur Rahman', '123', '+8801912081513', 'Kawnia,Barisal', '123', 'Brig Gen SM Mijanur Rahman', 'Gastroenteriology'),
(3, 'MD. Alauddin', '456', '+8801312345678', 'Taltoli,Barisal', '456', 'Maj Tarik Hasan', 'Oncology');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apoint`
--
ALTER TABLE `apoint`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `consume`
--
ALTER TABLE `consume`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apoint`
--
ALTER TABLE `apoint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `consume`
--
ALTER TABLE `consume`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
