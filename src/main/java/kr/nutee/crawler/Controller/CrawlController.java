package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.CrawlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/crawl",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class CrawlController {
    @Autowired
    CrawlService crawlService;

    @GetMapping(path = "/haksa")
    public List<Map<String,String>> crawlHaksa() throws IOException {
        return crawlService.getPageData("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51");
    }

    @GetMapping(path = "/sooup")
    public List<Map<String,String>> crawlSooup() throws IOException {
        return crawlService.getPageData("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10005&searchBun=53");
    }

    @GetMapping(path = "/hakjum")
    public List<Map<String,String>> crawlHakjum() throws IOException {
        return crawlService.getPageData("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10038&searchBun=89");
    }

    @GetMapping(path = "/janghak")
    public List<Map<String,String>> crawlJanghak() throws IOException {
        return crawlService.getPageData("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10006&searchBun=75");
    }

    @GetMapping(path = "/ilban")
    public List<Map<String,String>> crawlIlban() throws IOException {
        return crawlService.getPageData("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10007");
    }

    @GetMapping(path = "/hangsa")
    public List<Map<String,String>> crawlHangsa() throws IOException {
        return crawlService.getPageData("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10008");
    }
}
