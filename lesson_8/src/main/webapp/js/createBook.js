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
		$.post("books", book, function(data) {
			if (data == "Success") {
				alert("Success");
			}

		});
	}
});