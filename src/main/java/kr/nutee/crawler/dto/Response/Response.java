package kr.nutee.crawler.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    int code;
    String message;
//    int startPage;
//    int endPage;
    int pageSize;
    int pageNo;
    Object body;


}
