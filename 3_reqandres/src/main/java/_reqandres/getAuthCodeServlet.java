package _reqandres;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getAuthCode")
public class getAuthCodeServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         AuthImgCreater A=new AuthImgCreater();
		 String authCode = A.getAuthcode();  
         
	        request.getSession().setAttribute("authCode", authCode);    //将验证码保存到session中，便于以后验证  
	          
	        try {  
	            //发送图片  
                ImageIO.write(A.getSuthImg(authCode), "JPEG", response.getOutputStream()); 
                //ImageIO.write(A.getSuthImg(authCode),"JPEG",new File("gray11.jpg"));  
	        } catch (IOException e){  
	            e.printStackTrace();  
	        }  
	    
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		doGet(request,response);
	}
 
}