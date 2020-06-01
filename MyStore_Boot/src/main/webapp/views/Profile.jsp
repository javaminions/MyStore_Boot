<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="styles/ProfileStyle.css">
</head>
<body>
<br><br>
	<div class="Profile">
		<h2 style="margin-left: 4%;">Profile</h2>
		<br>
		<div class="card">
			<div class="card-inner">
				<div class="card-front">
					<h1>${user.username}</h1>
					<img src="images/user.png" alt="">
				</div>
				<div class="card-back">
					<div class="card-userinfo">
						<h3>${user.firstName} ${user.lastName}</h3>
						<p>123 main street</p>
						<p>Atlanta, Georgia, 30301</p>
					</div>
					<div class="card-rewards">
						<p>Total Rewards: 126pts</p>
					</div>
				</div>
			</div>
		</div>
		<div class="side-info">
			<div class="side-info-description">
				<p>Profile Description:</p>
				<p>I love running with my new running shoes and covering my face
					with the visor I purchased here</p>
				<p>The customer service is great !</p>
			</div>
			<table>

				<tr>
					<td>Total Orders:</td>
					<td>3</td>
				</tr>
				<tr>
					<td>WishList items:</td>
					<td>3</td>
				</tr>
				<tr>
					<td>Gifts sent:</td>
					<td>0</td>
				</tr>
			</table>
			<div class="side-info-span">
				<span><a href="#">Edit info</a></span>
			</div>
		</div>
			<div class="update-info">
			<div class="update-info-description">
			 
				<h3><i class="fas fa-unlock-alt" style="margin-right: 12px;"></i>Login and Security</h3>
				<p>Update your account settings here</p>
			</div>
		
			<div class="side-info-span">
				<span><a href="account">Update</a></span>
			</div>
		</div>
	</div>
	<br><br>
</body>
</html>
