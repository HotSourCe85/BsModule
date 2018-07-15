<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Search Test</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script    src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="margin:50px">
		<h3>Book Search Test</h3>
		<c:if test="${InputError ne null}">
			<div style="color: red">${InputError}</div>
		</c:if>
		<form action="/signUpUser" method="post">
			<div class="form-group">
				<label for="username">ID: <input type="text" class="form-control" id="username" name="username" value="${username}">
				<label for="name">Name: <input type="text" class="form-control" id="name" name="name" value="${name}">
				<label for="pwd">Password:</label> <input type="password" class="form-control" id="pwd" name="password">
				<label for="email">Email: <input type="text" class="form-control" id="email" name="email" value="${email}">	
			</div>
	
			<button type="submit" class="btn btn-success">Sign-Up</button>
			<button type="button" class="btn btn" onclick="location.href='/login'">취소</button>
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
