package com.cn.controller;

import com.cn.dao.JdbcJavabean;
import com.cn.model.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Find_Ve_id")
public class Find_Ve_id extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Find_Ve_id() {

        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String ve_id = req.getParameter("ve_id");
        List list =null;

        Vendor ved = new Vendor();
        JdbcJavabean dao=new JdbcJavabean();
        try {
            list=dao.Find_Ve_id(ve_id);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (list!=null&& list.size()>=0)
        {
            req.setAttribute("list",list);
            req.getRequestDispatcher("/Vendor.jsp").forward(req, resp);
        }else
        {
            req.setAttribute("error", "≤È’“ ß∞‹£°");
            req.getRequestDispatcher("/Vendor.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
