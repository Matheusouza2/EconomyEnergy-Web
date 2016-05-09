<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.infopower.entidades.Cliente"%>
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

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/admin.css" rel="stylesheet">
    
    <link href="../css/estilocadastro/css" rel="stylesheet">
    
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                        <h1>Cadastrar Administrador</h1><br/> <br/>
                        
                
                        
                        
                        <div class="col-md-6 col-sm-5">


<form class="form-horizontal" action="/InfoPower/admControle" method="post">
    <fieldset>

                    
            <!-- NOME input-->
              
       
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput1">Nome Administrador</label>
                <div class="col-md-8">

                    <input id="textinput1" name="nomeAdm" type="text" placeholder="Seu Nome" class="form-control input-md" required>

                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="logininput">Login</label>
                <div class="col-md-8">

                    <input id="logininput" name="loginAdm" type="text" placeholder="Login Administrador" class="form-control input-md" required>

                </div>
            </div>

            <!-- Telefone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="numberinput1">Telefone</label>
                <div class="col-md-8">
                    <input id="numberinput1" name="telefoneAdm" type="tel" placeholder="0 0000-0000" class="form-control input-md">

                </div>
            </div>



                   <!--CEP input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="cepinput1">CEP</label>
                <div class="col-md-8">

                    <input id="cepinput1" name="cepAdm" type="number" placeholder="Cep Administrador" class="form-control input-md" required>

                </div>
            </div>



            <!-- Endereco input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Enderecoinput1">Endereco</label>
                <div class="col-md-8">
                    <input id="Enderecoinput1" name="enderecoAdm" type="text" placeholder="Endereco" class="form-control input-md">

                </div>
            </div>

                   <!--Numero input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="cepinput1">Numero</label>
                <div class="col-md-8">
                    <input id="cepinput1" name="numeroAdm" type="number" placeholder="Numero" class="form-control input-md" required>
                </div>
            </div>


            <!-- Bairro input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Bairroinput1">Bairro</label>
                <div class="col-md-8">
                    <input id="Bairroinput1" name="bairroAdm" type="text" placeholder="Bairro" class="form-control input-md">

                </div>
            </div>


               <!-- Cidade input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Estadoinput1">Cidade</label>
                <div class="col-md-8">
                    <input id="Estadoinput1" name="cidadeAdm" type="text" placeholder="Cidade" class="form-control input-md">

                </div>
            </div>


               <!-- Estado input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Estadoinput1">Estado</label>
                <div class="col-md-8">
                    <input id="Estadoinput1" name="estadoAdm" type="text" placeholder="Estado" class="form-control input-md">

                </div>
            </div>


            <!-- País input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Paisinput1">Pais</label>
                <div class="col-md-8">
                    <input id="Paisinput1" name="paisAdm" type="text" placeholder="Pais" class="form-control input-md">

                </div>
            </div>



            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput1">Senha</label >
                <div class="col-md-8">
                    <input id="passwordinput1" name="senhaAdm" type="password" placeholder="Digite uma Senha" class="form-control input-md" required>

                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="button1id"></label>
                <div class="col-md-8">
                    <button type="submit" id="button3id" name="cadastro" value="salvar" class="btn btn-success"><i class="fa fa-floppy-o"></i> Salvar</button>
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

</body>

</html>
    