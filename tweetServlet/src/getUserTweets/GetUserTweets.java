package getUserTweets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sentimentanalysis.TweetCollection;


/**
 * Servlet implementation class GetUserTweets
 */
@WebServlet("/GetUserTweets")
public class GetUserTweets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TweetCollection tc = new TweetCollection("D:\\UCA Fall 2021\\OO Software Development Java\\TweetProject2\\tweetproject2\\sentimentanalysis\\trainingProcessed.txt", 1600000);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserTweets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("selected", request.getParameter("selected"));
		String uName = request.getParameter("userName").toString();
		//option pane and text box

         Set<Long> tweetIds = tc.getTweetIdsByUser(uName);
         String userTweets= "User Tweets \n";
         for(long i : tweetIds) 
         {
             userTweets = userTweets + tc.getTweetById(i) + "\n";
         }

         request.setAttribute("tweets",userTweets);
         request.setAttribute("userName",uName);
		

		String nextJSP = "/getUTweets.jsp";
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
