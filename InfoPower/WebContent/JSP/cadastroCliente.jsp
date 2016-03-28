<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário Cadastro</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/font-awesome.css">
        <link rel="stylesheet" href="../css/animate.css">
        <link rel="stylesheet" href="../css/templatemo_misc.css">
        <link rel="stylesheet" href="../css/templatemo_style.css">
    <link rel="stylesheet" href="../css/templatemo_style.css">
     <link rel="stylesheet" href="../css/estilocadastro.css">

    <script src="js/bootstrap.min.js"></script>
</head>
<body>



<div class="site-header">
    <div class="container">
        <div class="main-header">
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-10">


                </div> <!-- /.coluna-md-4 -->
                <div class="col-md-8 col-sm-6 col-xs-2">
                    <div class="main-menu">
                        <ul class="visible-lg visible-md">
                            <li><a href="inicio.html">Inicio</a></li>

                            <li ><a href="sobre.html">Sobre</a></li>
                            <li><a href="contato.html">Contato</a></li>
                        </ul>
                        <a href="#" class="toggle-menu visible-sm visible-xs">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div> <!-- /.main-menu -->
                </div> <!-- /.coluna-md-8 -->
            </div> <!-- /.row -->
        </div> <!-- /.main-header -->
        <div class="row">
            <div class="col-md-12 visible-sm visible-xs">
                <div class="menu-responsive">
                    <ul>
                        <li><a href="inicio.html">Inicio</a></li>

                        <li ><a href="sobre.html">Sobre</a></li>
                        <li><a href="contato.html">Contato</a></li>
                    </ul>
                </div> <!-- /.menu-responsive -->
            </div> <!-- /.coluna-md-12 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</div> <!-- /.site-header -->

<div class="page-top" id="templatemo_sobre">
</div> 



       <!-------------------FORMULARIO  usuario -------------------------->

<div class="col-md-5 col-sm-5">

<form class="form-horizontal" action="/InfoPower/ClienteServlet" method="post">
    <fieldset>

<!-- Form Name -->
<h3 class="widget-title">Cadastro Cliente</h3>



            <!-- Nome input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Nomeinput">Nome Cliente</label>
                <div class="col-md-8">

                    <input id="Nomeinput" name="nomeUser" type="text" placeholder="Seu Usuario" class="form-control input-md">

                </div>
            </div>
            <!-- Login input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Logininput">Login Cliente</label>
                <div class="col-md-8">

                    <input id="Nomeinput" name="loginUser" type="text" placeholder="Seu Login" class="form-control input-md">

                </div>
            </div>

            <!-- Telefone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Telefoneinput">Telefone</label>
                <div class="col-md-8">
                    <input id="Telefoneinput" name="telefoneUser"  placeholder="0 0000-0000" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Enderecoinput">Endereço</label>
                <div class="col-md-8">
                    <input id="Enderecoinput" name="enderecoUser" type="text" placeholder="Endereço" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Bairroinput">Bairro</label>
                <div class="col-md-8">
                    <input id="Bairroinput" name="bairroUser" type="text" placeholder="Bairro" class="form-control input-md">

                </div>
            </div>

                   <!--CEP input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="cepinput">CEP</label>
                <div class="col-md-8">

                    <input id="cepinput" name="cepUser" type="number" placeholder="Cep usuário" class="form-control input-md">

                </div>
            </div>

                    

                    <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Estadoinput">Estado</label>
                <div class="col-md-8">
                    <input id="Estadoinput" name="estadoUser" type="text" placeholder="Estado" class="form-control input-md">

                </div>
            </div>

      <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Paisinput">País</label>
                <div class="col-md-8">
                    <input id="Paisinput" name="paisUser" type="text" placeholder="Pais" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Senha</label>
                <div class="col-md-8">
                    <input id="passwordinput" name="senhaUser" type="password" placeholder="Digite uma Senha" class="form-control input-md">

                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="button1id"></label>
                <div class="col-md-8">
                    <button type="submit" id="button1id" name="button1id" class="btn btn-success">Salvar</button>
                    <button type="reset" id="button2id" name="button2id" class="btn btn-danger">Cancelar</button>
                </div>
            </div>

    </fieldset>
</form>


</div>
        </div>

    </fieldset>
</form>


       <!-------------------FORMULARIO -------------------------->

        </div>

    </fieldset>
</form>


</body>
</html>