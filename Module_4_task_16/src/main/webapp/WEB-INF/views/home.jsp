<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>

<html>
   <h1>Hello Spring MVC! (with Tiles)</h1>
   <body>
      <p> Current date is: <%= (new java.util.Date()).toLocaleString() %> </p>
   </body>
</html>