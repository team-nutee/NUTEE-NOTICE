package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.NoticeService;
import kr.nutee.crawler.dto.Resource.ResponseResource;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/crawl")//, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    NoticeRepository noticeRepository;

    @GetMapping(path = "/haksa")
    public ResponseEntity<ResponseResource> crawlHaksa() throws IOException {
        return noticeService.getNoticeApi("학사","haksa");
    }

    @GetMapping(path = "/sooup")
    public ResponseEntity<ResponseResource> crawlSooup() throws IOException {
        return noticeService.getNoticeApi("수업","sooup");
    }

    @GetMapping(path = "/hakjum")
    public ResponseEntity<ResponseResource> crawlHakjum() throws IOException {
        return noticeService.getNoticeApi("학점","hakjum");
    }

    @GetMapping(path = "/janghak")
    public ResponseEntity<ResponseResource> crawlJanghak() throws IOException {
        return noticeService.getNoticeApi("장학","janghak");
    }

    @GetMapping(path = "/ilban")
    public ResponseEntity<ResponseResource> crawlIlban() throws IOException {
        return noticeService.getNoticeApi("일반","ilban");
    }

    @GetMapping(path = "/hangsa")
    public ResponseEntity<ResponseResource> crawlHangsa() throws IOException {
        return noticeService.getNoticeApi("행사","hangsa");
    }



//    @GetMapping(path = "/test")
//    public ResponseEntity<ResponseResource> test(Pageable pageable) {
//        //Page<Notice> list = noticeRepository.findAll(pageable);
//        Page<Notice> list = noticeRepository.findAllByCategory("행사");
//        List<NoticeData> listData = new ArrayList<>();
//
//        for(int i = 0; i<list.getSize(); i++) {
//            NoticeData noticeData = new NoticeData(list.getContent().get(i));
//            listData.add(noticeData);
//        }
//        Response response = Response.builder()
//                .code(10)
//                .message("test")
//                .body(listData)
//                .build();
//        ResponseResource resource = new ResponseResource(response, CrawlController.class,"hangsa");
//        return ResponseEntity.ok().body(resource);

//    }
}