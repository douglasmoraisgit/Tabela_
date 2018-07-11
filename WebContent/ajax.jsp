<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SO question 4112686</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
/* $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$.get("TesteAjax", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
$("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
});
});*/

/*   $(document).on("click", "#somebutton", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$.get("TesteAjax", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
var $ul = $("<ul>").appendTo($("#somediv")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
$.each(responseJson, function(index, item) { // Iterate over the JSON array.
$("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
});
});
});*/
/*  $(document).on("click", "#somebutton", function() {               // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$.get("TesteAjax", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
var $select = $("#someselect");                           // Locate HTML DOM element with ID "someselect".
$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
$.each(responseJson, function(key, value) {               // Iterate over the JSON object.
$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
});
});
});   */

            $(document).on("click", "#somebutton", function() {        // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.get("TesteAjax", function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                    var $table = $("<table>").appendTo($("#somediv")); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
                    $.each(responseJson, function(index, produto) {    // Iterate over the JSON array.
                        $("<tr>").appendTo($table)                     // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
                            .append($("<td>").text(produto.idProduto))        // Create HTML <td> element, set its text content with id of currently iterated product and append it to the <tr>.
                            .append($("<td>").text(produto.nomeProduto))      // Create HTML <td> element, set its text content with name of currently iterated product and append it to the <tr>.
                            .append($("<td>").text(produto.nomeMaterial));    // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
                    });
                });
            });
            
        </script>
    </head>
    <body>
        <button id="somebutton">press here</button>
        <div id="somediv"></div>
       <!-- <select id="someselect" style="width: 60px"></select>-->
    </body>
</html>