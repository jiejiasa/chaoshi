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
@WebServlet("/delmembyid")
public class delmembyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delmembyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	       String memid=request.getParameter("memid");
	       List list=null;
	       boolean flag=false;
	       JdbcJavabean dao=new JdbcJavabean();
			try {
				flag=dao.delmembyid(memid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag)
			{
				try {
					list=dao.findallmem();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (list!=null&& list.size()>0)
				{
					request.setAttribute("list",list);
					request.getRequestDispatcher("/member.jsp").forward(request, response);
				}else
				{
					request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
					request.getRequestDispatcher("/member.jsp").forward(request, response);
					
				}
			}else
			{
				request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
				request.getRequestDispatcher("/member.jsp").forward(request, response);
				
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
