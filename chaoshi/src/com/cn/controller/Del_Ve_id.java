package com.cn.controller;

import com.cn.dao.JdbcJavabean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Del_Ve_id")
public class Del_Ve_id extends HttpServlet{

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public Del_Ve_id() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ve_id=request.getParameter("ve_id");
        List list=null;
        boolean flag=false;
        JdbcJavabean dao=new JdbcJavabean();
        try {
            flag=dao.de_Ve_id(ve_id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (flag)
        {
            try {
                list=dao.Find_Ve_all();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (list!=null&& list.size()>0)
            {
                request.setAttribute("list",list);
                request.getRequestDispatcher("/Vendor.jsp").forward(request, response);
            }else
            {
                request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
                request.getRequestDispatcher("/Vendor.jsp").forward(request, response);

            }
        }else
        {
            request.setAttribute("error", "É¾³ýÊ§°Ü£¡");
            request.getRequestDispatcher("/Vendor.jsp").forward(request, response);

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
