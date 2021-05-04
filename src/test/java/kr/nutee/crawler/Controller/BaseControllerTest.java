package kr.nutee.crawler.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.nutee.crawler.Common.RestDocsConfiguration;
import kr.nutee.crawler.Service.NoticeService;
import kr.nutee.crawler.repository.NoticeRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


//@AutoConfigureRestDocs
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Import(RestDocsConfiguration.class)
//@ExtendWith(RestDocumentationExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Transactional
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)



@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import(RestDocsConfiguration.class)
@ExtendWith(RestDocumentationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class BaseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected PasswordEncoder passwordEncoder;

//    protected String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZjAwMDEiLCJyb2xlIjoiUk9MRV9NQU5BR0VSIiwiaWQiOjEsImV4cCI6MTkxMjA2NDU4NiwiaWF0IjoxNTk2NzA0NTg2fQ.VmpRq6R0NhyteAp2ToaPPbjAANcSfZTMKvrXxCd3iFBcm3gVLn9GYd6lJQ07gRIyk_U38x4t7VEpzA2qcbMAgA";
}
