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
				</tr>

				<tr>
					<td>Train No</td>
					<td><input type="text" name="trainNo"></td>
				</tr>

				<tr>
					<td>Train type</td>
					<td><input type="text" name="trainType"></td>
				</tr>

				<tr>
					<td>Train fare</td>
					<td><input type="text" name="trainFare"></td>
				</tr>

				<tr>
					<td>Starting point</td>
					<td><input type="text" name="startingPoint"></td>
				</tr>

				<tr>
					<td>Destination point</td>
					<td><input type="text" name="destinationPoint"></td>
				</tr>

				<tr>
					<td><input type="submit" value="add train"></td>
				</tr>

			</tbody>
		</table>

	</form>

	
	<h3 style="color:red;">$ { msg }</h3>
	
</body>
</html>