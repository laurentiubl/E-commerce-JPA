<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/newProduct" method="post"
                   modelAttribute="pr">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="name" cssStyle="color: #ff0000;" />
            							   
            <form:input path="name" id="name" class="form-Control"/>
        </div>

       

        <div class="form-group">
            <label for="description">Description</label> <form:errors path="brand" cssStyle="color: #ff0000;" />
            <form:textarea path="brand" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label> <form:errors path="price" cssStyle="color: #ff0000;" />
            <form:input path="price" id="price" class="form-Control"/>
        </div>

  


        <div class="form-group">
            <label for="manufacturer">Manufacturer</label> <form:errors path="madein" cssStyle="color: #ff0000;" />
            <form:input path="madein" id="manufacturer" class="form-Control"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory/newProduct" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>