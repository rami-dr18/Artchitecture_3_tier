<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
        <html>

        <head>
            <title>Rdv Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                       <b>Rdv Management App</b> 
  
                    </div>

                    <ul class="navbar-nav">
                        <li><a type="submit" href="?action=listrdv" class="nav-link">Rdvs</a></li>
                          <li><a type="submit" href="?action=home" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Rdvs</h3>
                    <hr>
                    <div class="container text-left">

                        
                           <a type="submit" href="?action=new&id=<c:out value='${rdv.id}' />"  class="btn btn-success">Add New Rdv</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DATERDV</th>
                                <th>CINP</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="rdv" items="${listRdv}">

                                <tr>
                                  <td>
                                        <c:out value="${rdv.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${rdv.daterdv}" />
                                    </td>
                                    <td>
                                        <c:out value="${rdv.cinp}" />
                                    </td>
                                    
                                   <td>
                                   <form method="get" action="/project3tier_part2/rdv">
                                   <intput type="hidden" name="action" value="edit" >                                
                                     <a type="submit" href="?action=edit&id=<c:out value='${rdv.id}' />">Edit</a> 
                                   </form>
                                     <form method="get" action="/project3tier_part2r/rdv"> 
                                   <intput type="hidden" name="action" value="delete" >                                   
                                    <a type="submit" href="?action=delete&id=<c:out value='${rdv.id}' />">Delete</a>                                   
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