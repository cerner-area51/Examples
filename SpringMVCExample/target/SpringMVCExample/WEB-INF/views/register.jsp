<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="This Jsp saves a custmer to db" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

<script type="text/javascript">
//undefined and null
var u;
var v = null;
console.log(u);
console.log(v);
var name = "ravi";
var name1 = 'peter';
var x = 10;
var b = false;
//alert(x);
console.log("The value of name1 is"+name1);

function add(x, y){
	var z= 20;
	return x+y+z;
}
console.log(add(1,2));
//creating javascript object
var customer = new Object();
customer.name="Harry";
customer.age = 25;
customer.city = "Parlin";

var book = {name:"How to Program",price:40,author:"Dietel"};

function Person(firstname, lastname){
	this.firstname = firstname;
	this.lastname = lastname;
}

var p1 = new Person("Harry","Reid");
var p2 = new Person("Clinton","Bill");

console.log(customer);


$( document ).ready(function() {
    console.log( "ready!" );
});
</script>
</head>
<body>
	
	<h2>Register Customer</h2>
	<fieldset style="width: 400px;">
		<legend>Enter Customer Details</legend>
		<form id="registerForm">
			<table>
				<tr>
					<td>Customer Name:</td>
					<td><input type="text" name="name" value="Raju" id="customerName"/></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="city" class="cityCl"/></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><input type="text" name="street" id="street"/></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="state" /></td>
				</tr>
				<tr>
					<td>Postal Code:</td>
					<td><input type="text" name="zipCode" /></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input type="text" name="country" /></td>
				</tr>
			</table>
			<input type="button" value="Create" name="operation"  id="createBttn" /> 
		</form>
	</fieldset>

</body>
<script type="text/javascript">
$("#createBttn").click(function(){
	validate();
});
	console.log(document.getElementById("customerName").value);
	var contextRoot = '<c:url value= "/"/>';
	console.log(contextRoot);
	function validate(){
		var streetVal = document.getElementById("street").value;
		if(streetVal == null || streetVal == ""){
			alert("Street has to be entered");
			return false;
		}else{
			$.ajax({
				url: contextRoot+"customers/SAVE", 
				type : 'POST',
				data: $("#registerForm").serialize(),
				success: function(result){
		        	alert(result);
		    	},failure: function(){
		    		
		    	}
			});
		}
	}
</script>

</html>