<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Note Taker: Home Page</title>
    <%@include file="all_css.jsp"%>

</head>
<body>
    <div class="container">
        <%@include file="navbar.jsp"%>
        <br>

        <div class="card py-5">
        <img alt="" src="img/note_icon.png" class="img-fluid mx-auto" style="max-width: 400px">
        <h1 class="text-primary text-uppercase text-center mt-3">Start taking Notes</h1>



        <div class="container text-center">
            <a href="add_notes.jsp" class="btn btn-primary">Start Here</a>
        </div>

        </div>
    </div>

</body>
</html>
