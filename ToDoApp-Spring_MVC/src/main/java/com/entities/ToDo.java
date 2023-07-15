package com.entities;

import javax.xml.crypto.Data;
import java.util.Date;

public class ToDo {

    private String todoTitle;
    private String todoContent;
    private Date todoDate;

    public ToDo() {
    }

    public ToDo(String todoTitle, String todoContent, Date todoDate) {
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDate = todoDate;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "todoTitle='" + todoTitle + '\'' +
                ", todoContent='" + todoContent + '\'' +
                ", todoDate=" + todoDate +
                '}';
    }
}
