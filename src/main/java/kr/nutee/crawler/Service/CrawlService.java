package kr.nutee.crawler.Service;

import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CrawlService {

    private final NoticeRepository noticeRepository;
    public List<Notice> getPageData(String url) throws IOException {
        return null;
    }
}
