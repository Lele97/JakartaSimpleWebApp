<%@page import="com.project.local.jakartasimplewebapp.bean.Login"%>
<%@page import="com.project.local.jakartasimplewebapp.bean.LoginUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | Azienda Informatica</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #141e30, #243b55);
            color: #ffffff;
            text-align: center;
            margin: 0;
            padding: 50px;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
            display: inline-block;
            text-align: left;
            width: 60%;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin: 10px 0;
        }
        a {
            color: white;
            text-decoration: none;
            background: #007bff;
            padding: 10px 15px;
            border-radius: 5px;
            display: inline-block;
            transition: 0.3s;
        }
        a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>

<%
    String uemail = null;
    if (session.getAttribute("uemail") == null){
        response.sendRedirect("index.jsp");
    } else {
        uemail = (String) session.getAttribute("uemail");
    }
%>

    <div class="container">
        <h1>Benvenuto, <%= uemail %>!</h1>

        <h3>Pannello di amministrazione</h3>
        <h4>Gestione Categorie</h4>
        <ul>
            <li><a href="<%=request.getContextPath() %>/vistaCategoria">Visualizza</a></li>
            <li><a href ="<%=request.getContextPath() %>/InserisciCa">Nuovo</a></li>
        </ul>
        <h4>Gestione Prodotti</h4>
        <ul>
            <li><a href="<%=request.getContextPath() %>/vistaProdotto">Visualizza</a></li>
            <li><a href="<%=request.getContextPath() %>/InserisciPro">Nuovo</a></li>
        </ul>
    </div>

</body>
</html>
