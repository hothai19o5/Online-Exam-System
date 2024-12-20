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

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Exams</h1>
                    </div>

                    <!-- Content Section -->
                    <div class="mt-4">

                        <!-- Completed Exam -->
                        <h4>Completed Exam</h4>

                        <c:forEach var="completedExam" items="${completedExams}">
                            <div class="card mb-3 bg-success text-white shadow">
                                <div class="card-body">
                                    <h6>Exam Name: ${completedExam.title}</h6>
                                    <p>Description: ${completedExam.examDesc}</p>
                                    <div class="d-flex justify-content-between">
                                        <span>Questions: ${completedExam.totalQuestion}</span>
                                        <span>Time: ${completedExam.duration} Minute</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <!-- Divider -->
                        <hr class="sidebar-divider">

                        <!-- Uncompleted Exams -->
                        <h4>Uncompleted Exams</h4>

                        <c:forEach var="uncompletedExam" items="${uncompletedExams}">
                            <a href="#" class="text-decoration-none" data-target="#confirmModal" data-toggle="modal">
                                <div class="card mb-3 bg-info text-white shadow">
                                    <div class="card-body">
                                        <h6>Exam Name: ${uncompletedExam.title}</h6>
                                        <p>Description: ${uncompletedExam.examDesc}</p>
                                        <div class="d-flex justify-content-between">
                                            <span>Questions: ${uncompletedExam.totalQuestion}</span>
                                            <span>Time: ${uncompletedExam.duration} Minute</span>
                                            <span>Marks: ${uncompletedExam.totalQuestion*uncompletedExam.markRight}</span>
                                        </div>
                                    </div>
                                </div>
                            </a>

                            <!-- Confirm Modal -->

                            <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Are You Ready?</h5>
                                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">x</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">Select "Ready" below if you are ready.</div>
                                        <div class="modal-footer">
                                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                            <a class="btn btn-primary" href="/student/exam/${uncompletedExam.id}">
                                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                                Ready
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                        <!-- Divider -->
                        <hr class="sidebar-divider">

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