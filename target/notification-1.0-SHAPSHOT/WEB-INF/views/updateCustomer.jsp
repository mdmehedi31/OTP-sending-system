<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/22/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>
    

      <%--@elvariable id="customer" type="com.nf.entity"--%>
      <form:form action="${pageContext.request.contextPath}/updateCustomer" method="post"
                 modelAttribute="customer">
        <table>

            <tr>

                <td>
                    <input type="text" name="customerId" value="${customer.customerId}" style="display:none">
                </td>
            </tr>
           <tr>
             <td>Name: </td>
             <td>
                <input type="text" name="name" value="${customer.name}">
             </td>
           </tr>

          <tr>
            <td>Email: </td>
            <td>
              <input type="text" name="email" value="${customer.email}">
            </td>
          </tr>

          <tr>
            <td>Customer Details: </td>
            <td>
              <input type="text" name="customerDetails" value="${customer.customerDetails}">
            </td>
          </tr>
          <tr>
            <td>
              <input type="submit" value="Update">
            </td>
          </tr>
        </table>


      </form:form>
</body>
</html>
