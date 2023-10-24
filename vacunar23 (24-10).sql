-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2023 a las 00:30:09
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vacunar23`
--
CREATE DATABASE IF NOT EXISTS `vacunar23` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacunar23`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centrosalud`
--

CREATE TABLE `centrosalud` (
  `idCentro` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `zona` varchar(100) NOT NULL,
  `laboratorio` varchar(30) NOT NULL,
  `cantidadDosis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `centrosalud`
--

INSERT INTO `centrosalud` (`idCentro`, `nombre`, `direccion`, `zona`, `laboratorio`, `cantidadDosis`) VALUES
(5, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'EEUU', 1000),
(7, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Rusia', 1000),
(8, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Argentina', 1000),
(9, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Nueva York', 1000),
(10, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Reino Unido', 1000),
(11, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Reino Unido', 1000),
(12, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Nueva York', 1000),
(13, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Argentina', 1000),
(14, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Rusia', 1000),
(15, 'Centro Medico Sur', 'Callao 567', 'Sur', 'EEUU', 1000),
(16, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Reino Unido', 1000),
(17, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Nueva York', 1000),
(18, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Argentina', 1000),
(19, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Rusia', 1000),
(20, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'EEUU', 1000),
(21, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Reino Unido', 1000),
(22, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Nueva York', 1000),
(23, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Argentina', 1000),
(24, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Rusia', 1000),
(25, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'EEUU', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `codigo` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `cantRefuerzo` int(11) NOT NULL,
  `fechahoraCita` datetime NOT NULL,
  `centroVacunacion` int(11) NOT NULL,
  `fechahoraColoca` datetime DEFAULT NULL,
  `lotedosis` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `colocada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `idCiudadano` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `zona` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `celular` int(11) NOT NULL,
  `patologia` varchar(100) DEFAULT NULL,
  `ambitoTrabajo` varchar(100) NOT NULL,
  `covid` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`idCiudadano`, `dni`, `nombre`, `apellido`, `zona`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `covid`) VALUES
(4, 40459852, 'Maximo', 'Roberto', 'Norte', 'maxi@gmail.com', 154898989, 'Cardiaco', 'Salud', 1),
(5, 45684598, 'Pepe', 'Gimeno', 'Este', 'pepe@gmail.com', 154874568, 'Cardiaco', 'Salud', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `Lote` int(11) NOT NULL,
  `cantidadDosis` int(11) NOT NULL,
  `marcaVacuna` varchar(100) NOT NULL,
  `laboratorio` varchar(100) NOT NULL,
  `medida` double NOT NULL,
  `vencimiento` date NOT NULL,
  `colocada` tinyint(1) NOT NULL,
  `antigeno` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`Lote`, `cantidadDosis`, `marcaVacuna`, `laboratorio`, `medida`, `vencimiento`, `colocada`, `antigeno`) VALUES
(1, 7000, 'Sinopharm', 'Argentina', 0.6, '2016-06-02', 0, 'manaos'),
(2, 3000, 'Sputnik', 'Rusia', 0.6, '2025-09-23', 0, 'manaos'),
(3, 10000, 'Moderna', 'EEUU', 0.3, '2025-09-23', 0, 'manaos'),
(4, 10000, 'Pfizer', 'Nueva York', 0.3, '2025-09-23', 0, 'manos'),
(5, 10000, 'AstraZeneca', 'Reino Unido', 0.9, '2025-09-23', 0, 'manos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centrosalud`
--
ALTER TABLE `centrosalud`
  ADD PRIMARY KEY (`idCentro`),
  ADD KEY `cantidadDosis` (`cantidadDosis`),
  ADD KEY `laboratorio` (`laboratorio`),
  ADD KEY `zona` (`zona`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `centroVacunacion` (`centroVacunacion`),
  ADD KEY `persona` (`persona`),
  ADD KEY `lotedosis` (`lotedosis`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`idCiudadano`),
  ADD KEY `zona` (`zona`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`Lote`),
  ADD KEY `cantidadDosis` (`cantidadDosis`),
  ADD KEY `laboratorio` (`laboratorio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centrosalud`
--
ALTER TABLE `centrosalud`
  MODIFY `idCentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `idCiudadano` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `Lote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `centrosalud`
--
ALTER TABLE `centrosalud`
  ADD CONSTRAINT `centrosalud_ibfk_1` FOREIGN KEY (`laboratorio`) REFERENCES `vacuna` (`laboratorio`);

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`centroVacunacion`) REFERENCES `centrosalud` (`idCentro`),
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`persona`) REFERENCES `ciudadano` (`idCiudadano`),
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`lotedosis`) REFERENCES `vacuna` (`Lote`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
