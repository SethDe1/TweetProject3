package addTweet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sentimentanalysis.Tweet;
import sentimentanalysis.TweetCollection;


/**
 * Servlet implementation class AddTweet
 */
@WebServlet("/AddTweet")
public class AddTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TweetCollection tc = new TweetCollection("D:\\UCA Fall 2021\\OO Software Development Java\\TweetProject2\\tweetproject2\\sentimentanalysis\\trainingProcessed.txt", 1600000);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTweet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id =  request.getParameter("id");
		String polarity =  request.getParameter("polarity");
		String uName =  request.getParameter("uName");
		String tweetText =  request.getParameter("tweet");
		Tweet t = new Tweet(Integer.parseInt(polarity), Long.parseLong(id), uName, tweetText);
		tc.addTweet(t);
		
		Long tweetId = Long.parseLong(id);
		String tweet= tc.getTweetById(tweetId).toString();
		request.setAttribute("tweet", tweet);
		
		String nextJSP = "/AddTweet.jsp";
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
