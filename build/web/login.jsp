

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .s{
                text-align: center;
               margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <div style="text-aling:center;">
        <table class="s">
             <form action="LoginControlador" method="post">
            
            <tr>
                <td colspan="2"><h1>login</h1></td>
                
            </tr>
            <tr>
                <td>
            <label>usuario</label></td>
                <td> <input type="text" name="usuario"></td>
            </tr>
            <tr>
                <td><label>Password</label></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="ingresar"></td>
                
            </tr>
                   </form>
 
        </table>
        
   </div>
       
           
          
    </body>
</html>
