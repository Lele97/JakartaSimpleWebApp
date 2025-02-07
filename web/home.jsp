<%@page import="com.project.local.jakartasimplewebapp.bean.Login"%>
<%@page import="com.project.local.jakartasimplewebapp.bean.LoginUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>

<%
    String uemail = null; 
    if (session.getAttribute("uemail") == null){
        response.sendRedirect("index.jsp");
    }else{ 
        uemail =(String) session.getAttribute("uemail");}
%>
        <p><h1>Benvenuto : ${uemail} </h1><p>

    <h3>Pannello di amministrazione</h3>
    <h4>Gestione Categorie</h4>
    <ul>
        <li><a href="<%=request.getContextPath() %>/vistaCategoria">Visuallizza</a></li>
        <li><a href ="<%=request.getContextPath() %>/InserisciCa">Nuovo</a></li>
    </ul>
    <h4>Gestione Prodotti</h4>
    <ul>
        <li><a href="<%=request.getContextPath() %>/vistaProdotto">Visualizza</a></li>
        <li><a href="<%=request.getContextPath() %>/InserisciPro">Nuovo</a></li>
    </ul>

</body>
</html>
