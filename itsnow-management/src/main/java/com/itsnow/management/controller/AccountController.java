package com.itsnow.management.controller;

import com.github.pagehelper.PageInfo;
import com.itsnow.common.pojo.ResponseData;
import com.itsnow.common.pojo.TableData;
import com.itsnow.db.spring.boot.autoconfigure.controller.CrudController;


import com.itsnow.management.entity.Account;
import com.itsnow.management.pojo.AccountRequest;
import com.itsnow.management.pojo.ResponseCode;
import com.itsnow.management.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/7/30.
 */
@RestController
public class AccountController extends CrudController<Account, AccountRequest> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/account/name/{userName}", method = RequestMethod.GET)
    public ResponseData<Account> findAccountByUserName(@PathVariable("userName") String userName) {
        logger.debug("根据用户名查询ACCOUNT");
        if(StringUtils.isEmpty(userName)){
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        Account account = new Account();
        account.setUserName(userName);
        account = accountService.selectOne(account);
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), account);
    }

    @PostMapping("/account/table")
    @Override
    protected ResponseData<TableData<Account>> queryRecord(@RequestBody AccountRequest query) {
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(query.getUserName())) {
            criteria.andLike("userName", "%" + query.getUserName() + "%");
        }

        PageInfo<Account> pageInfo = accountService.selectByExampleList(example, query.getPageNum(), query.getPageSize());
        return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
    }

    @Override
    protected ResponseData<Account> addRecord(Account record) {
        return null;
    }

    @Override
    protected ResponseData<Account> deleteRecord(List<Account> record) {
        return null;
    }

    @Override
    protected ResponseData<Account> updateRecord(Account record) {
        return null;
    }
}
