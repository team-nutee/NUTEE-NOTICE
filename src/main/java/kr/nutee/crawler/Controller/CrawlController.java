package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.NoticeService;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.dto.Resource.ResponseResource;
import kr.nutee.crawler.dto.Response.NoticeData;
import kr.nutee.crawler.dto.Response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/crawl")//, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class CrawlController {

    @Autowired
    NoticeService noticeService;

    @GetMapping(path = "/haksa")
    public ResponseEntity<ResponseResource> crawlHaksa() throws IOException {
        List<Notice> list = noticeService.searchByCategory("학사");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("학사목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"haksa");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(path = "/sooup")
    public ResponseEntity<ResponseResource> crawlSooup() throws IOException {
        List<Notice> list = noticeService.searchByCategory("수업");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("수업목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"sooup");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(path = "/hakjum")
    public ResponseEntity<ResponseResource> crawlHakjum() throws IOException {
        List<Notice> list = noticeService.searchByCategory("학점");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("학점목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"hakjum");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(path = "/janghak")
    public ResponseEntity<ResponseResource> crawlJanghak() throws IOException {
        List<Notice> list = noticeService.searchByCategory("장학");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("장학목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"janghak");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(path = "/ilban")
    public ResponseEntity<ResponseResource> crawlIlban() throws IOException {
        List<Notice> list = noticeService.searchByCategory("일반");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("일반목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"ilban");
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping(path = "/hangsa")
    public ResponseEntity<ResponseResource> crawlHangsa() throws IOException {
        List<Notice> list = noticeService.searchByCategory("행사");
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("행사목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, CrawlController.class,"hangsa");
        return ResponseEntity.ok().body(resource);
    }
}