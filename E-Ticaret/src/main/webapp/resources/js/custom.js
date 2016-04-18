$(document).ready(function() {
	$(".bolum-select").selectpicker();
	$(".fakulte-select").selectpicker();
	$(".yerlesimTuru").selectpicker();
	

	window.setInterval(function() {
		if($("#tcStatus").val() == "HATA"){
			$("#kayit").attr("disabled", true);
		}else{
			if($("#emailStatus").val() == "HATA"){
				$("#kayit").attr("disabled", true);
			}else{
				$("#kayit").attr("disabled", false);
			}
		}
		
		if ($("#YatayGecisAyiraci option:selected").val() == "1" && ($("#YGSPuani").val() <= $("#tabanPuan").val() && $("#yerlesmePuani").val() <= $("#tabanPuan").val())) {
			$("#kayit").attr("disabled", true);
			$("#yerlesmePuanUyarisi").css("color","red");
			$("#yerlesmePuanUyarisi").css("display","initial");
		}else{
			$("#yerlesmePuanUyarisi").css("display","none");
		}
		if($("#YatayGecisAyiraci option:selected").val() != "1"){
			if($("#yuzlukNot").val() != "" && $("#yuzlukNot").val() < "60" && $("#yuzlukNot").val() != "00.00"){
				$("#kayit").attr("disabled", true);
				$("#dusukPuanUyarisi").css("color","red");
				$("#dusukPuanUyarisi").css("display","initial");
			}
			if($("#Gano").val() != ""  &&  $("#Gano").val() < "2" && $("#Gano").val() != "0.00"){
				if($("#yuzlukNot").val() != "" && $("#yuzlukNot").val() < "60" && $("#yuzlukNot").val() != "00.00"){
					$("#kayit").attr("disabled", true);
					$("#dusukPuanUyarisi").css("color","red");
					$("#dusukPuanUyarisi").css("display","initial");
				}else{
					$("#kayit").attr("disabled", false);
					$("#dusukPuanUyarisi").css("display","none");
				}
			} else{
				$("#kayit").attr("disabled", false);
				$("#dusukPuanUyarisi").css("display","none");
			}
		}
	}, 500);
	
	$('#fakulte').on("change",function(){
		var fakulteNo = $(this).val(); 
		$.ajax({
			url : "bolumler",
			type: "post",
			dataType : "json",
			data : {"fakulteNo" : fakulteNo},
			success : function(data){
				$('#bolum-select option').remove();
				$('.bolum-select').selectpicker('refresh');
				$.each(data.bolum,function(i,item){
					$('#bolum-select').append($('<option>', {value:item.bolumID, text:item.bolumAd}));
				});
				$('.bolum-select').prop('disabled',false);
				$('.bolum-select').selectpicker('refresh');
			}
		});
	});
	
	$('#fakulteID').on("change",function(){
		var fakulteNo = $(this).val();
		$.ajax({
			url : "../yonetim/bolumler",
			type: "post",
			dataType : "json",
			data : {"fakulteNo" : fakulteNo},
			success : function(data){
				$('#bolumID option').remove();
				$('.bolum-select').selectpicker('refresh');
				$.each(data.bolum,function(i,item){
					$('#bolumID').append($('<option>', {value:item.bolumID, text:item.bolumAd}));
					$("#basvurduguBolumProgrami").val(item.fakulteID.fakulteAd);
					$("#basvurduguBolumProgrami").attr("disabled",true);
				});
				$('.bolum-select').prop('disabled',false);
				$('.bolum-select').selectpicker('refresh');
			}
		});
	});
	
	$('#YGSPuani').change(function (){
		var bolum = $("#bolumID").val();
		var fakulte = $("#fakulteID").val();
		var sinif = $("#basvurduguSinifi option:selected").val();
		$("#tabanPuan").attr("disabled",false);
		$("#kontenjanBilgisi").attr("disabled",false);
		$.ajax({
			url : "otoekran",
			type : "post",
			data : {"bolum" : bolum, "fakulte" : fakulte, "sinif" : sinif},
			success : function(data){
				$.each(data.sonuc,function(i,item){
					$("#tabanPuan").val(item.tabanPuan)
					$("#kontenjanBilgisi").val(item.sinif);
					$("#tabanPuan").attr("disabled",true);
					$("#kontenjanBilgisi").attr("disabled",true);
				});
			}
		});
	});
	
	$('#yerlesmePuani').change(function (){
		var bolum = $("#bolumID").val();
		var fakulte = $("#fakulteID").val();
		var sinif = $("#basvurduguSinifi option:selected").val();
		$("#tabanPuan").attr("disabled",false);
		$("#kontenjanBilgisi").attr("disabled",false);
		$.ajax({
			url : "otoekran",
			type : "post",
			data : {"bolum" : bolum, "fakulte" : fakulte, "sinif" : sinif},
			success : function(data){
				$.each(data.sonuc,function(i,item){
					$("#tabanPuan").val(item.tabanPuan)
					$("#kontenjanBilgisi").val(item.sinif);
					$("#tabanPuan").attr("disabled",true);
					$("#kontenjanBilgisi").attr("disabled",true);
				});
			}
		});
	});
	
	$('#tcKimlikNo').change(function (){
		var tcNo = $("#tcKimlikNo").val();
		$("#tcNoStatus").html("<img src='../image/loading.gif'><font color=gray> kontrol ediliyor...</font>");
	    setTimeout(function() {
			$.ajax({
				url : "tckimlikkontrol",
				type : "post",
				data : {"tcKimlikNo" : tcNo},
				success : function(msg){
					if(msg == 1){
						$("#tcNoStatus").html("<font color=green><b></b>Uygundur</font>");
						$("#tcStatus").val("");
						$("#kayit").removeAttr("disabled");
					}else{
						$("#tcNoStatus").html("<font color=red><b></b>Bu Kimlik Numarası zaten sistemde var!</font>");
						$("#tcStatus").val("HATA");
						$("#kayit").attr("disabled",true);
					}
				}
			});
	    }, 1500);
	});
	
	$('#ePosta').change(function (){
		var ePosta = $("#ePosta").val();
		$("#emailCheckStatus").html("<img src='../image/loading.gif'><font color=gray> kontrol ediliyor...</font>");
	    setTimeout(function() {
			$.ajax({
				url : "emailkontrol",
				type : "post",
				data : {"ePostaAdresi" : ePosta},
				success : function(msg){
					if(msg == 1){
						$("#emailCheckStatus").html("<font color=green><b></b>E-Posta adresi kullanılabilir.</font>");
						$("#emailStatus").val("");
						$("#kayit").removeAttr("disabled");
					}else{
						$("#emailCheckStatus").html("<font color=red><b></b>Bu E-Posta adresi ile zaten kayıt var.</font>");
						$("#emailStatus").val("HATA");
						$("#kayit").attr("disabled",true);
					}
				}
			});
	    }, 1500);
	});
});
