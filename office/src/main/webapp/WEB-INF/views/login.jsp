<%@ include file="./include/head.jsp"%>

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

</html>
