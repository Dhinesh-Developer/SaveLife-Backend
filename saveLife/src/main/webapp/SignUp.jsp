<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp page</title>
</head>
<body>
	<form action="SignUp" method="post">
		Name : <input type="text" name="name" required>
		Email : <input type="email" name = "email" required>
		Password : <input type="password" name="password" required>
		Role : <input type="text" name="role" required>
		<input type="submit">  
	
	</form>
</body>
</html>