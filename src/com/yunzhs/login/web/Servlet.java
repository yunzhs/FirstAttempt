package com.yunzhs.login.web;

import com.yunzhs.login.service.Accountverify;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Servlet",urlPatterns = "/loginservice",loadOnStartup = 1)
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Accountverify acc=new Accountverify();
        try {
            boolean flag = acc.judgeUser(username);
            if(flag==true){
                //用户不存在
                response.getWriter().print("2");
            }else{
                //用户存在
                response.getWriter().print("1");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
