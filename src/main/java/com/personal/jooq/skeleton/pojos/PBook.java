package com.personal.jooq.skeleton.pojos;

import java.io.Serializable;

/**
 * Created by minhpham on 6/8/16.
 */
public class PBook implements Serializable{
    private Integer id;
    private Integer authorId;
    private String title;

    public PBook() {
    }

    public PBook(PBook value) {
        this.id = value.id;
        this.authorId = value.authorId;
        this.title = value.title;
    }

    public PBook(
            Integer id,
            Integer authorId,
            String title
    ) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(authorId);
        sb.append(", ").append(title);

        sb.append(")");
        return sb.toString();
    }
}
