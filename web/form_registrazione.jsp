<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrazione</title>
    </head>
    <body>
            <form  method="get" action="<%=request.getContextPath() %>/RecUser">
                <fieldset>                    
                    <label for="uname">Nome Utente</label>
                    <input type="text" required name="uname" placeholder="nome"></br></br>
                    <label for="uemail">E-mail</label>
                    <input type="text" required name="uemail" placeholder="e-mail"></br></br>
                    <label for="upassword">Password</label>
                    <input type="password" required name="upassword" placeholder="password"></br></br>
                    <button type="submit">Registrati</button>
                </fieldset>
            </form>
    </body>
</html>
