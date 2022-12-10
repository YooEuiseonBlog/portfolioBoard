package com.esy.portfolioboard.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@ToString(of = {"id", "title", "content"}, callSuper = true)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    private String title;
    private String content;

    //다대일 관계(외래키 보유)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<UploadFile> imageFiles = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Coment> comments = new ArrayList<>();

    //----------------------------------//
    public void setMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }
}
