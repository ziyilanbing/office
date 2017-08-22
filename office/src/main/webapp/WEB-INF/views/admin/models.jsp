
<section class="content-header">
	<h1>模块管理<small>advanced tables</small></h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> 系统设定</a></li>
		<li><a href="#">Tables</a></li>
		<li class="active">模块管理</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Data Table With Full Features</h3>
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
								<c:forEach var="odhModlInfo" items="${odhModlInfoList}">
									<tr>
										<td>${odhModlInfo.modelId }</td>
										<td>${odhModlInfo.parentModelId }</td>
										<td>${odhModlInfo.modelUrl }</td>
										<td>${odhModlInfo.modelName }</td>
										<td>${odhModlInfo.modelInfo }</td>
										<td>${odhModlInfo.layerNo }</td>
										<td>${odhModlInfo.displayOrder }</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>模块ID</th>
									<th>父模块ID</th>
									<th>模块URL</th>
									<th>模块名称</th>
									<th>模块说明</th>
									<th>层数</th>
									<th>显示顺序</th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<script>
$(function () {
    $(document).ready(function(){
    $('#example').DataTable({
	        pageLength: 20,
	        responsive: true,
	        dom: '<"html5buttons"B>lTfgitp',
	        buttons: [
	            {extend: 'copy'},
	            {extend: 'excel', title: 'ExampleFile'},
	            {extend: 'print',
	             customize: function (win){
	                    $(win.document.body).addClass('white-bg');
	                    $(win.document.body).css('font-size', '10px');
	                    $(win.document.body).find('table').addClass('compact').css('font-size', 'inherit');
	            }
	            }
	        ],
			language: {
				sSearch : "搜索:",
				copy : "拷贝:",
				oPaginate : {
		            sFirst : "首页",
		            sPrevious : "上页",
		            sNext : "下页",
		            sLast : "末页"
		        },
		        sInfo: "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
		        sInfoEmpty: "显示第 0 至 0 项结果，共 0 项",
		        sLengthMenu: "显示 _MENU_ 项结果",
		        sInfoFiltered : "(由 _MAX_ 项结果过滤)",
		        sZeroRecords: "没有匹配结果",
		        oAria: {
		            "sSortAscending": ": 以升序排列此列",
		            "sSortDescending": ": 以降序排列此列"
		        },
		        sEmptyTable : "表中数据为空",
		        sLoadingRecords : "载入中...",
			}
    });
    });
  });
</script>