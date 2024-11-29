<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<main>
		<h1>EX 02</h1>
		<div>Name : ${name }, AGE : ${age }</div>
		<div>Test : ${test }</div>
	</main>
</body>
</html>