package com.dao.user;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
       //定义一个验证登录的方法
	  int isValidation(@Param("name")String name,@Param("pwd")String pwd);
}
