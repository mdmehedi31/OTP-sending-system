<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #showList{
            border: 1px solid black;
            border-radius: 10px;
        }
        #listHead{
            background-color: darkcyan;
        }
    </style>
</head>
<body>

        <div align="center" class="container">
            <%--@elvariable id="addCustomerDto" type="com.nf.dto.AddCustomerDto"--%>
            <form:form action="${pageContext.request.contextPath}views/addCustomer" modelAttribute="addCustomerDto" method="post">

                <table>
                    <tr>
                        <td colspan="2">
                            <h3>Add Customer</h3>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Customer Name:
                        </td>
                        <td>
                            <form:input type="text" cssClass="form-control" id="name" placeholder="Name" path="name"></form:input>
                        </td>
                    </tr>

                    <tr>
                        <td>Email: </td>
                        <td>
                            <form:input type="text" cssClass="form-control" id="email" placeholder="email" path="email"></form:input>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Customer Details:
                        </td>
                        <td>
                            <form:textarea type="text" cssClass="form-control" id="customerDetails" placeholder="customer details" path="customerDetails"></form:textarea>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Add">
                        </td>
                    </tr>
                </table>

            </form:form>
        </div>
        <div>
        <table id="showList" class="table table-striped table-hover">
            <thead id="listHead">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Operation</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${listCustomer}"  varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="<c:url value="/writeEmail/${customer.customerId}"/>" class="btn btn-success">Send Email</a>
                        <a href="<c:url value="/viewCustomer/${customer.customerId}"/>" class="btn btn-success">Views</a>
                        <a href="<c:url value="/editCustomer/${customer.customerId}"/>" class="btn btn-success">Update</a>
                        <a href="<c:url value="/deleteCustomer/${customer.customerId}"/>" class="btn btn-danger">DELETE</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
</body>
</html>
