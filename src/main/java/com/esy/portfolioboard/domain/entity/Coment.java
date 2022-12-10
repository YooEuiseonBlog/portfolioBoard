package com.esy.portfolioboard.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@SuperBuilder
@Table(name = "comment")
@ToString(of = {"id", "comment"}, callSuper = true)
public class Coment extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    //----------------------------//
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
