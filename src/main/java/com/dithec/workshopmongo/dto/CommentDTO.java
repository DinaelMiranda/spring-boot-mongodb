package com.dithec.workshopmongo.dto;

import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommentDTO implements Serializable {


    private String text;
    private Date data;
    private AuthorDTO author;



    public CommentDTO() {
    }

    public CommentDTO(String text, Date data, AuthorDTO author) {
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
