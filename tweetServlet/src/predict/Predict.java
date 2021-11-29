package predict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sentimentanalysis.TweetCollection;
import sentimentanalysis.Tweet;

/**
 * Servlet implementation class Predict
 */
@WebServlet("/Predict")
public class Predict extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String predictPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/prediction.jsp\" />";
	private String tweetPage="<meta http-equiv = \"refresh\" content = \"0; url = http://localhost:8080/tweetServlet/tweetPage.jsp\" />";
	private TweetCollection tc = new TweetCollection("D:\\UCA Fall 2021\\OO Software Development Java\\TweetProject2\\tweetproject2\\sentimentanalysis\\trainingProcessed.txt", 1600000);
	private Tweet t;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Predict() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String textValue=request.getParameter("prediction").toString();
		request.setAttribute("text", textValue);
		if(request.getParameter("prediction")!=null)
		{
			t = new Tweet(0, 10000, "ASdsad", textValue.toString());
			tc.addTweet(t);
			String predict = Integer.toString(tc.predict(t));
			tc.removeTweet(t.getId());
			request.setAttribute("predict", predict);

			response.getWriter().append("<!DOCTYPE html>\r\n" +
					"<html>\r\n" +
					"<head>\r\n"+
					predictPage+
					"</head>\r\n" +
					"<body>\r\n"+
					"</body>\r\n"+
					"</html>");
		}
		else
		{
			response.getWriter().append("<!DOCTYPE html>\r\n" +
					"<html>\r\n" +
					"<head>\r\n"+
					tweetPage+
					"</head>\r\n" +
					"<body>\r\n"+
					"</body>\r\n"+
					"</html>");
		}
		String nextJSP = "/prediction.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
