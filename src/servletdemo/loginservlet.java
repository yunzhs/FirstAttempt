package servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

@WebServlet(name = "loginservlet" ,urlPatterns = "/logining" ,loadOnStartup =-1)
public class loginservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //统计访问次数
//        times t=new times();
//        t.doPost(request,response);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        //System.out.println(username);
        //System.out.println(password);
        if("admin".equals(username)&&"123".equals(password)){
            request.getSession().setAttribute("userExist",username);
           // response.sendRedirect(request.getContextPath()+"/jstldemo.jsp");
            request.getRequestDispatcher("/geng").forward(request,response);


        }
        else{
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("/index.html").forward(request,response);
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
