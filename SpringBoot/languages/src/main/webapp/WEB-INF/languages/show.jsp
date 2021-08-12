<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<a href="/languages">Dashboard</a>
<h2><c:out value="${language.name}"/></h2>
<h2><c:out value="${language.creator}"/></h2>
<h2><c:out value="${language.version}"/></h2>

<a href="/languages/${language.id}/edit">Edit</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

