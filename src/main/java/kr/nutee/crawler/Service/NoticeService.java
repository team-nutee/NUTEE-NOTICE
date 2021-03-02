package kr.nutee.crawler.Service;

import java.util.stream.Collectors;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final int TABLE_COLUMN_SIZE = 6;
//

    public void checkNotice(String url, String catecory) throws IOException {
        Document doc = Jsoup.connect(url).get();
        int size = doc.getElementsByTag("td").size();
        List<Notice> list = new ArrayList<>();
        for (int i = 0; i < size; i += TABLE_COLUMN_SIZE) {
            list.add(
                    Notice.builder()
                            .no(doc.getElementsByTag("td").get(i).text())
                            .title(doc.getElementsByTag("td").get(i + 1).text())
                            .href("http://skhu.ac.kr/board/" + doc.getElementsByTag("td").get(i + 1)
                                    .getElementsByTag("a").attr("href"))
                            .author(doc.getElementsByTag("td").get(i + 3).text())
                            .date(doc.getElementsByTag("td").get(i + 4).text())
                            .category(catecory)
                            .build()
            );
            isNewNotice(list.get(i / TABLE_COLUMN_SIZE));
        }
        List<Notice> notices = filterNewNotice(list);
        //sendAlarm(notices);
        addNewNotice(notices);
    }

    private List<Notice> filterNewNotice(List<Notice> pageNotices) {
        return pageNotices.stream().filter(this::isNewNotice).collect(Collectors.toList());
    }

    private boolean isNewNotice(Notice notice) {
        return noticeRepository.findNoticeByHrefAndCategory(notice.getHref(), notice.getCategory()) == null;
    }

    private void addNewNotice(List<Notice> newNotices) {
        for (Notice newNotice : newNotices) {
            noticeRepository.save(newNotice);
        }
    }
}
