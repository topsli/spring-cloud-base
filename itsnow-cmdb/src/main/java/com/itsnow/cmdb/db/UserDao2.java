package com.itsnow.cmdb.db;


import com.itsnow.cmdb.util.UniqueObjectIdHolder;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Xuekun_Li on 2019/5/17.
 */

@Repository
public class UserDao2 {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    public List<UserBean> list(){
        Connection conn =  DataSourceUtils.getConnection(dataSource);
        System.out.println("userDao2:list:datasource:"+ UniqueObjectIdHolder.getId(dataSource));
        System.out.println("userDao2:list:connection:"+ UniqueObjectIdHolder.getId(conn));
        Handle handle = DBI.open(conn);
        UserSQLs userQLs = handle.attach(UserSQLs.class);
        return userQLs.list();
    }

    public Integer insert(UserBean item){
        Connection conn =  DataSourceUtils.getConnection(dataSource);
        System.out.println("userDao2:insert:datasource:"+ UniqueObjectIdHolder.getId(dataSource));
        System.out.println("userDao2:insert:connection:"+ UniqueObjectIdHolder.getId(conn));
        Handle handle = DBI.open(conn);
        UserSQLs userSQLs = handle.attach(UserSQLs.class);
        return userSQLs.insert(item);
    }

    @RegisterMapper(UserMapper.class)
    interface UserSQLs {
        @SqlQuery("select * from users")
        List<UserBean> list();

        @SqlUpdate("insert into test (username)" +
                " values(:username) ")
        @GetGeneratedKeys
        Integer insert(@BindBean UserBean test);
    }

    public static class UserMapper implements ResultSetMapper<UserBean> {
        @Override
        public UserBean map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
            UserBean bean = new UserBean();
            bean.setId((Integer)r.getObject("id"));
            bean.setUsername(r.getString("username"));
            return bean;
        }
    }

}
