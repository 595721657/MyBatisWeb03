package com.dao.user;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
       //����һ����֤��¼�ķ���
	  int isValidation(@Param("name")String name,@Param("pwd")String pwd);
}
