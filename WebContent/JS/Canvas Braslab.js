<html xmlns="http://www.w3.org/1999/xhtml" class=""><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Centro Ótico - WebPedidos</title>
<link rel="shortcut icon" href="/webpedidos/resources/img/favicon.ico">
<meta name="robots" content="noindex,nofollow">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=IE7" /> -->
<link href="/webpedidos/resources/js/jquery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/webpedidos/resources/js/fancyapps/source/jquery.fancybox.css" media="screen">
<link href="/webpedidos/resources/js/tooltip/jquery.tooltip.css" rel="stylesheet" type="text/css">
<link href="/webpedidos/resources/js/chosen/chosen.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/webpedidos/resources/js/jquery.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/scripts.php"></script>
<script type="text/javascript" src="/webpedidos/resources/js/helpers.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery.alphanumeric.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/formatCurrency/jquery.formatCurrency.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery-ui/jquery.ui.datepicker-pt-BR.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/jquery.autoNumeric.js"></script>
<link href="/webpedidos/resources/js/datatables/media/css/jquery.dataTables.css" rel="stylesheet" type="text/css">
<link href="/webpedidos/resources/js/datatables//extensions/FixedColumns/css/dataTables.fixedColumns.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/webpedidos/resources/js/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/datatables/extensions/FixedColumns/js/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/fancyapps/lib/jquery.mousewheel-3.0.6.pack.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/fancyapps/source/jquery.fancybox.js"></script>
<script type="text/javascript" src="/webpedidos/resources/js/tooltip/jquery.tooltip.js"></script>
<script type="text/javascript" src="/webpedidos/pedido/atacado/scripts.php"></script>
<script type="text/javascript" src="/webpedidos/resources/js/chartjs/Chart.js"></script>

<link href="/layout/styles.css" rel="stylesheet" type="text/css">

        <style type="text/css">
            body {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                font-size: 13px;
                margin: 10px;
                padding: 0px;
                background-color: #ffffff;
            }
        </style>
    <style type="text/css">.fancybox-margin{margin-right:17px;}</style></head>
    <body style="overflow-x: hidden;">
        <script>

if(navigator.appName=="Microsoft Internet Explorer"){
	alert("Para utilizar esta funcionalidade, é necessário que o navegador seja o Google Chrome ou Firefox.");
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
			alert('Tamanho máximo de arquivo excedido (100kb).');
			$("#arquivo-medidas").val('');
			return false;
		}

		if($("#arquivo-medidas").val()){
			$("#form-upload").submit();
			$("#arquivo-medidas").val('');
			return false;
		}else{
			alert('Você deve selecionar o arquivo da leitura da armação.');
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
                alert("Não foi possível processar a imagem, tente novamente.");
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
      	  	  				var strErro = 'Não foi possivel enviar o arquivo, ocorreu o seguinte erro: \n\n';
      	  				}else if(obj.erros.length > 1){
      	  	  				var strErro = 'Não foi possivel enviar o arquivo, ocorreu os seguintes erros: \n\n';
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
                alert("Não foi possível processar o arquivo, tente novamente...");
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
  
</script>

<div id="desenho">
    <table class="tabela-2" width="100%">
        <tbody>
            <tr>
                <td colspan="2" class="titulo"><b>Upload da leitura da armação</b></td>
            </tr>
            <form id="form-upload" enctype="multipart/form-data"></form>
            <tr>
                <td colspan="2" nowrap="nowrap" align="center">
                    <input type="file" id="arquivo-medidas" name="arquivo-medidas" disabled="">
                    <input type="hidden" name="submit" value="submit">
                </td>
            </tr>
             <tr>
                 <td class="titulo" align="right">
                     <input type="button" id="remover-leitura" value="Remover Leitura" class="inputButton" style="display: inline-block;">
                 </td>
                <td class="titulo" align="left">
                    <input type="button" id="fechar" value="Fechar" class="inputButton">
                </td>

            </tr>
            <tr>
                <td class="titulo">Olho Esquerdo</td>
                <td class="titulo">Olho Direito</td>
            </tr>
            <tr>
                <td width="50%" nowrap="nowrap" align="center" id="td_oe">
                    
                <canvas id="OE" width="389" height="194" style="width: 389px; height: 194px;"></canvas></td>
                
                <td width="50%" nowrap="nowrap" align="center" id="td_od">
                    
                <canvas id="OD" width="380" height="190" style="width: 380px; height: 190px;"></canvas></td>
            </tr>
            
        </tbody>
    </table>

</div>

    

</body></html>