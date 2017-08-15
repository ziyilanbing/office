<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>Dashboard</h1>
	<h1>${COMPANY_TYPE.get('00')}</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Dashboard</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<form:form action="confirm" modelAttribute="workhoursModel"
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
						<c:if test="${not empty value}">
							<div class="callout callout-danger">
								<p id="errorMessage">${value}</p>
							</div>
						</c:if>
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
									<label>工时类型</label>
									<form:select class="form-control select2" path="wktmType">
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
									<form:select class="form-control select2" path="wktmSubtype">
										<option selected="selected">I-STAR_現物取引</option>
									</form:select>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>项目阶段</label>
									<form:select class="form-control select2" path="projectStage">
										<option selected="selected">内部设计</option>
									</form:select>
								</div>
								<!-- /.form-group -->
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>开始日期</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-calendar" for="datepicker"></i>
										</div>
										<form:input class="form-control date" path="wktmStartYmd"
											id="datepicker" value="${today}" />
									</div>
									<!-- /.input group -->
								</div>
								<!-- /.form group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>时间</label>
									<div class="input-group">

										<div class="input-group-addon">
											<i class="fa fa-clock-o"></i>
										</div>
										<form:input type="text" cssClass="form-control"
											cssErrorClass="form-control has-error" path="wktmStarthm"
											data-inputmask="'alias': 'hh:mm'" data-mask="true" />

									</div>
									<!-- /.input group -->
								</div>
								<!-- /.form group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>结束日期</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-calendar" for="datepicker2"></i>
										</div>
										<form:input class="form-control date" path="wktmEndYmd"
											id="datepicker2" value="${today}" />
									</div>
									<!-- /.input group -->
								</div>
								<!-- /.form group -->
							</div>
							<!-- /.col -->
							<div class="col-md-3">
								<div class="form-group">
									<label>时间</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-clock-o"></i>
										</div>
										<form:input type="text" cssClass="form-control"
											cssErrorClass="form-control has-error" path="wktmEndhm"
											data-inputmask="'alias': 'hh:mm'" data-mask="true" />
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
										path="comment" placeholder="Enter ..." maxlength="50"></form:textarea>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-primary pull-right"
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
									<th class="col-md-1">序号</th>
									<th class="col-md-1">工时类型</th>
									<th class="col-md-1">子类型</th>
									<th class="col-md-1">项目阶段</th>
									<th class="col-md-2">开始时间</th>
									<th class="col-md-2">结束时间</th>
									<th class="col-md-1">时间</th>
									<th class="col-md-3">备注</th>
								</tr>
								<tr>
									<td>1.</td>
									<td>${workhoursModel.odhWktmManageChecked.wktmType}</td>
									<td>${workhoursModel.odhWktmManageChecked.wktmSubtype}</td>
									<td>${workhoursModel.odhWktmManageChecked.projectStage}</td>
									<td><fmt:formatDate
											value="${workhoursModel.odhWktmManageChecked.wktmStartYmdhm}"
											pattern="yyyy-MM-dd HH:mm" /></td>
									<td><fmt:formatDate
											value="${workhoursModel.odhWktmManageChecked.wktmEndYmdhm}"
											pattern="yyyy-MM-dd HH:mm" /></td>
									<td>${workhoursModel.odhWktmManageChecked.wktmTimes}</td>
									<td>${workhoursModel.odhWktmManageChecked.memo}</td>
								</tr>
							</table>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<button type="button" class="btn btn-primary margin pull-right"
								data-toggle="modal" data-target="#exampleModal">提交</button>
							<button type="submit" class="btn btn-primary margin pull-right">下班</button>
							<button type="submit" class="btn btn-primary margin pull-right">删除</button>
							<button type="submit" class="btn btn-primary margin pull-right">修改</button>
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
<div class="modal" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">...</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="saveChanges"
					data-dismiss="modal">Save changes</button>
			</div>
		</div>
	</div>
</div>

<!-- InputMask -->
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.js'/>"></script>
<script
	src="<c:url value='/static/vendor/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
<script>
	$(function() {
		//Money Euro
		$("[data-mask]").inputmask();

		// Date picker
		$(".date").each(function() {
			$(this).datepicker({
				format : "yyyy/mm/dd",
				todayBtn : "linked",
				language : "zh-CN",
				orientation : "bottom auto",
				autoclose : true
			});
		});
		// app.js 实装TODO
		$('#exampleModal').on('shown.bs.modal', function(e) {
			$("#saveChanges").focus();
			$("#saveChanges").click(function() {
				$.post("submit");
			});
		});
	});
</script>