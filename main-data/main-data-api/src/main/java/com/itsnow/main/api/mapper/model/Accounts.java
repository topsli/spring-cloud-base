package com.itsnow.main.api.mapper.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Xuekun_Li on 2018/7/20.
 */
@Data
@Table(name = "accounts")
public class Accounts implements Serializable{

    @Id
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "account_domain")
    private String accountDomain;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_description")
    private String accountDescription;

    @Column(name = "account_enabled")
    private int  accountEnabled;

    @Column(name = "account_activated")
    private String  accountActivated;

    @Column(name = "activated_time")
    private Date activatedTime;

    @Column(name = "accountVerified")
    private String accountVerified;

    @Column(name = "verified_time")
    private Date verifiedTime;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "weixin")
    private String weixin;

    @Column(name = "qq")
    private String qq;

    @Column(name = "url")
    private String url;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "enterprise")
    private Integer enterprise;

    @Column(name = "enterprise_url")
    private String enterpriseUrl;

    @Column(name = "auth_url")
    private String authUrl;
}
