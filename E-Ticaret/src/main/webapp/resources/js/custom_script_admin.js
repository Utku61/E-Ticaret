$(document).ready(function(){
	
	$("#deleteKategoriModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteKategori').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteKargoModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteKargo').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteMarkaModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteMarka').attr('href',$(e.relatedTarget).data('href'));
	});

	$("#deleteOdemeModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteOdeme').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteSehirModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteSehir').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteSDurumModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteSDurum').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteMusteriModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteMusteri').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteUrunModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteUrun').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteYetkiModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteYetki').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$("#deleteSiparisModal").on('show.bs.modal',function(e){
		$(this).find('#btnDeleteSiparis').attr('href',$(e.relatedTarget).data('href'));
	});
	
	$('.table-sort').click(function (e) {
	    e.preventDefault();

	    var footableSort = $('table').data('footable-sort');
	    var index = $(this).data('index');
	    var ascending = $(this).data('ascending');
	    footableSort.doSort(index, ascending);
	});
  

	$("#EditKargoModal").on('show.bs.modal',function(e){
		$(this).find('#kargoID').val($(e.relatedTarget).data('kargo-no'));
		$(this).find('#ad').val($(e.relatedTarget).data('kargo-ad'));
		$(this).find('#aciklama').val($(e.relatedTarget).data('kargo-aciklama'));
	});
	
	$("#EditAltKategoriModal").on('show.bs.modal',function(e){
		$(this).find('#altKategoriID').val($(e.relatedTarget).data('altkategori-no'));
		$(this).find('#altKategoriAdi').val($(e.relatedTarget).data('altkategori-ad'));
	});
	
	$("#EditKategoriModal").on('show.bs.modal',function(e){
		$(this).find('#kategoriID').val($(e.relatedTarget).data('kategori-no'));
		$(this).find('#kategoriAdi').val($(e.relatedTarget).data('kategori-ad'));
	});
	
	$("#EditUstKategoriModal").on('show.bs.modal',function(e){
		$(this).find('#ustKategoriID').val($(e.relatedTarget).data('ustkategori-no'));
		$(this).find('#ustKategoriAdi').val($(e.relatedTarget).data('ustkategori-ad'));
	});
	
	$("#EditOdemeModal").on('show.bs.modal',function(e){
		$(this).find('#odemeSecenekID').val($(e.relatedTarget).data('odeme-no'));
		$(this).find('#odemeTipi').val($(e.relatedTarget).data('odeme-ad'));
	});
	
	$("#EditSehirModal").on('show.bs.modal',function(e){
		$(this).find('#sehirID').val($(e.relatedTarget).data('sehir-no'));
		$(this).find('#sehirAdi').val($(e.relatedTarget).data('sehir-ad'));
	});
	
	$("#EditSDurumModal").on('show.bs.modal',function(e){
		$(this).find('#siparisDurumID').val($(e.relatedTarget).data('sdurum-no'));
		$(this).find('#durum').val($(e.relatedTarget).data('sdurum-ad'));
	});
	
	$("#EditUrunModal").on('show.bs.modal',function(e){
		$(this).find('#urunID').val($(e.relatedTarget).data('urun-no'));
		$(this).find('#urunAdi').val($(e.relatedTarget).data('urun-ad'));
		$(this).find('#aciklama').val($(e.relatedTarget).data('urun-aciklama'));
		$(this).find('#fiyat').val($(e.relatedTarget).data('urun-fiyat'));
		$(this).find('#stokMiktar').val($(e.relatedTarget).data('urun-stok'));
	});
	
	$("#EditYetkiModal").on('show.bs.modal',function(e){
		$(this).find('#yetkiNo').val($(e.relatedTarget).data('yetki-no'));
		$(this).find('#yetkiAdi').val($(e.relatedTarget).data('yetki-ad'));
	});
	
	$("#EditSiparisModal").on('show.bs.modal',function(e){
		$(this).find('#siparisID').val($(e.relatedTarget).data('siparis-no'));
		$(this).find('#musteriID').val($(e.relatedTarget).data('siparis-musteri'));
		$(this).find('#siparisTeslimTarihi').val($(e.relatedTarget).data('siparis-teslimtarihi'));
	});
	
	$("#sepeteEkle").on('show.bs.modal',function(e){
		$(this).find('#urunID').val($(e.relatedTarget).data('urun-no'));
	});
	
//	$("UrunDetayModal").on('show.bs.modal', function(e) {
//		$(this).find('#resim').attr('src',$(e.relatedTarget).data('src'));
//		$('img').attr("src",$(e.relatedTarget).data('src'));
//	});
	

	

	
});