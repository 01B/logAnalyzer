package net.nopainnocode.log.domain;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 각각의 URL 의 정보를 받아 URL 정보를 객체화하는 클래스입니다.
 */
public class UrlInfo {

    private String mainUrl;

    private String serviceID;

    private String apiKey;

    private String apiQuery;

    private static final List<String> serviceIds = Arrays.asList("blog", "book", "image", "knowledge", "news", "vclip");
    private static final String API_KEY = "apikey";
    private static final String QUERY = "q";
    private static final String FUNCTION_SEARCH = "/search/";

    /**
     * UrlInfo 클래스 내의 build 메서드만을 통해서 초기화합니다.
     * @param mainUrl
     * @param serviceID
     * @param apiKey
     * @param apiQuery
     */
    private UrlInfo(String mainUrl, String serviceID, String apiKey, String apiQuery) {
        this.mainUrl = mainUrl;
        this.serviceID = serviceID;
        this.apiKey = apiKey;
        this.apiQuery = apiQuery;
    }

    /**
     * URL 문자열을 받아 UrlInfo 를 생성합니다
     * @param urlStr
     * @return
     */
    public static UrlInfo build(String urlStr) {
        String mainUrl = null;
        String serviceID = null;
        String apiKey = null;
        String apiQuery = null;
        try {
            URL url = new URL(urlStr);

            // serviceID 추출
            serviceID = extractServiceID(serviceID, url.getPath().replaceFirst("/", "").split("/")[1]);

            String query = url.getQuery();

            if(query != null) {
                query = query.toLowerCase();
                if(query.contains("&")) {
                    String[] querys = query.split("&");
                    apiKey = querys[0].split("=")[1];
                    apiQuery = querys[1].split("=")[1];
                } else {
                    if(query.contains(API_KEY.toLowerCase()))
                        apiKey = query.split("=")[1];
                    else if(query.contains(QUERY.toLowerCase()))
                        apiQuery = query.split("=")[1];
                }
                mainUrl = urlStr.replace(url.getPath(), "").replace(url.getQuery(), "").replace("?", "") + FUNCTION_SEARCH;
            } else {
                mainUrl = urlStr.replace(url.getPath(), "") + FUNCTION_SEARCH;
            }
        }catch (Exception e) {
            System.out.println(urlStr);
            e.printStackTrace();
        }

        return new UrlInfo(mainUrl, serviceID, apiKey, apiQuery);
    }

    /**
     * ServiceID 를 추출합니다.
     * @param serviceID
     * @param s
     * @return
     */
    private static String extractServiceID(String serviceID, String s) {
        String serviceIDTemp = s.toLowerCase();
        if(serviceIds.contains(serviceIDTemp))
            serviceID = serviceIDTemp;
        return serviceID;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiQuery() {
        return apiQuery;
    }
}