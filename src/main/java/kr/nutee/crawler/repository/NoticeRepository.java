package kr.nutee.crawler.repository;

import kr.nutee.crawler.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,String> {
    Notice findNoticeByHrefAndCategory(String href, String category);
    List<Notice> findAllByCategory(String category);
}