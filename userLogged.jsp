<%@ page language="java" 
   contentType="text/html; charset=windows-1256"
   pageEncoding="windows-1256"
   import="javax.servlet.http.*,myPackage.*"
%>

<html>

   <head>
      <meta http-equiv="Content-Type" 
         content="text/html; charset=windows-1256">
      <title>Datos del Usuario</title>
   </head>
  <body>

     <center>
       <%UserBean hola=(UserBean) session.getAttribute("currentSessionUser");%>
       Bienvenido <%= hola.getFirstName()+" "+hola.getLastName() %>
     </center>

  </body>

</html>
