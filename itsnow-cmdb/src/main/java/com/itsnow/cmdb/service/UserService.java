package com.itsnow.cmdb.service;

import com.itsnow.cmdb.db.UserBean;
import com.itsnow.cmdb.db.UserDao;
import com.itsnow.cmdb.db.UserDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Xuekun_Li on 2019/5/17.
 */

@Service
public class UserService {


    private UserDao userDao;
    private UserDao2 userDao2;

    @Autowired
    UserService(UserDao userDao, UserDao2 userDao2) {
        this.userDao = userDao;
        this.userDao2 = userDao2;
    }

    @Transactional
    public List<UserBean> list() {
        return userDao.list();
    }

    @Transactional
    public List<UserBean> listTwoTimes() {
        userDao.list();
        return userDao.list();
    }

    @Transactional
    public List<UserBean> listTwoDaos() {
        userDao.list();
        return userDao2.list();
    }

    @Transactional
    public Integer insertOK() {
        UserBean test = new UserBean();
        test.setUsername("username" + new Date().getTime());
        return userDao.insert(test);
    }

    @Transactional
    public void insertAndFail() {
        UserBean test = new UserBean();
        test.setUsername("username" + new Date().getTime());
        userDao.insert(test);

        throw new RuntimeException("test fail");
    }

    @Transactional
    public void insertAndFailButNotRollback() throws Exception {
        UserBean test = new UserBean();
        test.setUsername("username" + new Date().getTime());
        userDao.insert(test);

        throw new Exception("test fail");
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertAndFailAndRollback() throws Exception {
        UserBean test = new UserBean();
        test.setUsername("username" + new Date().getTime());
        userDao.insert(test);

        throw new Exception("test fail");
    }

    @Transactional
    public Integer deleteAll() {
        return userDao.deleteAll();
    }
}

