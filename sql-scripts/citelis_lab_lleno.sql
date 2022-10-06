/*
 Navicat Premium Data Transfer

 Source Server         : citelis lab docker
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : 0.0.0.0:33062
 Source Schema         : citelis_lab

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 04/10/2022 21:05:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` int NOT NULL AUTO_INCREMENT,
  `envio` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `module_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of process
-- ----------------------------
BEGIN;
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (1, 'Confirmación al cliente\nEnvío a agente de servicio', 'Post-venta\n', 'Cita servicio');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (2, 'Envío a agente de servicio', 'Post-venta\n', 'Confirmación al cliente');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (3, 'Envío a agente de servicio de pintura\n', 'Post-venta\n', 'Pintura');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (4, 'Envío de\n cotización\n a\n agente\nrefacciones\n', 'Post-venta\n', 'Refacciones');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (5, 'Envío a agente de ventas', 'Venta', 'Cotizaciones');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (6, 'Confirmación cita a cliente\nEnvío de cita a prueba de manejo', 'Venta', 'Prueba de manejo');
INSERT INTO `process` (`id`, `envio`, `module_name`, `name`) VALUES (7, 'Envío de mensaje de contacto a gerencia', 'Venta', 'Contacto');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `email`, `name`) VALUES (1, 'vendedorCita@mail.com', 'Vendedor de cita de servicio');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (2, 'vendedorConfirmacion@mail.com', 'Vendedor de Confirmación al cliente');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (3, 'vendedorPintura@mail.com', 'Vendedor de Pintura');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (4, 'vendedorRefacciones@mail.com', 'Vendedor de Refacciones');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (5, 'vendedorCotizaciones@mail.com', 'Vendedor de Cotizaciones');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (6, 'vendedorPruebaManejo@mail.com', 'Vendedor Prueba de manejo');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (7, 'vendedorContacto@mail.com', 'Vendedor Contacto');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (8, 'cliente11@mail.com', 'cliente cita 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (9, 'cliente12@mail.com', 'cliente cita 2');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (10, 'cliente21@mail.com', 'cliente confirmacion 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (11, 'cliente22@mail.com', 'cliente confirmacion 2');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (12, 'cliente23@mail.com', 'cliente confirmacion 3');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (13, 'cliente31@mail.com', 'cliente pintura 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (14, 'clinte32@mail.com', 'cliente pintura 2');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (15, 'cliente41@mail.com', 'cliente refacciones 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (16, 'cliente42@mail.com', 'cliente refacciones 2');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (17, 'cliente51@mail.com', 'cliente cotizaciones 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (18, 'cliente52@mail.com', 'cliente cotizaciones 2');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (19, 'cliente53@mail.com', 'cliente cotizaciones 3');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (20, 'cliente61@mail.com', 'cliente prueba manejo 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (21, 'cliente71@mail.com', 'cliente contacto 1');
INSERT INTO `user` (`id`, `email`, `name`) VALUES (22, 'cliente72@mail.com', 'cliente contacto 2');
COMMIT;


-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `auto_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `bank_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `hitch` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `term` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  `process_id` int DEFAULT NULL,
  `seller_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_ID_FK` (`client_id`),
  KEY `PROCESS_ID_FK` (`process_id`),
  KEY `SELLER_ID_FK` (`seller_id`),
  CONSTRAINT `PROCESS_ID_FK` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`),
  CONSTRAINT `SELLER_ID_FK` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`),
  CONSTRAINT `USER_ID_FK` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of sale
-- ----------------------------
BEGIN;
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (1, 'nissan versa', 'banco test', '50000', '5 meses', 8, 1, 1);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (2, 'auto test', 'banco test', '60000', '6 meses', 9, 1, 1);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (3, 'auto test', 'banco test', '60000', '7 meses', 10, 2, 2);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (4, 'auto test', 'banco test', '70000', '7 meses', 11, 2, 2);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (5, 'auto test', 'banco test', '60000', '7 meses', 12, 2, 2);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (6, 'auto test', 'banco test', '50000', '12 meses', 13, 3, 3);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (7, 'auto test', 'banco test', '50000', '12 meses', 14, 3, 3);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (8, 'auto test', 'banco test', '90000', '12 meses', 15, 4, 4);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (9, 'auto test', 'banco test', '90000', '9 meses', 17, 5, 5);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (10, 'auto test', 'banco test', '60000', '24 meses', 18, 5, 5);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (11, 'auto test', 'banco test', '125000', '12 meses', 19, 5, 5);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (12, 'auto test', 'banco test', '75000', '12 meses', 20, 6, 6);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (13, 'auto test', 'banco test', '65000', '14 meses', 21, 7, 7);
INSERT INTO `sale` (`id`, `auto_name`, `bank_name`, `hitch`, `term`, `client_id`, `process_id`, `seller_id`) VALUES (14, 'auto test', 'banco test', '85000', '48 meses', 22, 7, 7);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
