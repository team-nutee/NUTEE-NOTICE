package kr.nutee.crawler.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Notice {

    private String no;

    @Id
    String title;

    private String author;

    private String href;

    private String date;

    private int hit;

    private String category;
}
