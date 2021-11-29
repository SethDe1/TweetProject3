<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="500;url=http://localhost:8080/tweetServlet/Index.html" />
<title>Tweet Manipulation</title>
</head>
<body style="background-color: rgba(154, 110, 186, 0.79)">

	<a href="http://localhost:8080/tweetServlet/Index.html">LogOut</a>

	<form>
		<label for="TextArea"><font face="Chiller" size="20px">Tweets
				by Seth DeWalt</font></label><br>
		<textarea rows="20" cols="120\">
				<%=request.getAttribute("tweets")%>
				
				</textarea>
	</form>

	<!-- text field and redirect to predict -->
	<form action="/tweetServlet/Predict">
		<label for="Predict"><font face="Chiller">Type the text to Predict</font></label><br>
		<input type="text" id="prediction_text" name="prediction" size="70"
			required> <input name="prediction" type="submit"
			value="do prediction">
	</form>
		
	<!-- text field and redirect to getUserTweets -->
	<form action="/tweetServlet/GetUserTweets">
		<label for="GetTweets"><font face="Chiller">Enter Username to Get</font></label><br> <input
			type="text" id="uName" name="userName" size="30" required> <input
			name="userName" type="submit" value="get tweets">
	</form>

	<form action="/tweetServlet/AddTweet">
		<label for="id"><font face="Chiller">ID Number:</font></label><br> <input type="text"
			id="prediction_text" name="id" size="20" required><br> <label
			for="polarity"><font face="Chiller">Polarity:</font></label><br> <input type="text"
			id="prediction_text" name="polarity" size="20" required><br>
		<label for="uName"><font face="Chiller">Username:</font></label><br> <input type="text"
			id="prediction_text" name="uName" size="20" required><br>
		<label for="tweet"><font face="Chiller">Tweet:</font></label><br> <input type="text"
			id="prediction_text" name="tweet" size="20" required> <input
			name="addTweet" type="submit" value="add Tweet">
	</form>


</body>
</html>