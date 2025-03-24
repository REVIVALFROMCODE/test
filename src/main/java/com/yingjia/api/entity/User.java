package com.yingjia.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * Represents a user in the system.
 * <p>
 * CREATE TABLE `User` (
 * `UserId` VARCHAR(50) PRIMARY KEY,
 * `NickName` VARCHAR(50) NOT NULL,
 * `PhoneNumber` VARCHAR(20) UNIQUE,
 * `Gender` ENUM('male', 'female') NOT NULL,
 * `BirthDate` DATE NOT NULL,
 * `VipLevel` TINYINT UNSIGNED DEFAULT 0 NOT NULL,
 * `VipEffectiveDate` DATETIME DEFAULT NULL,
 * `VipExpiryDate` DATETIME DEFAULT NULL,
 * `VipFreeUses` INT DEFAULT 0 NOT NULL,
 * `Avatar` BLOB DEFAULT NULL,
 * `CreatedDate` DATETIME DEFAULT CURRENT_TIMESTAMP,
 * `UpdatedDate` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * `AccountStatus` ENUM('active', 'suspended', 'deleted') DEFAULT 'active' NOT NULL
 * );
 */
@Entity(name = "user_entity")
@Table(name = "User")
public class User {
    @Id
    @Column(name = "UserId")
    @JsonProperty("id")
    private String userId;

    @Column(name = "NickName")
    @JsonProperty("nickName")
    private String name;

    @Column(name = "PhoneNumber")
    @JsonProperty("mobile")
    private String phone;

    @Column(name = "Gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "BirthDate")
    @JsonProperty("birthday")
    private LocalDateTime birthday;

    @Column(name = "VipLevel")
    @JsonProperty("level")
    private int vipLevel;

    @Column(name = "VipEffectiveDate")
    @JsonProperty("VipEffectiveDate")
    private LocalDateTime VipEffectiveDate;

    @Column(name = "vipExpiryDate")
    @JsonProperty("vipExpiryDate")
    private LocalDateTime vipExpiryDate;

    @Column(name = "VipFreeUses")
    @JsonProperty("freeVipUses")
    private int freeVipUses;

    @Column(name = "CreatedDate")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedDate")
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "AccountStatus")
    @JsonProperty("status")
    private String status;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSex() {
        return gender;
    }

    public User setSex(String gender) {
        this.gender = gender;
        return this;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public LocalDateTime getVipExpiryDate() {
        return vipExpiryDate;
    }

    public int getFreeVipUses() {
        return freeVipUses;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public User setUserName(String name) {
        this.name = name;
        return this;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
