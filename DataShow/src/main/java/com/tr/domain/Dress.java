package com.tr.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PythonRepo", schema = "MyTest")
public class Dress {
    private String id;
    private String text;
    private Integer attitudes;
    private Integer comments;
    private Integer reposts;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "attitudes")
    public Integer getAttitudes() {
        return attitudes;
    }

    public void setAttitudes(Integer attitudes) {
        this.attitudes = attitudes;
    }

    @Basic
    @Column(name = "comments")
    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "reposts")
    public Integer getReposts() {
        return reposts;
    }

    public void setReposts(Integer reposts) {
        this.reposts = reposts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dress that = (Dress) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(text, that.text) &&
                Objects.equals(attitudes, that.attitudes) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(reposts, that.reposts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, attitudes, comments, reposts);
    }
}
