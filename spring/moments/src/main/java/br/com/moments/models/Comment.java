package br.com.moments.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank(message = "O nome do usuário não deve ser vazio")
    private String userName;

    @Column(columnDefinition = "TEXT")
    private String textComent;

    @ManyToOne
    @JoinColumn(name = "idMoment")
    private Moment idMoment;

    @Column(columnDefinition = "DATE")
    @NotBlank(message = "A data de criação não pode ser vazia")
    private LocalDate createAtComment;

    public Comment(String userName, String textComent, Moment idMoment, LocalDate createAtComment) {
        this.userName = userName;
        this.textComent = textComent;
        this.idMoment = idMoment;
        this.createAtComment = createAtComment;
    }

    public Comment() {

    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

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

    public LocalDate getCreateAtComment() {
        return createAtComment;
    }

    public void setCreateAtComment(LocalDate createAtComment) {
        this.createAtComment = createAtComment;
    }
}
