<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Retrieving All Parameters</title>
 </head>
<body>
<h4>Order your Pizza Here</h4>
<form action="ParamNames" method="post">
<b>Name</b> <input type="text" name="name"><br><br>
<b>Select the Crust:</b> 
<select name = "crust">
<option value="pan">Pan</option>
<option value="thin">Thin Crust</option>
<option value="deep">Deep Crust</option>
<option value="cheese">Cheese Burst</option>
</select> <br><br>
<b>Toppings: </b><br>
<input type="checkbox" name="toppings" value="peas">Peas<br>
<input type="checkbox" name="toppings" value="paneer">Paneer<br>
<input type="checkbox" name="toppings" value="redpeppers">Red Peppers<br>
<input type="checkbox" name="toppings" value="pineapple">Pineapple<br>
<input type="checkbox" name="toppings" value="onion">Onion<br>
<input type="checkbox" name="toppings" value="tomato">Tomato<br><br>
 
<b>Select 1 FREE Appetizer</b>
<input type="radio" name="appetizer" value="Garlic Bread">Garlic Bread
<input type="radio" name="appetizer" value="Cheese Garlic Bread">Cheese Garlic Bread
<input type="radio" name="appetizer" value="Veg Soup">Veg Soup
<input type="radio" name="appetizer" value="Veg Sandwich">Veg Sandwich<br><br>
 
<b>Address</b><br>
<textarea name="address" rows=3 cols=40></textarea><br><br>
<b>Credit Card:</b><br>
<input type="radio" name="cardType" value="Visa">Visa
<input type="radio" name="cardType" value="MasterCard">MasterCard
<input type="radio" name="cardType" value="Amex">American Express
<br><br>
<b>Credit Card Number:</b> <input type="password" name="cardNum">
<b>Repeat Credit Card Number: </b><input type="password" name="cardNum"><br><br>
<input type="submit" name="submit" value="Order Pizza">
</form>
</body>
</html>