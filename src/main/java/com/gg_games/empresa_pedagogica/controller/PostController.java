package com.gg_games.empresa_pedagogica.controller;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_post")
public class PostController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    @Column(nullable = false)
    private String postTitle;
    @Column(nullable = false)
    private String postContent;

    private LocalDate postData;

    public PostController() {
    }

    public PostController(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDate getPostData() {
        return postData;
    }

    public void setPostData(LocalDate postData) {
        this.postData = postData;
    }


}
