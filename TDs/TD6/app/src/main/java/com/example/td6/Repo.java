package com.example.td6;

public class Repo {
    private int id;
    private String name;
    private String full_name;
    private String html_url;

    //On peut renommer les variables avec la notation suivante
    //@SerializedName("full_name")
    //private String fullName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setId(int id) {
        this.id = id;
    }
}