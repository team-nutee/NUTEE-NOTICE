package kr.nutee.crawler.repository;

import kr.nutee.crawler.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface NoticeRepository extends JpaRepository<Notice,String> {
    Notice findNoticeByNo(String no);
    Notice findNoticeByTitle(String title);
    Notice findNoticeByAuthor(String author);
    Notice findNoticeByHref(String href);
    Notice findNoticeByDate(String date);
}
