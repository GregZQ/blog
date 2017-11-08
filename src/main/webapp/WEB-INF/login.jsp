<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
		<meta charset="UTF-8">
<link href="css/login.css" rel='stylesheet' type='text/css' />
</head>
<body style="height: 100%;">
</script>
<div class="login-form">
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
			<form action="${pageContext.request.contextPath }/tologin" method="post">
					<input type="text" class="text" value="username" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'username';}" >
					<div class="key">
							<input type="password" value="password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}">
					</div>
					<div class="signin">
						<input type="submit" value="Login" >
					</div>
			</form>
</div>
 	<div class="copy-rights">
				<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://zhangqii.com">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
	</div>
</body>
</html>