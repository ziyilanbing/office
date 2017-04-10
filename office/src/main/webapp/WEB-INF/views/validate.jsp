<%@ include file="./include/head.jsp"%>

<body>

	<form:form modelAttribute="validateModel" action="REPLACE_BY_SCRIPT"
		id="form" method="POST">
		<form:input type="text" path="textInput" />
		<form:button type="submit" formaction="post">submit</form:button>
	</form:form>
</body>
</html>
