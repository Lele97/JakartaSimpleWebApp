<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Benvenuto | Azienda Informatica</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #141e30, #243b55);
            color: #ffffff;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            text-align: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
            width: 400px;
        }
        h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }
        p {
            font-size: 14px;
            margin-bottom: 15px;
        }
        .button {
            display: inline-block;
            margin: 10px 0;
            padding: 12px 20px;
            font-size: 16px;
            color: white;
            background: #007bff;
            text-decoration: none;
            border-radius: 5px;
            transition: 0.3s;
        }
        .button:hover {
            background: #0056b3;
        }
        .footer {
            margin-top: 20px;
            font-size: 14px;
        }
        .footer a {
            color: #ffffff;
            text-decoration: none;
            margin: 0 10px;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Benvenuto nella nostra Azienda Informatica</h2>
        <p>Forniamo soluzioni digitali avanzate per il tuo business. Scopri i nostri servizi e unisciti a noi oggi stesso.</p>
        <a class="button" href="<%=request.getContextPath() %>/form_login.jsp">Accedi</a>
        <br>
        <a class="button" href="<%=request.getContextPath() %>/form_registrazione.jsp">Registrati</a>
    </div>

    <div class="footer">
        <a href="#">Chi Siamo</a>
        <a href="#">Servizi</a>
        <a href="#">Blog</a>
        <a href="#">Privacy Policy</a>
        <a href="#">Contatti</a>
    </div>
</body>
</html>
