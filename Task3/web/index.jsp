<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27.06.2019
  Time: 4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <title>
    Menu
  </title>
    <body>
      <div>Choose parser: </br></br>
         <form action='serv' method='POST'>
           <select name = 'parser'>
             <option>DOM</option>
             <option>SAX</option>
             <option>StAX</option>
             <option>JAXB</option>
           </select></br></br>
       <input type='submit' value='load'/>
        </form>
      </div>
    </body>
</html>