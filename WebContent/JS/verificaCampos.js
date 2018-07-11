function verificarCampos() {
	if ($("#odesf").val() == "") {
		alert('preciso informar um valor para o grau esf�rico de longe do olho direito!');
		return false;
	}
	else if ($("#longeEsfericoOE").val() == "") {
		alert('� preciso informar um valor para o grau esf�rico de longe do olho esquerdo!');
		return false;
	}
}