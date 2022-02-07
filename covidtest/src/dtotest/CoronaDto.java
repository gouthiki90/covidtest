package dtotest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CoronaDto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode; // 결과코드
            private String resultMsg; // 결과 메세지
        }

        @AllArgsConstructor
        @Data
        class Body {
            private int numOfRows; // 한 페이지 결과 수
            private int pageNo; // 페이지 수
            private int totalCount; // 전체 결과 수
            private Items items;

            @AllArgsConstructor
            @Data
            class Items {
                List<Item> item;

                @AllArgsConstructor
                @Data
                class Item {
                    private String accExamCnt; // 누적 의심신고 검사자
                    private String createDt; // 등록 일시분초
                    private String deathCnt; // 사망자 수
                    private String decideCnt; // 확진자 수
                    private String seq; // 게시글 번호(감염현황 고유값)
                    private String stateDt; // 기준일
                    private String stateTime; // 기준시간
                    private String updateDt; // 수정 일시분초
                }
            }
        }
    }
}
