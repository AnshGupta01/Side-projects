<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="com.entities.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="all_css.jsp"%>
    <title>Title</title>
</head>
<body>

</body>
        <div class="container">
            <%@include file="navbar.jsp"%>
            <br>
            <h1>Edit your Note</h1>
                <br>
            <%
                    int noteId= Integer.parseInt(request.getParameter("note_id").trim());
                    Session s = FactoryProvider.getFactory().openSession();
                    Note note = s.get(Note.class, noteId);
            %>

                <form action="UpdateServlet" method="post">

                    <input value="<%=note.getId()%>" name="noteId" type="hidden">

                    <div class="form-group">
                        <label for="title">Note Title</label>
                        <input name="title"
                               required type="text"
                               class="form-control"
                               id="title"
                               aria-describedby="emailHelp"
                               placeholder="Enter Here"
                                value="<%=note.getTitle()%>"/>
                    </div>

                    <div class="form-group">
                        <label for="content" class="form-label">Note Content</label>

                        <textarea name="content"
                                  required
                                  id="content"
                                  placeholder="Enter your content here"
                                  class="form-control"
                                  style="height: 300px"><%=note.getContent()%>
                        </textarea>

                    </div>
                    <br>

                    <div class="container text-center">
                        <button type="submit" class="btn btn-success">Save Note</button>

                    </div>
                </form>
</html>
