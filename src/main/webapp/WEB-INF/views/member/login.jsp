<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	Login
	<form action="login" method='post'>
		<table>
			<tbody>
				<tr>
					<td><label for='memberId'>ID</label><input type='text'
						id='memberId' name='memberId'></td>
				</tr>
				<tr>
					<td><label for='memberPw'>Password</label><input
						type='password' id='memberPw' name='memberPw'></td>
				</tr>
				<tr>
					<td><input type='submit' value='로그인'></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>