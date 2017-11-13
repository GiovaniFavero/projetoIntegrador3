window.onload = botaoMenu;
function botaoMenu() {
	var parametro = document.getElementById("botao-menu").getAttribute("data-botao");
	var botao = document.getElementById(parametro);
	botao.className += "current";
}
        