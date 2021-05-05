//package kr.nutee.crawler.Common;
//
//import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//
//@TestConfiguration
//public class RestDocsConfiguration {
//
//    @Bean
//    public RestDocsMockMvcConfigurationCustomizer restDocsMockMvcConfigurationCustomizer(){
//        return v -> v.operationPreprocessors()
//                .withRequestDefaults(prettyPrint())
//                .withResponseDefaults(prettyPrint());
//    }
//
//}
