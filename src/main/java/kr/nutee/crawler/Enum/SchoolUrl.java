package kr.nutee.crawler.Enum;

import lombok.Getter;

@Getter
public enum SchoolUrl {
    HAKSA_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51"),
    SOOUP_URL("http://www.skhu.ac.kr/board/boardlist.aspx?bsid=10005&searchBun=53"),
    HAKJUM_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51"),
    JANGHAK_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51"),
    ILBAN_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51"),
    HANGSA_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51");

    private final String url;

    SchoolUrl(String url) {
        this.url = url;
    }
}
