<html>

<head></head>
<body>

	<h3>Add Train</h3>

	<form action="signUp" method="post">
		<table>
			<tbody>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
					<td><h3 style="color: red;">${name}</h3></td>
				</tr>

				<tr>
					<td>password</td>
					<td><input type="text" name="password"></td>
					<td><h3 style="color: red;">${password}</h3></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
					<td><h3 style="color: red;">${email}</h3></td>
				</tr>

				<tr>
					<td>Mobile no</td>
					<td><input type="text" name="mobileNo"></td>
					<td><h3 style="color: red;">${mobileNo}</h3></td>
				</tr>

				<tr>
					<td>User_Name</td>
					<td><input type="text" name="userName"></td>
					<td><h3 style="color: red;">${userName}</h3></td>
				</tr>
				<tr>
					<td><input type="submit" value="sign up"></td>

				</tr>

			</tbody>
		</table>

	</form>


	<h3 style="color: red;">${msg}</h3>

</body>
</html>