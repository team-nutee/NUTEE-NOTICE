package kr.nutee.crawler.Service;

import java.util.stream.Collectors;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
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
public class Scheduler {
    @Autowired
    NoticeRepository noticeRepository;

    /*
    * 1. 해당 페이지의 전체를 긁어와요
    * 2. 기존 데이터베이스에 넣어졌던 id면 제외시킨다.
    * 3. 그러면 새로운 게시물들만 남게되고.
    * 4. 그 새로운 게시물들을 각각 알림서버에 데이터를 보내준다.
    * 5. 새로운 게시물들은 이제 데이터베이스에 넣어준다.
    *
    * 서버 크롤링 하는형식 -> 우리 데이터베이스에 저장되어있는 데이터를 꺼내오는 방식
    */

    @Scheduled(cron = "0 0 * * * *")
    public void getHaksaPage(String url) throws IOException {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Document doc = Jsoup.connect(url).get();
        int size = doc.getElementsByTag("td").size();
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < size; i += 6) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("no", doc.getElementsByTag("td").get(i).text());
            map.put("title", doc.getElementsByTag("td").get(i + 1).text());
            map.put("href", "http://skhu.ac.kr/board/" + doc.getElementsByTag("td").get(i + 1).getElementsByTag("a").attr("href"));
            map.put("author", doc.getElementsByTag("td").get(i + 3).text());
            map.put("date", doc.getElementsByTag("td").get(i + 4).text());
            list.add(map);
        }
//        List<Map<String, String>> list = new ArrayList<>();
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("date", doc.getElementsByTag("td").get(0 + 4).text());
//        list.add(map);
//
//        String today = format.format(Calendar.getInstance().getTime());
//        String page = list.get(0).get("date");
        List<Notice> notices = filterNewNotice(new ArrayList<>());
        //sendAlarm(notices);
        addNewNotice(notices);
    }

    private List<Notice> filterNewNotice(List<Notice> pageNotices) {
        return pageNotices.stream().filter(this::isNewNotice).collect(Collectors.toList());
    }

    private boolean isNewNotice(Notice notice) {
        //logic
        return true;
    }

    private void addNewNotice(List<Notice> newNotices) {
        for (Notice newNotice : newNotices) {
            noticeRepository.save(newNotice);
        }
    }
}
