package com.itsnow.management.pojo;

import com.itsnow.common.pojo.BaseRequestPojo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Xuekun_Li on 2018/7/30.
 */
@Table(name = "accounts")
@Data
public class AccountRequest extends BaseRequestPojo implements Serializable {

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
}
