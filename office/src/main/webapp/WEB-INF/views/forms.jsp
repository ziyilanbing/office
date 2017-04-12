<%@ include file="./include/head.jsp"%>

<body>

	<div id="wrapper">
		<%@ include file="./include/header.jsp"%>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Forms</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Basic Form Elements</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<form:form modelAttribute="formsModel"
										action="REPLACE_BY_SCRIPT" id="form" method="POST">
										<div class="form-group">
											<label>Text Input</label>
											<form:input cssClass="form-control"
												cssErrorClass="form-control has-errors" path="textInput"
												id="textInput" />
											<p class="help-block">Example block-level help text here.</p>
										</div>
										<label>${value}</label>
										<div class="form-group">
											<label>Text Input with Placeholder</label>
											<form:input class="form-control"
												path="textInputwithPlaceholder" placeholder="Enter text" />
										</div>
										<div class="form-group">
											<label>Static Control</label>
											<p class="form-control-static">email@example.com</p>
										</div>
										<div class="form-group">
											<label>File input</label> <input type="file">
										</div>
										<div class="form-group">
											<label>Text area</label>
											<form:textarea path="textarea" class="form-control" rows="3" />
										</div>
										<div class="form-group">
											<label>Checkboxes</label>
											<div class="checkbox">
												<label> <form:checkbox path="checkbox1" value="1" />Checkbox1
													1
												</label>
											</div>
											<div class="checkbox">
												<label> <form:checkbox path="checkbox2" value="2" />Checkbox2
													2
												</label>
											</div>
											<div class="checkbox">
												<label> <form:checkbox path="checkbox3" value="3" />Checkbox3
													3
												</label>
											</div>
										</div>
										<div class="form-group">
											<label>Inline Checkboxes</label> <label
												class="checkbox-inline"> <form:checkbox
													path="checkboxes" value="1" />1
											</label> <label class="checkbox-inline"> <form:checkbox
													path="checkboxes" value="2" />2
											</label> <label class="checkbox-inline"> <form:checkbox
													path="checkboxes" value="3" />3
											</label>
										</div>
										<div class="form-group">
											<label>Radio Buttons</label>
											<div class="radio">
												<label> <form:radiobutton path="radioButtons"
														id="optionsRadios1" value="1" />Radio 1
												</label>
											</div>
											<div class="radio">
												<label> <form:radiobutton path="radioButtons"
														id="optionsRadios2" value="2" />Radio 2
												</label>
											</div>
											<div class="radio">
												<label> <form:radiobutton path="radioButtons"
														id="optionsRadios3" value="3" />Radio 3
												</label>
											</div>
										</div>
										<div class="form-group">
											<label>Inline Radio Buttons</label> <label
												class="radio-inline"> <input type="radio"
												name="optionsRadiosInline" id="optionsRadiosInline1"
												value="option1" checked>1
											</label> <label class="radio-inline"> <input type="radio"
												name="optionsRadiosInline" id="optionsRadiosInline2"
												value="option2">2
											</label> <label class="radio-inline"> <input type="radio"
												name="optionsRadiosInline" id="optionsRadiosInline3"
												value="option3">3
											</label>
										</div>
										<div class="form-group">
											<label>Selects</label>
											<form:select path="selects" class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</form:select>
										</div>
										<div class="form-group">
											<label>Multiple Selects</label>
											<form:select path="multipleSelects" multiple="multiple"
												class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
											</form:select>
										</div>
										<button type="submit" class="btn btn-default"
											formaction="input">Submit Button</button>
										<button type="reset" class="btn btn-default">Reset
											Button</button>
									</form:form>
								</div>
								<!-- /.col-lg-6 (nested) -->
							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>
</html>
