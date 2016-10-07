-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'users'
-- 
-- ---

DROP TABLE IF EXISTS `users`;
		
CREATE TABLE `users` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `login` INTEGER NULL DEFAULT NULL,
  `pass` INTEGER NULL DEFAULT NULL,
  `name` INTEGER NULL DEFAULT NULL,
  `second_name` INTEGER NULL DEFAULT NULL,
  `last_name` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'class'
-- 
-- ---

DROP TABLE IF EXISTS `class`;
		
CREATE TABLE `class` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `number` INTEGER NULL DEFAULT NULL,
  `prefics` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'students'
-- 
-- ---

DROP TABLE IF EXISTS `students`;
		
CREATE TABLE `students` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `class_id` INTEGER NULL DEFAULT NULL,
  `fio` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'teachers'
-- 
-- ---

DROP TABLE IF EXISTS `teachers`;
		
CREATE TABLE `teachers` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `user_id` INTEGER NULL DEFAULT NULL,
  `lesson_id` INTEGER NULL DEFAULT NULL,
  `class_id` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'lessons'
-- 
-- ---

DROP TABLE IF EXISTS `lessons`;
		
CREATE TABLE `lessons` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `name` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'marks'
-- 
-- ---

DROP TABLE IF EXISTS `marks`;
		
CREATE TABLE `marks` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `student_id` INTEGER NULL DEFAULT NULL,
  `lesson_id` INTEGER NULL DEFAULT NULL,
  `mark` INTEGER NULL DEFAULT NULL,
  `day` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'days'
-- 
-- ---

DROP TABLE IF EXISTS `days`;
		
CREATE TABLE `days` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `lesson_id` INTEGER NULL DEFAULT NULL,
  `class_id` INTEGER NULL DEFAULT NULL,
  `count` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'visit'
-- 
-- ---

DROP TABLE IF EXISTS `visit`;
		
CREATE TABLE `visit` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `student_id` INTEGER NULL DEFAULT NULL,
  `lesson_id` INTEGER NULL DEFAULT NULL,
  `day` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'elective'
-- 
-- ---

DROP TABLE IF EXISTS `elective`;
		
CREATE TABLE `elective` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `lesson_id` INTEGER NULL DEFAULT NULL,
  `class_id` INTEGER NULL DEFAULT NULL,
  `student_id` INTEGER NULL DEFAULT NULL,
  `comment` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `students` ADD FOREIGN KEY (class_id) REFERENCES `class` (`id`);
ALTER TABLE `teachers` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `teachers` ADD FOREIGN KEY (lesson_id) REFERENCES `lessons` (`id`);
ALTER TABLE `teachers` ADD FOREIGN KEY (class_id) REFERENCES `class` (`id`);
ALTER TABLE `marks` ADD FOREIGN KEY (student_id) REFERENCES `students` (`id`);
ALTER TABLE `marks` ADD FOREIGN KEY (lesson_id) REFERENCES `lessons` (`id`);
ALTER TABLE `days` ADD FOREIGN KEY (lesson_id) REFERENCES `lessons` (`id`);
ALTER TABLE `days` ADD FOREIGN KEY (class_id) REFERENCES `class` (`id`);
ALTER TABLE `visit` ADD FOREIGN KEY (student_id) REFERENCES `students` (`id`);
ALTER TABLE `visit` ADD FOREIGN KEY (lesson_id) REFERENCES `lessons` (`id`);
ALTER TABLE `elective` ADD FOREIGN KEY (lesson_id) REFERENCES `lessons` (`id`);
ALTER TABLE `elective` ADD FOREIGN KEY (class_id) REFERENCES `class` (`id`);
ALTER TABLE `elective` ADD FOREIGN KEY (student_id) REFERENCES `students` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `users` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `class` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `students` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `teachers` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `lessons` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `marks` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `days` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `visit` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `elective` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `users` (`id`,`login`,`pass`,`name`,`second_name`,`last_name`) VALUES
-- ('','','','','','');
-- INSERT INTO `class` (`id`,`number`,`prefics`) VALUES
-- ('','','');
-- INSERT INTO `students` (`id`,`class_id`,`fio`) VALUES
-- ('','','');
-- INSERT INTO `teachers` (`id`,`user_id`,`lesson_id`,`class_id`) VALUES
-- ('','','','');
-- INSERT INTO `lessons` (`id`,`name`) VALUES
-- ('','');
-- INSERT INTO `marks` (`id`,`student_id`,`lesson_id`,`mark`,`day`) VALUES
-- ('','','','','');
-- INSERT INTO `days` (`id`,`lesson_id`,`class_id`,`count`) VALUES
-- ('','','','');
-- INSERT INTO `visit` (`id`,`student_id`,`lesson_id`,`day`) VALUES
-- ('','','','');
-- INSERT INTO `elective` (`id`,`lesson_id`,`class_id`,`student_id`,`comment`) VALUES
-- ('','','','','');