package com.ufrn.email.dtos;

import java.io.Serializable;
import java.util.UUID;

public class EmailDto {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
