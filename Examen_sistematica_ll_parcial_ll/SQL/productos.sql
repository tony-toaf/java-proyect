-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2024 at 04:53 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `productos`
--

-- --------------------------------------------------------

--
-- Table structure for table `detallecompras`
--

CREATE TABLE `detallecompras` (
  `IDDETALLECOMPRAS` int(11) NOT NULL,
  `ID_COMPRA` int(11) DEFAULT NULL,
  `ID_PRODUCTO` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `PRECIOCOMPRA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detalleventas`
--

CREATE TABLE `detalleventas` (
  `IDDETALLEVENTAS` int(11) NOT NULL,
  `ID_VENTA` int(11) DEFAULT NULL,
  `ID_PRODUCTO` int(11) DEFAULT NULL,
  `PRECIO_UNITARIO` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `IdProducto` int(11) NOT NULL,
  `Descripcion` varchar(355) DEFAULT NULL,
  `StockMinimo` int(11) DEFAULT NULL,
  `StockMaximo` int(11) DEFAULT NULL,
  `PrecioCompra` int(11) DEFAULT NULL,
  `PrecioUnitario` int(11) DEFAULT NULL,
  `Garantia` varchar(30) DEFAULT NULL,
  `Observaciones` varchar(200) DEFAULT NULL,
  `Estado` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL,
  `USUARIO` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`ID`, `USUARIO`, `PASSWORD`) VALUES
(1, 'tony', 'root');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detallecompras`
--
ALTER TABLE `detallecompras`
  ADD PRIMARY KEY (`IDDETALLECOMPRAS`);

--
-- Indexes for table `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD PRIMARY KEY (`IDDETALLEVENTAS`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detallecompras`
--
ALTER TABLE `detallecompras`
  MODIFY `IDDETALLECOMPRAS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detalleventas`
--
ALTER TABLE `detalleventas`
  MODIFY `IDDETALLEVENTAS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
