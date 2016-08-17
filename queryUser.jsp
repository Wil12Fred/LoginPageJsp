<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
  <title>Ingrese el Usuario</title>
</head>
<body>
  <form method="get" action="http://localhost:9999/hello/query">
      Username
      <input type="text" name="un"/><br>    

      Password
      <input type="password" name="pw"/>

      <input type="submit" value="submit">  
  </form>
</body>
</html>
