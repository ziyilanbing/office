CREATE TABLE `test_table` (
  `key_a` char(20) NOT NULL,
  `key_b` int(11) NOT NULL,
  `col_a` varchar(45) DEFAULT NULL,
  `col_b` varchar(45) DEFAULT NULL,
  `col_c` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`key_a`,`key_b`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
