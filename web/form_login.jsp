<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <form  method="get" action="<%=request.getContextPath() %>/LogUser">
        <fieldset>
            <label for="uemail">E-mail</label>
            <input type="text" name="uemail" placeholder="e-mail">
            <label for="upassword">Password</label>
            <input type="password" name="upassword" placeholder="password">
            <input type="submit" name="login" value="accedi">
      </fieldset>
    </form>
    </body>
</html>
