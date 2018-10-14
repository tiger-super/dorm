<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap.min.css">

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
</style>
</head>

<body>
	<div
		class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2 container col-center-block">
		<form class="form-signin form-horizontal">
			<div class="form-group">
				<label>用户名</label> <input class="form-control" type="text"
					name="uname">
			</div>
			<div class="form-group">
				<label>密码</label> <input class="form-control" type="password"
					name="upwd">
			</div>

			<div class="form-group">
				<label class="col-sm-1 control-label" style="padding-left: 0px;padding-right:1% ;">类型</label>
				<div class="select col-sm-4">
					<select class="form-control">
						<option>学生</option>
						<option>教师</option>
						<option>宿舍管理员</option>
					</select> 
				</div>
				
				<div class="select col-sm-4"></div>
				<div class="checkbox col-sm-3" style="padding-right: 0px;padding-left: 10%;">
					<label> <input type="checkbox" value="remember-me">
						记住我
					</label>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">登录</button>
			</div>
		</form>
	</div>

</body>

</html>