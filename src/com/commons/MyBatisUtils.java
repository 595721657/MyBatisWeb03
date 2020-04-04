package com.commons;
/**
 * �����ȡ�����ļ� ����ִ�ж��� �ر�ִ�ж���
 * MyBatis������
 * @author ����
 *
 */

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	   private static SqlSessionFactory fac;
       //��дһ����̬����飬���������ļ�
	   static {
		  try {
			//��ȡ���������ļ�
			InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
		    fac=new SqlSessionFactoryBuilder().build(is);   
		  } catch (IOException e) {
			e.printStackTrace();
		}
	 }
	   //����һ��sqlsession����
	   public static SqlSession createSqlSession() {
		   //openSession�����еĲ���
		   //�������true������ʾ������
		   //false ����ʾ����ر�
		   SqlSession sqlsession=fac.openSession(false);
		   return sqlsession;
	   }
	   //����һ���ر�sqlsession�ķ���
	   public static void closeSqlSession(SqlSession sqlsession) {
		   if(sqlsession!=null) {
			   sqlsession.close();
		   }
	   }
}
