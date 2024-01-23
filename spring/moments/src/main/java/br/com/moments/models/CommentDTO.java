package br.com.moments.models;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class CommentDTO {

    private String userName;

    private String textComent;

    private Moment idMoment;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextComent() {
        return textComent;
    }

    public void setTextComent(String textComent) {
        this.textComent = textComent;
    }

    public Moment getIdMoment() {
        return idMoment;
    }

    public void setIdMoment(Moment idMoment) {
        this.idMoment = idMoment;
    }
}
