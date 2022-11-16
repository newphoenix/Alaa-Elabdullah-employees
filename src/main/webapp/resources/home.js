$(document).ready(function(){
	
});

var tableHeader = `  
   <thead>
    <tr>
      <th scope="col">Employee ID #1</th>
      <th scope="col">Employee ID #2</th>
      <th scope="col">Project ID</th>
      <th scope="col">Days worked</th>
    </tr>
  </thead>`;

function upload(){
	
	$("#errorBox").addClass("d-none");
	
	let csv = $('#csv');
	if(csv.get(0).files.length == 0){
		return writeMessage('Please select a file');
	}	
	
	if($('#csv').get(0).files[0].size > 5242880){
		return writeMessage('Max file size is 5 Megabytes');
	}

	let formData = new FormData();
    formData.append("file", csv.get(0).files[0]);

    let table = $('#table');
    table.empty();
    
	$.ajax({
		type : "POST",
		url : "/employees",
		data : formData,
		dataType:'json',
	    processData: false,
		contentType: false,
		success : function(data) {
		
			if (data && data.length > 0) {	
				
				table.append(tableHeader);	
				table.append('<tbody>');		
				data.forEach(record =>{
					let emp1 = record.employeeId1;
					let emp2 = record.employeeId2;
					let projId = record.projectId;
					let days = record.daysWorked;
					table.append(`<tr><td>${emp1}</td><td>${emp2}</td><td>${projId}</td><td>${days}</td></tr>`,)
				});
				
				table.append('</tbody>');	
			}else{
				table.append('<tbody><tr><td>No Overlapping found</td></tr></tbody>');
			}
				
		},
		error : function() {
				writeMessage('Error please try later');	
		}
	});
	
	
}

function writeMessage(msg){
            $("#rmsg").text(msg);
	        $("#errorBox").addClass("alert-danger").removeClass("d-none");		
}