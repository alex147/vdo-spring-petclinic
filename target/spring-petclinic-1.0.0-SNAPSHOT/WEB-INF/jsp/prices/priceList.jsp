<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>

<html lang="en">


<jsp:include page="../fragments/headTag.jsp" />

<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<h2>Price list</h2>

		<datatables:table id="prices" data="${treatments}" cdn="true"
			row="treatment" theme="bootstrap2" cssClass="table table-striped"
			paginate="false" info="false">
			<datatables:column title="Id">
				<c:out value="${treatment.id}"></c:out>
			</datatables:column>
			<datatables:column title="Service">
				<c:out value="${treatment.name}"></c:out>
			</datatables:column>
			<datatables:column title="Price">
				<c:out value="${treatment.price}"></c:out>
			</datatables:column>
		</datatables:table>

		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
