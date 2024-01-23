package br.com.moments.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Moment")
public class Moment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMoment;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotBlank(message = "O título não deve ser vazio")
    private String title;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "A descrição não deve ser vazia")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(columnDefinition = "DATE")
    @NotNull(message = "A data de criação não deve ser vazia")
    private LocalDate createAtMoment;

    @Column(columnDefinition = "DATE")
    private LocalDate updateAtMoment;

    public Moment(String title, String description, String image, LocalDate createAtMoment, LocalDate updateAtMoment){
        this.title = title;
        this.description = description;
        this.image = image;
        this.createAtMoment = createAtMoment;
        this.updateAtMoment = updateAtMoment;
    }

    public long getIdMoment() {
        return idMoment;
    }

    public void setIdMoment(long idMoment) {
        this.idMoment = idMoment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getCreateAtMoment() {
        return createAtMoment;
    }

    public void setCreateAtMoment(LocalDate createAtMoment) {
        this.createAtMoment = createAtMoment;
    }

    public LocalDate getUpdateAtMoment() {
        return updateAtMoment;
    }

    public void setUpdateAtMoment(LocalDate updateAtMoment) {
        this.updateAtMoment = updateAtMoment;
    }


}
