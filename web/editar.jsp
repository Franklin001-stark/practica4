
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.emergentes.modelo.blog" %>
<% 
blog  libro= (blog)request.getAttribute("libro");
%>

<%
    if(session.getAttribute("logueado") != "ok")
    response.sendRedirect("login.jsp");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1><c:if test="${item == 0}">
                nuevo comentario
            </c:if>
         <c:if test="${item != 0}">
                editar comentario
            </c:if>
        </h1>
        <form action="MainControler" method="post">
            <table>
                <input type="hidden" name="id" value="${libro.id}">
               
                   
                    <input type="hidden" name="id_entrada" value="${libro.id_entrada}">
               
                <tr>
                    <td>fecha</td>
                    <td><input type="date" name="fecha" value="${libro.fecha}"></td>
            
            </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${libro.titulo}"></td>
            
            </tr>
            <tr>
                <td>Comentario</td>
               
                <td><textarea  type="text" name="comentario" value="${libro.comentario}" > </textarea> 
                              </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="enviar"></td>
            </tr>
            </table>
       
    </body>
</html>
