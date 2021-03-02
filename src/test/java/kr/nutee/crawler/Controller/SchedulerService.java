package kr.nutee.crawler.Controller;

import kr.nutee.crawler.Service.CrawlService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Component
public class SchedulerService {

    //    @Scheduled(cron = "0 0 20 * * *")
    @Test
    @Scheduled(fixedDelay = 10000)
    public void test()/* throws IOException*/ {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        CrwalingTest craw = new CrwalingTest();
//        List<Map<String, String>> list = craw.getPageData();

        String today = format.format(Calendar.getInstance().getTime());
//        String newPage = list.get(0).get("date");
        System.out.println("Test시작");
        System.out.println(today);
//        System.out.println(newPage);

//        if(today.equals(newPage)) {
//            System.out.println("hello");
//        }
    }
}
