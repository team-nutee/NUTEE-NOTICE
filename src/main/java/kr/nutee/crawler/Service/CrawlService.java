package kr.nutee.crawler.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrawlService {
    public List<Map<String,String>> getPageData(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        int size = doc.getElementsByTag("td").size();
        List<Map<String,String>> list = new ArrayList<>();
        for (int i = 0; i < size; i+=6) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("no", doc.getElementsByTag("td").get(i).text());
            map.put("title", doc.getElementsByTag("td").get(i + 1).text());
            map.put("href","http://skhu.ac.kr/board/"+doc.getElementsByTag("td").get(i+1).getElementsByTag("a").attr("href"));
            map.put("author", doc.getElementsByTag("td").get(i + 3).text());
            map.put("date", doc.getElementsByTag("td").get(i + 4).text());
            list.add(map);
        }
        return list;
    }
}
