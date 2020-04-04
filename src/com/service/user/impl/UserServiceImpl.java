package com.service.user.impl;

import org.apache.ibatis.session.SqlSession;

import com.commons.MyBatisUtils;
import com.dao.user.UserMapper;
import com.service.user.UserService;

public class UserServiceImpl implements UserService {
	//����һ��mapper����
	private UserMapper mapper;
	//����һ��sqlsession����
	private SqlSession sqlsession;
	//����һ����ʱ����
	private int result;
    //��֤��¼�ķ���
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
