package com.htsc.test;

import com.htsc.domain.User;
import com.htsc.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) {
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            SqlSessionFactory factory = builder.build(in);

            SqlSession session = factory.openSession();

            IUserDao userDao = session.getMapper(IUserDao.class);

            List<User> users = userDao.findAll();

            for(User user:users) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
