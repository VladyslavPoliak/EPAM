<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8" %>

<div class="dropdown show">
    <form action="${pageContext.request.contextPath}${currentServlet}">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
            Display
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <button class="dropdown-item btn btn-primary"
                    type="submit" value="9" name="count-cars">9</button>
            <button class="dropdown-item btn btn-primary"
                    type="submit" value="12" name="count-cars">12</button>
            <button class="dropdown-item btn btn-primary"
                    type="submit" value="15" name="count-cars">15</button>
        </div>
    </form>
</div>