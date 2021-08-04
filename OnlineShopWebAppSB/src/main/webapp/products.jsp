<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.phoenix.entities.Product" %>
 <%@page import="java.util.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

<%  HttpSession ss=request.getSession(false);
if(ss!=null) {%>
   
   <h2><marquee>Dear  <%= ss.getAttribute("user") %> ,Select products of your choice !</marquee></h2>
   
   <%List<Product> products=(List<Product>)ss.getAttribute("products");%>
   
    <table border="1" style="border:1px solid black;margin-left:auto;margin-right:auto;">
    <tr> 
    <th>ID</th>
    <th>Product Name</th>
    <th>Price</th>
    </tr>
    <%for(Product product:products) {%>
    <tr>
    <td><%=product.getId() %></td>
    <td><%=product.getName() %></td>
    <td><%=product.getPrice() %>
    
    </tr>
    <%} %>
    
    </table>
   
   
   <% }else{ %>
   <h2 style="color:red;">Sorry! your session is not </h2>
    <%  } %>
    
</body>
</html>