<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>用户管理</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">用户管理</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-2">
			<!-- Profile Image -->
			<div class="box box-primary">
				<div class="box-body box-profile">

					<h3 class="profile-username text-center">Nina Mcintire</h3>

					<p class="text-muted text-center">Software Engineer</p>

					<ul class="list-group list-group-unbordered">
						<li class="list-group-item"><a href=""><i
								class="fa fa-book margin-r-5"></i><b>所有用户</b> <b
								class="pull-right">1,322</b></a></li>
						<li class="list-group-item"><i
							class="fa fa-map-marker margin-r-5"></i><b>角色</b></li>
						<li class="list-group-item"><a href=""><i
								class="fa fa-file-text-o margin-r-5"></i><b>系统管理员</b> <b
								class="pull-right">1,322</b></a></li>
					</ul>

					<a href="#" class="btn btn-primary btn-block" data-target="#exampleModal" data-toggle="modal"><b>添加新角色</b></a>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-10">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Read Mail</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="table-responsive">
						<table id="example" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>模块ID</th>
									<th>父模块ID</th>
									<th>模块URL</th>
									<th>模块名称</th>
									<th>模块说明</th>
									<th>层数</th>
									<th>显示顺序</th>
								</tr>
							</thead>
							<tbody>
<%-- 								<c:forEach var="odhModlInfo" items="${odhModlInfoList}"> --%>
									<tr>
										<td>1${odhModlInfo.modelId }</td>
										<td>2${odhModlInfo.parentModelId }</td>
										<td>3${odhModlInfo.modelUrl }</td>
										<td>4${odhModlInfo.modelName }</td>
										<td>5${odhModlInfo.modelInfo }</td>
										<td>6${odhModlInfo.layerNo }</td>
										<td>7${odhModlInfo.displayOrder }</td>
									</tr>
									<tr>
										<td>1${odhModlInfo.modelId }</td>
										<td>2${odhModlInfo.parentModelId }</td>
										<td>3${odhModlInfo.modelUrl }</td>
										<td>4${odhModlInfo.modelName }</td>
										<td>5${odhModlInfo.modelInfo }</td>
										<td>6${odhModlInfo.layerNo }</td>
										<td>7${odhModlInfo.displayOrder }</td>
									</tr>
									<tr>
										<td>1${odhModlInfo.modelId }</td>
										<td>2${odhModlInfo.parentModelId }</td>
										<td>3${odhModlInfo.modelUrl }</td>
										<td>4${odhModlInfo.modelName }</td>
										<td>5${odhModlInfo.modelInfo }</td>
										<td>6${odhModlInfo.layerNo }</td>
										<td>7${odhModlInfo.displayOrder }</td>
									</tr>
									<tr>
										<td>1${odhModlInfo.modelId }</td>
										<td>2${odhModlInfo.parentModelId }</td>
										<td>3${odhModlInfo.modelUrl }</td>
										<td>4${odhModlInfo.modelName }</td>
										<td>5${odhModlInfo.modelInfo }</td>
										<td>6${odhModlInfo.layerNo }</td>
										<td>7${odhModlInfo.displayOrder }</td>
									</tr>
<%-- 								</c:forEach> --%>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<div class="pull-right">
						<button type="button" class="btn btn-default">
							<i class="fa fa-reply"></i> Reply
						</button>
						<button type="button" class="btn btn-default">
							<i class="fa fa-share"></i> Forward
						</button>
					</div>
					<button type="button" class="btn btn-default">
						<i class="fa fa-trash-o"></i> Delete
					</button>
					<button type="button" class="btn btn-default">
						<i class="fa fa-print"></i> Print
					</button>
				</div>
				<!-- /.box-footer -->
			</div>
			<!-- /. box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<div class="modal" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog modal-md modal-center" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">角色信息</h4>
			</div>
			<div class="modal-body">
				<div class="form-group has-feedback">
					<label class="control-label">角色名称：</label> <input type="text"
						class="form-control" name="roleName" ><i
						class="form-control-feedback" data-fv-icon-for="roleName"
						style="display: none;"></i> <small class="help-block"
						data-fv-validator="notEmpty" data-fv-for="roleName"
						data-fv-result="NOT_VALIDATED" style="display: none;">请填写角色名称</small>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label">权限分配：</label>
				</div>
			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">保存</button>
				<button type="button" class="btn btn-primary" id="saveChanges"
					data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<script>
$(function() {
	$('#exampleModal').on('shown.bs.modal', function(e) {
		$("#saveChanges").focus();
		$("#saveChanges").click(function() {
			$.pjax.reload('#pjax-container', {
				url : "submit"
			});
		});
	});
});
</script>