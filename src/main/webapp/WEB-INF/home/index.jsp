<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
						
						<div class="alert alert-info" role="alert">Logged in as 
						<c:out value="${username}"></c:out>
						</div>
							<div class="row pt-md-4">

								<div class="col-md-12">

									<c:if test="${books.isEmpty()}">
									<h2>No books yet.</h2>
									</c:if>
									<c:forEach var="book" items="${books}">

										<div class="blog-entry ftco-animate d-md-flex">
											<a href="/books/detail?id=${book.id}" class="img img-2"
												style="background-image: url(<c:url value='../pictures/books/${book.pictureUrl}'></c:url>);"></a>
											<div class="text text-2 pl-md-4">
												<h3 class="mb-2">
													<a href="/books/detail?id=${book.id}">${book.name}</a>
												</h3>

												<div class="meta-wrap">
													<p class="meta">
														<span><i class="icon-calendar mr-2"></i>${book.year}</span>
														<span>${book.stars}<i
																class="fas fa-star mr-2"></i>
														</span> <span>><i class="icon-comment2 mr-2"></i>${book.reviews.size()}
																Reviews</span>
													</p>
												</div>
												<p>ISBN: ${book.isbn}</p>
												<p>Author: ${book.author}</p>
												<p class="mb-4">
													<c:choose>
														<c:when test="${book.description.length()>=15}">
															<c:out value="${book.description.substring(0,15)}" />...
														</c:when>
														<c:otherwise>
															<c:out value="${book.description}" />
														</c:otherwise>
													</c:choose>
												</p>
												<p>

													<a href="books/detail?id=${book.id}" class="btn-custom">Read
														More <span class="ion-ios-arrow-forward"></span>
													</a>
												</p>
											</div>
										</div>
									</c:forEach>

								</div>

							</div>
							<!-- END-->
<!-- 							<div class="row"> -->
<!-- 								<div class="col"> -->
<!-- 									<div class="block-27"> -->
<!-- 										<ul> -->
<!-- 											<li><a href="#">&lt;</a></li> -->
<!-- 											<li class="active"><span>1</span></li> -->
<!-- 											<li><a href="#">2</a></li> -->
<!-- 											<li><a href="#">3</a></li> -->
<!-- 											<li><a href="#">4</a></li> -->
<!-- 											<li><a href="#">5</a></li> -->
<!-- 											<li><a href="#">&gt;</a></li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
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