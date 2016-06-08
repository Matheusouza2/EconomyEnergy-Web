<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Painel Administrador</title>
	
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/admin.css" rel="stylesheet">
    <script src="../js/jquery.js"></script>
    <script src="../js/validator.js"></script>
    <link href="../css/estilocadastro/css" rel="stylesheet">

</head>

<body>

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
                        <h1>Cadastrar Tarifa</h1><br/>
                                              
                        <h5 style="overflow:auto; color: red; " >Todos os Campos São Obrigatórios !</h5><br/>
                        
                        <!-------------------FORMULARIO  usuario -------------------------->

<div class="col-md-6 col-sm-5">


<form name="cadastro" class="form-horizontal" action="/InfoPower/TarifaControle?acao=salv" method="post" data-toggle="validator">
    <fieldset>
            <!-- NOME input-->
              
            <div class="form-group has-feedback" align="center">
                <label  class="col-md-4 control-label" for="textinput1">Nome Tarifa</label>
                <div class="col-md-8">

                    <input autofocus="autofocus"  id="nomeTarifa" name="nomeTarifa" required type="text" placeholder="Tarifa" class="form-control input-md">
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div><div class="help-block with-errors" style="float: right; padding-right: 160px;"></div>
            </div>

            <div class="form-group has-feedback">
                <label class="col-md-4 control-label" for="logininput">Valor</label>
                <div class="col-md-8">

                    <input id="valorTarifa" name="valorTarifa" required step="0.01" type="text" pattern="^[,0-9]{2,}" placeholder="Valor" class="form-control input-md">
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
                <span style="color: green"><i class="fa fa-1x fa-info-circle"></i> Separe as casas decimais com virgula</span>
            </div>
	
    </fieldset>
</form>

</div>
        </div>

    </fieldset>
</form>
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

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
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
					       <div class="alert-success"><h4 class="modal-title" id="modalLabel">Operação realizada com sucesso<h4></div>
					      </div>
					      <div class="modal-body">
					        Tarifa cadastrada com sucesso
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
	
if(sessao.getAttribute("mensagem").equals("erro-existe")){
	%>
	<script type="text/javascript">
		$('#titulo-erro').text('Erro ao cadastrar tarifa');
		$('#mensagem-erro').text('Esta tarifa já está cadastrada !');
		$("#modal-erro").modal('show');
	</script>
<%
sessao.setAttribute("mensagem", null);
	}//fim do if erro de login
	
	else if(sessao.getAttribute("mensagem").equals("erro-banco")){
		String erro = (String)sessao.getAttribute("erro");
		%>
		<script type="text/javascript">
		$('#titulo-erro').text('Erro tecnico');
		$('#mensagem-erro').text("<%=erro%>");
		$("#modal-erro").modal('show');
		</script>
	<%
sessao.setAttribute("mensagem", null);			
	}//fim do if erro endereço
	
	else if(sessao.getAttribute("mensagem").equals("sucesso")){%>
		<script type="text/javascript">
		$("#modal-sucesso").modal('show');
	</script>	
<%sessao.setAttribute("mensagem", null);
	}//fim do if sucesso

}//fim do primiro if%>

</html>