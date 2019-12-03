<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <title>Ninja Gold</title>
    
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
</head>
<body>
<div class="container col-10">
    <div class="row">
        <h3 class="mt-5">Your Gold: <c:out value="${total}" /></h3>
        <form action="/clear" method="POST" class="reset">
            <input class="mt-5" type="submit" name="submit" value="Reset gold" />
        </form>
    </div>
    <div class="row">
        <div class="place">
            <h3>Farm</h3>
            <p>(earns 10-20 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="farm"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>Cave</h3>
            <p>(earns 5-10 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="cave"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>House</h3>
            <p>(earns 2-5 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="house"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="place">
            <h3>Casino</h3>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="hidden" value="casino"/>
                <input type="submit" name="submit" value="Find Gold!"/>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="activities" align="center">
            <h3>Activities:</h3>
            <ul>
               	<c:forEach var="activity" items="${ activities }">
               	<c:choose>
               		<c:when test="${ activity.startsWith('You earned') }">
                		<li class="text-success"><c:out value="${activity}"/></li>
                	</c:when>
                	<c:otherwise>
                		<li class="text-danger"><c:out value="${activity}"/></li>
                	</c:otherwise>
                </c:choose>	
                </c:forEach>
            </ul>
        </div>
    </div>
    </div>
</body>
</html>