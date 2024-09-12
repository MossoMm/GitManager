package com.example.androidappbuilder;

public class RequestPost {
    String owner, title, repo,body, base, head;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public RequestPost(String owner, String title, String repo, String body, String base, String head) {
        this.owner = owner;
        this.title = title;
        this.repo = repo;
        this.body = body;
        this.base = base;
        this.head = head;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
