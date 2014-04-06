$(document).ready(function(){ 
	$( "select[name='country']" ).change(function() {
		$.getJSON('api/regions', {
			countryId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var html = '<option value="0">---Регион---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				html += '<option value="' + data[i].regionId + '">'
						+ data[i].regionName + '</option>';
			}
			html += '</option>';
			$("select[name='region']").html(html);
			$("select[name='city']").html('<option value="0">---Город---</option>');
			$("select[name='district']").html('<option value="0">---Район---</option>');
		});
	});
});


$(document).ready(function(){ 
	$( "select[name='region']" ).change(function() {
		$.getJSON('api/cities', {
			regionId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var html = '<option value="0">---Город---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				html += '<option value="' + data[i].cityId + '">'
						+ data[i].cityName + '</option>';
			}
			html += '</option>';
			$("select[name='city']").html(html);
			$("select[name='district']").html('<option value="0">---Район---</option>');
		});
	});
});


$(document).ready(function(){ 
	$( "select[name='city']" ).change(function() {
		$.getJSON('api/districts', {
			cityId : $(this).val(),
			ajax : 'true'
		}, function(data) {
			var html = '<option value="0">---Район---</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				html += '<option value="' + data[i].districtId + '">'
						+ data[i].districtName + '</option>';
			}
			html += '</option>';
			$("select[name='district']").html(html);
		});
	});
});
		
		
