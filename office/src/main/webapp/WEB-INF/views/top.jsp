<%@ include file="./include/head.jsp"%>

<%@ taglib prefix="office" uri="http://www.com.glad.office/tags"%>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">

			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>G</b>LD</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Glad</b>OFFLCE</span>
			</a>

			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 4 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user2-160x160.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a>
										</li>
										<!-- end message -->
										<li><a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user3-128x128.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													AdminLTE Design Team <small><i
														class="fa fa-clock-o"></i> 2 hours</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user4-128x128.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Developers <small><i class="fa fa-clock-o"></i>
														Today</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user3-128x128.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Sales Department <small><i class="fa fa-clock-o"></i>
														Yesterday</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img src="../../dist/img/user4-128x128.jpg"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Reviewers <small><i class="fa fa-clock-o"></i> 2
														days</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 10 notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												5 new members joined today
										</a></li>
										<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
												Very long description here that may not fit into the page
												and may cause design problems
										</a></li>
										<li><a href="#"> <i class="fa fa-users text-red"></i>
												5 new members joined
										</a></li>
										<li><a href="#"> <i
												class="fa fa-shopping-cart text-green"></i> 25 sales made
										</a></li>
										<li><a href="#"> <i class="fa fa-user text-red"></i>
												You changed your username
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
						<!-- Tasks: style can be found in dropdown.less -->
						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i> <span class="label label-danger">9</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 9 tasks</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Design some buttons <small class="pull-right">20%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua"
														style="width: 20%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Create a nice theme <small class="pull-right">40%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-green"
														style="width: 40%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">40% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Some task I need to do <small class="pull-right">60%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-red"
														style="width: 60%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">60% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Make beautiful transitions <small class="pull-right">80%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-yellow"
														style="width: 80%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">80% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all tasks</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../../dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">Alexander
									Pierce</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../../dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">

									<p>
										Alexander Pierce - Web Developer <small>Member since
											Nov. 2012</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>

			</nav>
		</header>

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
								class="fa fa-creative-commons" style="margin-top: 20px;"></i></span>

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
								class="fa fa-google-plus" style="margin-top: 20px;"></i></span>

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
								class="fa fa-creative-commons" style="margin-top: 20px;"></i></span>

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
								class="fa fa-creative-commons" style="margin-top: 20px;"></i></span>

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
