package kr.nutee.crawler.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Scheduler {


//    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 45 11,17,23 * * *")
    public void scheduler () throws IOException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        CrawlService craw = new CrawlService();
//        List<Map<String, String>> list = craw.getPageData("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51");
//        String today = format.format(Calendar.getInstance().getTime());
//        String page = list.get(0).get("date");
        Document doc = Jsoup.connect("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51").get();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("date", doc.getElementsByTag("td").get(0 + 4).text());
        list.add(map);

        String today = format.format(Calendar.getInstance().getTime());
        String page = list.get(0).get("date");
        System.out.println(today + page);

        if(today.equals(page)) {
            System.out.println("new");
        }
    }
}