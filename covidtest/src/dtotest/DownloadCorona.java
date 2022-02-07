package dtotest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dtotest.CoronaDto.Response.Body.Items.Item;

public class DownloadCorona {
    public static List<Item> CoronaList(String startCreateDt, String endCreateDt) {
        Map<String, String> coronaMap = new HashMap<>();
        try {
            StringBuffer sb = new StringBuffer();

            sb.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?");
            sb.append(
                    "serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&");
            sb.append("pageNo=1&");
            sb.append("numOfRows=10&");
            sb.append("totalCount=6&");
            sb.append("startCreateDt=" + startCreateDt + "&");
            sb.append("endCreateDt=" + endCreateDt + "&");
            sb.append("_type=json");

            URL url = new URL(sb.toString());

            HttpURLConnection stream = (HttpURLConnection) url.openConnection();
            // Stream 연결
            BufferedReader br = new BufferedReader(new InputStreamReader(stream.getInputStream(), "utf-8"));
            // BR로 데이터 가져오기
            String responseJson = br.readLine();
            // 데이터 읽기
            Gson gson = new Gson();
            CoronaDto dto = gson.fromJson(responseJson, CoronaDto.class);
            // Json으로 데이터 가져와서 자바 파싱하기

            List<Item> resulte = dto.getResponse().getBody().getItems().getItem();
            return resulte;

        } catch (Exception e) {
            System.out.println("정보를 불러오지 못 했습니다.");
            e.printStackTrace();
        }
        return null;
    }

}
