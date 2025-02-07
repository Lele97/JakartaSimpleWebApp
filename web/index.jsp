<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>

  <h3>Accedi</h3>  
  <ul>
      <li><a href="<%=request.getContextPath() %>/form_login.jsp">Accedi</a></li>    
  </ul>
  <h3>Registrati</h3>
  <ul>    
    <li><a href="<%=request.getContextPath() %>/form_registrazione.jsp">Registrati</a></li>
  </ul>

  </body>
</html>
