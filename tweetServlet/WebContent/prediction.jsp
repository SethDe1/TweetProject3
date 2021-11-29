<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="500;url=http://localhost:8080/tweetServlet/Index.html" />
<title>Predict</title>
</head>
<body style="background-color: rgba(154, 110, 186, 0.5)">
	<a href="http://localhost:8080/tweetServlet/Index.html">LogOut</a>
	<br>
	The prediction for your tweet is :<%=request.getAttribute("predict")%><br>
	<%=request.getAttribute("text")%>

</body>
</html>