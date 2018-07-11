
$(document).ready(function(){
	
	$('#myAjaxRequestForm').submit(function(){
		var dados = jQuery( this ).serialize();

		$.ajax({
			type: "GET",
			url: "FormularioAjaxLimitador",
			datatype: "json",
	    	data: dados,
			success: function( data ){
				$('#tabela tr').remove();
				
			    for(var i=0; data.length>i;i++){
				//Adicionando registros retornados na tabela
			
				$('#tabela').append('<tr><td>'+data[i].descricao+'</td><td>'+data[i].material+'</td><td>'+data[i].cor+'</td><td>'+data[i].tratamento+'</td><td>'+data[i].fotossensivel+'</td><td>'+data[i].indice+'</td><td>'+data[i].valor+'</td></tr>');
			}
			}
		});
		
		return false;
		
	});
	

});
    
  

