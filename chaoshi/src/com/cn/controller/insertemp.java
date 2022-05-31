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

/**
 * Servlet implementation class FindAllController
 */
@WebServlet("/insertemp")
public class insertemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertemp() {
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
		emp.setEmpid(Integer.parseInt(request.getParameter("empid")));
		emp.setEmpname(request.getParameter("empname"));
		emp.setEmptel(request.getParameter("emptel"));
		emp.setEmppos(request.getParameter("emppos"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.insertemp(emp);
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
				request.setAttribute("error", "新建失败");
				request.getRequestDispatcher("/emp.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "新建失败！");
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
