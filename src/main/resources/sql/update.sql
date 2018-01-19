CREATE TABLE `ts_commercialinterne_coi` (
  `coi_id` int(11) NOT NULL AUTO_INCREMENT,
  `coi_code` varchar(55) DEFAULT NULL,
  `coi_nom` varchar(55) DEFAULT NULL,
  `coi_prenom` varchar(55) DEFAULT NULL,
  `coi_civilite` varchar(55) DEFAULT NULL,
  `coi_telephone` varchar(55) DEFAULT NULL,
  `coi_fonction` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`coi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `textma`.`ts_commercialinterne_coi` (`coi_id`, `coi_code`, `coi_nom`, `coi_civilite`) VALUES ('1', '00', 'NON DEFINI', 'Mr.');
INSERT INTO `textma`.`ts_commercialinterne_coi` (`coi_id`, `coi_code`, `coi_nom`, `coi_prenom`, `coi_civilite`, `coi_telephone`, `coi_fonction`) VALUES ('2', '01', 'Keskin', 'Mustafa', 'Mr.', '0606060606', 'Gérant');
INSERT INTO `textma`.`ts_commercialinterne_coi` (`coi_id`, `coi_code`, `coi_nom`, `coi_prenom`, `coi_civilite`) VALUES ('3', '02', 'Keskin', 'Murat', 'Mr.');

ALTER TABLE `textma`.`te_client_cli`
ADD COLUMN `cli_coi_id` INT NULL AFTER `cli_datemodification`;
