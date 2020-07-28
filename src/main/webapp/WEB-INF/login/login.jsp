<!DOCTYPE html>
<html lang="en">

<head>
<title>Vegan Library - Log in</title>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->
</head>

<body>

	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<nav id="colorlib-main-menu" role="navigation">
				<h3>Log in</h3>
				<form>
					<div class="form-group">
						<label for="exampleUsername">Username</label> <input type="text"
							class="form-control" id="exampleUsername"
							aria-describedby="emailHelp" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div>
					<button type="submit" class="btn btn-primary">Log in</button>
					<a href="signin.jsp">or click here to sign in</a>
				</form>
			</nav>


			<!-- 			FOOTER -->
			<jsp:include page="../includes/footer.jsp" />
			<!-- 			FOOTER #-->
		</aside>
		<!-- END COLORLIB-ASIDE -->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">

						<div id="carouselExampleSlidesOnly" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" src="../images/pie.jpg"
										alt="First slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/plum.jpg"
										alt="Second slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/smoothie.jpg"
										alt="Third slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/market.jpg"
										alt="Third slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/olive-oil.jpg"
										alt="Third slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/veg1.jpg"
										alt="Third slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="../images/veg2.jpg"
										alt="Third slide">
								</div>
							</div>
						</div>


					</div>
				</div>
			</section>
		</div>
		<!-- END COLORLIB-MAIN -->
	</div>
	<!-- END COLORLIB-PAGE -->

	<!-- 			LOADER -->
	<jsp:include page="../includes/loader.jsp" />
	<!-- 			LOADER#-->


	<!-- 			SCRIPTS -->
	<jsp:include page="../includes/scripts.jsp" />
	<!-- 			SCRIPTS #-->

</body>

</html>