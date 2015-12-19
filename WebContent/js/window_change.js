//ウィンドウサイズを取得する
function getWindowSize() {
	var sW,sH;
	sW = window.innerWidth;
	sH = window.innerHeight;

	var a =document.getElementById('WinSize');

	a.style.width = sW;
	a.style.hight = sH;
}