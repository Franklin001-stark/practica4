<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.blog" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<blog> lista = (List<blog>)request.getAttribute("lista");
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
        <style type="text/css">
            .c{
             width: 80%; 
             margin-left: 50px;
             
            }
            a.ci{
                text-align: center;
                 margin-left: 80%;
            }
            h2.e{
                text-align: center;
            }
            a.cii{
                text-align: center;
                 margin-left: 80%;
            }
            
        </style>
    </head>
    <body>
      <a class="cii">Usuario: ${sessionScope.usuario}</a> <a href="LoginControlador?action=logout">Salir [x]</a>
        <h2 class="e" >Blog de salud</h2>
        
       
        <form class="c">
            <p><a href="MainControler?op=nuevo">Nuevo Comentario</a> </p>
             
            
            <c:forEach var="item" items="${lista}">
                
                    
                   ${item.fecha} <br>
                <h2 >${item.titulo}</h2> <br>
                     ${item.comentario} <br>
           
            
                
                     <a>Autor: </a>
                     <a class="ci" href="MainControler?op=editar&id=${item.id}">Editar</a>
                
                    <a   href="MainControler?op=eliminar&id=${item.id}" onclick="confirm('Esta seguro??')">Eliminar</a>
             <br>
                     <hr />
             
                 
            </c:forEach>
          
       </form>
       
    </body>
</html>
