package com.yingjia.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*

CREATE TABLE `Profiles`(
                           `UserId` INT PRIMARY KEY,
                           `Name` VARCHAR(50) NOT NULL,
                           `Title` VARCHAR(50) NOT NULL,
                           `Label` VARCHAR(50) NOT NULL,
                           `Gender` ENUM('male', 'female') NOT NULL,
                           `BirthDate` DATE NOT NULL
);

 */
@Entity(name = "profiles_entity")
@Table(name = "Profiles")
public class Profiles {
    @Id
    @Column(name = "UserId")
    @JsonProperty("parent_id")
    private String userId;

    @Column(name = "Name")
    @JsonProperty("username")
    private String name;

    @Column(name = "Title")
    @JsonProperty("title")
    private String title;

    @Column(name = "Label")
    @JsonProperty("label")
    private String label;

    @Column(name = "Gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "BirthDate")
    @JsonProperty("birthday")
    private LocalDateTime birthday;

    public Profiles(String userId) {
        this.userId=userId;
    }

    public Profiles setUserName(String userName) {
        this.name = userName;
        return this;
    }
    public Profiles setTitle(String title) {
        this.title = title;
        return this;
    }
    public Profiles setLabel(String label) {
        this.label = label;
        return this;
    }
    public Profiles setGender(String gender) {
        this.gender = gender;
        return this;
    }
    public Profiles setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public Profiles setBirthday(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.birthday = LocalDateTime.parse(birthday, formatter);
        return this;
    }
}
