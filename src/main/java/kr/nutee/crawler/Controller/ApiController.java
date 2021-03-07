package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.SearchNotice;
import kr.nutee.crawler.domain.entity.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/notice")
@Slf4j
public class ApiController {
    @Autowired
    SearchNotice searchnotice;


    @GetMapping(path = "/all")
    public List<Notice> allNotice() {
        return searchnotice.searchAllNotice();
    }

    @GetMapping(path = "/{category}")
    public List<Notice> categoryNotice(@PathVariable("category") String category) {
        return searchnotice.searchByCategory(category);
    }
}