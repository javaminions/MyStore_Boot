(document).ready(function($) {
	
	$('#imgurl').bind('input', function() {
	    $('#blah').attr('src', $(this).val()); //concatinate path if required
	});

});