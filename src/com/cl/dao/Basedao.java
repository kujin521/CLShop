package com.cl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.mysql.cj.xdevapi.PreparableStatement;



public class Basedao {
	static{
		
		//��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public static Connection getconn(){
		//����һ�����Ӷ���
		
		Connection conn= null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clshop?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	public static int common(String sql,Object[] params){
		
		int count = 0;
		Connection conn = Basedao.getconn();
		//׼��SQL���
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(sql);
			for(int i =0;i<params.length;i++){
				
				ps.setObject(i+1, params[i]);
				
				count = ps.executeUpdate();
			}
			
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(null, ps, conn);
			
			
		}
		
		return count;
		
		
	}
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn){
		
			try {
				if(rs!=null)
				rs.close();
								
				if(ps!=null)
					ps.close();
				
				if(conn!=null)				
					conn.close(); 
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
								
		
	}
	

}
