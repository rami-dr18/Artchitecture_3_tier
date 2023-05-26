<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Ordonnance Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a type="submit" href="?action=listord" class="nav-link">Ordonnances</a></li>
                          <li><a type="submit" href="?action=home" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${ord != null}">
                           
                             <form method="post" action="/project3tier_part2/ord">
                             <input name="action" type="hidden" value="update"/>
                        </c:if>
                        <c:if test="${ord == null}">
                          
                             <form method="post" action="/project3tier_part2/ord">
                               <input name="action" type="hidden" value="insert"/>
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${ord != null}">
                                    Edit Ordonnance
                                </c:if>
                                <c:if test="${ord == null}">
                                    Add New Ordonnace
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${ord != null}">
                            <input type="hidden" name="id" value="<c:out value='${ord.id}' />" />
                        </c:if>
 						<fieldset class="form-group">
                            <label>ID du Ordonnace</label> <input type="text" value="<c:out value='${ord.id}' />" class="form-control" name="id" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nom du Patient</label> <input type="text" value="<c:out value='${ord.nomp}' />" class="form-control" name="nomp" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Prenom du Patient</label> <input type="text" value="<c:out value='${ord.prenomp}' />" class="form-control" name="prenomp">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nom de Medicament</label> <input type="text" value="<c:out value='${ord.nommedicament}' />" class="form-control" name="nommedicament">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Adosage De Medicament</label> <input type="text" value="<c:out value='${ord.dosagemedicament}' />" class="form-control" name="dosagemedicament">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Cin du Patient</label> <input type="text" value="<c:out value='${ord.cinp}' />" class="form-control" name="cinp">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>