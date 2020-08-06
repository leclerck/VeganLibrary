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
				<!-- ::::::::FORMULARIO::::::::: -->
				<form action="/login" method="post">

					<div class="form-group">
						<label for="username">Username</label> 
						<input type="text"
							id="username" name="username"
							class="form-control"
							 placeholder="Enter your username" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> 
						<input
							id="password" name="password"
							type="password" class="form-control"
							placeholder="Enter your password">
					</div>

					<button type="submit" class="btn btn-primary">Log in</button>

					<a href="/login/signin">or click here to sign in</a>
				</form>
				<!-- ::::::::FORMULARIO::::::::# -->
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

						<!-- 			CAROUSEL -->
						<jsp:include page="../includes/carousel.jsp" />
						<!-- 			CAROUSEL#-->

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