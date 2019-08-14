package login;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class login extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter out=res.getWriter();
		String user;
		if(((String)req.getParameter("user")).equals("amd")&&((String)req.getParameter("passwd")).equals("intel")) {
			out.print("success login");
			
			return;
		}
		else {
			out.print("failure login");
			out.print(req.getParameter("user")=="amd"+" "+req.getParameter("passwd") );
			return;
		}
			
		
	}
}
