package com.example.androidappbuilder;

public class ResponsePost {
    String title, body,html_url;

    public String getUrl() {
        return html_url;
    }

    public void setUrl(String html_url) {
        this.html_url = html_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
