package kr.nutee.crawler.domain.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {

    @Id
    private String no;

    private String title;

    private String author;

    private String href;

    private LocalDate createdAt;

    private int hit;
}
