package com.cn.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.JdbcJavabean;

/**
 * Servlet implementation class delbyid
 */
@WebServlet("/delempbyid")
public class delempbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delempbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	       String empid=request.getParameter("empid");
	       List list=null;
	       boolean flag=false;
	       JdbcJavabean dao=new JdbcJavabean();
			try {
				flag=dao.delempbyid(empid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag)
			{
				try {
					list=dao.findallemp();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (list!=null&& list.size()>0)
				{
					request.setAttribute("list",list);
					request.getRequestDispatcher("/emp.jsp").forward(request, response);
				}else
				{
					request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
					request.getRequestDispatcher("/emp.jsp").forward(request, response);
					
				}
			}else
			{
				request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
				request.getRequestDispatcher("/emp.jsp").forward(request, response);
				
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
