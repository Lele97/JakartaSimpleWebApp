<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Benvenuto | Azienda Informatica</title>
    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #141e30, #243b55);
            color: #ffffff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.4);
            text-align: center;
            width: 100%;
            max-width: 400px;
            backdrop-filter: blur(10px);
        }

        h2 {
            margin-bottom: 25px;
            font-size: 28px;
            font-weight: 600;
        }

        .button {
            display: inline-block;
            margin: 15px 0;
            padding: 15px 25px;
            font-size: 16px;
            color: white;
            background: #007bff;
            text-decoration: none;
            border-radius: 8px;
            transition: background 0.3s ease, transform 0.2s ease;
            width: 100%;
            max-width: 250px;
        }

        .button:hover {
            background: #0056b3;
            transform: translateY(-2px);
        }

        .button:active {
            transform: translateY(0);
        }

        /* Responsive Design */
        @media (max-width: 480px) {
            .container {
                padding: 20px;
            }

            h2 {
                font-size: 24px;
            }

            .button {
                padding: 12px 20px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Benvenuto nella nostra Azienda Informatica</h2>
        <a class="button" href="<%=request.getContextPath() %>/form_login.jsp">Accedi</a>
        <a class="button" href="<%=request.getContextPath() %>/form_registrazione.jsp">Registrati</a>
    </div>
</body>
</html>