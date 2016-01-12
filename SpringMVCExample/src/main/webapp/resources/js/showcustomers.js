$(document).ready(function(){ 
	$( "#tabs" ).tabs();
	$.ajax({		
        url: contextRoot+'customers/All',
        type:'get',
        async : true,
        success: function(data){
        	loadCustomersGrid(data);
        }
	});
	
	
	function loadCustomersGrid(data){
		$("#customersGrid").jqGrid({
            datatype: 'jsonstring',
            datastr: data,
            editurl: 'clientArray',
            colNames: ['','Name','City','Street'],
            width: 500,
            height: 500,
            'cellEdit': true,
            colModel: [
                       { name: 'uniqueJqGridId', index: 'customerId',hidden:true, width: 0,key:true, sortable: false},
                       { name: 'name', index: 'name', width: 75, sortable: true}, 
                       { name: 'city', index: 'city',editable:true,edittype:'text', width: 115 },
                       { name: 'street', index: 'street',editable:true,edittype:'text', width: 115 }
            ],
            jsonReader: {
                repeatitems: false
            },                                     
            sortorder: "asc",
            viewrecords: true,
            shrinkToFit: true
        });		
	}
	
});