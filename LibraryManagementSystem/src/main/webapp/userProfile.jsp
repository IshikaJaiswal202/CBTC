
<html lang="en">
<head>
  <title>EditLibrarian</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <style type="text/css">
  section {
            padding: 60px 0;
            min-height: 100vh;
            box-shadow:3px 3px 4px rgba(0,0,0,0.5);
        }
.section_title {
  margin-bottom: 20px;
}

.section_title h2 {
  color: white;
  font-size: 25px;
  font-weight:900;
  letter-spacing: 1.8px;
  text-transform: uppercase;
}

.brand_border .fa.fa-minus {
    color: darkorange;
    font-size: 8px;
    height: 2px;
        background: #F8C01B none repeat scroll 0 0;
    width: 100px;
}
.brand_border .fas.fa-handshake {
    font-size: 14px;
        color:#000000;
}


.section_title p {
  color:black;
  font-size: 14px;
  font-family:sans-serif;
  line-height: 15px;
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
/* profile */
 .gradient-custom {
/* fallback for old browsers */
background: #f6d365;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1))
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
      <a class="navbar-brand" href="#" style="text-transform: uppercase;font-weight:700">Student</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div  id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" href="#" ">Home</a>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false style="margin-right:10px;">
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
<body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="50" style="background-color:black">
<section class="tables-page-section" >
    <div class="container">
     <div class="row">
      <div class="col-md-12">
       <div class="section_title text-center">
         <h2 style="font-size:35px;font-weight:"><b>Redraft Profile</b></h2>
            <p style="font-size:25px;">"The only limit to our realization of tomorrow will be our doubts today"</p>  
          </div>
  <section class="vh-100" style="background-color: #f4f5f7; width:700px;text-align: center;margin-left:250px;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;width:500px;margin-left:100px">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white"
              style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <img src="img/studentpro.png"
                alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
              <h5 style="font-size:20px;font-family:sans-serif;">Ishika Jaiswal</h5>
              <p>Web Designer</p>
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Information</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted">info@example.com</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Phone</h6>
                    <p class="text-muted">123 456 789</p>
                  </div>
                </div>
                <h6>Projects</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Recent</h6>
                    <p class="text-muted">Lorem ipsum</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Most Viewed</h6>
                    <p class="text-muted">Dolor sit amet</p>
                  </div>
                </div>
                <div class="d-flex justify-content-start">
                  <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</div>
</div>
</div>
</section>   
 

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
