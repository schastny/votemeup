CREATE TABLE `level` (
	`id` 			INT(11) 						 NOT NULL AUTO_INCREMENT,
	`Level` 		VARCHAR(45) 					 NOT NULL,
	`MinVoteYes` 	INT(11) 						 NOT NULL,
	`MinVotePeriod` ENUM('week','month','quarter')   NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `idLevel_Proposal_UNIQUE` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;


