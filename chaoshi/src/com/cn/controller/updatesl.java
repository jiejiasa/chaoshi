package com.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.JdbcJavabean;
import com.cn.model.stock_list;


@WebServlet("/updatesl")
public class updatesl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatesl() {
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
		stock_list sl=new stock_list();
		sl.setSl_id(Integer.parseInt(request.getParameter("new_id")));
		sl.setSl_name(request.getParameter("new_name"));
		sl.setGoods_number(Integer.parseInt(request.getParameter("new_number")));
		sl.setGoods_price(Float.parseFloat(request.getParameter("new_price")));
		sl.setSupplier_name(request.getParameter("new_sname"));
//		sl.setRuku_name(request.getParameter("new_ruku"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.updatesl(sl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			try {
				list = dao.findallsl();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/stock_list.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "±£¥Ê ß∞‹");
				request.getRequestDispatcher("/stock_list.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "±£¥Ê ß∞‹£°");
			request.getRequestDispatcher("/stock_list.jsp").forward(request, response);

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
