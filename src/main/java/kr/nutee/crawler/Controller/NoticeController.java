package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.NoticeService;
import kr.nutee.crawler.dto.Resource.ResponseResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/crawl")//, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping(path = "/haksa")
    public ResponseEntity<ResponseResource> crawlHaksa() {
        return noticeService.getNoticeApi("학사","haksa");
    }

    @GetMapping(path = "/sooup")
    public ResponseEntity<ResponseResource> crawlSooup() {
        return noticeService.getNoticeApi("수업","sooup");
    }

    @GetMapping(path = "/hakjum")
    public ResponseEntity<ResponseResource> crawlHakjum() {
        return noticeService.getNoticeApi("학점","hakjum");
    }

    @GetMapping(path = "/janghak")
    public ResponseEntity<ResponseResource> crawlJanghak() {
        return noticeService.getNoticeApi("장학","janghak");
    }

    @GetMapping(path = "/ilban")
    public ResponseEntity<ResponseResource> crawlIlban() {
        return noticeService.getNoticeApi("일반","ilban");
    }

    @GetMapping(path = "/hangsa")
    public ResponseEntity<ResponseResource> crawlHangsa() {
        return noticeService.getNoticeApi("행사","hangsa");
    }
//    @GetMapping(path = "/haksa")
//    public ResponseEntity<ResponseResource> crawlHaksa(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("학사","haksa", pageable);
//    }
//
//    @GetMapping(path = "/sooup")
//    public ResponseEntity<ResponseResource> crawlSooup(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("수업","sooup", pageable);
//    }
//
//    @GetMapping(path = "/hakjum")
//    public ResponseEntity<ResponseResource> crawlHakjum(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("학점","hakjum", pageable);
//    }
//
//    @GetMapping(path = "/janghak")
//    public ResponseEntity<ResponseResource> crawlJanghak(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("장학","janghak", pageable);
//    }
//
//    @GetMapping(path = "/ilban")
//    public ResponseEntity<ResponseResource> crawlIlban(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("일반","ilban", pageable);
//    }
//
//    @GetMapping(path = "/hangsa")
//    public ResponseEntity<ResponseResource> crawlHangsa(@PageableDefault(size=10) Pageable pageable) throws IOException {
//        return noticeService.getNoticeApi("행사","hangsa", pageable);
//    }
}