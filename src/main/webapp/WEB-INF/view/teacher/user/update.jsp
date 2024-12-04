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
                        <h1 class="h3 mb-0 text-gray-800">Update Student</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                            <i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>

                    <div class="mt-5">
                        <div class="row">
                            <div class="col-md-6 col-12 mx-auto">
                                <h3>Update a user</h3>
                                <hr />
                                <form:form action="/teacher/user/update" method="post" modelAttribute="user"
                                    enctype="multipart/form-data">
                                    <div class="mb-3" style="display: none;">
                                        <label class="form-label">Id:</label>
                                        <form:input type="text" class="form-control" path="id"/>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Email address:</label>
                                        <form:input type="email" class="form-control" path="email" />
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorPhoneNumber">
                                            <form:errors path="phone" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Phone Number:</label>
                                        <form:input type="text"
                                            class="form-control ${not empty errorPhoneNumber ? 'is-invalid' : ''}"
                                            path="phone" />
                                        ${errorPhoneNumber}
                                    </div>
                                    <div class="mb-3">
                                        <c:set var="errorUserName">
                                            <form:errors path="username" cssClass="invalid-feedback" />
                                        </c:set>
                                        <label class="form-label">Full Name:</label>
                                        <form:input type="text"
                                            class="form-control ${not empty errorUserName ? 'is-invalid' : ''}"
                                            path="username" />
                                        ${errorUserName}
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Role:</label>
                                        <!-- Thêm tag form để JavaSpring quản lý -->
                                        <form:select class="form-select" path="role.name">
                                            <form:option value="Admin">ADMIN</form:option>
                                            <form:option value="User">USER</form:option>
                                        </form:select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="avatarFile" class="form-label">Avatar:</label>
                                        <input class="form-control" type="file" id="avatarFile" accept=".jpg, .png, .jpeg" name="nameAvatarFile" >
                                      </div>
                                    <div class="mb-3 d-flex justify-content-around">
                                        <img style="max-height: 250px; display: none;" alt="avatar preview"
                                            id="avatarPreview">
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <button type="submit" class="btn btn-warning">Update</button>
                                        <a href="/teacher/user" class="btn btn-primary">Back</a>
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