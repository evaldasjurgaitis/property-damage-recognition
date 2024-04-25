CREATE database property_damage_recognition
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
CREATE USER 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON property_damage_recognition.* TO 'user'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

