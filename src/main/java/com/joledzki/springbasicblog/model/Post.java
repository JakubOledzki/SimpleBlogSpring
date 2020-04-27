package com.joledzki.springbasicblog.model;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String desc;

    public Post() {}

    public Post(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
}
