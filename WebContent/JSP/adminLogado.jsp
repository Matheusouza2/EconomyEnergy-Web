<%@page import="javax.websocket.SendResult"%>
<%@page import="org.apache.catalina.ha.backend.Sender"%>
<%@page import="com.infopower.entidades.Administrador"%>
<%@page import="com.infopower.controladores.ControladorAdmin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.infopower.entidades.Cliente"%>
<%@ page import="java.util.List"%>
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

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/admin.css" rel="stylesheet">

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
                        <h1>Painel de Controle Administrador</h1>
                        <p>Cadastre,Atualize,Exclua e Visualize Clientes,Administradores e Tarifas</p>
                        <p>Consulte a qualquer momento</code>.</p>
                        


                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    
     <!-- Modal -->

    <div class="modal fade"  id="myModal" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <div class ="alert-success">  <h4 class="modal-title">Cadastrado com Sucesso</h4></div>
                </div>

                <div class="modal-footer">
                	<a href="adminLogado.jsp" class="btn btn-success btn-sm" data-dismiss="modal">OK</a>

                </div>
            </div>
        </div>
    </div>
</div>

	 <!-- Modal -->

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
