<%@page import="java.util.List"%>
<%@page import="com.ishika.lms.bean.Book"%>

<html lang="en">
<head>
<title>BookPanel</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
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
			<a class="navbar-brand" href="#">Books</a>
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
						data-bs-toggle="dropdown" aria-expanded="false"> Books Detail
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="http://localhost:8090/LibraryManagementSystem/admin?action=showIssuedBook">Issued
									Book</a></li>
							<li><a class="dropdown-item" href="#">Returned Book</a></li>
							<li><a class="dropdown-item" href="#">Logout</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link">Contact Us</a></li>
					<li><a href="./addBook.jsp">
							<button class="btn btn-warning" type="button"
								style="width: 150px; margin-right: 10px; margin-left: 10px; font-family: cursive;">Add
								Book</button>
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
							<b>Book List</b>
						</h2>
						<div class="brand_border">
							<i class="fa fa-minus" aria-hidden="true"></i> <i
								class="fas fa-handshake"></i> <i class="fa fa-minus"
								aria-hidden="true"></i>
						</div>
						<p>
							"I believe that if you'll just stand up and go, life will open up
							for you,<br>Something just motivates you to keep moving."
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<th>Book_ID</th>
								<th>Book_Name</th>
								<th>Authore_Name</th>
								<th>No_Of_Pages</th>
								<th>Book_Stream</th>
								<th>Book_Quantity</th>
								<th>Enroll_Date</th>
								<th>Operation</th>
							</thead>
							<% List<Book> book=(List<Book>)request.getAttribute("books"); %>
							<%  for(Book books:book){%>
							<%if(books.getBookQuantity()!=0){ %>
							<tr>
								<td><%= books.getBookId() %></td>
								<td><%= books.getBookName()%></td>
								<td><%= books.getAuthoreName()%></td>
								<td><%= books.getNoOfPages()%></td>
								<td><%= books.getBookSubject()%></td>
								<td><%= books.getBookQuantity()%></td>
								<td><%= books.getCreatedDate()%></td>
								<td><div class="d-grid gap-2 d-md-block">
										<%String name=books.getBookName();%>
										<%String authorName= books.getAuthoreName();%>
										<%String stream= books.getBookSubject();%>
										<%Integer pages= books.getNoOfPages();%>
										<%Integer bookQuantity= books.getBookQuantity();%>
												<button type="button" class="btn btn-success"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false"
													>Issue Book</button>
													<%String actionsTo=null; %>
													<div class="dropdown-menu">
													<a  class="dropdown-item" onclick="confirmIssueBook('<%= name %>','<%=authorName%>','<%=actionsTo="student"%>','<%= bookQuantity%>')">For Student</a>
													 <a
														class="dropdown-item" onclick="confirmIssueBook('<%= name %>','<%=authorName%>','<%=actionsTo="librarian"%>','<%= bookQuantity%>')">For Librarian</a>
														 </div>	
													<button class="btn btn-info" type="button"
													onclick="confirmIncreaseQuantity('<%= name%>','<%=authorName%>','<%= stream%>','<%= pages%>','<%= bookQuantity%>')">Increase
													Quantity</button>
													
											</div></td>
											
							</tr>
							<%} %>
							<%} %>
						</table>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<th>Book_ID</th>
								<th>Book_Name</th>
								<th>Authore_Name</th>
								<th>No_Of_Pages</th>
								<th>Book_Stream</th>
								<th>Book_Quantity</th>
								<th>Enroll_Date</th>
								<th>Operation</th>
							</thead>
							<%  for(Book books:book){%>
							<%System.out.println(books.getBookQuantity()
									+"ooo");%>
							<%if(!(books.getBookQuantity()!=0)){ %>
							<tr>
							<%System.out.println(books.getBookQuantity()
									+"111");%>
								<td><%= books.getBookId() %></td>
								<td><%= books.getBookName()%></td>
								<td><%= books.getAuthoreName()%></td>
								<td><%= books.getNoOfPages()%></td>
								<td><%= books.getBookSubject()%></td>
								<td><%= books.getBookQuantity()%></td>
								<td><%= books.getCreatedDate()%></td>
									   
											
								<td><div class="d-grid gap-2 d-md-block">
								 <%String name=books.getBookName();%>
										<%String authorName= books.getAuthoreName();%>
										<%String stream= books.getBookSubject();%>
										<%Integer pages= books.getNoOfPages();%>
										<%Integer bookQuantity= books.getBookQuantity();%>
										<button class="btn btn-info" type="button" id="delete-button"
											onclick="confirmIncreaseQuantity('<%= name%>','<%=authorName%>','<%= stream%>','<%= pages%>','<%= bookQuantity%>')">Increase
													Quantity</button>
										<button class="btn btn-danger" type="button"
											id="delete-button"
											onclick="confirmDeletion(<%= books.getBookName()%>)">PermanentlyDelete</button>
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
 function confirmIssueBook(name,authorName,actionsTo,bookQuantity) {
	 console.log(bookQuantity);
     var editUrl = "http://localhost:8090/LibraryManagementSystem/admin?action=saveIssueBook&name="+encodeURIComponent(name)+"&authorName="+encodeURIComponent(authorName)+"&actionsTo="+encodeURIComponent(actionsTo)+"&bookQuantity="+encodeURIComponent(bookQuantity) ;
     window.location.href = editUrl;
 }
 function confirmDeletion(email,name) {
   Swal.fire({
     title: 'Are you sure?',
     text: "To delete "+name+"!",
     icon: 'warning',
     showCancelButton: true,
     confirmButtonColor: '#3085d6',
     cancelButtonColor: '#d33', 
     confirmButtonText: "Yes, delete "+name+" !"
   }).then((result) => {
     if (result.isConfirmed) {
    	 var url = "http://localhost:8090/LibraryManagementSystem/admin?action=deleteLibrarian&email=" + encodeURIComponent(email);
         window.location.href = url;
     }
   })
 }
 
 function confirmIncreaseQuantity(name,authorName,stream,pages,bookQuantity)
 { 
	 console.log(bookQuantity);
     var editUrl = "http://localhost:8090/LibraryManagementSystem/admin?action=editBook&name="+encodeURIComponent(name)+"&authorName="+encodeURIComponent(authorName)+"&stream="+encodeURIComponent(stream)+"&pages="+encodeURIComponent(pages)+"&bookQuantity="+encodeURIComponent(bookQuantity) ;
     window.location.href = editUrl;
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
