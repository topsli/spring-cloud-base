package com.itsnow.main.api.pojo.request;

import com.itsnow.common.pojo.BaseRequestPojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "users")
@Data
public class BaseUserRequest extends BaseRequestPojo implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "passport_id")
    private String passportId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_mobile")
    private String userMobile;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "pay_password")
    private String payPassword;

    @Column(name = "bizunit")
    private String bizunit;

    @Column(name = "depart_id")
    private String departId;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "identification")
    private String identification;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "qq")
    private String qq;

    @Column(name = "weixin")
    private String weixin;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "rel_user_id")
    private String relUserId;

    @Column(name = "rel_passport_id")
    private String relPassportId;

    @Column(name = "rel_username")
    private String relUsername;

    @Column(name = "user_enabled")
    private Integer userEnabled;

    @Column(name = "user_expired")
    private Integer userExpired;

    @Column(name = "user_locked")
    private Integer userLocked;

    @Column(name = "password_expired")
    private Integer passwordExpired;

    @Column(name = "email_verified")
    private Integer emailVerified;

    @Column(name = "mobile_verified")
    private Integer mobileVerified;

    @Column(name = "activate_email_code")
    private Integer activateEmailCode;

    @Column(name = "activate_sms_code")
    private Integer activateSmsCode;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;
}