<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@include file="all_css.jsp"%>

</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <h1>Please fill your Note details</h1>

<%--    This is add form    --%>
    <form action="SaveNoteServlet" method="post">
        <div class="form-group">
            <label for="title">Note Title</label>
            <input name="title"
                    required type="text"
                    class="form-control"
                    id="title"
                   aria-describedby="emailHelp"
                    placeholder="Enter Here"/>
        </div>

        <div class="form-group">
            <label for="content" class="form-label">Note Content</label>

            <textarea name="content"
                    required
                    id="content"
                    placeholder="Enter your content here"
                    class="form-control"
                    style="height: 300px"></textarea>

        </div>
        <br>

        <div class="container text-center">
            <button type="submit" class="btn btn-primary">Add</button>

        </div>
    </form>
</div>

</body>
</html>
