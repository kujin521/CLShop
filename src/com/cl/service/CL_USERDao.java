package com.cl.service;

import com.cl.dao.Basedao;
import com.cl.entity.CL_USER;

public class CL_USERDao {
	
	public static int insert(CL_USER u){
		String sql= "insert into CL_USER values(?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params = {
				u.getUSER_ID(),
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),				
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENITY_CODE(),				
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),																
				u.getUSER_STATUS()};		
		
	return	Basedao.common(sql, params);		
		
	}

}
