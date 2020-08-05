<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>Vegan Library - Book Maintainer</title>
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
								<button type="button" onclick="location.href = '../customers';"
									class="btn btn-secondary btn-lg disabled">Customer
									Maintainer</button>
								<button type="button" onclick="location.href = 'books';"
									class="btn btn-primary btn-lg">Book Maintainer</button>
							</div>

							<c:if test="${not empty message}">
								<div class="alert alert-info alert-dismissible fade show"
									role="alert">
									<strong>Done!</strong> ${message}
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:if>

							<h3>Book Register</h3>
							<form id="form" action="<c:url value='/books'/>" method="post"
								enctype="multipart/form-data">
								<div class="form-group row">
									<label for="picture" class="col-sm-2 col-form-label">Picture
									</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="file" class="form-control" id="picture"
											name="picture">
									</div>
								</div>
								<div class="form-group row">
									<label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="isbn" name="isbn"
											placeholder="ISBN">
									</div>
								</div>
								<div class="form-group row">
									<label for="name" class="col-sm-2 col-form-label">Name</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="name" name="name"
											placeholder="Name">
									</div>
								</div>
								<div class="form-group row">
									<label for="author" class="col-sm-2 col-form-label">Author</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="author"
											name="author" placeholder="Author">
									</div>
								</div>
								<div class="form-group row">
									<label for="year" class="col-sm-2 col-form-label">Year</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="number" class="form-control" id="year"
											name="year" placeholder="Year">
									</div>
								</div>
								<div class="form-group row">
									<label for="description" class="col-sm-2 col-form-label">Description</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="description"
											name="description" placeholder="Description">
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

							<div class="table-responsive">

								<table class="table" id="bookTable">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Picture</th>
											<th scope="col">ISBN</th>
											<th scope="col">Name</th>
											<th scope="col">Year</th>
											<th scope="col">Author</th>
											<th scope="col">Stars</th>
											<th scope="col">Description</th>
											<th scope="col">Reviews</th>
											<th scope="col">Action</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach var="book" items="${books}">
											<tr>
												<th scope="row">${book.id}</th>
												<td><img width="100" height="100"
													src="<c:url value='../pictures/books/${book.pictureUrl}'></c:url>"
													class="rounded" alt="${book.pictureUrl}" /></td>
												<td>${book.isbn}</td>
												<td>${book.name}</td>
												<td>${book.year}</td>
												<td>${book.author}</td>
												<td>${book.stars}</td>
												<td><c:choose>
														<c:when test="${book.description.length()>=15}">
															<c:out value="${book.description.substring(0,15)}" />
															<a href="/books/detail?id=${book.id}"> More...</a>
														</c:when>
														<c:otherwise>
															<c:out value="${book.description}" />
														</c:otherwise>
													</c:choose></td>
												<td>${book.reviews.size()}</td>
												<td><a href='javascript:update(${book.toJson()})'>Update</a>
													| <a href='javascript:delete_(${book.toJson()})'>Delete</a>
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
			$('#bookTable').DataTable();

		});
	</script>

	<script type="text/javascript">
		const delete_ = (book) => {
			if(!confirm("Are you sure you want to delete: " + book.name))
				return
				
			const baseUrl = window.location.origin
			window.location.href = baseUrl + '/books/delete?id=' + book.id
		}
			
			const update = (book) => {

				// capturamos el formulario
				const form = document.querySelector('#form')
				form.isbn.value = book.isbn
				form.name.value = book.name
				form.year.value = book.year
				form.author.value = book.author
				form.description.value = book.description


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
			input_id.value = book.id
			input_id.id = 'genElement001'

			const input_picture_url = document.createElement('input')
			input_picture_url.type = 'hidden'
			input_picture_url.name = 'pictureUrl'
			input_picture_url.value = book.pictureUrl
			input_picture_url.id = 'genElement002'

			// agregamos estos campos creados al formulario
			form.appendChild(input_id);
			form.appendChild(input_picture_url);
			// adaptamos el botón a una actualización
			// lo capturamos por su id
			form.button.textContent = 'Update'
			// cambiamos el método para que vaya a actualizar
			form.action = '/books/update'
		}

	</script>

</body>

</html>