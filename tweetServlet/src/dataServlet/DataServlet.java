package dataServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String checkBoxValue = (String)request.getParameter("radio_parameter");
		if (checkBoxValue != null && checkBoxValue.equals("display_servlet")) 
		{
			response.getWriter().append("for parameter text_parameter: value="+request.getParameter("text_parameter") +"<br>");
			response.getWriter().append("for parameter select_parameter: value="+request.getParameter("select_parameter") +"<br>");
			response.getWriter().append("for parameter color_parameter: value="+request.getParameter("color_parameter") +"<br>");
			response.getWriter().append("for parameter date_parameter: value="+request.getParameter("date_parameter") +"<br>");
			response.getWriter().append("for parameter datetime_parameter: value="+request.getParameter("datetime_parameter") +"<br>");
			response.getWriter().append("for parameter email_parameter: value="+request.getParameter("email_parameter") +"<br>");
			response.getWriter().append("for parameter file_parameter: value="+request.getParameter("file_parameter") +"<br>");
			response.getWriter().append("for parameter hidden_parameter: value="+request.getParameter("hidden_parameter") +"<br>");
			response.getWriter().append("for parameter month_parameter: value="+request.getParameter("month_parameter") +"<br>");
			response.getWriter().append("for parameter number_parameter: value="+request.getParameter("number_parameter") +"<br>");
			response.getWriter().append("for parameter password_parameter: value="+request.getParameter("password_parameter") +"<br>");
			response.getWriter().append("for parameter checkbox_parameter: value="+request.getParameter("checkbox_parameter") +"<br>");
			response.getWriter().append("for parameter range_parameter: value="+request.getParameter("range_parameter") +"<br>");
			response.getWriter().append("for parameter search_parameter: value="+request.getParameter("search_parameter") +"<br>");
			response.getWriter().append("for parameter submit_parameter: value="+request.getParameter("submit_parameter") +"<br>");
			response.getWriter().append("for parameter tel_parameter: value="+request.getParameter("tel_parameter") +"<br>");
			response.getWriter().append("for parameter text_parameter: value="+request.getParameter("text_parameter") +"<br>");
			response.getWriter().append("for parameter time_parameter: value="+request.getParameter("time_parameter") +"<br>");
			response.getWriter().append("for parameter url_parameter: value="+request.getParameter("url_parameter") +"<br>");
			response.getWriter().append("for parameter week_parameter: value="+request.getParameter("week_parameter") +"<br>");

		} 
		else if (checkBoxValue != null && checkBoxValue.equals("display_jsp"))
		{
			String label1="textParameter";
			String label1Value = request.getParameter("text_parameter");
			request.setAttribute(label1,label1Value);
			String label2="selectParameter";
			String label2Value = request.getParameter("select_parameter");
			request.setAttribute(label2,label2Value);
			RequestDispatcher
			rd=request.getRequestDispatcher("/display.jsp");
			rd.forward(request,response);
		} 
		else 
		{
			response.getWriter().append("servlet not expected to run directly, run from start.html");
		}

	}

}
