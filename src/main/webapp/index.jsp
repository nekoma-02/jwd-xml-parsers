<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<body>
<form action="Controller" method="post" enctype="multipart/form-data">
<input type="text" hidden="true" name="command" value="parse">
<input type="file" name="file" required> 
<input type="submit" name="type_parser" value="SAX">
<input type="submit" name="type_parser" value="STAX">
<input type="submit" name="type_parser" value="DOM">
</form>

</body>
</html>
