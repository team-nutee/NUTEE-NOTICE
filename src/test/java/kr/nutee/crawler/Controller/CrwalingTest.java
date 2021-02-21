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

    /*    @Test
        void crawlHaksa() throws IOException {*/
    @Test
    public List<Map<String, String>> getPageData() throws IOException {
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
//        System.out.println(list);
//        return list;
/*        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(format.format(Calendar.getInstance().getTime()));
//        System.out.println(list.get(size/6-1).get("no"));
//        System.out.println(list.get(0).get("date"));
        String a = format.format(Calendar.getInstance().getTime());
        String b = "2021-02-19";
//        String b = list.get(0).get("date");
        System.out.println(a);
        System.out.println(b);
        if(a.eWquals(b)) {
            System.out.println("새로운것");
        }
        System.out.println(list);*/
        System.out.println("List return");
        return list;
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