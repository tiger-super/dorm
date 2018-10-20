<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>

<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>

<style>
#accordion {
	padding: 0px;
}

#accordion div {
	margin: 0px;
	border-radius: 0px;
}

.panel-body {
	padding: 0px;
	border: none;
}

.panel-body .life {
	margin: 0px;
	padding: 0px;
	border: none;
}

.panel-body .life li {
	border-left: none;
	border-right: none;
	border-top: 1px dashed #DDDDDD;
	border-bottom: none;
}
</style>

<body>

	<div class="navbar navbar-default " style="margin: 0px;">
		<div class="container">

			<div class="navbar-header">
				<a href="#" class="navbar-brand">宿舍管理平台</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">欢迎你！<span class="glyphicon glyphicon-user"></span>${sessionScope.userSession.uName}
				</a></li>
				<li><a href="/dorm/login/show">退出</a></li>
			</ul>
		</div>
	</div>

	<div class="panel-group col-sm-2" id="accordion">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> 宿舍管理 </a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body" style="border: none;">
					<ul class="life ">
                        <c:if test="${user.uType eq  '教师' } ">
						<li class="list-group-item "><a>宿舍信息添加</a></li>
						<li class="list-group-item "><a>宿舍信息删除</a></li>
						<li class="list-group-item "><a>宿舍信息修改</a></li>
						<li class="list-group-item "><a>宿舍信息查询</a></li>
						<li class="list-group-item "><a>学生入住信息添加</a></li>
						<li class="list-group-item "><a>学生入住信息删除</a></li>
						<li class="list-group-item "><a>学生入住信息修改</a></li>
						</c:if>
						  <c:if test="${user.uType eq  '学生'  }">
						<li class="list-group-item "><a href="javascript:void(0);" id="stu-dorm-info">学生入住信息查询</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>

       <c:if test="${user.uType eq  '学生'  }">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree"> 生活管理 </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse">
				<div class="panel-body" style="border: none;">
					<ul class="life ">
						<li class="list-group-item "><a>水费缴费</a></li>
						<li class="list-group-item "><a>电费缴费</a></li>
						<li class="list-group-item "><a>网络续费</a></li>
					</ul>
				</div>
			</div>
		</div>
      </c:if>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFour"> 维修管理 </a>
				</h4>
			</div>
			<div id="collapseFour" class="panel-collapse collapse">
				<div class="panel-body" style="border: none;">
					<ul class="life ">
					 <c:if test="${user.uType eq '学生' }">
						<li class="list-group-item "><a href="javascript:void(0);" id="repair-apply"> 维修申请</a></li>
						</c:if>
						 <c:if test="${user.uType eq '宿舍管理员' }">
						<li class="list-group-item "><a>维修单查询</a></li>
						<li class="list-group-item "><a>维修处理</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>



         <c:if test="${user.uType eq '教师'} ">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFive"> 管理员管理 </a>
				</h4>
			</div>
			<div id="collapseFive" class="panel-collapse collapse">
				<div class="panel-body" style="border: none;">
					<ul class="life ">
						<li class="list-group-item "><a>添加管理员</a></li>
						<li class="list-group-item "><a>删除管理员</a></li>
						<li class="list-group-item "><a>修改管理员</a></li>
						<li class="list-group-item "><a>查询管理员</a></li>
					</ul>
				</div>
			</div>
		</div>
		</c:if>
	</div>
    <div class="col-sm-10">
	<iframe class="col-sm-12 load-info" 
	style="border: none;padding: 0px;margin: 0px;height: 500px; " src="/dorm/dormInfo/show"> </iframe>
	
	</div>

</body>

</html>