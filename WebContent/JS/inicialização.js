
    $(function() {
        $("#tabs").tabs();
    });

    
    $(document).ready(function() {

      initSessionStorage();

      
      
		$("#linhaOD").click(function() {
			var val = $( "#tipoOD option:selected" ).val();
			if(!val){
				alert('Selecione um tipo de produto.');
			}
		});

		$("#linhaOE").click(function() {
			var val = $( "#tipoOE option:selected" ).val();
			if(!val){
				alert('Selecione um tipo de produto.');
			}
		});

    	        
        $("#oc").change(function() {
    		validarRepeticaoOrdemCompra();
        });
    
        //$('.selectpicker').selectpicker();
        
        $("#entrega").mask("99/99/9999");
		$("#entrega").datepicker();
       	
        // olho direito

        decimal("#longeEsfericoOD");
        decimal("#longeCilindricoOD");
        numero("#longeEixoOD");
        decimalPositivo("#adicaoOD");
        decimal("#pertoEsfericoOD");
        decimal("#pertoCilindricoOD");
        numero("#pertoEixoOD");
        decimalNormal("#dnpOD");
        decimal("#alturaOD");
        decimal("#baseOD");
        decimal("#descentracaoOD");
        decimal("#prisma1OD");
        decimal("#prisma2OD");
        numero("#prismaEquil1OD");
        numero("#prismaEquil2OD");

        // olho esquerdo

        decimal("#longeEsfericoOE");
        decimal("#longeCilindricoOE");
        numero("#longeEixoOE");
        decimalPositivo("#adicaoOE");
        decimal("#pertoEsfericoOE");
        decimal("#pertoCilindricoOE");
        numero("#pertoEixoOE");
        decimalNormal("#dnpOE");
        decimal("#alturaOE");
        decimal("#baseOE");
        decimal("#descentracaoOE");
        decimal("#prisma1OE");
        decimal("#prisma2OE");
        numero("#prismaEquil1OE");
        numero("#prismaEquil2OE");

        numero("#pantoscopica");
        numero("#cornea");

        numero("#dp");

        $("#longeEixoOD, #pertoEixoOD, #longeEixoOE, #pertoEixoOE").blur(function() {
            validarEixo(this);
        });


        /*
         * Travar a gradua��o para os tipos
         * Vis�o simples e Vis�o simples surfa�ado.
         */

        $("#longeEsfericoOD, #longeCilindricoOD").change(function() {
			travarGraduacao("D", "longe");
        });
        $("#pertoEsfericoOD, #pertoCilindricoOD").change(function() {
        	travarGraduacao("D", "perto");
        });

        $("#longeEsfericoOE, #longeCilindricoOE").change(function() {
        	travarGraduacao("E", "longe");
        });
        $("#pertoEsfericoOE, #pertoCilindricoOE").change(function() {
        	travarGraduacao("E", "perto");
        });

        /*
         * Calcula a DNP e DP
         */

        $("#dp").change(function() {
        	var dp = $("#dp").val().replace(",", ".");
        	var dnp = (parseFloat(dp) / 2).toString().replace(".", ",");
        	forcarDecimal("#dnpOD", dnp);
        	forcarDecimal("#dnpOE", dnp);
        });

        $("#dnpOD, #dnpOE").change(function() {
        	if ($("#dnpOD").val().length != 0 && $("#dnpOE").val().length != 0) {
            	var dnpOD = $("#dnpOD").val().replace(",", ".");
            	var dnpOE = $("#dnpOE").val().replace(",", ".");
            	var dp = (parseFloat(dnpOD) + parseFloat(dnpOE)).toString();
            	forcarDecimal("#dp", dp);
        	}
        	else {
        		$("#dp").val("");
        	}
        });

    });


    /**
     * Calcula o grau de perto
     */
    function calcularGrauPerto(olho) {
        var longeEsferico   = $("#longeEsferico" + olho).val();
        var longeCilindrico = $("#longeCilindrico" + olho).val();
        var adicao          = $("#adicao" + olho).val();

        if (longeEsferico != "" && adicao != "") {
            if ((longeEsferico.replace(",", ".") % 0.25 == 0) && (adicao.replace(",", ".") % 0.25 == 0)) {
                $("#pertoCilindrico" + olho).val(longeCilindrico);
                $("#pertoEixo" + olho).val($("#longeEixo" + olho).val());

                longe = parseFloat(longeEsferico.replace(",", "."));
                adicao = parseFloat(adicao.replace(",", "."));
                $("#pertoEsferico" + olho).val(longe + adicao);

                mudacor("#pertoEsferico" + olho);
                mudacor("#pertoCilindrico" + olho);
            }
        }
    }


    /*
     * Valida o eixo
     */
    function validarEixo(campo) {
        var valor = $("#" + campo.name).val();
        if (valor < 0 || valor > 180) {
            $("#" + campo.name).focus();
            alert("O valor do eixo deve estar entre 0 e 180.");
        }
    }

    function validaLinhaProdutoReceita() {

      var tipo_form = $("input[name='olho']:checked").val();

      if (tipo_form == 'AO') {
        return validaReceitaAmbosOlhos();
      }

      if (tipo_form == 'OD') {
        return validaReceitaOD();
      }

      if (tipo_form == 'OE') {
        return validaReceitaOE();
      }

      return false;
    }

    function validaReceitaAmbosOlhos() {
        if(campoVazio('#codigoOD') || campoSelectVazio('#linhaOD')
          || campoVazio('#codigoOE') || campoSelectVazio('#linhaOE')) {
           return "Informe o c�digo e o produto para ambos os olhos.";
        }
    }

    function validaReceitaOD() {
      if(campoVazio('#codigoOD') || campoSelectVazio('#linhaOD')) {
        return "Informe o c�digo e o produto para o olho direito";
      }
    }

    function validaReceitaOE() {
      if(campoVazio('#codigoOE') || campoSelectVazio('#linhaOE')) {
        return "Informe o c�digo e o produto para o olho esquerdo";
      }
    }

    function campoVazio(campo) {
      return $(campo).val() == '';
    }

    function campoSelectVazio(campo) {
      return $(campo + ' :selected').val() == '';
    }

    function validarCamposObrigatorios() {
        var resultado = false;
        $('.campoObrigatorio').each(function() {
            if($(this).val() == '') {
              resultado = true;
            }
        });
        return resultado;
    }

    function validarNVB() {
        var msg = '';
        if($('#tabela-nvb').length == 0) {
          return msg;
        }

        var nvbValidado = parseInt($('#nvb-validado').val());
        if(nvbValidado == 0) {
              msg = 'Informe o valor do campo CVP e clique no bot�o validar.';
        }

        return msg;
    }

    function validaEnvioModeloArmacao() {
      var radio_envia_modelo = $("input[name='enviar_leitura_armacao']:checked").val();

      if(radio_envia_modelo === undefined) {
        alert('Informe se voc� vai enviar o arquivo com a leitura da arma��o.');
        $('#enviar-leitura-armacao-sim').focus();
        return true;
      }

      if(radio_envia_modelo == 'S' && $("#form-arquivo-leitura").val() == '') {
        alert('Envie o arquivo com a leitura da arma��o.');
        $('#upload_armacao_img').click();
        return true;
      }

      return false;
    }

    function validacaoProdutoSelecionadoMultiplaBase() {
      if ($("input[name='produtoSelecionadoOD']").length) {
        if ($("input[name='produtoSelecionadoOD']:checked").length == 0) {
          return "Selecione um produto para o olho direito.";
        }
      }
      if ($("input[name='produtoSelecionadoOE']").length) {
        if ($("input[name='produtoSelecionadoOE']:checked").length == 0) {
          return "Selecione um produto para o olho esquerdo.";
        }
      }

      if($('#confirmacao_selecao_produto').length) {
        return "Confirme a sele��o dos produtos.";
      }

      return "";
    }

    /*
     * Visualizar pedido
     */
    function visualizarPedido(acao) {

      var erro = false;
      var msg;

      msg = validacaoProdutoSelecionadoMultiplaBase();

      if(msg) {
        error = true;
        return alert(msg);
      }

      if (validarCamposObrigatorios()) {
        erro = true;
        return alert('Preencha os campos obrigat�rios.');
      }

      msg = travaAdicaoObrigatoria();

      if (msg != '') {
        erro = true;
        return alert(msg);
      }

      msg = validaDataHoraSugeridaEntrega();

      if (msg) {
        erro = true;
        return alert(msg);
      }

            msg = validaLinhaProdutoReceita();
      if (msg) {
        erro = true;
        return alert(msg);
      }
      
      msg = validarNVB();

      if (msg != '') {
        erro = true;
        alert(msg);
        $('#receitaDigital-NVB').focus();
        return;
      }

      

      if ($("#tabela-servicos-atualizada-produto").length) {
        if ($("#tabela-servicos-atualizada-produto").val() == "false") {
          erro = true;
          alert("Os produtos/servi�os foram modificados, atualize os itens adicionados antes de enviar o pedido.");
        }
      }

      if ($("#tabela-servicos-atualizada-servico").length) {
        if ($("#tabela-servicos-atualizada-servico").val() == "false") {
          erro = true;
          alert("Os produtos/servi�os foram modificados, atualize os itens adicionados antes de enviar o pedido.");
        }
      }

      if ($("#receitaAlterada").val() == "true") {
        erro = true;
        alert("A receita foi modificada, atualize os produtos adicionados antes de enviar o pedido.");
      }

      if ($("#medico").val() || $("#crm").val() || $("#uf_crm").val()) {

        if (!$("#medico").val() || !$("#crm").val() || !$("#uf_crm").val()) {

          erro = true;
          alert("Informe todos os dados do m�dico\nou\nApague os dados que foram preenchidos parcialmente.");
        }
      }

      if (!erro) {

        if (acao == 'enviarLab') {
          $("#acaoGravacao").empty();
          $("#acaoGravacao").html("<input type='hidden' name='acao' value='enviarLab'>");
        } else if (acao == 'aprovarMaisTarde') {
          $("#acaoGravacao").empty();
          $("#acaoGravacao").html("<input type='hidden' name='acao' value='aprovarMaisTarde'>");
        }
        setTimeout(enviarPedido(), 200);
      }
    }
	
	/**
	 * Envia o pedido
	 */
	function enviarPedido() {

        $.ajax({
            type:   "POST",
            url:    "/webpedidos/pedido/enviar.php",
            data:   $("#pedidoForm").serialize(),

            beforeSend: function() {
                $.blockUI({
                    message: '<div id="enviando-pedido"><table border="0" cellspacing="0" cellpadding="0"><tr><td><img src="/webpedidos/resources/img/carregando_24x24.gif" width="24" height="24" style="padding: 0px 15px;"></td><td align="left">Aguarde estamos validando seu pedido,<br>essa valida��o pode demorar alguns instantes...</td></tr></table></div>',
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

            success: function(data) {
                $.unblockUI();
        		$.fancybox({
        			maxWidth: 700,
        			maxHeight: 400,
        			modal : true,
        			content : data
        		});
            },

            error: function(data) {
                $.unblockUI();
            }
        });
		
	}

    function verificaBuscaSugestao(){

        var olho = $("input[name='olho']:checked").val();
        var sugestaoOD = getSessionStorage('produtoSugeridoOD');
        var sugestaoOE = getSessionStorage('produtoSugeridoOE');
        var produtoOD  = getSessionStorage('produtoOD');
        var produtoOE  = getSessionStorage('produtoOE');

        if(olho == "AO"){
            if(sugestaoOD != produtoOD) return false;
            if(sugestaoOE != produtoOE) return false;
        }else if(olho == "OD"){
            if(sugestaoOD != produtoOD) return false;
        }else if(olho == "OE"){
            if(sugestaoOE != produtoOE) return false;
        }
        return true;
    }

    function setSugestaoStorage() {

        var od = $("#linhaOD :selected").val();
        var oe = $("#linhaOE :selected").val();

        setSessionStorage('produtoSugeridoOD',od);
        setSessionStorage('produtoSugeridoOE',oe);
    }
	
    /*
     * Sugest�es de produdos
     */
		    function sugestoesProdutos() {

            window.fechar = false;

            var naoFazerBuscaSugestao = verificaBuscaSugestao();

            if(naoFazerBuscaSugestao){
                return;
            }

			$.ajax({
				type:   "POST",
				url:    "/webpedidos/pedido/sugestao_produtos.php?" + $("#pedidoForm").serialize() + "&tipoServico=SUG",
				data:   $("#pedidoForm").serialize() + "&tipoServico=SUG",
				beforeSend: function() {

                    $.fancybox({
                        "width"             : 700,
                        "minHeight"         : 100,
                        "autoScale"         : false,
                        "transitionIn"      : "none",
                        "transitionOut"     : "none",
                        "content"			: "<table class='tabela-1' width='700'><tr><th colspan='2'><b><span style='font-size: 20px;'>Aten��o</span></b></th></tr><tr><td><h4><span style='font-size: 20px;'>Aguarde a verifica��o da sugest�o de produtos.</span></h4><span style='font-size: 14px;'>Se houver sugest�o de produto/servi�o atribuida ao item selecionado,<br> uma nova tela com os Produtos/Servi�os sugeridos pelo laborat�rio ser� exibida em instantes.</span></td></tr></table>",
                        beforeClose			: function() {
                            if(window.fechar === true){
                                return true;
                            }
                            return false;
                        },
                        "closeBtn"   : false
                    });
				},
				success: function(data) {

                    window.fechar = true;
                    $.fancybox.close();

                    var obj;
                    try {
                        obj = jQuery.parseJSON(data);

                        $("#container-sugestao-auto").empty();
                        $("#container-sugestao-auto").html(obj.html);
                        buscarProdutoSugestaoAuto();

                    } catch(e) {

                        if (data != '') {

                            setSugestaoStorage();

                            $.fancybox({
                                "width"             : 700,
                                "height"            : 400,
                                "autoScale"         : false,
                                "transitionIn"      : "none",
                                "transitionOut"     : "none",
                                "content"			: data,
                                beforeClose			: function() {
                                    var temProdutosObrigatorios = $(".fancybox-inner").contents().find('#temProdutosObrigatorios').val();
                                    if (temProdutosObrigatorios == "S") {
                                        alert("Voc� tem que incluir os itens obrigat�rios.");
                                        return false;
                                    }
                                    //atualizarServicos();
                                    return true;
                                },
                                "closeBtn"   : false
                            });
                        }else{
                            setSugestaoStorage();
                        }
                    }
				},
				error: function(data) {
                    window.fechar = true;
                    $.fancybox.close();
					alert("N�o foi poss�vel verificar as sugest�es de produtos, tente novamente.");
				},
                complete: function(){
                    window.fechar = false;
                }
			});	
	    }

        /*
         * Buscar servi�o
         */
        function buscarProdutoSugestaoAuto() {

            $.ajax({
                type:   "POST",
                url:    "/webpedidos/pedido/ws_servico.php",
                data:   $("#container-sugestao-auto :input").serialize() + "&sugestaoProduto=S",

                beforeSend: function() {
                    $('.fancybox-skin').block({
                        message: '<div id="buscando-servicos">Aguarde buscando servi�os...</div>',
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

                success: function(data) {
                    var obj;
                    try {
                        obj = jQuery.parseJSON(data);
                        if (obj)
                            alert(obj.erro);
                    } catch(e) { }

                    if (obj == null) {
                        parent.$("#servicos").html(data);
                        parent.$("#atualizarServicoBtn").show();
                        parent.$("#atualizarServicoBtn").removeAttr("disabled");
                        $('.fancybox-skin').block({
                            message: '<div id="servicos-adicionados">Servi�os adicionados com sucesso</div>',
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
                        $("#temProdutosObrigatorios").val("N");
                        avisarFechar();
                    }
                },

                error: function(data) {
                    alert("N�o foi poss�vel carregar servi�os, tente novamente.");
                    $('.fancybox-skin').unblock();
                }
            });
        }
	
		
		function verificarGrau(valorOD, valorOE, tipo) {
			var olhoSelecionado = $("input[name=olho]:checked").val();
			if (olhoSelecionado == "AO") {
			    var valor1 = parseFloat(valorOD.replace(',', '.'));
                var valor2 = parseFloat(valorOE.replace(',', '.'));
				if (!isNaN(valor1) && !isNaN(valor2) && valor1 != 0 && valor2 != 0) {
					if ((valor1 > 0 && valor2 < 0) || (valor1 < 0 && valor2 > 0)) {
						var campo1 = '';
						var campo2 = '';

						if (tipo == 'EL') {
							campo1 = 'Esf�rico de longe do olho direiro';
							campo2 = 'Esf�rico de longe do olho esquerdo';
						}
						if (tipo == 'EP') {
							campo1 = 'Esf�rico de perto do olho direiro';
							campo2 = 'Esf�rico de perto do olho esquerdo';
						}
						if (tipo == 'CL') {
							campo1 = 'Cil�ndrico de longe do olho direiro';
							campo2 = 'Cil�ndrico de longe do olho esquerdo';
						}
						if (tipo == 'CP') {
							campo1 = 'Cil�ndrico de perto do olho direiro';
							campo2 = 'Cil�ndrico de perto do olho esquerdo';
						}
						
						alert('O grau para os campos abaixo s�o diferentes, um tem o valor positivo e o outro o valor negativo!\n\n' +
								'- ' + campo1 + '\n' + 
								'- ' + campo2 + '\n' + 
								'\nSe estiver correto continue fazendo o pedido normalmente.\n');
					}
				}
			}
		}

		$(document).ready(function() {
	        $("#longeEsfericoOD, #longeEsfericoOE").change(function() {
	        	verificarGrau($('#longeEsfericoOD').val(), $('#longeEsfericoOE').val(), 'EL');
	        });
	        
	        $("#longeCilindricoOD, #longeCilindricoOE").change(function() {
	        	verificarGrau($('#longeCilindricoOD').val(), $('#longeCilindricoOE').val(), 'CL');
	        });
	        
	        $("#pertoEsfericoOD, #pertoEsfericoOE").change(function() {
	        	verificarGrau($('#pertoEsfericoOD').val(), $('#pertoEsfericoOE').val(), 'EP');
	        });
	        
	        $("#pertoCilindricoOD, #pertoCilindricoOE").change(function() {
	        	verificarGrau($('#pertoCilindricoOD').val(), $('#pertoCilindricoOE').val(), 'CP');
	        });
		});
		
