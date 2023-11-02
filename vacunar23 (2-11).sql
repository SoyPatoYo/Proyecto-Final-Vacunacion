-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2023 a las 21:15:44
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
  `laboratorio` varchar(30) DEFAULT NULL,
  `cantidadDosis` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `centrosalud`
--

INSERT INTO `centrosalud` (`idCentro`, `nombre`, `direccion`, `zona`, `laboratorio`, `cantidadDosis`) VALUES
(1, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Reino Unido', 998),
(2, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Nueva York', 1000),
(3, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Argentina', 4500),
(4, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'Rusia', 1000),
(5, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', 'EEUU', 1600),
(11, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Reino Unido', 1000),
(12, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Nueva York', 1000),
(13, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Argentina', 5200),
(14, 'Centro Medico Sur', 'Callao 567', 'Sur', 'Rusia', 2000),
(15, 'Centro Medico Sur', 'Callao 567', 'Sur', 'EEUU', 2000),
(16, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Reino Unido', 1000),
(17, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Nueva York', 1099),
(18, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Argentina', 1000),
(19, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Rusia', 999),
(20, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'EEUU', 999),
(21, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Reino Unido', 1000),
(22, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Nueva York', 1000),
(23, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Argentina', 1000),
(24, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'Rusia', 1000),
(25, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', 'EEUU', 1000),
(26, 'Centro Medico Centro', '9 de Julio 130', 'Centro', 'Argentina', 999),
(27, 'Centro Medico Centro', '9 de Julio 130', 'Centro', 'Rusia', 1100),
(28, 'Centro Medico Centro', '9 de Julio 130', 'Centro', NULL, NULL),
(29, 'Centro Medico Norte', 'Rodriguez 1500', 'Norte', NULL, NULL),
(30, 'Centro Medico Sur', 'Callao 567', 'Sur', NULL, NULL),
(31, 'Centro Medico Este', 'Av. Peron 715', 'Este', NULL, NULL),
(32, 'Centro Medico Oeste', 'Av del Caño 512', 'Oeste', NULL, NULL),
(33, 'Centro Medico Centro', '9 de Julio 130', 'Centro', 'Mexico', 111),
(34, 'Centro Medico Este', 'Av. Peron 715', 'Este', 'Mexico', 100),
(35, 'Centro Medico Centro', '9 de Julio 130', 'Centro', 'Reino Unido', 0);

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
  `estado` tinyint(1) NOT NULL,
  `colocada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`codigo`, `persona`, `cantRefuerzo`, `fechahoraCita`, `centroVacunacion`, `fechahoraColoca`, `estado`, `colocada`) VALUES
(1, 4, 2, '2023-10-20 20:33:06', 1, NULL, 0, 0),
(3, 7, 1, '2023-11-05 15:30:00', 22, NULL, 1, 0),
(5, 8, 1, '2023-11-05 13:30:00', 16, NULL, 0, 0),
(6, 9, 1, '2023-11-06 13:30:00', 19, '2023-10-29 20:46:09', 0, 1),
(8, 10, 1, '2023-11-11 15:30:00', 1, '2023-11-01 15:42:37', 0, 1),
(12, 10, 2, '2023-11-11 13:30:00', 1, '2023-11-01 17:54:46', 0, 1),
(13, 10, 3, '2023-11-11 13:30:00', 1, NULL, 1, 0),
(14, 11, 1, '2023-11-11 14:30:00', 26, '2023-11-01 22:41:31', 0, 1),
(15, 12, 1, '2023-11-11 15:30:00', 18, NULL, 1, 0),
(16, 13, 1, '2023-11-11 13:30:00', 17, '2023-11-01 23:36:35', 0, 1);

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
  `covid` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`idCiudadano`, `dni`, `nombre`, `apellido`, `zona`, `email`, `celular`, `patologia`, `ambitoTrabajo`, `covid`, `estado`) VALUES
(4, 40459852, 'Maximo', 'Roberto', 'Norte', 'maxi@gmail.com', 154898989, 'Cardiaco', 'Salud', 0, 1),
(5, 45684598, 'Pepe', 'Gimeno', 'Este', 'pepe@gmail.com', 154874568, 'Cardiaco', 'Salud', 0, 1),
(7, 87654321, 'Pablito', 'Clavito', 'Oeste', 'pablo@gmail.com', 154555555, 'Ninguno', 'Ninguno', 1, 1),
(8, 23456789, 'Pepegrillo', 'Chapita', 'Este', 'pep@gmail.com', 154121212, 'Cardiaco', 'Salud', 1, 1),
(9, 40404040, 'Carlos', 'Sanchez', 'Este', 'carlos@gmail.com', 154121212, 'Diabetico', 'Ninguno', 0, 0),
(10, 88888888, 'Roberto', 'Gomez', 'Norte', 'roberto@gmail.com', 154333333, 'Ninguno', 'Ninguno', 0, 1),
(11, 66666666, 'Rodolfo', 'Guzman', 'Centro', 'rod@gmial.com', 154653092, 'Diabetico', 'Salud', 0, 1),
(12, 11111111, 'Marcos', 'Rojo', 'Este', 'marquitos@gmail.com', 152123141, 'Ninguno', 'Ninguno', 0, 1),
(13, 55555555, 'Thiago', 'Messi', 'Este', 'thiago@gmail.com', 154889944, 'Ninguno', 'Ninguno', 0, 1),
(14, 99999999, 'Tomas', 'Gomez', 'Sur', 'tom@gmail.com', 154848484, 'Diabetico', 'Salud', 0, 1);

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
(1, 5500, 'Sinofarm', 'Argentina', 0.6, '2016-06-02', 0, 'manaos'),
(2, 4830, 'Sputnik', 'Rusia', 0.6, '2025-09-23', 0, 'manaos'),
(3, 8400, 'Moderna', 'EEUU', 0.3, '2025-09-23', 0, 'manaos'),
(4, 9900, 'Pfizer', 'Nueva York', 0.3, '2025-09-23', 0, 'manaos'),
(5, 10000, 'AstraZeneca', 'Reino Unido', 0.9, '2025-09-23', 0, 'manaos'),
(6, 0, 'LLA', 'Mexico', 0.9, '2025-11-01', 1, 'manaos');

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
  ADD KEY `persona` (`persona`);

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
  MODIFY `idCentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `idCiudadano` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `Lote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`persona`) REFERENCES `ciudadano` (`idCiudadano`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
