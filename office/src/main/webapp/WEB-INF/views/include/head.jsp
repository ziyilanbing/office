<!DOCTYPE html>
<html lang="zh">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<meta name="description" content="">
<meta name="author" content="">
<title><spring:message code="${title}" htmlEscape="false" /></title>
<sec:csrfMetaTags />
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<!-- Custom Fonts -->
<link href="<c:url value='/static/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<!-- date picker -->
<link href="<c:url value='/static/vendor/bootstrap-datepicker/css/bootstrap-datepicker3.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- DataTables -->
<link href="<c:url value='/static/vendor/datatables/css/dataTables.bootstrap.css'/>"
	rel="stylesheet" type="text/css">
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value='/static/css/AdminLTE.min.css'/>">
<link rel="stylesheet" href="<c:url value='/static/css/skin-blue.min.css'/>">

<!-- jQuery -->
<script src="<c:url value='/static/vendor/jquery/jquery.min.js'/>"></script>
<!-- jQuery Pjax -->
<script src="<c:url value='/static/vendor/jquery/jquery.pjax.js'/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value='/static/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- date picker -->
<script src="<c:url value='/static/vendor/bootstrap-datepicker/js/bootstrap-datepicker.min.js'/>"></script>
<script src="<c:url value='/static/vendor/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js'/>"
	charset="UTF-8"></script>
<!-- InputMask -->
<script src="<c:url value='/static/vendor/input-mask/jquery.inputmask.js'/>"></script>
<script src="<c:url value='/static/vendor/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<!-- SlimScroll -->
<script src="<c:url value='/static/vendor/slimScroll/jquery.slimscroll.min.js'/>"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value='/static/js/app.js'/>"></script>

</head>