<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/login.js"></script>
<style>
.col-center-block {
	position: absolute;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-moz-transform:  translateY(-50%);
	-ms-transform:  translateY(-50%);
	-o-transform:  translateY(-50%);
	transform:  translateY(-50%);
}

.form-group {
	margin-bottom: 10px;
}

.alert {
	height: 35px;
	line-height: 8px
}

</style>
</head>

<body>
	<div
		class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2 container col-center-block">
		<form class="form-signin form-horizontal" id="login">
			<div class="form-group">
				<label>账号</label> <input class="form-control form-id" type="text"
					name="uId"> 
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide name-tips" style="margin: 0px;"></div>
			</div>


			<div class="form-group">
				<label>密码</label> <input class="form-control form-password"
					type="password" name="uPassword">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide password-tips"
					style="margin: 0px;"></div>
			</div>


			<div class="form-group">
				<label class="col-sm-1 control-label"
					style="padding-left: 0px; padding-right: 1%;">类型</label>
				<div class="select col-sm-4">
					<select class="form-control" name="uType">
						<option>学生</option>
						<option>教师</option>
						<option>宿舍管理员</option>
					</select>
				</div>

				<div class="select col-sm-4"></div>
				<div class="checkbox col-sm-3"
					style="padding-right: 0px; padding-left: 9%;">
					<label> <input type="checkbox" value="remember-me">
						记住我
					</label>
				</div>
			</div>

			<div class="form-group ">
				<div class="alert alert-danger alert-dismissable hide dataJudge" role="alert">
					<strong class="text"> </strong>
				</div>
			</div>

			<div class="form-group">
				<button class="btn btn-primary btn-block">登录</button>
			</div>
		</form>
	</div>
</body>

</html>