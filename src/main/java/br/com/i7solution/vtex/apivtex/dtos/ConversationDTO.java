package br.com.i7solution.vtex.apivtex.dtos;

import java.util.Date;

public class ConversationDTO {

    private String id;
    private FromDTO from;
    private ToDTO to[];
    private String subject;
    private String firstWords;
    private String body;
    private Boolean hasAttachment;
    private String attachmentNames[];
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FromDTO getFrom() {
        return from;
    }

    public void setFrom(FromDTO from) {
        this.from = from;
    }

    public ToDTO[] getTo() {
        return to;
    }

    public void setTo(ToDTO[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFirstWords() {
        return firstWords;
    }

    public void setFirstWords(String firstWords) {
        this.firstWords = firstWords;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public String[] getAttachmentNames() {
        return attachmentNames;
    }

    public void setAttachmentNames(String[] attachmentNames) {
        this.attachmentNames = attachmentNames;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
