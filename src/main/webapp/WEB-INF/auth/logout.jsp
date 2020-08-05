<!DOCTYPE html>
<html lang="en">

<head>
<title>Vegan Library - Log out</title>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->
</head>

<body>

	<style>
body {
	background-image: url('../frontImages/avocados.jpg');
	background-size: 700px 700px;
}
</style>
	
	<div class="row py-5 my-5">
		<div class="col-4"></div>
		
		<div class="card col-4">
			<div class="card-body">
				<h1 class="text-dark">Are you sure you want to log
					out?</h1>
				<button type="button" class="btn btn-info btn-block ">Log Out</button>
			</div>
		</div>
		<div class="col-4"></div>
	</div>


	<!-- 			LOADER -->
	<jsp:include page="../includes/loader.jsp" />
	<!-- 			LOADER#-->


	<!-- 			SCRIPTS -->
	<jsp:include page="../includes/scripts.jsp" />
	<!-- 			SCRIPTS #-->

</body>

</html>