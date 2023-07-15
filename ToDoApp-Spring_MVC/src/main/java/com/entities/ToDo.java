package com.entities;

import javax.xml.crypto.Data;

public class ToDo {

    private String todoTitle;
    private String todoContent;
    private Data todoDate;

    public ToDo() {
    }

    public ToDo(String todoTitle, String todoContent, Data todoDate) {
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoDate = todoDate;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public Data getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Data todoDate) {
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
