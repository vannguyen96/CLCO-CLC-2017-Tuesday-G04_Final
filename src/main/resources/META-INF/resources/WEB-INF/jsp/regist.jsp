<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="//cdn.ckeditor.com/4.6.2/full/ckeditor.js"></script>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User Registration Form</title>
</head>

<body>
	<div class="well lead">EDIT PAGE </div>
	<form:form method="POST" modelAttribute="webInfo"
		class="form-horizontal">
			<form:input type="hidden" path="page_id" id="id"/>
		<label class="col-md-3 control-lable" for="description">Description</label>
		<form:input type="text" path="description" id="description"
			class="form-control input-sm" />
</br>
		<label class="col-md-3 control-lable" for="content">Content</label>
		</br>
			
		<form:textarea path="content" id="txtnoidung"/>

		<input type="submit" value="Submit" class="btn btn-primary btn-sm" /> or <a
			href="<c:url value='/' />">Cancel</a>
	</form:form>

<script>
		CKEDITOR.replace( 'txtnoidung', {
			height: 300,

			// Configure your file manager integration. This example uses CKFinder 3 for PHP.
			filebrowserBrowseUrl: '/ckfinder/ckfinder.html',
			filebrowserImageBrowseUrl: '/ckfinder/ckfinder.html?type=Images',
			filebrowserUploadUrl: '/up',
			filebrowserImageUploadUrl: '/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images'
			
		} );
	
		
	</script>
</body>