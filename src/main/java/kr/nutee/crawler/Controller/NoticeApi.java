package kr.nutee.crawler.Controller;

import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping(path = "/noties")
//@RequiredArgsConstructor
//@ResponseBody
@RestController
@RequestMapping(value = "/notices")
public class NoticeApi {
    @Autowired
    NoticeRepository noticeRepository;


//    @RequestMapping(value = "/all")
    @GetMapping(path = "/all")
    public List<Notice> allNotice() {
        return noticeRepository.findAll();
    }

//    @RequestMapping(value = "notices/{category}", method = RequestMethod.GET)
    @GetMapping(path = "/{category}")
    public List<Notice> categoryNotice(@PathVariable("category") String category) {
        List<Notice> list = new ArrayList<>();
        int Table_Size = (int) noticeRepository.count();
        for(int i=0 ; i<Table_Size ; i++) {
            if(noticeRepository.findAll().get(i).getCategory().equals(category)) {
                list.add(noticeRepository.findAll().get(i));
            }
        }
        return list;
    }


}