/**
 * 
 */

$(document).ready(function(){
	
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&#]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null) {
	       return null;
	    }
	    return decodeURI(results[1]) || 0;
	}
	
	if ($.urlParam('access_token') != null) {
		window.localStorage.setItem('access_token', $.urlParam('access_token'));
		window.location.href='http://localhost:8081/list.html';
	}
	
	
	
	$('#submit-button').click(function() {
		$.ajax({
			url:   'http://localhost:8080/oauth/token?grant_type=password',
			type: 'POST',
			data: jQuery.param({ username: $('input[name="username"]').val(), password: $('input[name="password"]').val()}),
			beforeSend: function (xhr) {
				xhr.setRequestHeader('Authorization', 'Basic Y2xpZW50ZToxMjM0NTY=');
			},
			contentType: "application/x-www-form-urlencoded",
			success: function(response) {
				window.localStorage.setItem('access_token', response.access_token);
				window.location.href='http://localhost:8081/list.html';				
			},
			error: function(xhr, textStatus, error) {
	            console.log(xhr.responseText);
	            console.log(xhr.statusText);
	            console.log(textStatus);
	            console.log(error);

	          }
		});
		
	});
	
	
	
});