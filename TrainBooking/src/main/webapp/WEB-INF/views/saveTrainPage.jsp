<html>

<head></head>
<body>

	<h3>Add Train</h3>

	<form action="saveTrain" method="post">
		<table>
			<tbody>
				<tr>
					<td>Train name</td>
					<td><input type="text" name="trainName"></td>
					<td><h3 style="color: red;">${trainName}</h3></td>
				</tr>

				<tr>
					<td>Train No</td>
					<td><input type="text" name="trainNo"></td>
					<td><h3 style="color: red;">${trainNo}</h3></td>
				</tr>

				<tr>
					<td>Train type</td>
					<td><input type="text" name="trainType"></td>
					<td><h3 style="color: red;">${trainType}</h3></td>
				</tr>

				<tr>
					<td>Train fare</td>
					<td><input type="text" name="trainFare"></td>
					<td><h3 style="color: red;">${trainFare}</h3></td>
				</tr>

				<tr>
					<td>Starting point</td>
					<td><input type="text" name="startingPoint"></td>
					<td><h3 style="color: red;">${startingPoint}</h3></td>
				</tr>

				<tr>
					<td>Destination point</td>
					<td><input type="text" name="destinationPoint"></td>
					<td><h3 style="color: red;">${destinationPoint}</h3></td>
				</tr>

				<tr>
					<td><input type="submit" value="add train"></td>

				</tr>

			</tbody>
		</table>

	</form>


	<h3 style="color: red;">${msg}</h3>

</body>
</html>