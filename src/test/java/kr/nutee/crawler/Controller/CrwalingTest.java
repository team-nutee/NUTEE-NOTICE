package kr.nutee.crawler.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CrwalingTest {

    @Test
    void getPageData() throws IOException {
        String URL = "http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51";
        Document doc = Jsoup.connect(URL).get();
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
        System.out.println(list);
    }

    @Test
    void crawlSooup() {
    }

    @Test
    void crawlHakjum() {
    }

    @Test
    void crawlJanghak() {
    }

    @Test
    void crawlIlban() {
    }

    @Test
    void crawlHangsa() {
    }
}