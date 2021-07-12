package kr.nutee.crawler.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Notice {

    private String no;

    private String title;

    private String author;

    @Id
    private String href;

    private String date;

    private int hit;

    private String category;

}
