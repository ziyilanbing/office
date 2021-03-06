<jsp:include page="./include/head.jsp" flush="true"/>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Dear <strong>${user}</strong>, You are not authorized to access this page.</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">Alert Styles</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="alert alert-danger">
						Dear <strong>${user}</strong>, You are not authorized to access
						this page. <br /> <a href="<c:url value='/logout' />"
							class="alert-link"> click this link to login </a>.
					</div>
				</div>
				<!-- .panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /#wrapper -->

</body>

</html>
