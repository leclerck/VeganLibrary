<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>Vegan Library - Customer Maintainer</title>
<!-- 			HEAD -->
<jsp:include page="../includes/head.jsp" />
<!-- 			HEAD #-->


<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.21/r-2.2.5/sp-1.1.1/datatables.min.css" />

<style type="text/css">
.paginate_button:hover {
	border: solid #ffffff !important;
	background: #ffffff !important
}

.page-item.active .page-link {
	background-color: #1eafed !important;
	border-color: #1eafed !important;
}
</style>
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
						<div class="col-xl-12 px-md-5 mt-5">
							<div class="mb-4">
								<button type="button" onclick="location.href = 'customers';"
									class="btn btn-primary btn-lg">Customer Maintainer</button>
								<button type="button" onclick="location.href = '../books';"
									class="btn btn-secondary btn-lg disabled">Book
									Maintainer</button>
							</div>

							<c:if test="${not empty message}">
								<div class="alert alert-info alert-dismissible fade show"
									role="alert">
									<strong>Done! </strong> ${message}
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:if>

							<h3>Customer sign in</h3>
							<form id="form" action="<c:url value='/customers'/>" method="post"
								enctype="multipart/form-data">
								<div class="form-group row">
									<label for="avatar" class="col-sm-2 col-form-label">Profile
										Picture </label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="file" class="form-control" id="avatar"
											name="avatar">
									</div>
								</div>
								<div class="form-group row">
									<label for="username" class="col-sm-2 col-form-label">Username</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="username"
											name="username" placeholder="Username">
									</div>
								</div>
								<div class="form-group row">
									<label for="email" class="col-sm-2 col-form-label">Email</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="email" class="form-control" id="email"
											name="email" placeholder="Email">
									</div>
								</div>
								<div class="form-group row">
									<label for="password" class="col-sm-2 col-form-label">Password</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="password" class="form-control" id="password"
											name="password" placeholder="Password">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4"></div>
									<div class="col-sm-8">
										<button id="button" type="submit"
											class="btn btn-primary btn-block">Save</button>
									</div>
								</div>
							</form>
							<br>

							<table class="table" id="customerTable">
								<thead>
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Avatar</th>
										<th scope="col">Username</th>
										<th scope="col">Email</th>
										<th scope="col">Password</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="customer" items="${customers}">
										<tr>
											<th scope="row">${customer.id}</th>
											<td><img width="100" height="100"
												src="<c:url value='../pictures/customers/${customer.avatarUrl}'></c:url>"
												class="rounded" alt="${customer.avatarUrl}" /></td>
											<td>${customer.username}</td>
											<td>${customer.email}</td>
											<td>${customer.password}</td>
											<td><a
												href='javascript:update(${customer.toJson()})'>Update</a>
												| <a href='javascript:delete_(${customer.toJson()})'>Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
	<!-- 			SCRIPTS#-->

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous">
		
	</script>
	<script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.21/r-2.2.5/sp-1.1.1/datatables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#customerTable').DataTable();
		});
	</script>

	<script type="text/javascript">
		const delete_ = (customer) => {
			if(!confirm("Are you sure you want to delete : " + customer.username))
				return

			const baseUrl = window.location.origin
			window.location.href = baseUrl + '/customers/delete?id=' + book.id
		}
		
		const update = (customer) => {
			// capturamos el formulario
			const form = document.querySelector('#form')
			form.username.value = customer.username
			form.email.value = customer.email
			form.password.value = customer.password
			
			// eliminamos los imputs si existen, si existe
			// será capturado por su id
			const input001 = form.genElement001
			if(input001)
				input001.remove();

			const input002 = form.genElement002
			if(input002)
				input002.remove();

			// creamos dos input escondidos, con el resto
			// de los atributos que necesitaremos para
			// la actualización
			const input_id = document.createElement('input')
			input_id.type = 'hidden'
			input_id.name = 'id'
			input_id.value = customer.id
			input_id.id = 'genElement001'

			const input_avatar_url = document.createElement('input')
			input_avatar_url.type = 'hidden'
			input_avatar_url.name = 'avatarUrl'
			input_avatar_url.value = customer.avatarUrl
			input_avatar_url.id = 'genElement002'

			// agregamos estos campos creados al formulario
			form.appendChild(input_id);
			form.appendChild(input_avatar_url);
			// adaptamos el botón a una actualización
			// lo capturamos por su id
			form.button.textContent = 'Update'
			// cambiamos el método para que vaya a actualizar
			form.action = '/customers/update'
		}

	</script>

</body>

</html>