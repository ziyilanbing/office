<%@ include file="./include/header.jsp"%>
<!DOCTYPE html>
<html lang="zh">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link href="../WEB-INF/static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="../WEB-INF/static/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="../WEB-INF/static/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../WEB-INF/static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<form:form modelAttribute="loginModel" action="submit" id="form"
		method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Please Sign In</h3>
						</div>
						<div class="panel-body">
							<fieldset>
								<div class="form-group">
									<form:input path="username" class="form-control" type="text"
										placeholder="E-mail" />
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
								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<!-- jQuery -->
	<script src="../WEB-INF/static/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../WEB-INF/static/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../WEB-INF/static/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../WEB-INF/static/js/sb-admin-2.js"></script>

</body>

</html>
