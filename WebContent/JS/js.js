function insertcode()
{   var esfdireito;
    var cildireito;
    var esfesquerdo;
    var cilesquerdo;
	var positivo = "+";
	var negativo = "-";
	
	esfdireito = document.getElementById('odesf');
	cildireito = document.getElementById('odcil');
	esfesquerdo = document.getElementById('oeesf');
	cilesquerdo = document.getElementById('oecil');
	            if (esfdireito < 0)
		        {
  	            esfdireito.style.color = "red";
  	           
  	            
                }
	            else
	            esfdireito.style.color = "blue";
	            esfdireito.value = positivo+esfdireito.value;
	            if (cildireito < 0){
	            	cildireito.style.color = "red";
	            }
	            else
	            	cildireito.style.color = "blue";
	            cildireito.value = positivo+cildireito.value;
	       
}