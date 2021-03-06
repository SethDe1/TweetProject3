package LoginServlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sentimentanalysis.TweetCollection;
import sentimentanalysis.Tweet;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String infoPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/tweetPage.jsp\" />";
	private String loginPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/Index.html\" />";
	private TweetCollection tc = new TweetCollection("D:\\UCA Fall 2021\\OO Software Development Java\\TweetProject2\\tweetproject2\\sentimentanalysis\\trainingProcessed.txt", 1600000);
	private String tweets = tc.toString();
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
		String redirect;
		//deciding where to redirect
		if(!(request.getParameter("uName").equals("md"))&&!(request.getParameter("pWord").equals("pw")))
		{
			//if not correct back to login
			redirect=loginPage;
			//writing redirect
			response.getWriter().append("<!DOCTYPE html>\r\n" +
					"<html>\r\n" +
					"<head>\r\n"+
					redirect+
					"</head>\r\n" +
					"<body>\r\n"+
					"</body>\r\n"+
					"</html>");
			request.setAttribute("tweets", tweets);
		}
		else
		{
			//actual data behind password


			//set redirect to info page
			redirect=infoPage;
			

			//displaying data
			response.getWriter().append("<!DOCTYPE html>\r\n" +
					"<html>\r\n" +
					"<head>\r\n"+
					redirect+
					"</head>\r\n" +
					"<body>\r\n"+
					"</body>\r\n"+
					"</html>");
			

			request.setAttribute("tweets", tweets);
			String nextJSP = "/tweetPage.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}