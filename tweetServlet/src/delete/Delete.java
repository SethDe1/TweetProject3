package delete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sentimentanalysis.TweetCollection;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TweetCollection tc = new TweetCollection("D:\\UCA Fall 2021\\OO Software Development Java\\TweetProject2\\tweetproject2\\sentimentanalysis\\trainingProcessed.txt", 1600000);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int i = Integer.parseInt(request.getParameter("deleteTweet"));
		if (i==1)
		{
			Long id = Long.parseLong(request.getParameter("id"));
			tc.removeTweet(id);
			
			request.setAttribute("id", id.toString());
			String nextJSP = "/delete.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		else
		{
			String nextJSP = "/Index.html";
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
