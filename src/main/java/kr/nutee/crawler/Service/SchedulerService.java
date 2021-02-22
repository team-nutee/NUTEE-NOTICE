package kr.nutee.crawler.Service;

import java.util.stream.Collectors;
import kr.nutee.crawler.Enum.SchoolUrl;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerService {

    private final NoticeRepository noticeRepository;

    /*
    * 1. 해당 페이지의 전체를 긁어와요
    * 2. 기존 데이터베이스에 넣어졌던 id면 제외시킨다.
    * 3. 그러면 새로운 게시물들만 남게되고.
    * 4. 그 새로운 게시물들을 각각 알림서버에 데이터를 보내준다.
    * 5. 새로운 게시물들은 이제 데이터베이스에 넣어준다.
    *
    * 서버 크롤링 하는형식 -> 우리 데이터베이스에 저장되어있는 데이터를 꺼내오는 방식
    */

    @Scheduled(cron = "0 * * * * *")
    @Scheduled(fixedDelay = 5000)
    public void getHaksaPage() throws IOException {
        String url = SchoolUrl.HAKSA_URL.getUrl();
        Document doc = Jsoup.connect(url).get();
        int size = doc.getElementsByTag("td").size();
        List<Notice> list = new ArrayList<>();
        for (int i = 0; i < size; i += 6) {
            list.add(
                Notice.builder()
                    .no(doc.getElementsByTag("td").get(i).text())
                    .title(doc.getElementsByTag("td").get(i + 1).text())
                    .href("http://skhu.ac.kr/board/" + doc.getElementsByTag("td").get(i + 1)
                        .getElementsByTag("a").attr("href"))
                    .author(doc.getElementsByTag("td").get(i + 3).text())
                    .date(doc.getElementsByTag("td").get(i + 4).text())
                    .build()
            );
        }

//        isNewNotice(new Notice(list.get(0).get("title")));
        List<Notice> notices = filterNewNotice(list);
        System.out.println(notices);
        //sendAlarm(notices);
        addNewNotice(notices);
    }

    private List<Notice> filterNewNotice(List<Notice> pageNotices) {
        return pageNotices.stream().filter(this::isNewNotice).collect(Collectors.toList());
    }

    private boolean isNewNotice(Notice notice) {
        return noticeRepository.findNoticeByTitle(notice.getTitle()) == null;
    }

    private void addNewNotice(List<Notice> newNotices) {
        for (Notice newNotice : newNotices) {
            noticeRepository.save(newNotice);
        }
    }
}
