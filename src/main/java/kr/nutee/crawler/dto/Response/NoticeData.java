package kr.nutee.crawler.dto.Response;

import kr.nutee.crawler.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeData {

    private String no;

    private String title;

    private String author;

    private String href;

    private String date;

    private int hit;

    private String category;

    public NoticeData(Notice notice) {
        this.no = notice.getNo();
        this.title = notice.getTitle();
        this.author = notice.getAuthor();
        this.href = notice.getHref();
        this.date = notice.getDate();
        this.hit = notice.getHit();
        this.category = notice.getCategory();
    }
}
