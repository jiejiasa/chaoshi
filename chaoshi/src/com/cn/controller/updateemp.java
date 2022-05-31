package com.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.JdbcJavabean;
import com.cn.model.emp;


@WebServlet("/updateemp")
public class updateemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateemp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		emp emp=new emp();
		emp.setEmpid(Integer.parseInt(request.getParameter("new_empid")));
		emp.setEmpname(request.getParameter("new_empname"));
		emp.setEmptel(request.getParameter("new_emptel"));
		emp.setEmppos(request.getParameter("new_emppos"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.updateemp(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			try {
				list = dao.findallemp();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/emp.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "±£¥Ê ß∞‹");
				request.getRequestDispatcher("/emp.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "±£¥Ê ß∞‹£°");
			request.getRequestDispatcher("/emp.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
