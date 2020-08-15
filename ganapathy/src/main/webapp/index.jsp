<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>




<html>

<body class="text-center">
<div class="alert-danger", role="alert", id="error-group", style="display: none"></div>
    <div >
       
    <div class="row add-form" >
          <div class="col-6">
            <div class="card2">
                 
                  <form id="formadd1" class="mt-2" >
                     <div class="row">
                        <div class="col-sm-6">
                          
                          
                          <div class="form-group" >
                              <label for="pwd" class="label">Veg</label>
                              <input type="radio" class="main" name="group" value="veg" id="veg">
                              <label for="pwd" class="label">Non-Veg</label>
                              <input type="radio" class="main1"  name="group" value="nonveg" id="nonveg">
                          </div>
                           <div class="form-group sub" style="display:none;">
                              <label for="pwd" class="label">Search categories</label>
                              <input type="text"  name="search1" id="term1" class="form-control search" >
                          </div>
                          <div class="form-group sub1" style="display:none;">
                              <label for="pwd" class="label">Search Categories</label>
                              <input type="text"  name="search2" id="term2" class="form-control search2" >
                          </div>
                       </div>
                    </div>
                 </form>
               
              </div>
            </div> </div>
</br></br></br></br>
<table class="display responsive nowrap table-striped table-hover table-bordered" style="width:100%" id="example" >
   <thead>
      <tr>
          <th>id</th>
          <th>productname</th>
          <th>productdescription</th>
          <th>categories</th>
          
          <th></th>
      </tr>
    </thead>
    <tbody>
    
    </tbody>
  </table>

    </body>
</html>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	  $("#veg").on('input propertychange paste',function(){
		  alert('hi');
		  
		var data=
			{
				categories:$("#veg").val()
			};
	             
	             
	             

		  $("table tbody").empty();
		    $.ajax({
		      type:'POST',
		     
		      url:"ListController",
		      data:JSON.stringify(data),
		      dataType: "json",
		      contentType:"application/json",
		      
		      success: function(data) {
		    	  alert("data");
		        console.log(data);
		        for(var i=0;i<data.length;i++){
      var markup = "<tr><td>"+data[i].id+"</td><td>"+data[i].productname+"</td><td>"+data[i].productdescription+"</td><td>"+data[i].categories+"</td></tr>";
		          $("table tbody").append(markup);
		          
		        }          
		    
		    },
		  
		    });
		    return false;
		    
	    });
});
</script>

