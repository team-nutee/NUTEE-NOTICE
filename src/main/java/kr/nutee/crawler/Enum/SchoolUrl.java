package kr.nutee.crawler.Enum;

import lombok.Getter;

@Getter
public enum SchoolUrl {
    HAKSA_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10004&searchBun=51"),
    SOOUP_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10005&searchBun=53"),
    HAKJUM_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10038&searchBun=89"),
    JANGHAK_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10006&searchBun=75"),
    ILBAN_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10007"),
    HANGSA_URL("http://skhu.ac.kr/board/boardlist.aspx?bsid=10008");

    private final String url;

    SchoolUrl(String url) {
        this.url = url;
    }
}
