<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.infopower.entidades.Cliente"%>
    <%@ page import="com.infopower.entidades.Endereco"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lista de Clientes</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/templatemo_misc.css">
        <link rel="stylesheet" href="css/templatemo_style.css">
    <link rel="stylesheet" href="css/templatemo_style.css">
     <link rel="stylesheet" href="css/estilocadastro.css">

    <script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<h3 class="widget-title" align="center">Listar Usuário</h3>
<div class = "container">
     <table border="1" class="tabela_listar">

<tr class="linha_listar" bgcolor="#EAEAEA">
	<th class="coluna_listar">ID</th> <th>NOME</th> <th>LOGIN</th> <th>SENHA</th> <th>TELEFONE</th><th>BAIRRO</th>
</tr>

<%
//Scriptlet
List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
List<Endereco> lista2 = (List<Endereco>) request.getAttribute("lista");

for(Cliente cliente : lista){
	%>
		<tr>
			<td class="coluna_listar"><% out.print(cliente.getId()); %></td>
			<td class="coluna_listar"><% out.print(cliente.getNome()); %></td>
			<td class="coluna_listar"><% out.print(cliente.getLogin()); %></td>
			<td class="coluna_listar"><% out.print(cliente.getSenha()); %></td>
			<td class="coluna_listar"><% out.print(cliente.getTelefone()); %></td>
			<td class="coluna_listar"><% out.print(cliente.getBairro());%></td>
		
		</tr>
<%}%>

</table>
</div>

       <!-------------------FORMULARIO -------------------------->


       

</body>
</html>