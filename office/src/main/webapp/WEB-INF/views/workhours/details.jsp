<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>Dashboard</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Dashboard</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
				<form:form action="REPLACEBYSCRIPT" method="POST">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- Horizontal Form -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">
							<spring:message code="${title}" htmlEscape="false" />
						</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<div class="box-body">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>部 门</label>
									<p class="form-control-static">第一系统开发部</p>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>部 门</label>
									<p class="form-control-static">第一系统开发部</p>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-5">
								<div class="form-group">
									<label>查询日期</label>
									<div class="input-daterange input-group" id="datepicker">
										<input type="text" class="input-sm form-control"
											name="wktmStartYmdhm" value="${firstday}" /> <span
											class="input-group-addon">~</span> <input type="text"
											class="input-sm form-control" name="wktmEndYmdhm"
											value="${today}" />
									</div>
								</div>
								<!-- /.form-group -->
							</div>
							<div class="col-md-1" style="padding-top: 1.6em;">
								<button type="submit" class="btn btn-info pull-right"
									formaction="search" role="button">查询</button>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
			<!--/.col (right) -->
		</div>
		<!-- /.row -->
		<div id="collapse">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header with-border">
							<h3 class="box-title">Bordered Table</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table class="table table-bordered table-hover">
								<tr>
									<th class="col-md-1">序号</th>
									<th class="col-md-1">工时类型</th>
									<th class="col-md-1">子类型</th>
									<th class="col-md-1">项目阶段</th>
									<th class="col-md-2">开始时间</th>
									<th class="col-md-2">结束时间</th>
									<th class="col-md-1">时间</th>
									<th class="col-md-3">备注</th>
								</tr>
								<c:forEach var="a" items="${OdhWktmManageList }">
									<tr>
										<td>${a.recNo }.</td>
										<td>${a.wktmType }</td>
										<td>${a.wktmSubtype }</td>
										<td>${a.projectStage }</td>
										<td><fmt:formatDate value="${a.wktmStartYmdhm}"
												pattern="yyyy-MM-dd HH:mm" /></td>
										<td><fmt:formatDate value="${a.wktmEndYmdhm }"
												pattern="yyyy-MM-dd HH:mm" /></td>
										<td>${a.wktmTimes }</td>
										<td>${a.memo }</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<!-- /.box -->
				</div>
			</div>
		</div>
	</form:form>
</section>
<!-- /.content -->
<!-- InputMask -->
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.js'/>"></script>
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<script>
	$(function() {
		//Date picker
		$('.input-daterange').datepicker({
			format : "yyyy/mm/dd",
			todayBtn : "linked",
			language : "zh-CN",
			autoclose : true
		});
	});
</script>
