
<html lang="en">
<head>
<title>AddAdmin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
<style type="text/css">
section {
	padding: 60px 0;
	min-height: 100vh;
}

.section_title {
	margin-bottom: 40px;
}

.section_title h2 {
	color: white;
	font-size: 25px;
	font-weight: 700;
	letter-spacing: 1.8px;
	text-transform: uppercase;
}

.brand_border .fa.fa-minus {
	color: #fff;
	font-size: 8px;
	height: 2px;
	background: #F8C01B none repeat scroll 0 0;
	width: 100px;
}

.brand_border .fas.fa-handshake {
	font-size: 14px;
	color: #000000;
}

.section_title p {
	color: white;
	font-size: 14px;
	line-height: 25px;
	padding: 14px 0;
}

.tables-page-section .table {
	text-align: center;
	margin-bottom: 40px;
}

.tables-page-section .table th {
	border-bottom: 1px solid #ffffff;
	border-right: 1px solid #ffffff;
	font-family: 'Montserrat', sans-serif;
	font-size: 15px;
	font-weight: 700;
	padding: 10px 20px;
	text-align: center;
}

.tables-page-section .table td {
	border-bottom: 1px solid #ffffff;
	border-right: 1px solid #ffffff;
	background: #f1f1f1;
	font-family: 'Lato', sans-serif;
	font-size: 13px;
	color: #666666;
	padding: 10px 20px;
}

.tables-page-section .table thead th {
	padding: 15px 20px;
	text-align: center;
	background: #ffba00 !important;
}

.tables-page-section .table tr th {
	background: #f1f1f1;
}
/* login   */
.login-dark {
	height: 1000px;
	background-size: cover;
	position: relative;
}

.login-dark form {
	max-width: 320px;
	width: 90%;
	background-color: darkorange;
	padding: 40px;
	border-radius: 4px;
	transform: translate(-50%, -50%);
	position: absolute;
	top: 30%;
	left: 50%;
	color: #fff;
	box-shadow: 3px 3px 4px rgba(0, 0, 0, 0.5);
}

.login-dark .illustration {
	text-align: center;
	padding: 15px 0 20px;
	font-size: 100px;
	color: #2980ef;
}

.login-dark form .form-control {
	background: none;
	border: none;
	border-bottom: 1px solid #434a52;
	border-radius: 0;
	box-shadow: none;
	outline: none;
	color: inherit;
}

.login-dark form .btn-primary {
	background: black;
	border: none;
	border-radius: 10px;
	padding: 11px;
	box-shadow: aqua;
	margin-top: 32px;
	margin-bottom: 22px;
	text-shadow: none;
	outline: none;
	width: 100px;
}

.login-dark form .btn-primary:hover, .login-dark form .btn-primary:active
	{
	background: white;
	color: black;
	outline: none;
}

.login-dark form .forgot {
	display: block;
	text-align: center;
	font-size: 12px;
	color: white;
	opacity: 0.9;
	text-decoration: none;
}

.login-dark form .forgot:hover, .login-dark form .forgot:active {
	opacity: 1;
	text-decoration: none;
}

.login-dark form .btn-primary:active {
	transform: translateY(1px);
}
/* header */
.navbar-toggler {
	width: 50px;
	height: 50px;
	padding: 0;
	border-radius: 50%;
	transition: 0.3s ease-in-out;
	flex-shrink: 0;
}

.navbar-toggler:focus {
	box-shadow: none;
}

@media screen and (max-width: 991px) {
	.navbar-collapse.collapse:not(.show) {
		display: block;
	}
	.navbar-collapse {
		position: fixed;
		top: 0;
		left: 0;
		background: #212529;
		width: 215px;
		height: 100%;
		z-index: 9999;
		padding: 25px;
		transform: translateX(-215px);
		transition: 0.5s ease-in-out;
		display: block;
	}
	.navbar-collapse.show {
		transform: translateX(0px);
	}
	.nav-overlay {
		position: absolute;
		background: #0000007d;
		width: 100vw;
		height: 100vh;
		top: 0;
		left: 0;
		z-index: 2;
		transform: translateX(-100vw);
		transition: 0.5s ease-in-out;
		display: block;
	}
	.nav-overlay.active {
		transform: translateX(0);
	}
	/* header */
	.navbar-toggler {
		width: 50px;
		height: 50px;
		padding: 0;
		border-radius: 50%;
		transition: 0.3s ease-in-out;
		flex-shrink: 0;
	}
	.navbar-toggler:focus {
		box-shadow: none;
	}
	@media screen and (max-width: 991px) {
		.navbar-collapse.collapse:not(.show) {
			display: block;
		}
		.navbar-collapse {
			position: fixed;
			top: 0;
			left: 0;
			background: #212529;
			width: 215px;
			height: 100%;
			z-index: 9999;
			padding: 25px;
			transform: translateX(-215px);
			transition: 0.5s ease-in-out;
			display: block;
		}
		.navbar-collapse.show {
			transform: translateX(0px);
		}
		.nav-overlay {
			position: absolute;
			background: #0000007d;
			width: 100vw;
			height: 100vh;
			top: 0;
			left: 0;
			z-index: 2;
			transform: translateX(-100vw);
			transition: 0.5s ease-in-out;
			display: block;
		}
		.nav-overlay.active {
			transform: translateX(0);
		}
	}
}
</style>
</head>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"
				style="text-transform: uppercase; font-weight: 700">Admin</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#"">Home</a>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false style="margin-right:10px;">
							Exit </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="./index.html" style="">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>


<body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50"
	style="background-color: black">
	<section class="tables-page-section"="service">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section_title text-center">
						<h2 style="font-size: 35px">
							<b>Add Admin</b>
						</h2>
						<div class="brand_border">
							<i class="fa fa-minus" aria-hidden="true"></i> <i
								class="fas fa-handshake"></i> <i class="fa fa-minus"
								aria-hidden="true"></i>
						</div>
						<p style="font-size: 15px">Either you run the day or the day
							runs you !</p>
						<div class="login-dark">
							<form action="./admin" method="post"
								style="width: 600px; height: 550px">
								<h2 style="text-align: center; font-weight: 600px;">
									<b>Register<b></b>
								</h2>
								<br>
								<div class="form-group">
									<input class="form-control" type="name" name="name"
										placeholder="Name" required="required">
								</div>
								<br>
								<div class="form-group">
									<input class="form-control" type="email" name="email"
										placeholder="Email" required="required">
								</div>
								<br>
								<div class="form-group">
									<input class="form-control" type="password" name="password"
										placeholder="Password " required="required">
								</div>
								<br>
								<div class="form-group">
									<input class="form-control" type="text" name="contact"
										placeholder="Contact" required="required">
								</div>
								<br>
								<div class="form-group">
									<input class="form-control" type="text" name="address"
										placeholder="Address" required="required">
								</div>
								<br>
								<div class="form-group">
									<button class="btn btn-primary btn-dark" type="submit"
										name="action" value="admin">Sign In</button>
								</div>
							</form>
							<%
							if (request.getAttribute("success") != null && (boolean) request.getAttribute("success")) {
							%>
							<script>
								Swal.fire('Success!', 'User has been added.',
										'success')
							</script>
							<%
							}
							%>
							<%
							if (request.getAttribute("success") != null && !(boolean) request.getAttribute("success")) {
							%>
							<script>
								Swal.fire('Failed!', 'Email Already Exists')
							</script>
							<%
							}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		$(document).ready(function() {
			const button = document.querySelector(".navbar-toggler");
			const navOverlay = document.querySelector(".nav-overlay");
			const navbarCollapse = document.querySelector(".navbar-collapse");

			button.addEventListener("click", function() {
				navOverlay.classList.toggle("active");
			});

			navOverlay.addEventListener("click", function(event) {
				if (event.target === navOverlay) {
					navOverlay.classList.remove("active");
					navbarCollapse.classList.remove("show");
				}
			});
		});
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
