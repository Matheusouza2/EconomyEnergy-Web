<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.infopower.entidades.Cliente"%>
<!DOCTYPE html>
<html lang="en">

<head>
	
    <title>Painel Cliente</title>
    
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/admin.css" rel="stylesheet">
    <script src="../js/jquery.js"></script>
    <script src="../js/validator.js"></script>
    <link href="../css/estilocadastro/css" rel="stylesheet">

</head>

<body>

<%
Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

                
    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <%HttpServletRequest httpServletRequest = (HttpServletRequest) request;
							HttpSession sessao = httpServletRequest .getSession();
							if(sessao.getAttribute("adminLogado")!=null){
								%>
								<jsp:include page="menu.jsp" flush="true" />
							<% }%>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>Cadastrar Cliente</h1><br/>
                        
                        <h5 style="overflow:auto; color: red; " >Todos os Campos São Obrigatório !</h5><br/>
                                               
                        
                        <!-------------------FORMULARIO  usuario -------------------------->

<div class="col-md-5 col-sm-5">


<form name="cadastro" class="form-horizontal" action="/InfoPower/ClienteServlet?acao=salv" method="post" data-toggle="validator">
    <fieldset>

<!-- Form Name -->

            <!-- Nome input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Nomeinput">Nome Cliente </label>
                <div class="col-md-8">

                    <input id="Nomeinput" name="nomeUser" required type="text" placeholder="Seu Usuario" autofocus="autofocus" class="form-control input-md" >
				<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>
            
	        <!--CPF input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="CpfInput">CPF</label>
                <div class="col-md-8">
                    <input id="cpfUser" name="cpfUser" required type="text" placeholder="Cpf" class="form-control input-md" >
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

                      
            <!-- Login input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Logininput">Login Cliente</label>
                <div class="col-md-8">

                    <input id="Nomeinput"  name="loginUser" required type="text" placeholder="Seu Login" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>
            
             <!-- Password input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="passwordinput">Senha</label>
                <div class="col-md-8">
                    <input id="passwordinput"  name="senhaUser" required type="password" placeholder="Digite uma Senha" class="form-control input-md" >
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Telefone input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Telefoneinput">Telefone</label>
                <div class="col-md-8">
                    <input id="telefoneUser" name="telefoneUser" required type="tel" placeholder="0 0000-0000" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>	
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

        <!--CEP input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="cepinput">CEP</label>
                <div class="col-md-8">

                    <input id="cepUser"  name="cepUser" required type="text" placeholder="Cep" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Text input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Enderecoinput">Logradouro</label>
                <div class="col-md-8">
                    <input id="EnderecoInput"  name="enderecoUser" required type="text" placeholder="Endereço" class="form-control input-md" >
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>
            
            <!-- Text input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Bairroinput">Bairro</label>
                <div class="col-md-8">
                    <input id="BairroInput"   name="bairroUser" required type="text" placeholder="Bairro" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>
			      
			        <!--Numero input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="cepinput1">Numero</label>
                <div class="col-md-8">
                    <input id="numeroInput"  name="numeroUser" required type="text" pattern="^[0-9]{2,}" placeholder="Numero" class="form-control input-md" >
 					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>               
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

                 <!--Cidade input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="cepinput1">Cidade</label>
                <div class="col-md-8">
                    <input id="cidadeInput"  name="cidadeUser" required type="text" placeholder="Cidade" class="form-control input-md" >
                	<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

                    <!-- Estado input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Estadoinput">Estado</label>
                <div class="col-md-8">
                    <input id="EstadoInput"  name="estadoUser" required type="text" placeholder="Estado" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

      <!-- País input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Paisinput">País</label>
                <div class="col-md-8">
                    <input id="PaisInput" name="paisUser" required type="text" placeholder="Pais" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="button1id"></label>
                <div class="col-md-8">
                    <input class="btn btn-success" type="submit" name="cadastro" id="button3id" value="Salvar" />
                    <button type="reset" id="button2id" name="button2id" class="btn btn-danger"><i class="fa fa-times"></i> Cancelar</button>
                </div>
            </div>

    </fieldset>
</form>


</div>
        </div>



       <!-------------------FORMULARIO -------------------------->

        </div>
                         
                    </div>


                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>

    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../js/jquery.js"></script>
	<script src="../js/MaskJquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
     <script src="../js/jquery.easing.min.js"></script>
    <script src="../js/jquery.fittext.js"></script>
    <script src="../js/wow.min.js"></script>
    <script src="../js/creative.js"></script>
    
    <!-- VALIDAÇÃO DOS CAMPOS OBRIGATORIOS -->
		
    <script type="text/javascript">
		//mascaras de telefone, cep e cpf
		$(document).ready(function(){
			$("#telefoneUser").mask("(99)99999-9999");
			$("#cepUser").mask("99999-999");
			$("#cpfUser").mask("999.999.999-99");
			});
	
	</script>
	
	<!-- Buscar cep -->
    <script type="text/javascript" >

        $(document).ready(function() {
        	function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#EnderecoInput").val("");
                $("#BairroInput").val("");
                $("#cidadeInput").val("");
                $("#EstadoInput").val("");
            }
            //Quando o campo cep perde o foco.
            $("#cepUser").blur(function() {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                   var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#EnderecoInput").val("...");
                		$("#BairroInput").val("...");
                		$("#cidadeInput").val("...");
                		$("#EstadoInput").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#EnderecoInput").val(dados.logradouro);
                                $("#BairroInput").val(dados.bairro);
                                $("#cidadeInput").val(dados.localidade);
                                $("#EstadoInput").val(dados.uf);
                                $("#PaisInput").val('Brasil');
                                document.getElementById("PaisInput").readOnly = true;
                                document.getElementById("EstadoInput").readOnly = true;
                                document.getElementById("cidadeInput").readOnly = true;
                            } //end if.
                            else {
                            	$('#titulo-erro').text('Erro ao identificar cep');
                        		$('#mensagem-erro').text('Este cep não foi encontrado!');
                        		$("#modal-erro").modal('show');
                            }
                        
                        });
                    }
                }
        	});
        });

    </script>
    <!-- Fim da busca de CPF -->

    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

	<!-- Modal -->
				<div class="alert-success">
					<div class="modal fade" id="modal-sucesso" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
					       <div class="alert-success"><h4 class="modal-title" id="modalLabel">Cliente Cadastrado com sucesso<h4></div>
					      </div>
					      <div class="modal-body">
					        O cliente foi cadastrado com sucesso
					      </div>
						<div class="modal-footer">
					    	  <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
				 <!-- /.modal -->
				 
				<!-- Modal -->
				<div class="alert-danger">
					<div class="modal fade" id="modal-erro" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
					       <div class="alert-danger"><h4 class="modal-title" id="titulo-erro"><h4></div>
					      </div>
					      <div class="modal-body" id="mensagem-erro">
					      </div>
					      <div class="modal-footer">
					      <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
				 <!-- /.modal --> 
</body>

<% 
if(sessao.getAttribute("mensagem") != null){
	
if(sessao.getAttribute("mensagem").equals("erro-cadastro")){
	%>
	<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar cliente');
		$('#mensagem-erro').text('Este login já está associado a um dos nossos clientes. Tente outro login!');
		$("#modal-erro").modal('show');
	</script>
<%
sessao.setAttribute("mensagem", null);
	}//fim do if erro de login
	
	else if(sessao.getAttribute("mensagem").equals("erro-endereço")){
		%>
		<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar cliente');
		$('#mensagem-erro').text('Este endereço já está cadastrado no nosso banco de dados!');
		$("#modal-erro").modal('show');
		</script>
	<%
sessao.setAttribute("mensagem", null);			
	}//fim do if erro endereço
	
	else if(sessao.getAttribute("mensagem").equals("erro-cpf")){
		%>
		<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar cliente');
		$('#mensagem-erro').text('Este cpf já está associado a um dos nossos clientes!');
		$("#modal-erro").modal('show');
		</script>
	<%
sessao.setAttribute("mensagem", null);			
	}//fim do if erro endereço	
	
	else if(sessao.getAttribute("mensagem").equals("erro-banco")){
		String erro = (String) sessao.getAttribute("erro");
		%>
		<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar cliente');
		$('#mensagem-erro').text("<%=erro%>");
		$("#modal-erro").modal('show');
		</script>
	<%
	sessao.setAttribute("mensagem", null);			
	}	
	
	else if(sessao.getAttribute("mensagem").equals("sucesso")){%>
		<script type="text/javascript">
		$("#modal-sucesso").modal('show');
	</script>	
<%sessao.setAttribute("mensagem", null);
	}//fim do if sucesso
}//fim do primiro if%>

</html>