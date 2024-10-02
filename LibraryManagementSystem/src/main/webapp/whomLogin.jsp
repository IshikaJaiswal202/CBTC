
<html lang="en">
<head>
  <title>lms</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
		integrity="sha384-4LISF5TTJX/fLmGSxO53rV4miRxdg84mZsxmO8Rx5jGtp/LbrixFETvWa5a6sESd"
		crossorigin="anonymous">
  <style type="text/css">
 
	<style type="text/css">
		.login-container {
			margin-top: 100px;
			max-width: 1500px;
			height: 340px;
			margin-left: 200px;
			padding: 30px;
			border: 8px solid #ccc;
			border-radius: 20px;
			text-align: center;
}
            .buttonSty{
            }
.btn-group {
	margin-bottom: 40px;
}/* header */
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
      .but
      {
        font-size:15px;
        font-weight:300px;
        margin-top:20px;
        color: white;
        text-align: center;
      }
      .box
      {
        height:150px;
         width:190px;
         margin-left:160px;
          border-radius:15px; 
          border:8px solid; 
          border-style:hidden;
           margin-top:20px;
           padding-left:10px;
           color:white;
           background-color:darkorange;
         
      }
  </style>
</head>
<body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50" style="background-color:black">
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#" style="text-transform: uppercase;font-weight:700">Admin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div ></div>
      <div  id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" href="#" ">Home</a>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="margin-right:10px;">
              Exit
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Logout</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<!-- Option 1: Include in HTML -->
	<h1 style="text-align: center; margin-top:60px; color:darkorange;font-size:70px;text-transform:uppercase;font-family:serif; ">
		<b>Library Management System<b></b>
		</h1>
		<p class="but"> "I'm realizing how much I've diminished my own power. I'm not doing that no more."</p>
	<div class="container mt-5">
		<div class="login-container" style="border-color:white; background-color: white;width:950px ;margin-top:30px; border-radius:15px;margin-left:160px;height:330px">
		<br></br>
			<h1 style="color:black; text-align: center;font-weight:700px;font-size:30px;">Find You Perfect Match, Connect To..
			</h1>
			<div class="btn-group">
				<button type="button" class="btn btn-light box"
					onclick="redirectTo('./adminLogin.jsp')"
					style="margin-right:15px; border-radius:10px;">
					<h1>
						<b><i class="bi bi-person-fill-gear" style="font-size:70px;color:white;"></i><br>Admin</b>
					</h1>
				</button>
				
				<button type="button" class="btn btn-light box" onclick="redirectTo('./userLogin.jsp')"style="margin-left:10px; border-radius:10px;">
					<h1>
						<b><i class="bi bi-person-fill"style="font-size: 70px;color:white;"></i><br>User</b>
					</h1>
				</button>
			</div>
		</div>
	</div>

	<script>
        function redirectTo(page) {
            window.location.href = page;
        }
    </script>
 <script type="text/javascript">
 $(document).ready(function () {
     const button = document.querySelector(".navbar-toggler");
     const navOverlay = document.querySelector(".nav-overlay");
     const navbarCollapse = document.querySelector(".navbar-collapse");

     button.addEventListener("click", function () {
       navOverlay.classList.toggle("active");
     });

     navOverlay.addEventListener("click", function (event) {
       if (event.target === navOverlay) {
         navOverlay.classList.remove("active");
         navbarCollapse.classList.remove("show");
       }
     });
   });
</script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
