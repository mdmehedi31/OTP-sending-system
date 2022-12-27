<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <div>


     <form:form action="${pageContext.request.contextPath}views/sendOtp" method="post">
         <table align="center">
             <tr>
                 <td colspan="2">
                     <h3>SEND OTP</h3>
                 </td>
             </tr>
             <tr>
                 <td>
                     OTP Type
                 </td>
                 <td>
                   <select>
                       <option></option>
                   </select>
                 </td>
             </tr>
             <tr>
                 <td>
                     Email/SMS
                 </td>
                 <td>
                    <%-- <form:input &lt;%&ndash;path=""&ndash;%&gt;></form:input>--%>
                     <input type="text">
                 </td>
             </tr>
             <tr>
                 <td>
                     <input type="submit" value="Send">
                 </td>
             </tr>
         </table>


     </form:form>

 </div>

</body>
</html>
