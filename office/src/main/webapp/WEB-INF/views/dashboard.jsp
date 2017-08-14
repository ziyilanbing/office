<%@ taglib prefix="office" uri="http://www.com.glad.office/tags"%>
<jsp:include page="./include/head.jsp" flush="true"/>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="./include/header.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			
			<iframe id="mainFrame" name="mainFrame" src="/office/workhours/register" style="overflow:visible;min-height: 900px;" scrolling="yes" frameborder="no" width="100%"></iframe>

		</div>
		<!-- /.content-wrapper -->

		<jsp:include page="./include/footer.jsp" flush="true"/>
	</div>
	<!-- ./wrapper -->

</body>

</html>
