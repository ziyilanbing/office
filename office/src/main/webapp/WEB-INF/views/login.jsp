<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>GLAD Office - 宏智科技电子办公系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/static/css/AdminLTE.min.css'/>">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="../../index.html"><b>GLAD</b>office</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

			<form:form modelAttribute="loginModel" action="REPLACE_BY_SCRIPT"
				id="form" method="POST">

				<div class="form-group has-feedback">
					<form:input path="username" class="form-control" type="text"
						placeholder="用户名" value="admin" />
					<span
						class="glyphicon glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<form:input class="form-control" placeholder="密码" path="password"
						type="password" value="1" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox">
							<label> <input id="remember" name="remember-me"
								type="checkbox" value="Remember Me" />Remember Me
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-primary btn-block btn-flat"
							formaction="submit">登录</button>
						<!-- /.col -->
					</div>
				</div>
			</form:form>

			<a href="#">I forgot my password</a><br> <a href="register.html"
				class="text-center">Register a new membership</a>
		</div>
	</div>
</body>

<!-- jQuery -->
<script src="<c:url value='/static/vendor/jquery/jquery-2.2.3.min.js'/>"></script>
<!-- Bootstrap Core JavaScript -->
<script
	src="<c:url value='/static/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
</html>
