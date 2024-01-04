let books = null;

$.get("allBooks", function(data) {
	if (data !== '') {
		books = data;
		
	}

}).done(function() {
	let cardsContent = "";
	
	jQuery.each(books, function(i, value) {
		cardsContent += "<div class='col'>" +
						"<div class='card'>" +
						"<div class='card-body'>" +
						"<h5 class='card-title'>" + value.title + "</h5>" +
						"<h6 class=card-subtitle mb-2 text-muted'>" + value.author + "</h6>" +
						"<p class='card-text'>" + value.price + "</p>" +
						"<a href='book?id=" + value.id +"' class='card-link for-user'>link</a>" +
						"</div>" + 
						"</div>" + 
						"</div>" + 
						"</div>";
	})
	$('#booksCards').html(cardsContent);
});