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

    @Scheduled(cron = "0 * * * * *")
    public void checkPage() throws IOException {
        noticeService.checkNewNotice(SchoolUrl.HAKSA_URL.getUrl(), "학사");
        noticeService.checkNewNotice(SchoolUrl.SOOUP_URL.getUrl(), "수업");
        noticeService.checkNewNotice(SchoolUrl.HAKJUM_URL.getUrl(), "학점");
        noticeService.checkNewNotice(SchoolUrl.JANGHAK_URL.getUrl(), "장학");
        noticeService.checkNewNotice(SchoolUrl.ILBAN_URL.getUrl(), "일반");
        noticeService.checkNewNotice(SchoolUrl.HANGSA_URL.getUrl(), "행사");
    }
}
