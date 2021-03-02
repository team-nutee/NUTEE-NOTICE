package kr.nutee.crawler.Scheduler;

import kr.nutee.crawler.Enum.SchoolUrl;
import kr.nutee.crawler.Service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class Scheduler {
    @Autowired
    NoticeService noticeService;
//
    @Scheduled(cron = "0 * * * * *")
    public void checkPage() throws IOException {
        noticeService.checkNotice(SchoolUrl.HAKSA_URL.getUrl(), "학사");
        noticeService.checkNotice(SchoolUrl.SOOUP_URL.getUrl(), "수업");
        noticeService.checkNotice(SchoolUrl.HAKJUM_URL.getUrl(), "학점");
        noticeService.checkNotice(SchoolUrl.JANGHAK_URL.getUrl(), "장학");
        noticeService.checkNotice(SchoolUrl.ILBAN_URL.getUrl(), "일반");
        noticeService.checkNotice(SchoolUrl.HANGSA_URL.getUrl(), "행사");
    }
}
