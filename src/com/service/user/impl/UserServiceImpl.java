package com.service.user.impl;

import org.apache.ibatis.session.SqlSession;

import com.commons.MyBatisUtils;
import com.dao.user.UserMapper;
import com.service.user.UserService;

public class UserServiceImpl implements UserService {
	//创建一个mapper对象
	private UserMapper mapper;
	//创建一个sqlsession对象
	private SqlSession sqlsession;
	//创建一个临时变量
	private int result;
    //验证登录的方法
	@Override
	public boolean isValidation(String name, String psw) {
		sqlsession=MyBatisUtils.createSqlSession();
		mapper=sqlsession.getMapper(UserMapper.class);
		result=mapper.isValidation(name, psw);
		MyBatisUtils.closeSqlSession(sqlsession);
		if (result>0) {
			return true;
		} else {
			return false;
		}
	}

}
