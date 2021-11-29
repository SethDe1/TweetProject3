<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="500;url=http://localhost:8080/tweetServlet/Index.html" />
<title>Tweet Manipulation</title>
</head>
<body style="background-color: rgba(154, 110, 186, 0.5)">
	<a href="http://localhost:8080/tweetServlet/Index.html">LogOut</a>
	Username:
	<%=request.getAttribute("userName")%><br>
	<textarea id="userName" name="userName" rows="11" cols="120">
  		<%=request.getAttribute("tweets")%>
  </textarea>
	
	<form action="/tweetServlet/Delete">
	<label for="ty">Delete Tweet</label> <input type="text"
			placeholder="Enter Tweet Id" name="id" required>
		  <input type="radio" id="delete" name="deleteTweet" value=1><br>
		<!-- submit button and remember me button -->
	</form>

</body>
</html>