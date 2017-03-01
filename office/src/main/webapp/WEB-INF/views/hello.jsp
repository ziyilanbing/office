<html>
<head>
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
	Example</title>
</head>
<body>
	<form:form id="form"
		action="<%=request.getContextPath()%>/test/getTest"
		modelAttribute="helloModel">

		<table>
			<tr>
				<td>人员内码：<input name="psseno" type="text"> 单位内码:<input
					name="cpseno" type="password"> <input name="tj"
					type="submit" value="提交">
				</td>
			</tr>
		</table>

${form.message}
</form:form>

</body>
</html>