<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	box-sizing: border-box
}

/* Add padding to containers */
.container {
	padding: 16px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
<body>
	<form action="/ltwebct4/register" method="post">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="username"><b>Tên đăng nhập</b></label> <input type="text"
				placeholder="Nhập Tên đăng nhập" name="uname" id="uname" required>

			<label for="fullname"><b>Họ tên</b></label> <input type="text"
				placeholder="Nhập Họ tên" name="fullname" id="fullname" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Nhập Email" name="email" id="email" required>

			<label for="phone"><b>Số điện thoại</b></label> <input type="text"
				placeholder="Nhập Số điện thoại" name="phone" id="phone" required>

			<label for="psw"><b>Mật khẩu</b></label> <input type="password"
				placeholder="Nhập Mật khẩu" name="psw" id="psw" required> <label
				for="psw-repeat"><b>Nhập lại Mật khẩu</b></label> <input
				type="password" placeholder="Nhập lại Mật khẩu" name="psw-repeat"
				id="psw-repeat" required>
			<hr>


			<button type="submit" class="registerbtn">Tạo tài khoản</button>
		</div>

		<div class="container signin">
			<p>
				Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>.
			</p>
		</div>
	</form>

</body>
</html>