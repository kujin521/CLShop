package com.cl.servlet.user;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.entity.CL_USER;
import com.cl.service.CL_USERDao;

/**
 * Servlet implementation class DoUserAdd
 * 
 */
@WebServlet("/clshop/manager/admin_useradd")
public class DoUserAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("aaa");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id =request.getParameter("ID");
		String username =request.getParameter("userName");
		
		String pwd =request.getParameter("passWord");
		String sex =request.getParameter("sex");
		String year =request.getParameter("birthday");
		String email =request.getParameter("email");
		String mobile =request.getParameter("mobile");
		String address =request.getParameter("address");						
		CL_USER u = new CL_USER(id,username,pwd,sex,year,null,email,mobile,address,1);
				
		//加入到数据库表中
		int count = CL_USERDao.insert(u);
				
		
		//成功或失败重定向到哪里
		
		if (true){
			response.sendRedirect("admin_user.jsp");
						
		}else{
			
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("aletr('用户添加失败')");
			out.write("location.herf='manager/admin_useradd.jsp'");
			out.write("</script>");
		}
	}

}
