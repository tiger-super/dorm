$(document).ready(function() {
	 $ ("#fileupload" ).fileinput ({
		 uploadUrl:'/dorm/add',
		// 设置语言
		language:'zh',
		// 最大上传数
        maxFileCount:1, 
        // 文件后缀
        allowedFileExtensions: ["xls", "xlsx"],
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        layoutTemplates:{
        	actionZoom: '',//去除上传预览的缩列图中的预览图标
        }
	 });
	//异步上传返回结果处理
	 $("#fileupload").on("fileuploaded", function (event, data, previewId, index){
		 var response = data.response;
		 alert(response.result);
	 })
})