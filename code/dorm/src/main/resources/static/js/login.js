$(document).ready(function() {
	 $("#login").submit(function() {
		$.ajax({
				url:'/dorm/login/LoginVerification',
				type:"get",
				  data:$("#login").serialize(),
		success: function(result) {
			if (result == "true") {
				  window.location.href = "/dorm/login/success/jump"
			} else {
				$(".alert").removeClass("hide");
				$(".text").text(result);
			}

		}}
		);
      return false;
	})
})
