package LoginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String infoPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/infoPage.html\" />";
	private String loginPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/Index.html\" />";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		String redirect = loginPage;
		if(request.getParameter("uName").equals("md")&&request.getParameter("pWord").equals("pw"))
		{
			redirect=infoPage;
		}
		response.getWriter().append("<!DOCTYPE html>\r\n" +
				"<html>\r\n" +
				"<head>\r\n"+
				redirect+
				"</head>\r\n" +
				"<body>\r\n" +
				"</body>\r\n"+
				"</html>");
		
		response.getWriter().append("\"<html>\\r\\nreset:<input type=\"reset\" value=\"reset\" name=\"reset_parameter\"><br>\"</html>\"");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}