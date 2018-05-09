<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>
<head>
  <title>LMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">LMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="All-tasks">All Task</a></li>
      
          <li><a href="New-task">Add Task</a></li>
        </ul>
      
  </div>
</nav>

<div class="container"> 
<div class="jumbotron text-center">
 <h1> Welcome to Task Manager</h1>
</div>
</div>
  
  
  
  <c:choose>
  
  <c:when test="${ mode=='TASKS'}">
  
  <div class="container text-center">

<table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Task Name</th>
        <th>Description</th>
        <th>Finished</th>
        <th>Due Date</th>
         <th> Edit</th>
         <th> Delete</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="task" items="${allTasks}">
       <tr>
       <td> ${task.id}</td>
       <td> ${task.name}</td>
       <td> ${task.description}</td>
       <td> ${task.finished}</td>
       <td> ${task.duedate}</td>
       
       <td> <a href="Update-tasks?id=${task.id}"> <span class="glyphicon glyphicon-pencil"></span></a></td>
       <td> <a href="Delete-task?id=${task.id}"> <span class="glyphicon glyphicon-trash"></span></a></td>
       
       </tr>
      </c:forEach>
   
    </tbody>
  </table>
 
  </div>
  
  </c:when>
  
  
  <c:when test="${ mode=='HOME'}">
  
  </c:when>
  
  <c:when test="${ mode=='NEW' || mode=='UPDATE'}">
  
  
  <div class="container text-center">
  <h3> Manage Task</h3>
  <form class="form-horizontal" method="post" action="Save-task">
  <input type="hidden" name="id" value="${task.id}"/>
  
		  <div class="form-group">
		  <label class="control-label col-md-3"> Name</label>
		  <div class="col-md-7">
		  <input type="text" class="form-control" name="name" value="${task.name }">
		  
		  </div>
		  </div>
		  
		  
		  <div class="form-group">
		  <label class="control-label col-md-3"> Description</label>
		  <div class="col-md-7">
		  <input type="text" class="form-control" name="description" value="${task.description }">
		  </div>
		  </div>
		  
		  
		  
		  <div class="form-group">
		  <label class="control-label col-md-3"> Finished</label>
		  <div class="col-md-7">
		  <input type="radio" class="col-sm-1" name="finished"  value="true">
		  <div class="col-sm-1">Yes</div>
		  <input type="radio" class="col-sm-1" name="finished" value="false">
		   <div class="col-sm-1">No</div>
		  
		  </div>
		  
		  <div class="pul-right">
		  <input type="submit" class="btn btn-primary" value="Save">
		  
		  </div>
  </div>
  </form>
  
  </div>
  </c:when>
  
  
  
  
  </c:choose>
  


</body>
</html>