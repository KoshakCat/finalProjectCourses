<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
<H1>Welcome ${name}</H1>
<p><font color="red">${errorMessage}</font></p>

<table class="table table-striped">
    <caption>Accessible editions</caption>
    <thead>
    			<th>Name</th>
    			<th>Type</th>
    			<th>Cost</th>
    			<th>Circulation</th>
    			<th>Actions</th>
    </thead>
    <tbody>
        <c:forEach items="${editions}" var="edition">
            <tr>
                <td>${edition.editionName}</td>
                <td>${edition.editionType}</td>
                <td>${edition.subscriptionCost}</td>
                <td>${edition.circulation}</td>
                <td>&nbsp;&nbsp&nbsp&nbsp;
                    <a class="btn btn-danger" href="/delete-edition?edition=${edition.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a class="btn btn-success" href="/add-edition">Add New Edition</a>
</div>

<%@ include file="../common/footer.jspf"%>