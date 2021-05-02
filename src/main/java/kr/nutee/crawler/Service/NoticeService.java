package kr.nutee.crawler.Service;

import kr.nutee.crawler.Controller.NoticeController;
import kr.nutee.crawler.domain.entity.Notice;
import kr.nutee.crawler.dto.Resource.ResponseResource;
import kr.nutee.crawler.dto.Response.NoticeData;
import kr.nutee.crawler.dto.Response.Response;
import kr.nutee.crawler.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final int TABLE_COLUMN_SIZE = 6;

    public void checkNewNotice(String url, String catecory) throws IOException {
        Document doc = Jsoup.connect(url).get();
        int size = doc.getElementsByTag("td").size();
        List<Notice> list = new ArrayList<>();
        for (int i = 0; i < size; i += TABLE_COLUMN_SIZE) {
            list.add(
                    Notice.builder()
                            .no(doc.getElementsByTag("td").get(i).text())
                            .title(doc.getElementsByTag("td").get(i + 1).text())
                            .href("http://skhu.ac.kr/board/" + doc.getElementsByTag("td").get(i + 1)
                                    .getElementsByTag("a").attr("href"))
                            .author(doc.getElementsByTag("td").get(i + 3).text())
                            .date(doc.getElementsByTag("td").get(i + 4).text())
                            .category(catecory)
                            .build()
            );
            isNewNotice(list.get(i / TABLE_COLUMN_SIZE));
        }
        List<Notice> notices = filterNewNotice(list);
        //sendAlarm(notices);
        addNewNotice(notices);
    }

    private List<Notice> filterNewNotice(List<Notice> pageNotices) {
        return pageNotices.stream().filter(this::isNewNotice).collect(Collectors.toList());
    }

    private boolean isNewNotice(Notice notice) {
        return noticeRepository.findNoticeByHrefAndCategory(notice.getHref(), notice.getCategory()) == null;
    }

    private void addNewNotice(List<Notice> newNotices) {
        for (Notice newNotice : newNotices) {
            noticeRepository.save(newNotice);
        }
    }

    public List<Notice> searchAllNotice() {
        return noticeRepository.findAll();
    }
//
//    public List<Notice> searchByCategory(String category) {
//        return noticeRepository.findAllByCategory(category);
//    }

//    public ResponseEntity<ResponseResource> getNoticeApi(String category, String url) {
//        List<Notice> list = searchByCategory(category);
//        List<NoticeData> listData = new ArrayList<>();
//
//        for(int i = 0; i<list.size(); i++) {
//            NoticeData noticeData = new NoticeData(list.get(i));
//            listData.add(noticeData);
//        }
//        Response response = Response.builder()
//                .code(10)
//                .message(category+"목록")
//                .body(listData)
//                .build();
//        ResponseResource resource = new ResponseResource(response, NoticeController.class,url);
//        return ResponseEntity.ok().body(resource);
//    }

    public ResponseEntity<ResponseResource> getNoticeApi(String category, String url, Pageable pageable) {
//        Page<Notice> list = noticeRepository.findAll(pageable);
        Page<Notice> list = noticeRepository.findAllByCategory(category, pageable);
        List<NoticeData> listData = new ArrayList<>();

        for(int i = 0; i<list.getSize(); i++) {
            NoticeData noticeData = new NoticeData(list.getContent().get(i));
            listData.add(noticeData);
        }
        Response response = Response.builder()
                .code(10)
                .message(category + "목록")
                .body(listData)
                .build();
        ResponseResource resource = new ResponseResource(response, NoticeController.class, url);
        return ResponseEntity.ok().body(resource);

    }
//    public void changeByCategory(String category) {
//        noticeRepository.findAllByCategory(category).get(0).setNo();
//    }

}