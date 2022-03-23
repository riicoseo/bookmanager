package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //GenerationType.IDENTITY 는 entity 별로 시퀀스 별도로 생성해 사용하겠다는 뜻
    //GenerationType.AUTO 는 hibernate_sequence 를 하나 만들어 여러 entity에서 공통으로 사용하겠다는 뜻

    //optional false 는 book 객체가 null 로 들어오는 것을 허용치 않겠다는 의미. 즉, book 은 not null
    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore;

    private int reviewCount;

}
