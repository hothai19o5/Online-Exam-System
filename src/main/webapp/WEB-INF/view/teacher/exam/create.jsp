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
                                <h3>Create new exam</h3>
                                <hr />
                                <form:form action="/teacher/exam/create" method="post" modelAttribute="newExam" enctype="multipart/form-data">
                                    <div class="mb-3">
                                        <c:set var="errorExamTitle">
                                            <form:errors path="title" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Exam Title:</label>
                                        <form:input type="text"
                                            class="form-control ${not empty errorExamTitle ? 'is-invalid' : ''}" path="title" />
                                        ${errorExamTitle}
                                    </div>
                                    <!-- Row for duration and total question -->
                                    <div class="row mb-3">
                                        <div class="col-6">
                                            <c:set var="errorDuration">
                                                <form:errors path="duration" cssClass="invalid-feedback" />
                                            </c:set>
                                            <label class="form-label">Duration:</label>
                                            <form:input type="number"
                                                class="form-control ${not empty errorDuration ? 'is-invalid' : ''}" path="duration" />
                                            ${errorDuration}
                                        </div>
                                        <div class="col-6">
                                            <c:set var="errorTotalQuestion">
                                                <form:errors path="totalQuestion" cssClass="invalid-feedback" />
                                            </c:set>
                                            <label class="form-label">Total Question:</label>
                                            <form:input type="number"
                                                class="form-control ${not empty errorTotalQuestion ? 'is-invalid' : ''}" path="totalQuestion" />
                                            ${errorTotalQuestion}
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorExamDesc">
                                            <form:errors path="examDesc" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Exam Description:</label>
                                        <form:input type="text"
                                            class="form-control ${not empty errorExamDesc ? 'is-invalid' : ''}" path="examDesc" />
                                        ${errorExamDesc}
                                    </div>
                                    <!-- Row for mark wrong and mark right -->
                                    <div class="row mb-3">
                                        <div class="col-6">
                                            <c:set var="errorMarkWrong">
                                                <form:errors path="markWrong" cssClass="invalid-feedback" />
                                            </c:set>
                                            <label class="form-label">Mark Wrong:</label>
                                            <form:input type="number"
                                                class="form-control ${not empty errorMarkWrong ? 'is-invalid' : ''}" path="markWrong" />
                                            ${errorMarkWrong}
                                        </div>
                                        <div class="col-6">
                                            <c:set var="errorMarkRight">
                                                <form:errors path="markRight" cssClass="invalid-feedback" />
                                            </c:set>
                                            <label class="form-label">Mark Right:</label>
                                            <form:input type="number"
                                                class="form-control ${not empty errorMarkRight ? 'is-invalid' : ''}" path="markRight" />
                                            ${errorMarkRight}
                                        </div>
                                    </div>
                                    <div class="col-12 mb-3 d-flex justify-content-between">
                                        <button type="submit" class="btn btn-info">Create</button>
                                        <a href="/teacher/exam" class="btn btn-primary">Back</a>
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