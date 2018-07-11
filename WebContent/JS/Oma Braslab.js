
if(navigator.appName=="Microsoft Internet Explorer"){
	alert("Para utilizar esta funcionalidade, � necess�rio que o navegador seja o Google Chrome ou Firefox.");
	continueExecution();
}

function habilitarCampo(campo) {
    parent.$(campo).val('');
    parent.$(campo).attr('readonly', false);
    parent.$(campo).removeClass('inputReadonly');
}

function desabilitaInputFile() {
    $('#arquivo-medidas').prop('disabled', true);
}

function habilitaInputFile() {
    $('#arquivo-medidas').prop('disabled', false);
}

$(function(){

	$("#remover-leitura").hide();

    $("#fechar").click(function(){
        $('.fancybox-skin').unblock();
        parent.$.fancybox.close();
    });

	$('#arquivo-medidas').change(function() {
		
		var arquivo = this.files[0];

		if(arquivo.size > 104858){
			alert('Tamanho m�ximo de arquivo excedido (100kb).');
			$("#arquivo-medidas").val('');
			return false;
		}

		if($("#arquivo-medidas").val()){
			$("#form-upload").submit();
			$("#arquivo-medidas").val('');
			return false;
		}else{
			alert('Voc� deve selecionar o arquivo da leitura da arma��o.');
			return false;
		}
	});



	$("#remover-leitura").click(function(){
		$.ajax({
            type:   "GET",
            url:    "/webpedidos/pedido/laboratorio/processa_upload.php?delete=true",
            cache: false,
            contentType: false,
            processData: false,
            success: function(){

            	$("#OE").remove();
            	$("#OD").remove();

            	$("#td_oe").append('<canvas id="OE"></canvas>');
            	$("#td_od").append('<canvas id="OD"></canvas>');

            	$("#remover-leitura").hide();

                habilitarCampo('#ponte');
                habilitarCampo('#mva');
                habilitarCampo('#mha');
                habilitarCampo('#dma');
                habilitarCampo('#receitaDigital-PANTOSCOPICO');
                habilitarCampo('#diametro');
                habilitaInputFile();

                parent.$("#dpa").val('');
				parent.$("#form-arquivo-leitura").val('');

				parent.$("#upload_armacao_img").attr('src','/webpedidos/resources/img/modelo_cliente.png');

                            }
    	});
	});
	
	

		$("#remover-leitura").show();
	
		$.ajax({
            type:   "GET",
            url:    "/webpedidos/pedido/laboratorio/processa_upload.php",
            cache: false,
            contentType: false,
            processData: false,
            beforeSend: function() {
            	
                $.blockUI({
                    message: '<div>Aguarde processando imagem...</div>',
                    overlayCSS: {
                        backgroundColor: '#fff',
                        opacity: 0.6
                    },
                    css: {
                        border: 'none',
                        padding: '15px',
                        backgroundColor: '#000',
                        '-webkit-border-radius': '10px',
                        '-moz-border-radius': '10px',
                        opacity: .8,
                        color: '#fff'
                	}
                });
        	},
         
            success: function (data) {

                desabilitaInputFile();

  				var	obj = jQuery.parseJSON(data);

                $.blockUI({
					message: '<div>Imagem processada com sucesso.</div>',
					overlayCSS: {
						backgroundColor: '#fff',
						opacity: 0.6
					},
					css: {
						border: 'none',
						padding: '15px',
						backgroundColor: '#0076a3',
						'-webkit-border-radius': '10px',
						'-moz-border-radius': '10px',
						opacity: .8,
						color: '#ffffff'
					}
				});

				setTimeout($.unblockUI,1000); 
				exibirModeloLente(obj.dadosModelo);

                            },
        
            error: function(data) {
                alert("N�o foi poss�vel processar a imagem, tente novamente.");
                $.unblockUI();
            }
        });
        
	
    $("#form-upload").submit(function(event){	

    	event.preventDefault();
    	var formData = new FormData($(this)[0]); 
    
        $.ajax({
            type:   "POST",
            url:    "/webpedidos/pedido/laboratorio/processa_upload.php",
            data: formData,
            cache: false,
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
        
            beforeSend: function() {
            	
                $.blockUI({
                    message: '<div>Aguarde processando arquivo...</div>',
                    overlayCSS: {
                        backgroundColor: '#fff',
                        opacity: 0.6
                    },
                    css: {
                        border: 'none',
                        padding: '15px',
                        backgroundColor: '#000',
                        '-webkit-border-radius': '10px',
                        '-moz-border-radius': '10px',
                        opacity: .8,
                        color: '#fff'
                	}
                });
        	},
         
            success: function (data) {

  				var	obj = jQuery.parseJSON(data);

  				if(('erros' in obj)){
      				if(obj.erros.length){
    
      	  				if(obj.erros.length == 1){
      	  	  				var strErro = 'N�o foi possivel enviar o arquivo, ocorreu o seguinte erro: \n\n';
      	  				}else if(obj.erros.length > 1){
      	  	  				var strErro = 'N�o foi possivel enviar o arquivo, ocorreu os seguintes erros: \n\n';
      	  				}
      	  				
    					for(var i=0; i < obj.erros.length; i++){
    						strErro += (i+1) + '-' + obj.erros[i] + "\n";
    					}
    					alert(strErro);
    					setTimeout($.unblockUI,1000); 
      				}

                    habilitaInputFile();

  				}else{

                    desabilitaInputFile();

  					if(obj.ponte){
  						parent.$("#ponte").val(obj.ponte);
  						parent.$('#ponte').attr('readonly', true);
  						parent.$("#ponte").addClass('inputReadonly');
  					}

  					if(obj.mva){
  						parent.$("#mva").val(obj.mva);
  						parent.$('#mva').attr('readonly', true);
  						parent.$("#mva").attr('class','inputReadonly');
  					}

  					if(obj.mha){
  						parent.$("#mha").val(obj.mha);
  						parent.$('#mha').attr('readonly', true);
  						parent.$("#mha").attr('class','inputReadonly');
  					}

  					if(obj.dpa){
  						parent.$("#dpa").val(obj.dpa);
  					}

  					if(obj.angpant){
  						parent.$("#receitaDigital-PANTOSCOPICO").val(obj.angpant);
  						parent.$('#receitaDigital-PANTOSCOPICO').attr('readonly', true);
  						parent.$("#receitaDigital-PANTOSCOPICO").attr('class','inputReadonly');
  					}

                    parent.$('#dma').attr('readonly', true);
                    parent.$("#dma").attr('class','inputReadonly');

                    if(obj.dma){
                        parent.$("#dma").val(obj.dma);
                    }else{
                        parent.$("#dma").val('');
                    }

                    parent.$("#diametro").val('');
                    parent.$('#diametro').attr('readonly', true);
                    parent.$("#diametro").attr('class','inputReadonly');

  					parent.$("#form-arquivo-leitura").val(obj.arquivo_leitura);

  					parent.$("#upload_armacao_img").attr('src','/webpedidos/resources/img/modelo_cliente_enviado.png');
  					
  					$.blockUI({
  						message: '<div>Arquivo processado com sucesso.</div>',
  						overlayCSS: {
  							backgroundColor: '#fff',
  							opacity: 0.6
  						},
  						css: {
  							border: 'none',
  							padding: '15px',
  							backgroundColor: '#0076a3',
  							'-webkit-border-radius': '10px',
  							'-moz-border-radius': '10px',
  							opacity: .8,
  							color: '#ffffff'
  						}
  					});

                    
  					setTimeout($.unblockUI, 1500); 
  					exibirModeloLente(obj.dadosModelo);
  					$("#remover-leitura").show();
  				}
            },
        
            error: function(data) {
                alert("N�o foi poss�vel processar o arquivo, tente novamente...");
                $.unblockUI();
            }
        });
    
    	return false;
    });
});

function exibirModeloLente(data)
{
	if(('od' in data) || ('oe' in data)){

        var renderOD = false;
        var renderOE = false;

        if(data.oe.labels ) {
            renderOE = true;
            labelsOE = JSON.parse("[" + data.oe.labels + "]");
            pontosOE = JSON.parse("[" + data.oe.pontos + "]");
        }

        if(data.od.labels ) {
            renderOD = true;
            labelsOD = JSON.parse("[" + data.od.labels + "]");
            pontosOD = JSON.parse("[" + data.od.pontos + "]");
        }

        if(renderOE) {
            var optionsOE = {
                responsive: true,
                angleShowLineOut: false,
                scaleShowLine: false
            };

            var dataOE = {
                labels: labelsOE,
                datasets: [
                    {
                        fillColor: "#448ccb",
                        strokeColor: "rgba(220,220,220,1)",
                        pointColor: "#448ccb",
                        pointStrokeColor: "#448ccb",
                        pointHighlightFill: "#448ccb",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: pontosOE
                    }
                ]
            };
        }

        if(renderOD){
            var optionsOD = {
                responsive:true,
                angleShowLineOut : false,
                scaleShowLine: false
            };

            var dataOD = {
                labels: labelsOD,
                datasets: [
                    {
                        fillColor: "#448ccb",
                        strokeColor: "rgba(220,220,220,1)",
                        pointColor: "#448ccb",
                        pointStrokeColor: "#448ccb",
                        pointHighlightFill: "#448ccb",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: pontosOD
                    }
                ]
            };
        }

        if(renderOE) {
            var ctxOE = document.getElementById("OE").getContext("2d");
            new Chart(ctxOE).Radar(dataOE, optionsOE);
        }

        if(renderOD) {
            var ctxOD = document.getElementById("OD").getContext("2d");
            new Chart(ctxOD).Radar(dataOD, optionsOD);
        }
	}
}

function avisarFechar()
{
  setTimeout(continueExecution, 1500);
}

function continueExecution()
{
    $('.fancybox-skin').unblock(); 
	parent.$.fancybox.close();
} 
