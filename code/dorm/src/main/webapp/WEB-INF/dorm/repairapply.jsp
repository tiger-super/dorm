<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/repaircommit.js"></script>
<style>
.form-group div {
	padding: 0px;
}

.col-center-block {
	position: absolute;
	top: 35%;
	-webkit-transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	-o-transform: translateY(-50%);
	transform: translateY(-50%);
}

.form-group {
	margin-bottom: 10px;
}
</style>
</head>

<body>
	<div
		class="col-lg-8 col-lg-offset-2 col-sm-9 col-sm-offset-1 col-xs-8 col-xs-offset-2 container col-center-block">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">申请人：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="repairApplyName"
						placeholder="请输入名称">
				</div>
				<label for="firstname" class="col-sm-2 control-label">电话：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="phone"
						placeholder="请留下您的电话">
				</div>
			</div>


			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">宿舍地区：</label>
				<div class="col-sm-3">
					<select class="form-control">
						<option>请选择宿舍地区</option>
					</select>
				</div>

				<label for="firstname" class="col-sm-2 control-label">宿舍房间号：</label>
				<div class="col-sm-3">
					<select class="form-control">
						<option>请选择宿舍房间号</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">维修设备名称：</label>
				<div class="col-sm-3">
					<select class="form-control">
						<option>请选择维修设备名称</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">维修原因：</label>
				<div class="col-sm-8">
					<textarea class="form-control" rows="4" name=textarea
						placeholder="请填写维修的原因"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10" style="padding: 0px;"></div>
				<button type="submit" class="btn btn-success  ">提交</button>
			</div>

		</form>
	</div>

</body>

</html>