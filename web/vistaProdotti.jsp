<%@page import="com.project.local.jakartasimplewebapp.bean.ProductID"%>
<%@page import="com.project.local.jakartasimplewebapp.bean.ProductsDAO"%>
<%@page import="com.project.local.jakartasimplewebapp.servlet.ModificaPro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
	<h2>Elenco Prodotti</h2>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav me-auto">
			<li class="nav-item"><a class="nav-link active"
				href="<%=request.getContextPath() %>/Home">Home</a></li>
		</ul>
		<form class="d-flex">
			<input class="form-control me-sm-2" type="text" placeholder="Search">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			<h3>Elenco Prodotti</h3>

			<table id='prodotti'>
				<thead>
					<tr>						
						<th>Titolo</th>
						<th>Categoria</th>
						<th>Descrizione</th>
						<th>Modifica</th>
						<th>Elimina</th>
					</tr>
				</thead>
				<tbody>
					<%
			List<ProductID> productss = (List<ProductID>) request.getAttribute("products");
                        if (productss != null) {
			for (int i = 0; i < productss.size(); i++) {

				System.out.println(productss.get(i));
			%>
			<tr>
				<td><%=productss.get(i).getId()%></td>
				<td><%=productss.get(i).getTitle()%></td>
				<td><%=productss.get(i).getCategory()%></td>
				<td><%=productss.get(i).getDescription()%></td>
				<td><a
					href="<%=request.getContextPath() %>/ModPro?id=<%=productss.get(i).getId()%>">modifica</a></td>
				<td><a
					href="<%=request.getContextPath() %>/DelPro?id=<%=productss.get(i).getId()%>">elimina</a></td>
			</tr>
			<%
			}
                    }
			%>
				</tbody>
			</table>
	

	</form>
	</div>
</body>
</html>
