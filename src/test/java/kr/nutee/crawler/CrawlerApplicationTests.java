package kr.nutee.crawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootTest
class CrawlerApplicationTests {


    @Test
    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplicationTests.class, args);
    }

    @Test
    void contextLoads() {
    }

}
