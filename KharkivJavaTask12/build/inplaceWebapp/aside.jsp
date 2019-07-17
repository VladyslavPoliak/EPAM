<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="visible-xs-block xs-option-container">
    <a class="pull-right" data-toggle="collapse" href="#productCatalog">Product catalog <span class="caret"></span></a>
    <a data-toggle="collapse" href="#findProducts"><span class="caret"></span></a>
</div>
<!-- Search form -->
<form class="search" action="/search">
    <div id="findProducts" class="panel panel-success collapse">
        <div class="panel-heading"> ooo</div>
        <div class="panel-body">
            <div class="input-group">
                <input type="text" name="query" class="form-control" placeholder="ppppppppppppppppp">
                <span class="input-group-btn">
					<a id="goSearch" class="btn btn-default"></a>
				</span>
            </div>
            <div class="more-options">
                <a data-toggle="collapse" href="#searchOptions"><span class="caret"></span></a>
            </div>
        </div>
        <div id="searchOptions" class="collapse">
        jjj
        </div>
    </div>
</form>

<div id="productCatalog" class="panel panel-success collapse">
    jjjjjj
</div>
<!-- /Categories -->