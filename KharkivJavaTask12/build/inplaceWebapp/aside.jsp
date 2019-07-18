<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-3 ">
            <form class="sticky-top p-2" action="main" method="GET">
                <h3>Producers</h3>
                <tag:tagForCarProduсers producers="${MARKS_LIST}"/>

                <div class="form-group">
                    <label for="exampleInputEmail1">Min price</label>
                    <input type="number" class="input-number" name="minPrice" id="exampleInputEmail1">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Max price</label>
                    <input type="number" class="input-number" name="maxPrice" id="exampleInputPassword1">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Search for name</label>
                    <input type="text" class="input-number2" name="searchByName" id="exampleInputPassword12">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <div class="dropdown show">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Select car class</a>
                <tag:tagForCarClass cl="${CLASSES_LIST}"/>
            </div>

        </div>
    </div>
</div>