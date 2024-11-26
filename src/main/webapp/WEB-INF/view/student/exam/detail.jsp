<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <div class="container my-4">
                    <!-- Header -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h3>${exam.title}</h3>
                        <button class="btn btn-outline-info">???</button>
                    </div>

                    <!-- Main Content -->
                    <div class="row">
                        <!-- Left Section: Questions -->
                        <div class="col-lg-9">
                            <c:forEach var="question" items="${questions}">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <h5 class="card-title">Q ${question.id}. ${question.questionDesc}</h5>
                                        <form>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="q8" id="q8Option1" value="package">
                                                <label class="form-check-label" for="q8Option1">${question.option1}</label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="q8" id="q8Option2" value="import">
                                                <label class="form-check-label" for="q8Option2">${question.option2}</label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="q8" id="q8Option3" value="extends">
                                                <label class="form-check-label" for="q8Option3">${question.option3}</label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="q8" id="q8Option4" value="export">
                                                <label class="form-check-label" for="q8Option4">${question.option4}</label>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>


                            <!-- Submit Button -->
                            <button class="btn btn-primary w-100">Submit Exam</button>
                        </div>

                        <!-- Right Section: Timer and Details -->
                        <div class="col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <h6>Time Left : <span class="text-danger">9:29</span></h6>
                                    <ul class="list-unstyled mt-3">
                                        <li><strong>Name:</strong> Student Name</li>
                                        <li><strong>Exam Name:</strong> ${exam.title}</li>
                                        <li><strong>Total Questions:</strong> ${exam.totalQuestion}</li>
                                        <li><strong>Total Marks:</strong> 40</li>
                                        <li><strong>Mark for Correct:</strong> +${exam.markRight}</li>
                                        <li><strong>Mark for Wrong:</strong> -${exam.markWrong}</li>
                                        <li><strong>Exam Duration:</strong> ${exam.duration} Minutes</li>
                                    </ul>
                                </div>
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
