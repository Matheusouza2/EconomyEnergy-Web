<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.infopower.entidades.Cliente"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
        <title>Economy Energy</title>
        <meta name="description" content="">
<!--
Travel Template criado por
http://www.templatemo.com/tm-409-travel

e Modificado para estudos academicos : InfoPower
-->
        <meta name="viewport" content="width=device-width">
		<meta name="author" content="A-Team">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600,300' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/templatemo_misc.css">
        <link rel="stylesheet" href="css/templatemo_style.css">
        <link rel="stylesheet" href="css/estilo.css">

        <script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<!--[caso for IE 7]>
            <p class="chromeframe">Você esta usando um navegador desatualizado. <a href="http://google.com/">Atualize seu browser agora</a> ou <a href="http://www.google.com/chromeframe/?redirect=true">instale Google Chrome Frame</a> Para uma melhor experiência no nosso site.</p>
        <![endif]-->

   


        <!--logo da empresa local superior lado esquerdo do site -->
        <div class="site-header">
            <div class="container">
                <div class="main-header">
                    <div class="row">
                        <div class="col-md-4 col-sm-6 col-xs-10">

                        </div> <!-- /.col-md-4 -->

                        <!--menu de botoes do site -->

                        <div class="col-md-8 col-sm-6 col-xs-2">
                            <div class="main-menu">
                                <ul class="visible-lg visible-md">
                                    <li class="active"><a href="index.jsp">Inicio</a></li>
                                    <li><a href="sobre.html">sobre</a></li>
                                    <li><a href="contato.html">Contato</a></li>

                                </ul>
                      <!--  login Modal usuário-->
                                <a href="#" data-toggle="modal" data-target="#login-modal-usuario">Usuario  / </a>

                                <div class="modal fade" id="login-modal-usuario" tabindex="-1" role="dialog" aria-labelledby="meuModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog">
                                        <div class="loginmodal-container">
                                            <h1>Sua Conta de Usuário</h1><br>
                                            <form method="post" action="/InfoPower/AutenticadorCliente">
                                                <input type="text" name="user" placeholder="Nome Login">
                                                <input type="password" name="pass" placeholder="Senha">
                                                <input type="submit" name="loginusuario" class="login loginmodal-submit" value="Logar Usuario">
                                            </form>

                                                <div class="modal-footer">

                                                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">Fechar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                              <!-- Fim login usuario-->


                                <!-- Inicio Login Modal Administrador -->

                                <a href="#" data-toggle="modal" data-target="#login-modal-admin">Administrador</a>

                                <div class="modal fade" id="login-modal-admin" tabindex="-1" role="dialog" aria-labelledby="meuModalLabel" aria-hidden="true" style="display: none;">
                                    <div class="modal-dialog">
                                        <div class="loginmodal-container">
                                            <h1>Login Administrador</h1><br>
                                            <form method="post" action="/InfoPower/AutenticadorAdministrador">
                                                <input type="text" name="admin" placeholder="Administrador">
                                                <input type="password" name="pass2" placeholder="Senha">
                                                <input type="submit" name="loginadmin" class="login loginmodal-submit" value="Logar Admin">
                                            </form>

                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">Fechar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                     <!---------------------- fim login modal administrador--------------------------------------->


                                <a href="#" class="toggle-menu visible-sm visible-xs">
                                    <i class="fa fa-bars"></i>
                                </a>
                            </div> <!-- /menu principal-->
                        </div> <!-- /.col-md-8 -->
                    </div> <!-- /.row -->
                </div> <!-- /Cabeçalho Principal -->
                   


                <div class="row">
                    <div class="col-md-12 visible-sm visible-xs">
                        <div class="menu-responsive">
                            <ul>
                        <li class="active"><a href="inicio.html">Inicio</a></li>
                                <li><a href="sobre.html">Sobre</a></li>
                                <li><a href="contato.html">Contato</a></li>
                            </ul>
                        </div> <!-- /.menu-responsive -->
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
            </div> <!-- /.recipiente -->
        </div> <!-- /.site cabeçalho -->


        <div class="flexslider">
            <ul class="slides">
                <li>
                    <div class="overlay"></div>
                    <img src="images/energy.jpg" alt="Special 1"/>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5 col-lg-4">
                                <div class="flex-caption visible-lg">

                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="overlay"></div>
                    <img src="images/imagem2.gif" alt="Special 2">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5 col-lg-4">
                                <div class="flex-caption visible-lg">


                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="overlay"></div>
                    <img src="images/Energia.jpg" alt="Special 3">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5 col-lg-4">
                                <div class="flex-caption visible-lg">

                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div> <!-- /.Slider -->





		<div class="middle-content"></div>

        <div class="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-4">
                        <div class="footer-logo">
                            <a href="inicio.html">
                                <img src="images/IMAGEM.jpg" alt="">
                            </a>
                        </div>
                    </div> <!-- /.col-md-4 -->
                    <div class="col-md-4 col-sm-4">
                        <div class="copyright">
                            <span>
                                Desenvolvido Por &copy; 2016 <a href="#">InfoPower</a>
                            

                            
                            </span>
                        </div>
                    </div> <!-- /.col-md-4 -->
                    <div class="col-md-4 col-sm-4">
                        <ul class="social-icons">
                            <li><a href="#" class="fa fa-facebook"></a></li>
                            <li><a href="#" class="fa fa-twitter"></a></li>

                        </ul>
                    </div> <!-- /.col-md-4 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /.site-footer -->

        <script src="js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="js/bootstrap.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
        <!-- templatemo 409 travel -->  

</body>
</html>