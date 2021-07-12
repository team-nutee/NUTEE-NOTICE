package kr.nutee.crawler.repository;

import kr.nutee.crawler.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,String> {
    Notice findNoticeByHrefAndCategory(String href, String category);
    List<Notice> findAllByCategory(String category);
    Page<Notice> findAllByCategoryAndHit(String category,int hit, Pageable pageable);
//    Notice findNoticeByTitleAndCategory(String title, String category);
}