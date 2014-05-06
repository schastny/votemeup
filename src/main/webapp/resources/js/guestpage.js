$(document).ready(function(){ 
	$( "select[name='country']" ).change(function() {
		$.getJSON('filtr/api/regions', {
			countryId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var htmlStr = '<option value="0">---Регион---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				htmlStr += '<option value="' + data[i].regionId + '">'
						+ data[i].regionName + '</option>';
			}
			htmlStr += '</option>';
			$("select[name='region']").html(htmlStr);
			$("select[name='city']").html('<option value="0">---Город---</option>');
			$("select[name='district']").html('<option value="0">---Район---</option>');
		});
	});
});


$(document).ready(function(){ 
	$( "select[name='region']" ).change(function() {
		$.getJSON('filtr/api/cities', {
			regionId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var htmlStr = '<option value="0">---Город---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				htmlStr += '<option value="' + data[i].cityId + '">'
						+ data[i].cityName + '</option>';
			}
			htmlStr += '</option>';
			$("select[name='city']").html(htmlStr);
			$("select[name='district']").html('<option value="0">---Район---</option>');
		});
	});
});


$(document).ready(function(){ 
	$( "select[name='city']" ).change(function() {
		$.getJSON('filtr/api/districts', {
			cityId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var htmlStr = '<option value="0">---Район---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				htmlStr += '<option value="' + data[i].districtId + '">'
						+ data[i].districtName + '</option>';
			}
			htmlStr += '</option>';
			$("select[name='district']").html(htmlStr);
		});
	});
});
		
		
