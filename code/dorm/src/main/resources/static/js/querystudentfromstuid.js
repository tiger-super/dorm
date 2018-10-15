$(document).ready(function() {
$(".queryStuId").click(function(){
		$.ajax({
			url:'/dorm/dormInfo/query/sutId',
			type:'get',
			data:{'stuId':$(".stu-id").val()},
			dataType:'json',
			success:function(result){
				$("#address").text(result.dormAddress);
				$("#number").text(result.dormNo);
				$("#id").text(result.dormInfos[0].student.stuId);
				$("#name").text(result.dormInfos[0].student.stuName);
				$("#sex").text(result.dormInfos[0].student.stuSex);
				$("#bedno").text(result.dormInfos[0].bedNo);
			}
		})
	})
})