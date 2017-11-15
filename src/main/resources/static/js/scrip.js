window.onload = botaoMenu;
function botaoMenu() {
	var parametro = document.getElementById("botao-menu").getAttribute("data-botao");
	var botao = document.getElementById(parametro);
	botao.className += "current";
	$("#data-nascimento").mask("00/00/0000");
	$("#cpf").mask("999.999.999-99");
	$("#telefone").mask("(99) 9 9999-9999");
}




