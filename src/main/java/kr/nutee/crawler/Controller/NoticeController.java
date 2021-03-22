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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/notice")//,consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class NoticeController {
    @Autowired
    NoticeService noticeService;

//    @GetMapping(path = "/all")
//    public List<Notice> allNotice() {
//        return noticeService.searchAllNotice();
//    }

    @GetMapping(path = "/{category}")
    public List<Notice> categoryNotice(@PathVariable("category") String category) {
        return noticeService.searchByCategory(category);
    }

    //모두
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseResource> allNotice() {
        List<Notice> list = noticeService.searchAllNotice();
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.size(); i++) {
            NoticeData noticeData = new NoticeData(list.get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message("test")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response,NoticeController.class);
        return ResponseEntity.ok().body(resource);
    }
}