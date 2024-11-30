<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JA2PYC</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<main>
		<h1>exUpload</h1>
		<div>
			<form action="/ex/exUploadPost" method="post"
				enctype="multipart/form-data">
				<div>
					<input type='file' name='files'>
				</div>
				<div>
					<input type='file' name='files'>
				</div>
				<div>
					<input type='file' name='files'>
				</div>
				<div>
					<input type='file' name='files'>
				</div>
				<div>
					<input type='submit'>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</body>
</html>