package com.pm.dao.factory;

import com.pm.dao.datasource.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

/***
 * 包含用户表的数据库操作语句
 */

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    /***
     * 使用ID查询用户
     * @param id
     * @return
     */
    public User queryUserByID(int id){
        return session.get(User.class, id);
    }

    /***
     * 使用用户名字和密码登录系统
     * @param name
     * @param pwd
     * @return
     */
    public User userLogin(String name, String pwd){

        Query query = session.createQuery("from User where userName= ?1  and userPwd= ?2");
        query.setParameter(1, name);
        query.setParameter(2, pwd);
        User user = (User) query.uniqueResult();

        return user;

    }
}
