use agendaproject

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2020 a las 13:00:22
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agenda`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `borrarContacto` (IN `idr` INT(3))  MODIFIES SQL DATA
    SQL SECURITY INVOKER
DELETE FROM `contacto` WHERE `id` = idr$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `borrarNota` (IN `idr` INT(3))  MODIFIES SQL DATA
    SQL SECURITY INVOKER
DELETE FROM `nota` WHERE `id` = idr$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `borrarRecordatorio` (IN `idr` INT(3))  MODIFIES SQL DATA
    SQL SECURITY INVOKER
DELETE FROM `recordatorio` WHERE `id` = idr$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `comprobarNombreUsuario` (IN `nick` VARCHAR(25) CHARSET utf8)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT `user`  FROM `usuario` WHERE `usuario`.`nickname` LIKE nick$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaContacto` (IN `usu` INT(3), IN `name` VARCHAR(20) CHARSET utf8, IN `ape` VARCHAR(50) CHARSET utf8, IN `tel` INT(9), IN `dire` VARCHAR(80) CHARSET utf8, IN `emilio` VARCHAR(50) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
INSERT INTO `contacto` (`id`, `user`, `nombre`, `apellidos`, `telefono`, `direccion`, `email`) VALUES (NULL, usu, name, ape, tel, dire, emilio)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaNota` (IN `usu` INT(3), IN `title` VARCHAR(15) CHARSET utf8, IN `note` VARCHAR(155) CHARSET utf8, IN `fech` VARCHAR(150) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
INSERT INTO `nota` (`id`, `user`, `titulo`, `notas`, `fecha`) VALUES (NULL, usu, title, note, fech)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaRecordatorio` (IN `usu` INT(3), IN `title` VARCHAR(40) CHARSET utf8, IN `fech` VARCHAR(15) CHARSET utf8, IN `hora` VARCHAR(12) CHARSET utf8, IN `descr` VARCHAR(255) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
INSERT INTO `recordatorio` (`id`, `user`, `titulo`, `fecha`, `hora`, `descripcion`) VALUES (NULL, usu, title, fech, hora, descr)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaUsuario` (IN `nick` VARCHAR(25) CHARSET utf8, IN `pass` VARCHAR(25) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
INSERT INTO `usuario` (`user`, `nickname`, `password`) VALUES (NULL, nick, pass)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificaContacto` (IN `id` INT(3), IN `name` VARCHAR(20) CHARSET utf8, IN `ape` VARCHAR(50) CHARSET utf8, IN `tel` INT(9), IN `dire` VARCHAR(80) CHARSET utf8, IN `emilio` VARCHAR(50) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
UPDATE `contacto` SET `nombre` = name, `apellidos` = ape, `telefono` = tel, `direccion` = dire, `email` = emilio WHERE `contactos`.`id` = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificaNota` (IN `id` INT(3), IN `title` VARCHAR(15) CHARSET utf8, IN `note` VARCHAR(155) CHARSET utf8, IN `fech` VARCHAR(150) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
UPDATE `nota` SET `titulo` = title, `notas` = note, `fecha` = fech WHERE `nota`.`id` = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificaRecordatorio` (IN `id` INT(3), IN `title` VARCHAR(40) CHARSET utf8, IN `fech` VARCHAR(15) CHARSET utf8, IN `hora` VARCHAR(12) CHARSET utf8, IN `descr` VARCHAR(255) CHARSET utf8)  MODIFIES SQL DATA
    SQL SECURITY INVOKER
UPDATE `recordatorio` SET `titulo` = title, `fecha` = fech, `hora` = hora, `descripcion` = descr WHERE `recordatorio`.`id` = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `seleccionaContacto` (IN `usu` INT(3))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT `id`, `nombre`, `apellidos`, `telefono`, `direccion`, `email` FROM `contacto` WHERE `user` = usu$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `seleccionaNota` (IN `usu` INT(3))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT `id`, `titulo`, `notas`, `fecha` FROM `nota` WHERE `user` = usu$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `seleccionaRecordatorio` (IN `usu` INT(3))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT `id` , `titulo` , `descripcion` , `fecha`, `hora` FROM `recordatorio` WHERE `user` = usu$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `seleccionaUsuario` (IN `nick` VARCHAR(25) CHARSET utf8, IN `pass` VARCHAR(25) CHARSET utf8)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT `user` FROM `usuario` WHERE `nickname` = nick AND `password` = pass$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

CREATE TABLE `contacto` (
  `id` int(3) UNSIGNED NOT NULL,
  `user` int(3) UNSIGNED NOT NULL,
  `nombre` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `apellidos` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `direccion` varchar(80) COLLATE latin1_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id`, `user`, `nombre`, `apellidos`, `telefono`, `direccion`, `email`) VALUES
(19, 16, 'qewrr123', '', 123123123, '', ''),
(23, 1, 'Prueba2', 'Prueba2 Prueba2', 654654655, 'Calle la Prueba2', 'Prueba2@Prueba2.Prueba'),
(24, 1, 'Prueba4', 'Prueba4 Prueba4', 666999880, 'Calle la Prueba4', 'Prueba4@Prueba4.Prueba'),
(25, 1, 'Prueba3', 'Prueba3 Prueba3', 654654651, 'Calle la Prueba3', 'Prueba3@Prueba3.Prueba3'),
(27, 3, 'Csharp2', 'Csharp2', 666555568, 'Calle Csharp2', 'Csharp2@Csharp.com'),
(32, 3, 'Csharp', 'Csharp', 666555567, 'Calle Csharp', 'Csharp@Csharp.com'),
(33, 3, 'Csharp3', 'Csharp3', 666555561, 'Calle Csharp3', 'Csharp3@Csharp.com'),
(34, 1, 'Prueba5', 'Prueba5 Prueba5', 666999886, 'Calle la Prueba5', 'Prueba5@Prueba5.Prueba'),
(35, 10, 'Prueba2', 'Prueba2 Prueba2', 693639693, 'Calle Prueba2', 'Prueba2@Prueba2.com'),
(52, 1, 'Prueba6', 'Prueba6 Prueba6', 600005453, 'Calle la Prueba6', 'Prueba6@Prueba6.Prueba6'),
(57, 22, 'Paco', 'Mer Chocolate', 654445522, 'Calle de la piruleta', ''),
(58, 22, 'Probando', 'Voy', 918879789, 'Calle de ahora vengo', ''),
(59, 22, 'A ver', 'What', 633300000, 'WTF', ''),
(60, 22, 'Prueba', 'otra', 654546545, 'ASASDASDASDAS', ''),
(70, 1, 'Prueba7', 'Prueba7 Prueba7', 678921457, 'Calle la Prueba7', 'Prueba7@Prueba7.Prueba7'),
(89, 1, 'Prueba8', 'Prueba8 Prueba8', 678921488, 'Calle la Prueba8', 'Prueba8@Prueba8.Prueba8'),
(90, 1, 'Prueba9', 'Prueba9 Prueba9', 678921499, 'Calle la Prueba9', 'Prueba9@Prueba9.Prueba9'),
(92, 1, 'Prueba', 'Prueba Prueba', 678921111, 'Calle la Prueba', 'Prueba@Prueba.Prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `id` int(3) NOT NULL,
  `user` int(11) NOT NULL,
  `titulo` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `notas` varchar(155) COLLATE latin1_general_ci DEFAULT NULL,
  `fecha` varchar(150) COLLATE latin1_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`id`, `user`, `titulo`, `notas`, `fecha`) VALUES
(11, 1, 'Probando2', 'Probando 2', 'sábado 7 noviembre 19:54:47 2020'),
(13, 3, 'Prueba c#', 'Probando', 'martes 21 abril 13:08:25  2020'),
(14, 10, 'Prueba nota', 'Prueba de inserción nota usuario 2', 'jueves 23 abril 15:05:36  2020'),
(15, 1, 'Prueba', 'Nota de prueba', 'sábado 7 noviembre 19:57:05 2020'),
(16, 1, 'Hola mundo', 'Hello World', 'sábado 7 noviembre 20:00:39 2020'),
(19, 1, 'Probando', 'Nota de prueba', 'lunes 16 noviembre 19:51:34 2020'),
(31, 22, 'NotaWea', 'Prueba', 'lunes 9 noviembre 17:41:45 2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recordatorio`
--

CREATE TABLE `recordatorio` (
  `id` int(3) NOT NULL,
  `user` int(3) NOT NULL,
  `titulo` varchar(40) NOT NULL,
  `fecha` varchar(15) DEFAULT NULL,
  `hora` varchar(12) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recordatorio`
--

INSERT INTO `recordatorio` (`id`, `user`, `titulo`, `fecha`, `hora`, `descripcion`) VALUES
(15, 1, 'prueba', '2020-01-08', '17:44', 'Prueba'),
(19, 10, 'Prueba de recordatorio', '2022-08-13', '00:29', ''),
(26, 1, 'prueba2', '2020-11-20', '12:21', 'Prueba24'),
(38, 22, 'RecordatorioWea', '2020-11-19', '22:48', 'Prueba'),
(39, 1, 'prueba3', '2020-01-19', '21:46', 'Prueba3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `user` int(3) NOT NULL,
  `nickname` varchar(25) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `password` varchar(25) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `nickname`, `password`) VALUES
(1, 'david', 'david'),
(10, 'david2', 'david2'),
(11, 'david3', 'david3'),
(16, 'david4', 'david4'),
(17, 'david5', 'david5'),
(18, 'david6', 'david6'),
(19, 'david7', 'david7'),
(20, 'david8', 'david8'),
(21, 'qq', 'qq'),
(22, 'wea', 'wea'),
(24, 'admin', '$2a$04$IfzJJgNypJrahbzu7M'),
(26, 'user', '$2a$04$IfzJJgNypJrahbzu7M'),
(27, 'zczx', 'zxczxc');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `telefono` (`telefono`,`user`) USING BTREE;

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recordatorio`
--
ALTER TABLE `recordatorio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`user`),
  ADD UNIQUE KEY `nickname` (`nickname`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contacto`
--
ALTER TABLE `contacto`
  MODIFY `id` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `nota`
--
ALTER TABLE `nota`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `recordatorio`
--
ALTER TABLE `recordatorio`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `user` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
