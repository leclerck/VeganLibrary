<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Vegan Library - ${book.name}</title>
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
						<div class="col-lg-8 px-md-5 py-5">
							<div class="row pt-md-2">
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
								<div class="col-10">
									<h1 class="mb-3">${book.name}</h1>
								</div>
								<div class="col-2"></div>
								<div class="meta-wrap">
									<p class="meta">
										<span><a href=""><i class="icon-calendar mr-2"></i>${book.year}</a></span>
										<!-- STARS -->
										<span class="mr-1"> <fmt:parseNumber
												value="${book.stars}" var="whole" integerOnly="TRUE"
												type="NUMBER"></fmt:parseNumber> <c:forEach begin="1"
												end="${whole}" varStatus="loop">
												<i class="fas fa-star"></i>
											</c:forEach> <c:set var="half" value="0"></c:set> <c:if
												test="${book.stars - whole >= .25 && book.stars - whole < .75}">
												<i class="fas fa-star-half-alt"></i>
												<c:set var="half" value="1"></c:set>
											</c:if> <c:if test="${5- book.stars>=1}">
												<c:forEach begin="${whole+half+1}" end="5" varStatus="loop">
													<i class="far fa-star"></i>
												</c:forEach>
											</c:if> Stars
										</span>
										<!-- STARS -->
										<span><a href=""><i class="icon-comment2 mr-2"></i>${book.reviews.size()}</a></span>
										<!-- IMPLEMENTAR DESCARGA -->
										<a href="/books/${book.fileUrl}" download><button type="button" class="btn btn-primary ml-4">Download
											Here</button></a>
									</p>
								</div>
								<div class="row mb-4">
									<div class="col-lg-7">
										<img style="width: 400px;"
											src="../pictures/books/${book.pictureUrl}" alt=""
											class="img-fluid">
									</div>
									<div class="col-lg-4">
										<p>ISBN: ${book.isbn}</p>
										<p>Author: ${book.author}</p>

									</div>
								</div>
								<div class="row mb-4 w-100">
									<div class="col-12 overflow-visible">
										<p class="overflow-visible">${book.description}</p>
									</div>
								</div>

								<!-- 								<div class="tag-widget post-tag-container mb-5 mt-5"> -->
								<!-- 									<div class="tagcloud"> -->
								<!-- 										<a href="#" class="tag-cloud-link">Life</a> <a href="#" -->
								<!-- 											class="tag-cloud-link">Sport</a> <a href="#" -->
								<!-- 											class="tag-cloud-link">Tech</a> <a href="#" -->
								<!-- 											class="tag-cloud-link">Travel</a> -->
								<!-- 									</div> -->
								<!-- 								</div> -->


								<div class="pt-5">
									<h3 class="mb-5 font-weight-bold">${book.reviews.size()}
										Reviews</h3>
									<ul class="comment-list">
										<li class="comment">
											<div class="vcard bio">
												<img src="../frontImages/person_1.jpg"
													alt="Image placeholder">
											</div> <!-- 1ST COMMENT -->
											<div class="comment-body">
												<h4>This book sucks</h4>
												<p>
													<i class="fas fa-star"></i><i class="far fa-star"></i><i
														class="far fa-star"></i><i class="far fa-star"></i><i
														class="far fa-star"></i> Stars
												</p>
												<h5>John Doe</h5>
												<div class="meta">October 03, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
											</div>
										</li>
										<!-- 1ST COMMENT# -->
										<c:forEach var="review" items="${book.reviews}">
											<li class="comment">
												<div class="vcard bio">
													<img
														src="../pictures/customers/${review.customer.avatarUrl}"
														alt="Image placeholder">
												</div> <!-- 1ST COMMENT -->
												<div class="comment-body">
													<h4>${review.title}</h4>

													<!-- STARS -->
													<span class="mr-1"> <fmt:parseNumber
															value="${review.stars}" var="whole" integerOnly="TRUE"
															type="NUMBER"></fmt:parseNumber> <c:forEach begin="1"
															end="${whole}" varStatus="loop">
															<i class="fas fa-star"></i>
														</c:forEach> <c:set var="half" value="0"></c:set> <c:if
															test="${review.stars - whole >= .25 && review.stars - whole < .75}">
															<i class="fas fa-star-half-alt"></i>
															<c:set var="half" value="1"></c:set>
														</c:if> <c:if test="${5- review.stars>=1}">
															<c:forEach begin="${whole+half+1}" end="5"
																varStatus="loop">
																<i class="far fa-star"></i>
															</c:forEach>
														</c:if> Stars
													</span>
													<!-- STARS -->

													<h5>${review.customer}</h5>
													<div class="meta">${review.date}</div>
													<p>${review.content}</p>
												</div>
											</li>
										</c:forEach>
									</ul>
									<!-- END comment-list -->
									<!-- FORM -->
									<div class="comment-form-wrap pt-5">
										<h3 class="mb-5">Leave a review</h3>
										<form id="reviewForm"
											action="<c:url value='/books/detail?id=${book.id}'/>"
											method="post" class="p-3 p-md-5 bg-light">
											<div class="form-group">
												<label for="title">Title: </label> <input type="text"
													class="form-control" id="title" name="title">
											</div>
											<div class="form-group">
												<label>Stars: &nbsp;</label>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="inlineRadio1"
														value="option1"> <label class="form-check-label"
														for="inlineRadio1">1</label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="inlineRadio2"
														value="option2"> <label class="form-check-label"
														for="inlineRadio2">2</label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="inlineRadio3"
														value="option1"> <label class="form-check-label"
														for="inlineRadio3">3</label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="inlineRadio4"
														value="option2"> <label class="form-check-label"
														for="inlineRadio4">4</label>
												</div>
												<div class="form-check form-check-inline">
													<input class="form-check-input" type="radio"
														name="inlineRadioOptions" id="inlineRadio5"
														value="option1"> <label class="form-check-label"
														for="inlineRadio5">5</label>
												</div>
											</div>
											<div class="form-group">
												<label for="content">Message</label>
												<textarea name="content" id="content" cols="30" rows="10"
													class="form-control"></textarea>
											</div>
											<div class="form-group">
												<input type="submit" value="Post Review"
													class="btn py-3 px-4 btn-primary">
											</div>
											<!-- IMPLEMENTAR FORMULARIO -->
										</form>
									</div>
									<!-- FORM -->
								</div>
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