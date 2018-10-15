$(document).ready(function() {
	$.ajax({
		url:'/dorm/device/querys/dormAddress',
		type:'get',
		success:function(result){
			for(let i = 0 ; i < result.length; i++){
				$("#dormAddress").append("<option  value="+(i+1)+">"+result[i]+"</option>");
			}
		}
		
	})
	$("#dormAddress").click(function(){
		if($("#dormAddress").find("option:selected").text() != '请选择宿舍地区'){
			$("#dormAddress option[value='0']").remove();
			$("#dormNo").empty();
			$("#dormNo").append("<option value=0>请选择宿舍房间号</option>");
			$.ajax({
				url:'/dorm/device/querys/dormNo', 	
				type:'get',
				data:{"dormAddress":$("#dormAddress").find("option:selected").text()},
				dataType:'json',
				success:function(result){
					for(let i = 0 ; i < result.length; i++){
						$("#dormNo").append("<option>"+result[i]+"</option>");
					}
				}
				})
		}else{
			$("#dormNo").empty();
			$("#dormNo").append("<option value=0>请选择宿舍房间号</option>");
			$("#repairInstrument").empty();
			$("#repairInstrument").append("<option value=0>请选择维修设备名称</option>");
		}
	})
	$("#dormNo").click(function(){
		if($("#dormNo").find("option:selected").text() != '请选择宿舍房间号'){
			$("#dormNo option[value='0']").remove();
			$("#repairInstrument").empty();
			$("#repairInstrument").append("<option value=0>请选择维修设备名称</option>");
			$.ajax({
				url:'/dorm/device/query/devices', 	
				type:'get',
				data:{"dormAddress":$("#dormAddress").find("option:selected").text(),"dormNo":$("#dormNo").find("option:selected").text()},
				dataType:'json',
				success:function(result){
					for(let i = 0 ; i < result.length; i++){
						
						$("#repairInstrument").append("<option>"+result[i]+"</option>");
					}
				}
			})
		}else{
			$("#repairInstrument").empty();
			$("#repairInstrument").append("<option value=0>请选择维修设备名称</option>");
		}
	})
	
	
	$("#repair-commit").click(function(){
		
	})
})
