<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<!-- 			NAV -->
			<jsp:include page="../includes/nav.jsp" />
			<!-- 			NAV #-->
			<!-- 			FOOTER -->
			<jsp:include page="../includes/footer.jsp" />
			<!-- 			FOOTER #-->
		</aside>
		<!-- END COLORLIB-ASIDE -->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-xl-8 py-5 px-md-5">
							<div class="row pt-md-4">
								<!--1er POST-->
								<div class="d-flex justify-content-center align-items-center"
									id="main">
									<h1
										class="mr-3 pr-3 align-top border-right inline-block align-content-center">404</h1>
									<div class="inline-block align-middle">
										<h2 class="font-weight-normal lead" id="desc">The page
											you requested was not found.</h2>
									</div>
								</div>
								<!--1er POST-->
							</div>
							<!-- END-->
							
						</div>
						<!-- 			SIDEBAR -->
						<jsp:include page="../includes/sidebar.jsp" />
						<!-- 			SIDEBAR #-->

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