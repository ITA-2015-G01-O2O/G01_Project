$(function() {
	$('#myTabs a[href="#profile"]').tab('show'); // Select tab by name
	$('#myTabs a:first').tab('show') ;// Select first tab
	$('#myTabs a:last').tab('show') ;// Select last tab
	$('#myTabs li:eq(2) a').tab('show');
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
	

	
});