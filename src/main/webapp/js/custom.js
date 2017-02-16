$('#get').click(function() {
	console.log("GET");
	$.ajax({
		type : "GET",
		cache : false,
		url : '/getRandomData',
		data : "",
		success : function(response) {
			var html = "";
			$.each(response.data, function(i) {
				html = html + response.data[i] + "<br/>";
			});
			$('#container').html(html);
		}
	});
	console.log("after GET");
});

$('#post').click(function() {
	console.log("POST");
	if (!$("#data").val()) {
		alert("Enter your data!");
	} else {
		$.ajax({
			type : "POST",
			cache : false,
			url : '/persist',
			data : {
				'data' : $("#data").val()
			},
			success : function(response) {
				$('#get').click();
			}
		});
	}
	console.log("after POST");
});