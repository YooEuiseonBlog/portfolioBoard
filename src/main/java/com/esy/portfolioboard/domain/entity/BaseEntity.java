package com.esy.portfolioboard.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity {

    private Integer views;
    private Integer likes;

    private LocalDateTime createDate;
    private LocalDateTime lastEditDate;
}
