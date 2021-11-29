<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="500;url=http://localhost:8080/tweetServlet/Index.html" />
<title>Add Tweet</title>
</head>
<body style="background-color: rgba(154, 110, 186, 0.5)">
	<br><a href="http://localhost:8080/tweetServlet/Index.html">LogOut</a>
	The tweet added is: <br>
	<%=request.getAttribute("tweet")%>

</body>
</html>