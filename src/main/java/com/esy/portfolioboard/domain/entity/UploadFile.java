package com.esy.portfolioboard.domain.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@ToString(of = {"id", "uploadFileName", "storeFileName"})
public class UploadFile {
    @Id
    @GeneratedValue
    private Long id;

    private String uploadFileName;
    private String storeFileName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    public void setPost(Post post) {
        this.post = post;
        post.getImageFiles().add(this);
    }
}
