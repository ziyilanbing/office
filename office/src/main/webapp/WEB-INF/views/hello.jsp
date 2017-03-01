<%@ include file="../include/header.jsp"%>

<html>
<head>
<title>登录注册bundle</title>

<link rel="stylesheet/less" href="resources/styles/app/app.less">
<link rel="stylesheet"
	href="resources/styles/libs/bootstrap/bootstrap.min.css">

<script src="resources/scripts/libs/less/less-1.7.1.min.js"></script>
<script data-main="resources/scripts/app/main/main.js"
	src="resources/scripts/libs/require/require.js"></script>
</head>
<body>
	<form:form modelAttribute="helloModel" action="submit?aaa=bbb" id="form" method="POST">
		<table class="my-login-table" id="loginTable">
			<tr>
				<td>用户名</td>
				<td><form:input path="username" class="form-control" type="text"
					placeholder="请输入用户名" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><form:input path="password" class="form-control" type="text"
					placeholder="请请输入密码用户名" /></td>
					<td>${helloModel.password}</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button class="btn btn-info" type="submit">登录</button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>