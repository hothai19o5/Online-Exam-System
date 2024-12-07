<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Exam System</title>

    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="../layout/sidebar.jsp" />
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="../layout/topbar.jsp" />
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <div class="mt-5">
                        <div class="row">
                            <div class="col-md-6 col-12 mx-auto">
                                <h3>Create a question</h3>
                                <hr />
                                <form:form action="/teacher/question/create" method="post" modelAttribute="newQuestion" enctype="multipart/form-data">
                                    <div class="mb-3">
                                        <c:set var="errorTitle">
                                            <form:errors path="title" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Question Title:</label>
                                        <form:input type="text" class="form-control ${not empty errorTitle ? 'is-invalid' : ''}" path="title" />
                                        ${errorTitle}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorQuestion">
                                            <form:errors path="questionDesc" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Question Description:</label>
                                        <form:input type="text" class="form-control ${not empty errorQuestion ? 'is-invalid' : ''}" path="questionDesc" />
                                        ${errorQuestion}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorOption1">
                                            <form:errors path="option1" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Option 1:</label>
                                        <form:input type="text" class="form-control ${not empty errorOption1 ? 'is-invalid' : ''}" path="option1" />
                                        ${errorOption1}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorOption2">
                                            <form:errors path="option2" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Option 2:</label>
                                        <form:input type="text" class="form-control ${not empty errorOption2 ? 'is-invalid' : ''}" path="option2" />
                                        ${errorOption2}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorOption3">
                                            <form:errors path="option3" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Option 3:</label>
                                        <form:input type="text" class="form-control ${not empty errorOption3 ? 'is-invalid' : ''}" path="option3" />
                                        ${errorOption3}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorOption4">
                                            <form:errors path="option4" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Option 4:</label>
                                        <form:input type="text" class="form-control ${not empty errorOption4 ? 'is-invalid' : ''}" path="option4" />
                                        ${errorOption4}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorAnswer">
                                            <form:errors path="answer" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label for="answerSelect" class="form-label">Answer:</label>
                                        <form:select path="answer" id="answerSelect" class="form-select ${not empty errorAnswer ? 'is-invalid' : ''}">
                                            <option value="" disabled selected>Select your answer</option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                        </form:select>
                                        ${errorAnswer}
                                    </div>
                                    <div class="col-12 mb-3 d-flex justify-content-between">
                                        <button type="submit" class="btn btn-info">Create</button>
                                        <a href="/teacher/question" class="btn btn-primary">Back</a>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="../layout/footer.jsp" />
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <jsp:include page="../layout/logoutModal.jsp" />

    <!-- Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin-2.min.js"></script>

</body>

</html>