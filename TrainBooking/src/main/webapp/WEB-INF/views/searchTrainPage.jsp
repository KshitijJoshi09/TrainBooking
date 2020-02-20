<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head></head>
<body>

	<h3>Search Train by locations</h3>

	<form action="searchTrainByDestination">
		<table>
			<thead>
				<tr>
					<td><h3>From</h3></td>
					<td><h3>To</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="from"></td>
					<td><input type="text" name="to"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search"></td>
				</tr>
			</tbody>
		</table>
	</form>

	<br>
	<%-- <h4>${msg }</h4> --%>
	<%-- <h4>${trains }</h4> --%>

	<table>
		<thead>
			<tr>
				<th>Train No</th>
				<th>Train Name</th>
				<th>Train Fare</th>
				<th>Train Type</th>
				<th>Train From</th>
				<th>Train To</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${trains}" var="train">

				<tr>

					<td><c:out value="${train.getTrainNo()}" /></td>
					<td><c:out value="${train.getTrainName()}" /></td>
					<td><c:out value="${train.getTrainFare()}" /></td>
					<td><c:out value="${train.getTrainType()}" /></td>
					<td><c:out value="${train.getStartingPoint()}" /></td>
					<td><c:out value="${train.getDestinationPoint()}" /></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
	<h3>${msg}</h3>



</body>
</html>