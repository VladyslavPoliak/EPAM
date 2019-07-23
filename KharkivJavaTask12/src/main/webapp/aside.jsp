<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-3 ">
            <form class="sticky-top p-2" action="${pageContext.request.contextPath}/search">
                <h3>Producers</h3>
                <tag:tagForCarProduсers producers="${MARKS_LIST}"/>

                <h3>Class</h3>
                <tag:tagForCarClass cl="${CLASSES_LIST}"/>

                <div class="form-group display">
                    <label>Price: </label>
                    <input type="number" class="input-number" name="minPrice" value="${searchForm.minPrice}">
                    <input type="number" class="input-number" name="maxPrice" value="${searchForm.maxPrice}">
                </div>

                <div class="form-group ">
                    <label for="search">Search for name</label>
                    <input type="text" class="input-number2" name="searchByName" id="search"
                           value="${searchForm.query}">
                </div>

                <tag:numberOfDisplayedCars/>

                <button type="submit" class="btn btn-primary">Search</button>
            </form>

        </div>
    </div>
</div>
