package com.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.JdbcJavabean;
import com.cn.model.salelist;

/**
 * Servlet implementation class FindAllController
 */
@WebServlet("/insertsale")
public class insertsale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertsale() {
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
		salelist sale=new salelist();
		sale.setSaleid(Integer.parseInt(request.getParameter("saleid")));
		sale.setSalename(request.getParameter("salename"));
		sale.setSalenum(Integer.parseInt(request.getParameter("salenum")));
		sale.setTotal(Float.parseFloat(request.getParameter("total")));
		sale.setDate(request.getParameter("date"));
		sale.setFunder(request.getParameter("funder"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.insertsale(sale);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			try {
				list = dao.findallsale();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/salelist.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "新建失败");
				request.getRequestDispatcher("/salelist.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "新建失败！");
			request.getRequestDispatcher("/salelist.jsp").forward(request, response);

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
