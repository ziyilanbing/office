
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="content-header">
	<h1>Dashboard</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Total</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<form:form action="REPLACE_BY_SCRIPT" modelAttribute="workhoursModel"
		method="POST">
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
											name="wktmStartYmdhm" value="${earlierday}" /> <span
											class="input-group-addon">~</span> <input type="text"
											class="input-sm form-control" name="wktmEndYmdhm"
											value="${today}" />
									</div>
								</div>
								<!-- /.form-group -->
							</div>
						</div>
						<!-- /.row -->
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>工时类型</label>
									<form:select class="input-sm form-control select2"
										path="wktmType">
										<option selected="selected">项目</option>
										<option>EPG</option>
										<option>事务</option>
										<option>IT</option>
										<option>度量</option>
										<option>配置</option>
										<option>品保</option>
										<option>管理</option>
										<option>测试</option>
										<option>其他</option>
									</form:select>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>子类型</label>
									<form:select class="input-sm form-control select2"
										path="wktmSubtype">
										<option selected="selected">I-STAR_現物取引</option>
									</form:select>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-5">
								<div class="form-group">
									<label>项目阶段</label>
									<form:select class="input-sm form-control select2"
										path="projectStage">
										<option selected="selected">内部设计</option>
									</form:select>
								</div>
								<!-- /.form-group -->
							</div>
							<div class="col-md-1" style="padding-top: 1.6em;">
								<button type="submit" class="btn btn-info pull-right"
									formaction="searchTotal" role="button">查询</button>
							</div>
							<!-- /.col -->

						</div>
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
									<th>序号</th>
									<th>工时类型</th>
									<th>子类型</th>
									<th>项目阶段</th>
									<th>时间</th>
								</tr>
								<%-- 											<c:forEach var="a" items="${ }"> --%>
								<!-- 												<tr> -->
								<%-- 													<td>${a.recNo }.</td> --%>
								<%-- 													<td>${a.wktmType }</td> --%>
								<%-- 													<td>${a.wktmSubtype }</td> --%>
								<%-- 													<td>${a.projectStage }</td> --%>
								<%-- 													<td>${a.wktmTimes }</td> --%>
								<!-- 												</tr> -->
								<%-- 											</c:forEach> --%>
							</table>
						</div>
					</div>
					<!-- /.box -->
				</div>
			</div>
		</div>
	</form:form>
</section>

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