<%@ taglib prefix="office" uri="http://www.com.glad.office/tags"%>
<%@ include file="../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="../include/header.jsp"%>

		<office:office-menu />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
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
				<form:form action="REPLACE_BY_SCRIPT"
					modelAttribute="workhoursModel" method="POST">
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- Horizontal Form -->
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title">General Form 工时登记</h3>
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
												<label>工时类型</label> <select class="form-control select2"
													style="width: 100%;">
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
												</select>
											</div>
											<!-- /.form-group -->
										</div>
										<!-- /.col -->
										<div class="col-md-3">
											<div class="form-group">
												<label>子类型</label> <select class="form-control select2"
													style="width: 100%;">
													<option selected="selected">I-STAR_現物取引</option>
												</select>
											</div>
											<!-- /.form-group -->
										</div>
										<!-- /.col -->
										<div class="col-md-3">
											<div class="form-group">
												<label>项目阶段</label> <select class="form-control select2"
													style="width: 100%;">
													<option selected="selected">内部设计</option>
												</select>
											</div>
											<!-- /.form-group -->

										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label>开始时间:</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-calendar" for="datepicker1"></i>
													</div>
													<form:input class="form-control pull-right"
														path="startDate" id="datepicker1" />
													<div class="input-group-addon">
														<i class="fa fa-clock-o"></i>
													</div>
													<form:input type="text" class="form-control"
														path="startTime" data-inputmask='"mask": "99:99"'
														data-mask="true" />
												</div>
												<!-- /.input group -->
											</div>
											<!-- /.form group -->
										</div>
										<!-- /.col -->
										<div class="col-md-6">
											<div class="form-group">
												<label>结束时间:</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-calendar" for="datepicker2"></i>
													</div>
													<form:input class="form-control pull-right" path="endDate"
														id="datepicker2" data-inputmask="'alias': 'yyyy/mm/dd'"
														data-mask="true" />
													<div class="input-group-addon">
														<i class="fa fa-clock-o"></i>
													</div>
													<form:input type="text" class="form-control" path="endTime"
														data-inputmask='"mask": "99:99"' data-mask="true" />
												</div>
												<!-- /.input group -->
											</div>
											<!-- /.form group -->
										</div>
										<!-- /.col -->
										<div class="col-md-12">
											<!-- textarea -->
											<div class="form-group">
												<label>Textarea</label>
												<form:textarea class="form-control" rows="3" id="comment"
													path="comment" placeholder="Enter ..."></form:textarea>
											</div>
											<!-- /.form-group -->
										</div>
										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" class="btn btn-info pull-right"
										formaction="confirm" role="button">确认</button>
								</div>
								<!-- /.box-footer -->
							</div>
							<!-- /.box -->
						</div>
						<!--/.col (right) -->
					</div>
					<!-- /.row -->
					<div
						<c:if test="${workhoursModel.odhWktmManageChecked == null}">
							class="collapse"
						</c:if>>
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
												<th>开始时间</th>
												<th>结束时间</th>
												<th>时间</th>
												<th>备注</th>
											</tr>
											<tr>
												<td>1.</td>
												<td>项目</td>
												<td>I-STAR_現物取引</td>
												<td>内部设计</td>
												<td>2017-05-18 08:30</td>
												<td>2017-05-18 08:30</td>
												<td>8时0分</td>
												<td>${workhoursModel.odhWktmManageChecked.memo}</td>
											</tr>
										</table>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="submit" class="btn btn-info margin pull-right" formaction="submit">提交</button>
										<button type="submit" class="btn btn-info margin pull-right">下班</button>
										<button type="submit" class="btn btn-info margin pull-right">删除</button>
										<button type="submit" class="btn btn-info margin pull-right">修改</button>
									</div>
									<!-- /.box-footer -->
								</div>
								<!-- /.box -->
							</div>
						</div>
					</div>
				</form:form>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<%@ include file="../include/footer.jsp"%>

	</div>
	<!-- ./wrapper -->

</body>

<!-- InputMask -->
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.js'/>"></script>
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<script>
	$(function() {
		//Money Euro
		$("[data-mask]").inputmask();
		$("#confirm").click(function() {

		});
	});
</script>
</html>
