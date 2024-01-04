$(document).ready(function() {
	$('.leftmenutrigger').on('click', function(e) {
		$('.side-nav').toggleClass("open");
		e.preventDefault();
	});
});


$("button.book-logout").click(function() {

	$.get("logout", function(data) {
		if (data != '') {
			let customUrl = '';
			let urlContent = window.location.href.split('/');

			for (let i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + '/';
			}
			customUrl += data;
			window.location = customUrl;
		}

	});
});

let role = null;

$.get("userRole", function(data) {
	if (data !== '') {
		role = data;
	}
}).done(function() {
	if (role === "ADMINISTRATOR") {
		$('li.for-user').hide();
		$('a.for-user').hide();
	} else {
		$('li.for-admin').hide();
	}
});
