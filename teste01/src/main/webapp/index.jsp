<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<body>
<h2>Teste 01 
<%
   Date date = new Date();
   out.print( "<h2 align=\"center\">" +date.toString()+"</h2>");
%></h2>
</body>
</html>