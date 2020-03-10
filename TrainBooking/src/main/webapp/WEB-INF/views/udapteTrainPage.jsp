<html>

<head></head>
<body>

	<h3>Add Train</h3>

	<form action="/TrainBooking/updateTrain" method="post">
		<table>
			<tbody>
				<tr>
					<td><input type="text" name ="id" value="${train.getId()}"
						hidden="true"></td>
				</tr>
				<tr>
					<td>Train name</td>
					<td><input type="text" name="trainName"
						value="${train.getTrainName()}"></td>
					<td><h3 style="color: red;">${trainName}</h3></td>
				</tr>

				<tr>
					<td>Train No</td>
					<td><input type="text" name="trainNo"
						value="${train.getTrainNo()}"></td>
					<td><h3 style="color: red;">${trainNo}</h3></td>
				</tr>

				<tr>
					<td>Train type</td>
					<td><input type="text" name="trainType"
						value="${train.getTrainType()}"></td>
					<td><h3 style="color: red;">${trainType}</h3></td>
				</tr>

				<tr>
					<td>Train fare</td>
					<td><input type="text" name="trainFare"
						value="${train.getTrainFare()}"></td>
					<td><h3 style="color: red;">${trainFare}</h3></td>
				</tr>

				<tr>
					<td>Starting point</td>
					<td><input type="text" name="startingPoint"
						value="${train.getStartingPoint()}"></td>
					<td><h3 style="color: red;">${startingPoint}</h3></td>
				</tr>

				<tr>
					<td>Destination point</td>
					<td><input type="text" name="destinationPoint"
						value="${train.getDestinationPoint()}"></td>
					<td><h3 style="color: red;">${destinationPoint}</h3></td>
				</tr>

				<tr>
					<td><input type="submit" value="Update train"></td>
				</tr>

			</tbody>
		</table>

	</form>


	<h3 style="color: red;">${msg}</h3>

</body>
</html>