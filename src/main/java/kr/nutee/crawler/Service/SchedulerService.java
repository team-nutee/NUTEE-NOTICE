package kr.nutee.crawler.Service;

import java.util.stream.Collectors;
import kr.nutee.crawler.Enum.SchoolUrl;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerService {

    private final NoticeRepository noticeRepository;
    private final int TABLE_COLUMN_SIZE = 6;


    public void getPage(String url, String catecory) throws IOException {
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

    @Scheduled(cron = "0 * * * * *")
    public void getHaksaPage() throws IOException {
       getPage(SchoolUrl.HAKSA_URL.getUrl(), "학사");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getSooupPage() throws IOException {
        getPage(SchoolUrl.SOOUP_URL.getUrl(), "수업");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getHakjumPage() throws IOException {
        getPage(SchoolUrl.HAKJUM_URL.getUrl(), "학점");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getJanghakPage() throws IOException {
        getPage(SchoolUrl.JANGHAK_URL.getUrl(), "장학");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getIlbanPage() throws IOException {
        getPage(SchoolUrl.ILBAN_URL.getUrl(), "일반");
    }

    @Scheduled(cron = "0 * * * * *")
    public void getHangsaPage() throws IOException {
        getPage(SchoolUrl.HANGSA_URL.getUrl(), "행사");
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
