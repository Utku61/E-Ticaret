$(document).ready(function() {
	$(".bolum-select").selectpicker();
	$(".fakulte-select").selectpicker();
	$(".yerlesimTuru").selectpicker();
	var adres = window.location.pathname;
	var controllerAdres = "";
	if(adres == "/eticaret/admin/" || adres == "/eticaret/admin/index"){
		controllerAdres = "getAjaxSiparisSayisi";
	}else{
		controllerAdres = "../getAjaxSiparisSayisi";
	}
	
	window.setInterval(function() {
		$.ajax({
			url : controllerAdres,
			type : "get",
			success : function(msg){
				$("#siparisNo").html(" (" + msg + ")")
			}
		});
	}, 3000);
});
