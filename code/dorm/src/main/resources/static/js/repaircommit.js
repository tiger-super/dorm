$(document)
		.ready(
				function() {
					$.ajax({
						url : '/dorm/device/querys/dormAddress',
						type : 'get',
						success : function(result) {
							for (let i = 0; i < result.length; i++) {
								$("#dormAddress").append(
										"<option>"
												+ result[i] + "</option>");
							}
						}

					})
					$("#dormAddress")
							.click(
									function() {
										if ($("#dormAddress").find(
												"option:selected").text() != '请选择宿舍地区') {
											$("#dormAddress").parent().removeClass("has-error");
											$("#dormAddress option[value='0']")
													.remove();
											$("#dormNo").empty();
											$("#dormNo")
													.append(
															"<option value=0>请选择宿舍房间号</option>");
											$("#repairInstrument").empty();
											$("#repairInstrument")
													.append(
															"<option value=0>请选择维修设备名称</option>");
											$
													.ajax({
														url : '/dorm/device/querys/dormNo',
														type : 'get',
														data : {
															"dormAddress" : $(
																	"#dormAddress")
																	.find(
																			"option:selected")
																	.text()
														},
														dataType : 'json',
														success : function(
																result) {
															for (let i = 0; i < result.length; i++) {
																$("#dormNo")
																		.append(
																				"<option>"
																						+ result[i]
																						+ "</option>");
															}
														}
													})
										} else {
											$("#dormNo").empty();
											$("#dormNo")
													.append(
															"<option value=0>请选择宿舍房间号</option>");
											$("#repairInstrument").empty();
											$("#repairInstrument")
													.append(
															"<option value=0>请选择维修设备名称</option>");
										}
									})
					$("#dormNo")
							.click(
									function() {
										if ($("#dormNo")
												.find("option:selected").text() != '请选择宿舍房间号') {
											$("#dormNo").parent().removeClass("has-error");
											$("#dormNo option[value='0']")
													.remove();
											$("#repairInstrument").empty();
											$("#repairInstrument")
													.append(
															"<option value=0>请选择维修设备名称</option>");
											$
													.ajax({
														url : '/dorm/device/query/devices',
														type : 'get',
														data : {
															"dormAddress" : $(
																	"#dormAddress")
																	.find(
																			"option:selected")
																	.text(),
															"dormNo" : $(
																	"#dormNo")
																	.find(
																			"option:selected")
																	.text()
														},
														dataType : 'json',
														success: function(
																result) {
															for (let i = 0; i < result.length; i++) {

																$(
																		"#repairInstrument")
																		.append(
																				"<option>"
																						+ result[i]
																						+ "</option>");
															}
														}
													})
										} else {
											$("#repairInstrument").empty();
											$("#repairInstrument")
													.append(
															"<option value=0>请选择维修设备名称</option>");
										}
									})
					$("#repairInstrument")
							.click(
									function() {
										if ($("#repairInstrument").find(
												"option:selected").text() != '请选择维修设备名称') {
											$("#repairInstrument").parent().removeClass("has-error");
											$(
													"#repairInstrument option[value='0']")
													.remove();
										}

									})
					$('#repairReason').keyup(function(event) {
						var maxLength = 150;
						var len = $('textarea').val().length;
						$("#repairReason").parent().removeClass("has-error");
						if (len <= maxLength) {
							$("#textareaCount").text(len)
						}

					})
					$("#repair-apply").submit(function() {
						console.log("提交")
						if(judgeInfoComplete() == true){
							console.log("X")
						$
						.ajax({
							url : '/dorm/repair/accept',
							type : 'get',
							data :$("#repair-apply").serialize() ,
							success: function(result) {
								if(result == "true" ){
									alert("申请成功");
									window.location.reload();
								}else{
									alert("申请失败");
								
								}
								
							}
						})}  
						return false;
					}
					)
					
					
					
					$("#repairApplyName").blur(function(){
						if($("#repairApplyName").val() != ''){
							$("#repairApplyName").parent().removeClass("has-error");
						}
					})
					$("#repairApplyPhone").blur(function(){
						if($("#repairApplyPhone").val() != ''){
							$("#repairApplyPhone").parent().removeClass("has-error");
						}
					})
				})
				
function judgeInfoComplete(){
	var result = true;
	if($("#repairApplyName").val() == ''){
		result = false;
		$("#repairApplyName").parent().addClass("has-error");
	}
	if($("#repairApplyPhone").val() == ''){
		result = false;
		$("#repairApplyPhone").parent().addClass("has-error");
	}
	if($("#dormAddress").find("option:selected").text() == '请选择宿舍地区'){
		result = false;
		$("#dormAddress").parent().addClass("has-error");
	}
	if($("#dormNo").find("option:selected").text() == '请选择宿舍房间号'){
		result = false;
		$("#dormNo").parent().addClass("has-error");
	}
	if($("#repairInstrument").find("option:selected").text() == '请选择维修设备名称'){
		result = false;
		$("#repairInstrument").parent().addClass("has-error");
	}
	if($("#repairReason").val() == ''){
		result = false;
		$("#repairReason").parent().addClass("has-error");
	}
	return result;
}
