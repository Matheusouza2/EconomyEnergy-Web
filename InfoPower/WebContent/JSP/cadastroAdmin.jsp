<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.infopower.entidades.Administrador"%>
<%@ page import="com.infopower.controladores.ControladorAdmin"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Painel Administrador</title>
	
    <script src="../js/jquery.js"></script>
    <script src="../js/validator.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/admin.css" rel="stylesheet">
    <link href="../css/estilocadastro/css" rel="stylesheet">
 

</head>

<body>
<%
Administrador admin = (Administrador) request.getAttribute("admin");
%>
    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <%HttpServletRequest httpServletRequest = (HttpServletRequest) request;
							HttpSession sessao = httpServletRequest .getSession();
							if(sessao.getAttribute("adminLogado")!=null){
								%>
								<jsp:include page="menu.jsp" flush="true" />
							<% }else{
								response.sendRedirect("Usuario.jsp");
							}%>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>Cadastrar Administrador</h1><br/>
                        
                <h5 style="overflow:auto; color: red; " > Todos os campos são Obrigatório !</h5><br/>
                        
                        
                        <div class="col-md-6">


<form name="cadastro" class="form-horizontal" action="/InfoPower/admControle?acao=salv" method="post" data-toggle="validator">
    <fieldset>

                    
            <!-- NOME input-->
              
       
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="textinput1">Nome</label>
                <div class="col-md-8" style="float: left;">

                    <input id="nomeAdm" name="nomeAdm" required type="text" placeholder="Seu Nome" autofocus="autofocus" class="form-control input-md" >
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>	
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
                
            </div>
			
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="logininput">Login</label>
                <div class="col-md-8">

                    <input id="loginAdm" name="loginAdm" required type="text" placeholder="Login Administrador" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>
            
            
            <!-- Password input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="passwordinput1">Senha</label >
                <div class="col-md-8">
                    <input id="passwordinput1" name="senhaAdm" required type="password" placeholder="Digite uma Senha" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Telefone input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="numberinput1"  >Telefone</label>
                <div class="col-md-8">
                    <input id="telefoneAdm" name="telefoneAdm" required type="tel" placeholder="(00) 00000-0000" class="form-control input-md" maxlength=13 >
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!--CEP input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="cepinput1">CEP</label>
                <div class="col-md-8">

                    <input id="cepAdm" name="cepAdm" required maxlength=9 type="text" placeholder="Cep Administrador" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Endereco input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Enderecoinput1">Endereco</label>
                <div class="col-md-8">
                    <input id="EnderecoInput" name="enderecoAdm" required type="text" placeholder="Endereco" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

			<!--Numero input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="cepinput1">Numero</label>
                <div class="col-md-8">
                    <input id="NumeroInput" name="numeroAdm" required type="text" pattern="^[0-9]" placeholder="Numero" class="form-control input-md">
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>


            <!-- Bairro input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Bairroinput1">Bairro</label>
                <div class="col-md-8">
                    <input id="BairroInput" name="bairroAdm" required type="text" placeholder="Bairro" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>


               <!-- Cidade input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Estadoinput1">Cidade</label>
                <div class="col-md-8">
                    <input id="cidadeInput" name="cidadeAdm" required type="text" placeholder="Cidade" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>


               <!-- Estado input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Estadoinput1">Estado</label>
                <div class="col-md-8">
                    <input id="EstadoInput" name="estadoAdm" required type="text" placeholder="Estado" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>


            <!-- País input-->
            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="Paisinput1">Pais</label>
                <div class="col-md-8">
                    <input id="PaisInput" name="paisAdm" required type="text" placeholder="Pais" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="button1id"></label>
                <div class="col-md-8">
                	<input class="btn btn-success" type="submit" name="cadastro" id="button3id" onclick="return validaForm()" value="Salvar" />
                    <button type="reset" id="button4id" name="button2id" class="btn btn-danger"><i class="fa fa-times"></i> Cancelar</button>
                </div>
            </div>

    </fieldset>
</form>


						</div>
                         
                    </div>


                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
<script type="text/javascript">
    $(document).ready(function(){
       $("#cepAdm").mask('99999-999'); 
       $("#telefoneAdm").mask("(99)99999-9999");
    });
    </script>
    
		<!-- VALIDAÇÃO DOS CAMPOS OBRIGATORIOS -->
		
  <script src="../js/jquery.min.js"></script>
 <script src="../js/bootstrap.min.js"></script>
  <script src="../js/jquery.easing.min.js"></script>
    <script src="../js/jquery.fittext.js"></script>
    <script src="../js/wow.min.js"></script>
    <script src="../js/creative.js"></script>
     <!-- Mascara -->
    <script src="../js/MaskJquery.js"></script>

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
            $("#cepAdm").blur(function() {

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
                                document.getElementById("PaisInput").disabled = true;
                                document.getElementById("EstadoInput").disabled = true;
                                document.getElementById("cidadeInput").disabled = true;
                            } //end if.
                            else {
                            	$('#titulo-erro').text('Erro ao identificar cep');
                        		$('#mensagem-erro').text('O cep não foi encontrado!');
                        		$("#modal-erro").modal('show');
                            }
                        
                        });
                    }
                }
        	});
        });

    </script>
    <!-- Fim da busca de CPF -->


<!-- Modal -->
				<div class="alert-success">
					<div class="modal fade" id="modal-sucesso" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
					       <div class="alert-success"><h4 class="modal-title" id="modalLabel">Administrador Cadastrado com sucesso<h4></div>
					      </div>
					      <div class="modal-body">
					        O Administrador foi cadastrado com sucesso
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
	
if(sessao.getAttribute("mensagem").equals("erro")){
	%>
	<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar administrador');
		$('#mensagem-erro').text('Este login já está associado a um dos nossos administradores. Tente outro login!');
		$("#modal-erro").modal('show');
	</script>
<%
sessao.setAttribute("mensagem", null);
	}//fim do if erro de login
	
	else if(sessao.getAttribute("mensagem").equals("erro-banco")){
			String erro = (String) sessao.getAttribute("erro");
		%>
		<script type="text/javascript">
		$('#titulo-erro').text('Erro tecnico');
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