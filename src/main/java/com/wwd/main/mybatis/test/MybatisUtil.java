package com.wwd.main.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wwd.main.mybatis.dao.UserDao;

public class MybatisUtil {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("config.xml"));

		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 UserDao userDAO = sqlSession.getMapper(UserDao.class);
		 System.out.println(userDAO.get("11"));

	}
}
