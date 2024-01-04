<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<!--can delete -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/bottomFooter.css">

<title>Creating a book</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<form class="createBook ">
				<div class="form-group">
					<input type="text" class="form-control bookTitle"
						placeholder="Enter book title">
				</div>
				<div class="form-group">
					<input type="text" class="form-control bookAuthor"
						placeholder="Enter book author">
				</div>
				<div class="form-group">
					<input type="number" class="form-control bookPrice"
						placeholder="Enter book price">
				</div>
				<button class="btn btn-primary createBook">Submit</button>
			</form>
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<script src="js/header.js"></script>
	<script src="js/serverCalls.js"></script>
</body>
</html>