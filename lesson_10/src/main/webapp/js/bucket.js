function myFunction() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

let bucket = null;

$.get("allBuckets", function(data) {
	if (data !== '') {
		bucket = data;

	}

}).done(function() {
	let tableContent = "<tr class='header'>" +
		"<th style='width: 20%;'>Title</th>" +
		"<th style='width: 20%;'>Author</th>" +
		"<th style='width: 20%;'>Price</th>" +
		"<th style='width: 20%;'>Purchase Date</th>" +
		"<th style='width: 20%;'>Options</th>" +
		"</tr>";

	jQuery.each(bucket, function(i, value) {
		tableContent += "<tr>" +
			"<td>" + value.title + "</td>" +
			"<td>" + value.author + "</td>" +
			"<td>" + value.price + "</td>" +
			"<td>" + value.purchaseDate + "</td>" +
			"<td><button onClick='deleteOrderFromBucket(" + value.bucketId + ")'>delete</button></td>" +
			"</tr>";
	})
	$('#myTable').html(tableContent);
});

function deleteOrderFromBucket(bucketId) {
	let customUrl = "";
	let urlContent = window.location.href.split('/');
	for (let i = 0; i < urlContent.length - 1; i++) {
		customUrl += urlContent[i] + '/';
	}
	customUrl += "bucket?bucketId=" + bucketId;

	$.ajax({
		url: customUrl,
		type: "DELETE",
		success: function(data) {
			if (data == "Success") {
				location.reload();
			}
		}
	});
}