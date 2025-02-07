<%@page import="com.project.local.jakartasimplewebapp.bean.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>Inserisci</title>
  <link href="" type="text/css" rel="stylesheet"/>
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
    <h1>Form d'inserimento categorie</h1>
<h3> Inserisci una nuova categoria da registrare</h3>
<form action="<%=request.getContextPath() %>/InsCa2" method="get">
  <fieldset>
    
    <label for="code">Codice :</label>
    <input type="text" id="code" name="codice" placeholder="Inserisci codice categoria"></br></br>
    <label for="description">Descrizione :</label>
    <input type="text" id="description" name="descrizione" placeholder="Inserisci descrizione categoria"></br></br>
    <input type="submit" name="invia" value="invia i miei dati">
    <input type="reset" name="reset" value="Azzera">

    </fieldset>
  </form>
</body>
</html>
