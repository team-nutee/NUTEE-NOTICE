package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Enum.SchoolUrl;
import kr.nutee.crawler.Service.CrawlService;
import kr.nutee.crawler.domain.entity.Notice;
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
@RequestMapping(path = "/crawl", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class CrawlController {
    @Autowired
    CrawlService crawlService;

    @GetMapping(path = "/haksa")
    public List<Notice> crawlHaksa() throws IOException {
        return crawlService.getPageData(SchoolUrl.HAKSA_URL.getUrl());
    }

    @GetMapping(path = "/sooup")
    public List<Notice> crawlSooup() throws IOException {
        return crawlService.getPageData(SchoolUrl.SOOUP_URL.getUrl());
    }

    @GetMapping(path = "/hakjum")
    public List<Notice> crawlHakjum() throws IOException {
        return crawlService.getPageData(SchoolUrl.HAKJUM_URL.getUrl());
    }

    @GetMapping(path = "/janghak")
    public List<Notice> crawlJanghak() throws IOException {
        return crawlService.getPageData(SchoolUrl.JANGHAK_URL.getUrl());
    }

    @GetMapping(path = "/ilban")
    public List<Notice> crawlIlban() throws IOException {
        return crawlService.getPageData(SchoolUrl.ILBAN_URL.getUrl());
    }

    @GetMapping(path = "/hangsa")
    public List<Notice> crawlHangsa() throws IOException {
        return crawlService.getPageData(SchoolUrl.HANGSA_URL.getUrl());
    }
}
