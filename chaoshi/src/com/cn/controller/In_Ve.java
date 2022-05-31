package com.cn.controller;

import com.cn.dao.JdbcJavabean;
import com.cn.model.Vendor;
import com.cn.model.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/In_Ve")
public class In_Ve extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public In_Ve() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Vendor vendor = new Vendor();
        vendor.setVe_id(Integer.parseInt(request.getParameter("ve_id")));
        vendor.setVe_name(request.getParameter("ve_name"));
        vendor.setVe_tel(request.getParameter("ve_tel"));
        vendor.setVe_address(request.getParameter("ve_address"));
        List list = null;
        boolean flag = false;
        JdbcJavabean dao = new JdbcJavabean();
        try {
            flag = dao.insertVendor(vendor);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (flag) {
            try {
                list = dao.Find_Ve_all();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (list != null && list.size() > 0) {
                request.setAttribute("list", list);
                request.getRequestDispatcher("/Vendor.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "新建失败");
                request.getRequestDispatcher("/Vendor.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("error", "新建失败！");
            request.getRequestDispatcher("/Vendor.jsp").forward(request, response);

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
