<%@page import="com.project.local.jakartasimplewebapp.bean.CategoryID"%>
<%@page import="com.project.local.jakartasimplewebapp.servlet.ModificaCa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista</title>
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
	<h2>Elenco Categorie</h2>

	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link active"
			href="<%=request.getContextPath()%>/Home">Home</a></li>
	</ul>

	<input class="form-control me-sm-2" type="text" placeholder="Search">
	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>



	<h3>Elenco Categorie</h3>
	<table id='categories' >
		<thead>
			<tr>	
                                <th>ID</th>
				<th>Codice</th>
				<th>Descrizione</th>
				<th>Modifica</th>
				<th>Elimina</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<CategoryID> categoriess = (List<CategoryID>) request.getAttribute("categories");
                        if (categoriess != null) {
			for (int i = 0; i < categoriess.size(); i++) {

				System.out.println(categoriess.get(i));
			%>
			<tr>
                                <td><%=categoriess.get(i).getId()%></td>
				<td><%=categoriess.get(i).getCode()%></td>
				<td><%=categoriess.get(i).getDescription()%></td>
				<td><a href="<%=request.getContextPath() %>/ModCa?id=<%=categoriess.get(i).getId()%>">modifica</a></td>
				<td><a href="<%=request.getContextPath() %>/DelCa?id=<%=categoriess.get(i).getId()%>">elimina</a></td>
			</tr>
			<%
			}
                    }
			%>
		</tbody>
	</table>
	

</body>
</html>
