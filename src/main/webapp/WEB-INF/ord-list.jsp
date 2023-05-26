<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
        <html>

        <head>
            <title>Ordonnace Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                       <b>Ordonnance Management App</b> 
  
                    </div>

                    <ul class="navbar-nav">
                        <li><a type="submit" href="?action=listord" class="nav-link">Ordonnances</a></li>
                        <li><a type="submit" href="?action=home" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Ordonnaces</h3>
                    <hr>
                    <div class="container text-left">

        <a type="submit" href="?action=new&id=<c:out value='${ord.id}' />"  class="btn btn-success">Add
     New Ordonnance</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NomP</th>
                                <th>PrenomP</th>
                                <th>Nom Medicament</th>
                                 <th>Dosage Medicament</th>
                                  <th>Cin Patient</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="ord" items="${listOrd}">

                                <tr>
                                  <td>
                                        <c:out value="${ord.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${ord.nomp}" />
                                    </td>
                                    <td>
                                        <c:out value="${ord.prenomp}" />
                                    </td>
                                    <td>
                                        <c:out value="${ord.nommedicament}" />
                                    </td>
                                    <td>
                                        <c:out value="${ord.dosagemedicament}" />
                                    </td>
                                    <td>
                                        <c:out value="${ord.cinp}" />
                                   </td>
                                   <td>
                                   <form method="get" action="/project3tier_part2/ord">
                                   <intput type="hidden" name="action" value="edit" >                                
                                     <a type="submit" href="?action=edit&id=<c:out value='${ord.id}' />">Edit</a> 
                                   </form>
                                   <form method="get" action="/project3tier_part2/ord"> 
                                   <intput type="hidden" name="action" value="delete" >                                   
                                    <a type="submit" href="?action=delete&id=<c:out value='${ord.id}' />">Delete</a>                                   
                                   </form>
                                     </td>
                           </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>