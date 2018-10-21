<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/basic.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/querystudentfromstuid.js"></script>

<body>

	<div class="col-sm-12" style="margin-top: 20px;">
		<div class="col-sm-5 row">
			<form class="form-inline" role="form">
				<div class="form-group">
					<label class="form-label">请输入你的学号：</label> <input type="text"
						class="form-control stu-id"
						onkeyup="value=value.replace(/[^\d]/g,'')">
				</div>
			</form>

		</div>
		<div class="col-sm-3">
			<button type="button" class="btn btn-info queryStuId">查询</button>
		</div>

	</div>
	<div class="col-sm-12">
		<!--立体分隔线-->
		<hr style="filter: progid:dximagetransform.microsoft.glow(color="
			#987cb9",strength=10) " width="97%" color="#987cb9" size=1>
	</div>
	<div class="col-sm-12">


		<table class="table table-bordered stu-Use-Drom-Info"
			style="margin-bottom: 0px;">
			<caption>学生入住信息</caption>
			<thead>
				<tr>
					<th>地区</th>
					<th>房间号</th>
					<th>学生学号</th>
					<th>学生姓名</th>
					<th>学生性别</th>
					<th>床位</th>
				</tr>
			</thead>
			<tbody id="student-drom-info" >
				<tr>
					<th id="address"></th>
					<th id="number"></th>
					<th id="id"></th>
					<th id="name"></th>
					<th id="sex"></th>
					<th id="bedno"></th>
				<tr>
			</tbody>
		</table>

	</div>
</body>
</html>
