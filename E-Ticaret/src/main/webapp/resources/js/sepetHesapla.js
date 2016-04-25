$(document).ready(function() {
	var toplam = 0;
	var fiyat = $(".fiyat");
	$.each(fiyat, function(index, value) {
		toplam = toplam + parseInt($(fiyat[index]).html());
	})
	$(".toplamFiyat").html(toplam + " ₺");
});
