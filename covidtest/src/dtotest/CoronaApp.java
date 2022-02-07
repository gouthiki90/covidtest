package dtotest;

import java.util.List;
import java.util.Scanner;

import dtotest.CoronaDto.Response.Body.Items.Item;

public class CoronaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("코로나 현황 범위를 알립니다.");
        System.out.println("알고 싶은 시작 날짜를 입력해주세요.");
        System.out.println("ex) 20220110 시작일");
        String startCreateDt = sc.nextLine();

        System.out.println("종료 날짜를 입력해주세요.");
        System.out.println("ex) 20220115 종료일");
        String endCreateDt = sc.nextLine();

        List<Item> coronaList = DownloadCorona.CoronaList(startCreateDt, endCreateDt);
        for (int i = 0; i < coronaList.size(); i++) {
            System.out.println("⎯⎯⎯⎯⎯⎯코로나 현황 범위 알림⎯⎯⎯⎯⎯⎯");
            System.out.println("기록 날짜 : " + coronaList.get(i).getStateDt());
            System.out.println("업데이트 날짜 : " + coronaList.get(i).getUpdateDt());
            System.out.println("확진자 수 : " + coronaList.get(i).getDecideCnt());
            System.out.println("사망자 수 : " + coronaList.get(i).getDeathCnt());
        }

    }
}
