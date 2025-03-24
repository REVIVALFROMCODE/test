USE mydatabase;
CREATE TABLE `User` (
                        `UserId` VARCHAR(50) PRIMARY KEY,
                        `NickName` VARCHAR(50) NOT NULL,
                        `PhoneNumber` VARCHAR(20) UNIQUE,
                        `Gender` ENUM('male', 'female') NOT NULL,
                        `BirthDate` DATE NOT NULL,
                        `VipLevel` TINYINT UNSIGNED DEFAULT 0 NOT NULL,
                        `VipEffectiveDate` DATETIME DEFAULT NULL,
                        `VipExpiryDate` DATETIME DEFAULT NULL,
                        `VipFreeUses` INT DEFAULT 0 NOT NULL,
                        `Avatar` BLOB DEFAULT NULL,
                        `CreatedDate` DATETIME DEFAULT CURRENT_TIMESTAMP,
                        `UpdatedDate` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `AccountStatus` ENUM('active', 'suspended', 'deleted') DEFAULT 'active' NOT NULL
);

CREATE TABLE `Levels`(
                         `VipLevel` TINYINT UNSIGNED PRIMARY KEY,
                         `Name` VARCHAR(50) NOT NULL,
                         `Text` TEXT DEFAULT NULL,
                         `Price` DECIMAL(10,2)
);

CREATE TABLE `Profiles`(
                           `UserId` INT PRIMARY KEY,
                           `Name` VARCHAR(50) NOT NULL,
                           `Gender` ENUM('male', 'female') NOT NULL,
                           `BirthDate` DATE NOT NULL
);

DELIMITER //
CREATE PROCEDURE test_pro()
BEGIN
DELETE FROM User;
INSERT INTO User (
    UserId,
    NickName,
    PhoneNumber,
    Gender,
    BirthDate
)
VALUES (
           '084y_69bGhbvBmHgjH5dHVzac5jadyz95zYC50SQQ25pqk7',
           'johndoe',
           '18633335555',
           'male',
           '2025-12-31 23:59:59'
       );

INSERT INTO Levels (
    VipLevel,
    Name,
    Text,
    Price
)
VALUES (
           '1',
           'VIP1',
           'TestText',
           9.9
       );

INSERT INTO Profiles (
    UserId,
    Name,
    Gender,
    BirthDate
)
VALUES (
           '084y_69bGhbvBmHgjH5dHVzac5jadyz95zYC50SQQ25pqk7',
           'johndoe',
           'male',
           '2025-12-31 23:59:59'
       );
END;

//
DELIMITER ;

DELIMITER //

CREATE PROCEDURE ConditionalExecution()
BEGIN
    DECLARE test_flag BOOLEAN;
    SET test_flag = TRUE;

    IF test_flag THEN
        CALL test_pro();
END IF;

END;

//
DELIMITER ;

CALL ConditionalExecution();





