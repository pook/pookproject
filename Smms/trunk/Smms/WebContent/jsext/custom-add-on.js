/**
 * 
 */
$.subscribe('test',function(event,data){
	alert('you success');
});
$.subscribe('rowselect', function(event, data) {
	alert('se'+event.originalEvent.orderId);
});
