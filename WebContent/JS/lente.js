function calcularCurvaCorrigida(esferico, cilindrico) {
	var esf = parseFloat(esferico);
	var cil = parseFloat(cilindrico);
	var mais = (esf + cil);
	var resultDiv = mais / 2;
	var result = resultDiv + 6;
	return result;
}

function verificarCamposObrigatorios3D() {
	if ($("#longeEsfericoOD").val() == "") {
		alert('preciso informar um valor para o grau esf�rico de longe do olho direito!');
		return false;
	}
	else if ($("#longeEsfericoOE").val() == "") {
		alert('� preciso informar um valor para o grau esf�rico de longe do olho esquerdo!');
		return false;
	}
	
	else if ( $("#longeCilindricoOD").val() != "" && $("#longeCilindricoOD").val() != 0 && 
			($("#longeEixoOD").val() == "" || $("#longeEixoOD").val() == 0) ) {
		alert('� preciso informar um eixo para para o grau de longe \ndo olho direito entre 1 e 180 quando existe grau cil�ndrico!');
		return false;
	}
	else if ( $("#longeCilindricoOE").val() != "" && $("#longeCilindricoOE").val() != 0 && 
			($("#longeEixoOE").val() == "" || $("#longeEixoOE").val() == 0) ) {
		alert('� preciso informar um eixo para para o grau de longe \ndo olho esquerdo entre 1 e 180 quando existe grau cil�ndrico!');
		return false;
	}
	
	else if ($("#dnpOD").val() == "") {
		alert('� preciso informar um valor para DNP (Dist�ncia Naso Pupilar) do olho direito!');
		return false;
	} 
	else if ($("#dnpOE").val() == "") {
		alert('� preciso informar um valor para DNP (Dist�ncia Naso Pupilar) do olho esquerdo!');
		return false;
	} 

	else if ($("#alturaOD").val() == "") {
		alert('� preciso informar um valor para Altura do olho direito!');
		return false;
	} 
	else if ($("#alturaOE").val() == "") {
		alert('� preciso informar um valor para Altura do olho esquerdo!');
		return false;
	} 

	else if ($("#dpa").val() == "") {
		alert('Informe um valor para DPA (Dist�ia Ponte Aro)!');
		return false;
	} 
	else if ($("#mva").val() == "") {
		alert('Informe um valor para MVA (Medida Vertical do Aro)!');
		return false;
	} 
	else if ($("#diametro").val() == "") {
		alert('Informe um valor para Diametro!');
		return false;
	} 
	else if ($("#ponte").val() == "") {
		alert('Informe um valor para Ponte!');
		return false;
	}

	return true;
}

function retornarZeroQuandoVazio(value) {
	var valor = value;
	if (valor == "") {
		return 0;
	}
	
	return valor;
}

function dadosOlhoPara3D(olho, olhoCampo) {
	var desfer 		= $("#longeEsferico" + olho).val().replace(',', '.');
	var dcilin 		= retornarZeroQuandoVazio($("#longeCilindrico" + olho).val().replace(',', '.'));

	var de 			= '&de' 		+ olhoCampo + '=' + desfer + 'f';
	var dc 			= '&dc' 		+ olhoCampo + '=' + dcilin + 'f';
	var eix 		= '&eix' 		+ olhoCampo + '=' + retornarZeroQuandoVazio($("#longeEixo" + olho).val().replace(',', '.')) + 'f';
	var ad 			= '&ad' 		+ olhoCampo + '=' + retornarZeroQuandoVazio($("#adicao" + olho).val().replace(',', '.')) + 'f';
	var pri 		= '&pri' 		+ olhoCampo + '=0.0';
	var baspr 		= '&baspr' 		+ olhoCampo + '=0.0';
	var curv 		= calcularCurvaCorrigida(desfer, dcilin);
	var cb 			= '&cb' 		+ olhoCampo + '=' + curv + 'f';
	var dm 			= '&dm' 		+ olhoCampo + '=' + $("#diametro").val().replace(',', '.');
	var mat 		= '&mat'		+ olhoCampo + '=';
	var ind 		= '&ind' 		+ olhoCampo + '=1.49;1.67;1.89';
	var esp 		= '&esp' 		+ olhoCampo + '=2.0;1.5;1.0';
	var mva 		= '&mva' 		+ olhoCampo + '=' + $("#mva").val().replace(',', '.') + 'f';
	var horizontal	=  $("#dpa").val().replace(',', '.') - $("#ponte").val().replace(',', '.');
	var mha 		= '&mha' 		+ olhoCampo + '=' + horizontal + 'f';
	var desh 		= '&desh' 		+ olhoCampo + '=' + retornarZeroQuandoVazio($("#descentracao" + olho).val().replace(',', '.'));
	var desv 		= '&desv' 		+ olhoCampo + '=0.0';
	var modelo 		= '&modelo' 	+ olhoCampo + '=10';
	var ponte 		= '&ponte' 		+ olhoCampo + '=' + $("#ponte").val().replace(',', '.') + 'f';
	var dnp 		= '&dnp' 		+ olhoCampo + '=' + $("#dnp" + olho).val().replace(',', '.') + 'f';
	var ap 			= '&ap' 		+ olhoCampo + '=' + $("#altura" + olho).val().replace(',', '.') + 'f';

	return de + dc + eix + ad + pri + baspr + cb + dm + mat + ind + esp + mva + mha + desh + desv + modelo + ponte + dnp + ap;
}

function visualizar3D() {
	if (verificarCamposObrigatorios3D()) {
		var serial = 'serial=413413584956585849';
		var resolucao = '&resolucao=800;600';
	
		var urlOD = dadosOlhoPara3D("OD", "od");
		var urlOE = dadosOlhoPara3D("OE", "oe");
		var url = serial + resolucao + urlOD + urlOE;
	
		window.open('../../3d/lente.html?' + url, 'popup', 'width=820,height=610,left=10,top=10');
	}
}