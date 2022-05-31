package com.cn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.dao.JdbcJavabean;
import com.cn.model.goods;

/**
 * Servlet implementation class FindAllController
 */
@WebServlet("/updategoods")
public class updategoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updategoods() {
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
		goods goods=new goods();
		goods.setGoods_id(Integer.parseInt(request.getParameter("new_id")));
		goods.setGoods_name(request.getParameter("new_name"));
		goods.setGoods_price(Float.parseFloat(request.getParameter("new_price")));
		goods.setGoods_number(Integer.parseInt(request.getParameter("new_number")));
		goods.setGoods_shelf_number(request.getParameter("new_shelf_number"));
		List list = null;
		boolean flag = false;
		JdbcJavabean dao = new JdbcJavabean();
		try {
			flag = dao.updategoods(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			try {
				list = dao.findallgoods();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "����ʧ��");
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("error", "����ʧ�ܣ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);

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
