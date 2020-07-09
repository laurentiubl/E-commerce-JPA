<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


 

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${listProductss}" var="productt">
                <tr>
                    <td><img src="#" alt="image"/></td>
                    <td>${productt.name}</td>
                    <td>${productt.brand}</td>
                    <td>${productt.madein}</td>
                    <td>${productt.price} USD</td>
                      <td><a href="<spring:url value="/produse/viewPr/${productt.id}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
        </table>

 <div class=" ult-main-seperator-inner">
 
 <svg class="uvc-tilt-left-seperator" version= "1.1" fill="#FF0000" width="100%" height="60" viewbox="0 0 4 0.266661" preserveAspectRatio="none"
   style="height: 60px;" >
  <polygon class="fil0"  points="4,0 4,0.266661 -0,0.266661" />
</svg>
 
 </div>
  



<%@include file="/WEB-INF/views/template/footer.jsp" %>