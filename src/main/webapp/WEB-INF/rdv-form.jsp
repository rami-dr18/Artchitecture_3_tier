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
                        <a href="https://www.javaguides.net" class="navbar-brand"> RdvManagement App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listrdv" class="nav-link">Rdvs</a></li>
                          <li><a type="submit" href="?action=home" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${rdv != null}">
                            <form action="/project3tier_part2/rdv" method="post">
                            <input name="action" type="hidden" value="update"/>
                        </c:if>
                        <c:if test="${rdv == null}">
                         
                             <form method="post" action="/project3tier_part2/rdv">
                              <input name="action" type="hidden" value="insert"/>
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${rdv != null}">
                                    Edit Rdv
                                </c:if>
                                <c:if test="${rdv == null}">
                                    Add New Rdv
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${rdv != null}">
                            <input type="hidden" name="id" value="<c:out value='${rdv.id}' />" />
                        </c:if>
 						<fieldset class="form-group">
                            <label>ID du Rdv</label> <input type="text" value="<c:out value='${rdv.id}' />" class="form-control" name="id" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Date du Rdv</label> <input type="text" value="<c:out value='${rdv.daterdv}' />" class="form-control" name="daterdv" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Cin du Patient</label> <input type="text" value="<c:out value='${rdv.cinp}' />" class="form-control" name="cinp">
                        </fieldset>

                        

                        <button type="submit" class="btn btn-success">Save</button>
                        
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>