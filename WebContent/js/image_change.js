//indexのmain-visual本来の画像サイズを基に、画像サイズを変更
function resizeImagePercent( resizeRate ) {
	   var resizeImg = document.getElementById("index_main_visual");
	   resizeImg.width = resizeImg.naturalWidth * resizeRate;
	   resizeImg.height = resizeImg.naturalHeight * resizeRate;
	}