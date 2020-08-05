<!DOCTYPE html>
<html lang="en">

<head>
<title>Vegan Library - Sign in</title>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->
<style type="text/css">
#colorlib-aside{
padding-top: 2em !important;
}
</style>
</head>

<body>

	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<nav id="colorlib-main-menu" role="navigation">
				<h3>Sign in</h3>
				<form>
					<div class="form-group row">
						<label for="inputUsername" class="col-sm-2 col-form-label">Profile
							Picture</span>
						</label>
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<input type="file" class="form-control" id="pic" name="pic">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputUsername"
								placeholder="Username">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="Password">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Sign in</button>
					<a href="/login">or click here to log in</a>
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
					<!-- 			CAROUSEL -->
					<jsp:include page="../includes/carousel.jsp" />
					<!-- 			CAROUSEL#-->
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