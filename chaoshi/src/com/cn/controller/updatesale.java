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


@WebServlet("/updatesale")
public class updatesale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatesale() {
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
		sale.setSaleid(Integer.parseInt(request.getParameter("new_saleid")));
		sale.setSalename(request.getParameter("new_salename"));
		sale.setSalenum(Integer.parseInt(request.getParameter("new_salenum")));
		sale.setTotal(Float.parseFloat(request.getParameter("new_total")));
		sale.setDate(request.getParameter("new_date"));
		sale.setFunder(request.getParameter("new_funder"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.updatesale(sale);
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
				request.setAttribute("error", "±£¥Ê ß∞‹");
				request.getRequestDispatcher("/salelist.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "±£¥Ê ß∞‹£°");
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
