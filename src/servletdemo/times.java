package servletdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebServlet("/geng")
public class times extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doGet(request, response);
    }

    private Cookie cookinit(HttpServletRequest request, String name) {

        Cookie[] cookie = request.getCookies();

        if (cookie == null) {
            return null;
        } else {
            for (Cookie c : cookie) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
            return null;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie=cookinit(request,"thelasttime");
        response.setContentType("text/html;charset=utf-8");

        if(cookie==null){
            String time =String.format("%tF---%<tT", new Date());
            cookie=new Cookie("thelasttime",time);
            System.out.println(time);
            response.addCookie(cookie);
            response.getWriter().print("欢迎访问我的主页");
            //request.getSession().setAttribute("welcome","欢迎访问我的主页");
            response.getWriter().write("3秒钟跳到主页");
            //设置3秒钟跳转
            response.setHeader("refresh", "3;url=http://localhost:8080/jstldemo1.jsp");
        }
        else{
            response.getWriter().print("欢迎访问我的主页"+"<br/>"+"你上次访问的时间是:"+cookie.getValue());
            //String str="欢迎访问我的主页"+"<br/>"+"你上次访问的时间是:"+cookie.getValue();
            String time =String.format("%tF--%<tT", new Date());
            cookie=new Cookie("thelasttime",time);
            response.addCookie(cookie);
            response.getWriter().write("3秒钟跳到主页");
            //设置3秒钟跳转
            response.setHeader("refresh", "3;url=http://localhost:8080/jstldemo1.jsp");
        }
    }
}
