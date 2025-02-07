<%@page import="com.project.local.jakartasimplewebapp.bean.Product"%>
<%@page import="com.project.local.jakartasimplewebapp.bean.CategoryList"%>
<%@page import="com.project.local.jakartasimplewebapp.bean.CategoryDrop"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html lang="it" dir="ltr">
   <head>
     <meta charset="utf-8">
     <title>Modifica</title>
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
<h1>Modifica prodotto</h1>
<form action="<%=request.getContextPath() %>/ModPro2" method="get">
    
  <fieldset>
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">    
    <label for="title">Inserisci nuovo titolo del prodotto:</label>
    <input type="text" id="title" name="title"></br></br>
    <label for="category">Categoria :
         <select name="category">
             <%
		List<CategoryDrop> categorieslistt = (List<CategoryDrop>) request.getAttribute("categoriesList");
                if (categorieslistt != null) {
		for (int i = 0; i < categorieslistt.size(); i++) {			
			%>
         <option value="<%=categorieslistt.get(i).getCode()%>"><%=categorieslistt.get(i).getCode()%></option>
         <%
			}
                    }
			%>
         </select></label><br/><br/>
    <label for="description">descrizione del prodotto:</label>
    <input type="text" id="description" name="description"></br></br>      
    <input type="submit" name="invia" value="Invia i miei dati">
    <input type="reset" name="reset" value="Azzera">
  </fieldset>
</form>
   </body>
 </html>
