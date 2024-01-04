$("button.createBook").click(function() {
	let title = $("form.createBook input.bookTitle").val();
	let author = $("form.createBook input.bookAuthor").val();
	let price = $("form.createBook input.bookPrice").val();

	if (title == '' || author == '' || price == '') {
		alert("Please fill all fields...!!!!!!");
	} else {
		let book = {
			title: title,
			author: author,
			price: price,
		};
		$.post("book", book, function(data) {
			if (data == "Success") {
				alert("Success");
			}

		});
	}
});

$("button.buy-book").click(function() {
	let bookId = jQuery(this).attr("book-id");

	$.post("bucket", {bookId: bookId}, function(data) {
		if (data == "Success") {
			$("[data-dismiss=modal]").trigger({ type: "click" });
			alert("Success");
		}

	});
});