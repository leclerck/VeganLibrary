<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.21/b-1.6.2/fh-3.1.7/r-2.2.5/datatables.min.css" />
<title>Vegan Library</title>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->
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

								<table id="mytable" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>Name</th>
											<th>Last name</th>
											<th>City</th>
											<th>Gender</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
											<td>@mdo</td>

										</tr>
										<tr>
											<th scope="row">2</th>
											<td>Jacob</td>
											<td>Thornton</td>
											<td>@fat</td>
											<td>@fat</td>

										</tr>
										<tr>
											<th scope="row">3</th>
											<td>Larry</td>
											<td>the Bird</td>
											<td>@twitter</td>
											<td>@twitter</td>

										</tr>
									</tbody>
									<tfoot>
										<tr>
											<th>Name</th>
											<th>Last name</th>
											<th>City</th>
											<th>Gender</th>
											<th>Actions</th>
										</tr>
									</tfoot>
								</table>
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
	<!-- 			SCRIPTS#-->
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.21/b-1.6.2/fh-3.1.7/r-2.2.5/datatables.min.js"></script>

</body>

</html>