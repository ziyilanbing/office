<%@ taglib prefix="office" uri="http://www.com.glad.office/tags"%>
<%@ include file="./include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="./include/header.jsp"%>

		<office:office-menu />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Dashboard <small>Version 2.0</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Dashboard</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- Info boxes -->
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box">
							<span class="info-box-icon bg-aqua"> <i
								class="fa fa-creative-commons"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">通知</span> <span
									class="info-box-number">90</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box">
							<span class="info-box-icon bg-red"><i
								class="fa fa-google-plus"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">考勤信息</span> <span
									class="info-box-number">41,410</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->

					<!-- fix for small devices only -->
					<div class="clearfix visible-sm-block"></div>

					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box">
							<span class="info-box-icon bg-green"><i
								class="fa fa-creative-commons"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">审批信息</span> <span
									class="info-box-number">760</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box">
							<span class="info-box-icon bg-yellow"><i
								class="fa fa-creative-commons"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">否决信息</span> <span
									class="info-box-number">2,000</span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-footer">
								<div class="row">
									<div class="col-sm-3 col-xs-6">
										<div class="description-block border-right">
											<span class="description-percentage text-green"><i
												class="fa fa-caret-up"></i> 17%</span>
											<h5 class="description-header">$35,210.43</h5>
											<span class="description-text">通知</span>
										</div>
										<!-- /.description-block -->
									</div>
									<!-- /.col -->
									<div class="col-sm-3 col-xs-6">
										<div class="description-block border-right">
											<span class="description-percentage text-yellow"><i
												class="fa fa-caret-left"></i> 0%</span>
											<h5 class="description-header">$10,390.90</h5>
											<span class="description-text">考勤信息</span>
										</div>
										<!-- /.description-block -->
									</div>
									<!-- /.col -->
									<div class="col-sm-3 col-xs-6">
										<div class="description-block border-right">
											<span class="description-percentage text-green"><i
												class="fa fa-caret-up"></i> 20%</span>
											<h5 class="description-header">$24,813.53</h5>
											<span class="description-text">审批信息</span>
										</div>
										<!-- /.description-block -->
									</div>
									<!-- /.col -->
									<div class="col-sm-3 col-xs-6">
										<div class="description-block">
											<span class="description-percentage text-red"><i
												class="fa fa-caret-down"></i> 18%</span>
											<h5 class="description-header">1200</h5>
											<span class="description-text">否决信息</span>
										</div>
										<!-- /.description-block -->
									</div>
								</div>
								<!-- /.row -->
							</div>
							<!-- /.box-footer -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<div class="col-md-8">

						<!-- TABLE: LATEST ORDERS -->
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Latest Orders</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool"
										data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool"
										data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>Order ID</th>
												<th>Item</th>
												<th>Status</th>
												<th>Popularity</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a href="pages/examples/invoice.html">OR9842</a></td>
												<td>Call of Duty IV</td>
												<td><span class="label label-success">Shipped</span></td>
												<td>
													<div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR1848</a></td>
												<td>Samsung Smart TV</td>
												<td><span class="label label-warning">Pending</span></td>
												<td>
													<div class="sparkbar" data-color="#f39c12" data-height="20">90,80,-90,70,61,-83,68</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR7429</a></td>
												<td>iPhone 6 Plus</td>
												<td><span class="label label-danger">Delivered</span></td>
												<td>
													<div class="sparkbar" data-color="#f56954" data-height="20">90,-80,90,70,-61,83,63</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR7429</a></td>
												<td>Samsung Smart TV</td>
												<td><span class="label label-info">Processing</span></td>
												<td>
													<div class="sparkbar" data-color="#00c0ef" data-height="20">90,80,-90,70,-61,83,63</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR1848</a></td>
												<td>Samsung Smart TV</td>
												<td><span class="label label-warning">Pending</span></td>
												<td>
													<div class="sparkbar" data-color="#f39c12" data-height="20">90,80,-90,70,61,-83,68</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR7429</a></td>
												<td>iPhone 6 Plus</td>
												<td><span class="label label-danger">Delivered</span></td>
												<td>
													<div class="sparkbar" data-color="#f56954" data-height="20">90,-80,90,70,-61,83,63</div>
												</td>
											</tr>
											<tr>
												<td><a href="pages/examples/invoice.html">OR9842</a></td>
												<td>Call of Duty IV</td>
												<td><span class="label label-success">Shipped</span></td>
												<td>
													<div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->
							</div>
							<!-- /.box-body -->
							<div class="box-footer clearfix">
								<a href="javascript:void(0)"
									class="btn btn-sm btn-info btn-flat pull-left">Place New
									Order</a> <a href="javascript:void(0)"
									class="btn btn-sm btn-default btn-flat pull-right">View All
									Orders</a>
							</div>
							<!-- /.box-footer -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->

					<div class="col-md-4">
						<!-- Info Boxes Style 2 -->
						<div class="info-box bg-yellow">
							<span class="info-box-icon"><i
								class="ion ion-ios-pricetag-outline"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Inventory</span> <span
									class="info-box-number">5,200</span>

								<div class="progress">
									<div class="progress-bar" style="width: 50%"></div>
								</div>
								<span class="progress-description"> 50% Increase in 30
									Days </span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
						<div class="info-box bg-green">
							<span class="info-box-icon"><i
								class="ion ion-ios-heart-outline"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Mentions</span> <span
									class="info-box-number">92,050</span>

								<div class="progress">
									<div class="progress-bar" style="width: 20%"></div>
								</div>
								<span class="progress-description"> 20% Increase in 30
									Days </span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
						<div class="info-box bg-red">
							<span class="info-box-icon"><i
								class="ion ion-ios-cloud-download-outline"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Downloads</span> <span
									class="info-box-number">114,381</span>

								<div class="progress">
									<div class="progress-bar" style="width: 70%"></div>
								</div>
								<span class="progress-description"> 70% Increase in 30
									Days </span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
						<div class="info-box bg-aqua">
							<span class="info-box-icon"><i
								class="ion-ios-chatbubble-outline"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Direct Messages</span> <span
									class="info-box-number">163,921</span>

								<div class="progress">
									<div class="progress-bar" style="width: 40%"></div>
								</div>
								<span class="progress-description"> 40% Increase in 30
									Days </span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.12
			</div>
			<strong>Copyright &copy; 2014-2016 <a
				href="http://almsaeedstudio.com">Almsaeed Studio</a>.
			</strong> All rights reserved.
		</footer>
		<div class="control-sidebar-bg"></div>

	</div>
	<!-- ./wrapper -->

</body>

</html>
