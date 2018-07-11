CREATE TABLE `country` (
  `code` varchar(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `continent` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `lifeExpectancy` decimal(2,0) DEFAULT NULL,
  `gnp` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*
-- Query: SELECT * FROM lm.country
LIMIT 0, 200

-- Date: 2017-11-11 14:29
*/

INSERT INTO `country` (`code`,`name`,`continent`,`region`,`lifeExpectancy`,`gnp`) VALUES ('usa','United States','america','north',77,8510700);
