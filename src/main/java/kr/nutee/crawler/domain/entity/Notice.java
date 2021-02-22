package kr.nutee.crawler.domain.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Notice {

    @Id
    private String no;

    private String title;

    private String author;

    private String href;

    private String date;

    private int hit;

    public Notice(String title) {
        this.title = title;
    }
}
