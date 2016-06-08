<%@page import="com.infopower.controladores.ControladorAdmin"%>
<%@page import="com.infopower.entidades.Administrador"%>
<%@page import="com.infopower.entidades.Cliente"%>
<%@page import="com.infopower.controladores.ControladorCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
<title>Detalhamento de Usuarios</title>

<!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">


	<link rel="stylesheet" href="../css/style.css">

  <link href="../css/admin.css" rel="stylesheet" >
  
  <!-- BOOTSTRAP STYLES-->
    <link href="../css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="../css/custom.css" rel="stylesheet" />

 <link href="../css/admin.css rel="stylesheet">



     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
   <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
      
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
    
    
<!------------------- CONDICAO PARA ID USUARIO E PANEL DE INFORMACAO USUARIO --------------------------------->


<%if(request.getParameter("id") != null){
			int id = Integer.parseInt(request.getParameter("id"));
	
			ControladorCliente controlecliente = new ControladorCliente();
	
			Cliente cliente = controlecliente.procurarId(id);	
			%>
			
			
      <div class="panel panel-success">
      
      <div class="panel-heading">Painel Usuario Informações</div>
      
	<div class="panel-body">
	
			
			  <table border="1" class="table table-bordered">

<tr class="linha_listar" bgcolor="#EAEAEA">
	<th>ID</th> <th>Nome</th> <th>Login</th> <th>Telefone</th> <th>Logradouro</th><th>Numero</th><th>Bairro</th>
	<th>Cidade</th><th>Estado</th><th>Pais</th>
</tr>
			
			
			
			<tr>
			<td><%=cliente.getId()%></td>
			 <td><%=cliente.getNome()%></td>
			 <td><%=cliente.getLogin()%></td>
			 <td><%=cliente.getTelefone()%></td>
			<td><%=cliente.getLogradouro()%></td>
			<td><%=cliente.getNumero()%></td>
			<td><%=cliente.getBairro()%></td>
			<td><%=cliente.getCidade()%></td>
			<td><%=cliente.getEstado()%></td>
			<td><%=cliente.getPais()%></td>
			</tr>
			
				</div>
				</div>
	</div>
	</table>
	
	
<!----------------------- CONDICAO E PANEL DE INFORMACAO DE ADMINS -------------------------->
			
		<%}else if(request.getParameter("matricula") != null){
			int matricula = Integer.parseInt(request.getParameter("matricula"));
			ControladorAdmin controlerAdmin = new ControladorAdmin();
			Administrador administrador = controlerAdmin.procurar(matricula);
			%>
			
			
			
      <div class="panel panel-danger">
      
      <div class="panel-heading">Painel Administradores Informações</div>
      <div class="panel-body">
			
			  <table border="1" class="table table-bordered">
			
			<tr class="linha_listar" bgcolor="#EAEAEA">
	<th>Matricula</th> <th>Nome</th> <th>Login</th> <th>Telefone</th> <th>Logradouro</th><th>Numero</th><th>Bairro</th>
	<th>Cidade</th><th>Estado</th><th>Pais</th>
</tr>
			
			
			<tr>
			<td><%=administrador.getMatricula()%></td>
			 <td><%=administrador.getNome()%></td>
			 <td><%=administrador.getLogin()%></td>
			 <td> <%=administrador.getTelefone()%></td>
			 <td><%=administrador.getLogradouro()%></td>
			<td> <%=administrador.getNumero()%></td>
			<td> <%=administrador.getBairro()%></td>
			<td> <%=administrador.getCidade()%></td>
			 <td><%=administrador.getEstado()%></td>
			 <td><%=administrador.getPais()%></td>
			 </tr>

</div>
</div>

</div>
</table>


<%

}

%>



	     

</body>

</html>