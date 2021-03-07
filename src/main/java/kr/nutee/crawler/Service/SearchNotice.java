package kr.nutee.crawler.Service;

import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class SearchNotice {
    @Autowired
    NoticeRepository noticeRepository;


    public List<Notice> searchAllNotice() {
        return noticeRepository.findAll();
    }

    public List<Notice> searchByCategory(String category) {
        int Table_Size = (int) noticeRepository.count();
        List<Notice> list = new ArrayList<>();
        for(int i = 0 ; i < Table_Size ; i++) {
            if(noticeRepository.findAll().get(i).getCategory().equals(category)) {
                list.add(noticeRepository.findAll().get(i));
            }
        }
        return list;
    }
}