<%@page import="java.util.List"%>
<%@page import="com.ishika.lms.bean.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>UserPanel</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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
	width: max-content;
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
</style>
</head>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">User</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="nav-overlay"></div>
			<div id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About Us</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Exit </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="./index.html">Logout</a></li>
							<li><a class="dropdown-item" href="#">Service 2</a></li>
							<li><a class="dropdown-item" href="#">Service 3</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link">Contact Us</a></li>
					<li><a href="./addUser.jsp">
							<button class="btn btn-warning" type="button"
								style="width: 150px; margin-right: 10px; margin-left: 10px; font-family: cursive;">Add
								User</button>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>


<body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50"
	style="background-color: black">
	<section class="tables-page-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section_title text-center">
						<h2>
							<b>Users List</b>
						</h2>
						<div class="brand_border">
							<i class="fa fa-minus" aria-hidden="true"></i> <i
								class="fas fa-handshake"></i> <i class="fa fa-minus"
								aria-hidden="true"></i>
						</div>
						<p>
							"Learning how to be still, to really be still and let life happen
							that <br>stillness becomes a radiance."
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<th>User_ID</th>
								<th>User_Name</th>
								<th>User_Email</th>
								<th>User_Contact</th>
								<th>User_Address</th>
								<th>User_IsActive</th>
								<th>Enroll_Date</th>
								<th>Operation</th>
							</thead>
							<%
							List<User> stud=(List<User>)request.getAttribute("Users");
							%>
							<%
							for(User s:stud){
							%>
							<%
							if(s.getUser_isActive().equals("true")){
							%>
							<tr>
								<td><%=s.getUser_id()%></td>
								<td><%=s.getUser_name()%></td>
								<td><%=s.getUser_email()%></td>
								<td><%=s.getUser_contact()%></td>
								<td><%=s.getUser_address()%></td>
								<td><%=s.getUser_isActive()%></td>
								<td><%=s.getUser_createDate()%></td>


								<td><div class="d-grid gap-2 d-md-block">
								<%
								String email=s.getUser_email();
								%>
										<%
										String name=s.getUser_name();
										%>
											<button class="btn btn-info" type="button" onclick="editUser('<%=email%>')">Edit</button>
										
										
										<a>
                                        <button class="btn btn-danger" type="button"
											id="delete-button"  onclick="confirmBlock('<%=email%>','<%=name%>')"
											>Delete</button></a>
                               </div></td>

							</tr>
							<%
							}
							%>
							<%
							}
							%>
                            
						</table>




						<table class="table">
							<p
								style="text-align: center; color: red; font-family: fantasy; font-size: 26px; font-weight: 900;">List
								Of Block User</p>
							<thead>
								<th>User_ID</th>
								<th>User_Name</th>
								<th>User_Email</th>
								<th>User_Contact</th>
								<th>User_Address</th>
								<th>User_IsActive</th>
								<th>Enroll_Date</th>
								<th>Operation</th>
							</thead>
							<%
							for(User s:stud){
							%>
							<%if(!(s.getUser_isActive().equals("true"))){ %>
							<tr>
								<td><%=s.getUser_id()%></td>
								<td><%=s.getUser_name()%></td>
								<td><%=s.getUser_email()%></td>
								<td><%=s.getUser_contact()%></td>
								<td><%=s.getUser_address()%></td>
								<td><%=s.getUser_isActive()%></td>
								<td><%=s.getUser_createDate()%></td>


								<td><div class="d-grid gap-2 d-md-block">
							     <button  class="btn btn-info" type="button"
											id="delete-button"  onclick="confirmUnBlock('<%= s.getUser_email() %>','<%= s.getUser_name() %>')"
											>Unblock</button>
                                 <button class="btn btn-danger" type="button" id="delete-button" onclick="confirmDeletion('<%=s.getUser_email()%>')">PermanentlyDelete</button>
            
										
									</div></td>

							</tr>
							<%} %>
							<%} %>

						</table>
					</div>
				</div>

			</div>
		</div>
	</section>
	<script type="text/javascript">
	
	 function confirmDeletion(email) {
		   Swal.fire({
		     title: 'Are you sure?',
		     text: "To delete "+name+"!",
		     icon: 'warning',
		     showCancelButton: true,
		     confirmButtonColor: '#3085d6',
		     cancelButtonColor: '#d33',
		     confirmButtonText: 'Yes, delete it!'
		   }).then((result) => {
		     if (result.isConfirmed) {
		    	 var url = "http://localhost:8090/LibraryManagementSystem/admin?action=deleteUser&email=" + encodeURIComponent(email);
		         window.location.href = url;
		     }
		   })
		 }
	 function editUser(email) {
         var editUrl = "http://localhost:8090/LibraryManagementSystem/admin?action=editUser&email=" + encodeURIComponent(email) ;
         window.location.href = editUrl;
     }
	 function confirmBlock(email,name) {
		   Swal.fire({
		     title: 'Are you sure?',
		     text: "To delete "+name+"!",
		     icon: 'warning',
		     showCancelButton: true,
		     confirmButtonColor: '#3085d6',
		     cancelButtonColor: '#d33',
		     confirmButtonText: 'Yes, delete it!'
		   }).then((result) => {
		     if (result.isConfirmed) {
		    	 var url = "http://localhost:8090/LibraryManagementSystem/admin?action=blockUser&email=" + encodeURIComponent(email);
		         window.location.href = url;
		     }
		   })
		 }
	 function confirmUnBlock(email,name) {
		   Swal.fire({
		     title: 'Are you sure?',
		     text: "To Unblock "+name+"!",
		     icon: 'warning',
		     showCancelButton: true,
		     confirmButtonColor: '#3085d6',
		     cancelButtonColor: '#d33',
		     confirmButtonText: 'Yes!'
		   }).then((result) => {
		     if (result.isConfirmed) {
		    	 var url = "http://localhost:8090/LibraryManagementSystem/admin?action=unBlockUser&email=" + encodeURIComponent(email);
		         window.location.href = url;
		     }
		   })
		 }
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
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
