-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 26-07-2019 a las 01:21:16
-- Versión del servidor: 10.1.38-MariaDB-0+deb9u1
-- Versión de PHP: 7.0.33-0+deb9u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crudBanda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instrumento`
--

CREATE TABLE `instrumento` (
  `idinstrumento` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `idmusico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `instrumento`
--

INSERT INTO `instrumento` (`idinstrumento`, `nombre`, `descripcion`, `idmusico`) VALUES
(1, 'flauta', 'Instrumento de viento', 4),
(2, 'Guitarra', 'Instrumento de cuerda', 1),
(3, 'Violín', 'cuerda', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musico`
--

CREATE TABLE `musico` (
  `idmusico` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `fecha_nac` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `musico`
--

INSERT INTO `musico` (`idmusico`, `nombre`, `apellidos`, `direccion`, `fecha_nac`) VALUES
(1, 'manuel', 'martínez', 'calle la amargadera 23', '1936-12-31'),
(2, 'juan', 'suarez', 'c/venezuela 12', '2019-06-10'),
(3, 'maria', 'perez perez', 'av finisterre 113', '1980-07-08'),
(4, 'marta', 'fernandez', 'av. finisterre 113', '1987-06-12');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `instrumento`
--
ALTER TABLE `instrumento`
  ADD PRIMARY KEY (`idinstrumento`),
  ADD KEY `idmusico` (`idmusico`);

--
-- Indices de la tabla `musico`
--
ALTER TABLE `musico`
  ADD PRIMARY KEY (`idmusico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `instrumento`
--
ALTER TABLE `instrumento`
  MODIFY `idinstrumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `musico`
--
ALTER TABLE `musico`
  MODIFY `idmusico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `instrumento`
--
ALTER TABLE `instrumento`
  ADD CONSTRAINT `instrumento_ibfk_1` FOREIGN KEY (`idmusico`) REFERENCES `musico` (`idmusico`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
