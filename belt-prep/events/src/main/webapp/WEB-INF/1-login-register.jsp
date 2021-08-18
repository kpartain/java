<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <!--  UTF AND TITLE -->
        <meta charset="UTF-8" />
        <title>ASSIGNMENT</title>

        <!-- for Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <!-- YOUR own local CSS -->
        <link rel="stylesheet" type="text/css" href="/css/style.css" />
        <!-- For any Bootstrap that uses JS or jQuery-->
        <!-- 	<script src="/webjars/jquery/jquery.min.js"></script>-->
        <!-- 	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
    </head>
    <body>
        <div class="d-flex justify-content-around">
            <h1>LOGIN & REGISTRATION</h1>
        </div>

        <div class="d-flex justify-content-between mx-5 gap-5">
            <!-- *****************************************************REGISTER***************************************************** -->
            <div class="w-50 border border-dark p-3">
                <h3>Register</h3>
                <form:form
                    action="/register"
                    method="post"
                    modelAttribute="newUser"
                >
                    <span>
                        <form:errors path="firstName" class="text-danger" />
                    </span>
                    <div
                        class="d-flex justify-content-between gap-2 w-100 mb-2"
                    >
                        <label>First Name:</label>
                        <div class="w-50">
                            <form:input
                                path="firstName"
                                class="form-control"
                                placeholder="first name"
                            />
                        </div>
                    </div>
                    <span>
                        <form:errors path="lastName" class="text-danger" />
                    </span>
                    <div
                        class="d-flex justify-content-between gap-2 w-100 mb-2"
                    >
                        <label>Last Name:</label>
                        <div class="w-50">
                            <form:input
                                path="lastName"
                                class="form-control"
                                placeholder="last name"
                            />
                        </div>
                    </div>
                    <span>
                        <form:errors path="state" class="text-danger" />
                        <form:errors path="city" class="text-danger" />
                    </span>
                    <div class="d-flex justify-content-between w-100 mb-2">
                        <label>Location:</label>
                        <div class="d-flex w-50">
                            <form:input
                                path="city"
                                class="form-control"
                                placeholder="city"
                            />
                            <form:select
                                path="state"
                                name="state"
                                class="form-control-sm"
                            >
                                <c:forEach
                                    items="${listOfStateCodes}"
                                    var="state"
                                    varStatus="loop"
                                >
                                    <form:option value="${state}">
                                        <c:out value="${state}"></c:out>
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <span>
                        <form:errors path="email" class="text-danger" />
                    </span>
                    <div
                        class="d-flex justify-content-between gap-2 w-100 mb-2"
                    >
                        <label>Email:</label>
                        <div class="w-50">
                            <form:input
                                path="email"
                                class="form-control"
                                placeholder="email"
                            />
                        </div>
                    </div>
                    <span>
                        <form:errors path="password" class="text-danger" />
                    </span>
                    <div class="d-flex justify-content-between gap-2 mb-2">
                        <label>Password:</label>
                        <div class="w-50">
                            <form:password
                                path="password"
                                class="form-control"
                                placeholder="password"
                            />
                        </div>
                    </div>
                    <span>
                        <form:errors path="confirm" class="text-danger" />
                    </span>
                    <div class="d-flex justify-content-between gap-2 mb-2">
                        <label>Confirm Password:</label>
                        <div class="w-50">
                            <form:password
                                path="confirm"
                                class="form-control"
                                placeholder="re-enter password"
                            />
                        </div>
                    </div>
                    <div class="d-flex align-items-end flex-column">
                        <input
                            type="submit"
                            value="Register"
                            class="btn btn-primary"
                        />
                    </div>
                </form:form>
            </div>
            <!-- *****************************************************LOGIN *****************************************************************-->
            <div class="w-50 border border-dark p-3 ms-5">
                <form:form
                    action="/login"
                    method="post"
                    modelAttribute="newLogin"
                >
                    <h3>Login</h3>
                    <span>
                        <p class="text-danger">
                            <c:out value="${loginErrors}" />
                        </p>
                    </span>
                    <span>
                        <form:errors path="email" class="text-danger"
                    /></span>
                    <div class="d-flex justify-content-between gap-2 mb-2">
                        <label>Email:</label>
                        <div class="w-50">
                            <form:input path="email" class="form-control" />
                        </div>
                    </div>
                    <span>
                        <form:errors path="password" class="text-danger" />
                    </span>
                    <div class="d-flex justify-content-between gap-2 mb-2">
                        <label>Password:</label>
                        <div class="w-50">
                            <form:password
                                path="password"
                                class="form-control"
                            />
                        </div>
                    </div>
                    <div class="d-flex align-items-end flex-column">
                        <input
                            type="submit"
                            value="Login"
                            class="btn btn-success"
                        />
                    </div>
                </form:form>
            </div>

            <!--  end main flex parent box -->
        </div>
    </body>
</html>
