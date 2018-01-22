package site.yananart.entity;

import java.sql.Timestamp;

public class What {
    private String comment;
    private Timestamp time;

    public What(String comment, Timestamp time) {
        this.comment = comment;
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
