<%@ include file="./include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bootstrap Admin Theme Login - SB Admin 2</title>

<%@ include file="./include/head.jsp"%>

</head>

<body>

	<form:form modelAttribute="loginModel" action="REPLACE_BY_SCRIPT"
		id="form" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Please Sign In</h3>
						</div>
						<c:if test='${authenticationFailureResult != null}'>
							<div class="alert alert-danger">
								<p>Invalid user name and password.</p>
							</div>
						</c:if>
						<div class="panel-body">
							<fieldset>
								<div class="form-group">
									<form:input path="username" class="form-control" type="text"
										placeholder="username" />
								</div>
								<div class="form-group">
									<form:input class="form-control" placeholder="Password"
										path="password" type="password" value="" />
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me" />Remember Me
									</label>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block" type="submit"
									formaction="submit">Login</button>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>

</html>
