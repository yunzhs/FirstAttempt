package servletdemo;

import utils.VerifyCode;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "CodeServlet",urlPatterns = "/code",loadOnStartup = 1)
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到响应的字节流
        ServletOutputStream outputStream=response.getOutputStream();
        //获取工具类中的验证码图片
        VerifyCode vc=new VerifyCode();
        //BufferedImage,img用来加载到内存中的一个类
        BufferedImage image=vc.getImage();
        String s=vc.getText();//分别获取图片和数字
        request.getSession().setAttribute("servercode",s);
        //System.out.println(s);
        vc.output(image, outputStream);
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
