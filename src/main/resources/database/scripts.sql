CREATE DATABASE `bankinfo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */

CREATE TABLE `users` (
   `id` int NOT NULL AUTO_INCREMENT,
   `name` varchar(100) DEFAULT NULL,
   `email` varchar(100) DEFAULT NULL,
   `balance` double DEFAULT NULL,
   `phone` varchar(45) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

 CREATE TABLE `transactions_history` (
    `id` varchar(36) NOT NULL,
    `user_id` int NOT NULL,
    `transaction_amount` double NOT NULL,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `total_balance` double NOT NULL,
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci