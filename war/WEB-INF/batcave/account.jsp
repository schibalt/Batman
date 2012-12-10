<!DOCTYPE html>
<body>
	<%@ include file="header.jsp"%>
	<div class="signup">
		<form Action="/batcave/register" Method="post">
			<fieldset>
				<table>
					<tr>
						<td><label for='name'>Your Full Name*: </label></td>
						<td><input type='text' name='name' id='name' maxlength="50" value="Andrew Tilisky"/></td>
					</tr>
					<tr>
						<td><label for='email'>Email Address*:</label></td>
						<td><input type='text' name='email' id='email' maxlength="50"  value="art26@zips.uakron.edu"/></td>
					</tr>
					<tr>
						<td><label for='username'>UserName*:</label></td>
						<td><input type='text' name='username' id='username'
							maxlength="50"  value="atilisky"/></td>
					</tr>
					<tr>
						<td><label for='password'>Password*:</label></td>
						<td><input type='password' name='password' id='password'
							maxlength="50"  value="batman"/></td>
					</tr>
				</table>
				<legend>Create User Account</legend>
				<button>
					<h3>register</h3>
				</button>
			</fieldset>
		</form>
	</div>
	<%@ include file="footer.html"%>