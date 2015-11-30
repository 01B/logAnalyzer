package net.nopainnocode.log.utils.formatter;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.type.Status;

import java.util.*;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 로그 분석 결과의 자료구조와 서식을 만듦니다.
 */
public class LogFormatter implements Formatter<Log> {

    private final static int RANK_COUNT = 3;
    private Map<Status, List<Log>> logMap = new HashMap<>();

    /**
     * Comparator 인터페이스를 상속받아 계산로직에 사용한다.
     */
    private Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> firstEntry, Map.Entry<String, Integer> secondEntry) {
            return firstEntry.getValue() > secondEntry.getValue() ? -1 : 1;
        }
    };

    /**
     * 저장된 정보를 이용해 출력에 용이한 데이터 구조를 만들어 출력 문자열을 만든다.
     * @return
     */
    @Override
    public String doFormat() {

        List<Log> okLogs = logMap.get(Status.OK);

        String maxCalledApi = getMaxCalledApiKey(okLogs);
        Map<String, Integer> rankedServiceIdMap = rankServiceId(okLogs);
        Map<String, Double> rateBrowerMap = rateWebBrowser(okLogs);

        return generateWriteStr(maxCalledApi, rankedServiceIdMap, rateBrowerMap);
    }

    /**
     * 데이터가 저장된 자료구조를 이용해 출력하고자 하는 문자열을 만든다.
     * @param maxCalledApi
     * @param rankedServiceIdMap
     * @param rateBrowerMap
     * @return
     */
    private String generateWriteStr(String maxCalledApi, Map<String, Integer> rankedServiceIdMap, Map<String, Double> rateBrowerMap) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최다호출 APIKEY\n" + maxCalledApi);
        stringBuilder.append("\n\n");
        stringBuilder.append(String.format("상위 %d개의 API ServiceID와 각각의 요청 수\n",RANK_COUNT));
        Iterator<Map.Entry<String, Integer>> serviceIdIterator = rankedServiceIdMap.entrySet().iterator();
        while(serviceIdIterator.hasNext()) {
            Map.Entry<String, Integer> nextEntry= serviceIdIterator.next();
            stringBuilder.append(
                    String.format("%s : %d\n",
                            nextEntry.getKey(),
                            nextEntry.getValue()));
        }
        stringBuilder.append("\n웹브라우저별 사용 비율\n");
        Iterator<Map.Entry<String, Double>> rateBrowerIterator = rateBrowerMap.entrySet().iterator();
        while(rateBrowerIterator.hasNext()) {
            Map.Entry<String, Double> nextEntry= rateBrowerIterator.next();
            stringBuilder.append(
                    String.format("%s : %.2f%%\n",
                            nextEntry.getKey(),
                            nextEntry.getValue()));
        }

        return stringBuilder.toString();
    }

    /**
     * 최다 호출 Api key 를 가져온다.
     * @param okLogs
     * @return
     */
    private String getMaxCalledApiKey(List<Log> okLogs) {

        Map<String, Integer> urlApiCountMap = countSomething(okLogs, new State<Log>() {
            @Override
            public String getState(Log log) {
                return log.getUrlInfo().getApiKey();
            }
        });

        String maxApiKey = Collections.max(urlApiCountMap.entrySet(), comparator).getKey();

        return maxApiKey;
    }

    /**
     * 정해진 순위까지의 많이 요된 service ID 를 가져온다.
     * @param okLogs
     * @return
     */
    private Map<String, Integer> rankServiceId(List<Log> okLogs) {

        Map<String, Integer> serviceIdCountMap = countSomething(okLogs, new State<Log>(){
            @Override
            public String getState(Log log) {
                return log.getUrlInfo().getServiceID();
            }
        });

        List<Map.Entry<String, Integer>> list = new LinkedList<>(serviceIdCountMap.entrySet());
        Collections.sort(list, comparator);
        Map<String, Integer> result = new LinkedHashMap<>();
        for(int i = 0; i < RANK_COUNT; i++) {
            result.put(list.get(i).getKey(), list.get(i).getValue());
        }

        return result;
    }

    /**
     * 웹 브라우져 별 사용 비율을 계산하여 가져온다.
     * @param okLogs
     * @return
     */
    private Map<String, Double> rateWebBrowser(List<Log> okLogs) {

        int totalCount = okLogs.size();
        Map<String, Double> result = new LinkedHashMap<>();
        Map<String, Integer> browerCountMap = countSomething(okLogs, new State<Log>(){
            @Override
            public String getState(Log log) {
                return log.getWebBrower().toString();
            }
        });

        List<Map.Entry<String, Integer>> list = new LinkedList<>(browerCountMap.entrySet());
        Collections.sort(list, comparator);

        for (Map.Entry<String, Integer> entry : list) {
            double rate = ((double)entry.getValue()) / ((double)totalCount) * 100;
            result.put(entry.getKey(), rate);
        }
        return result;
    }

    /**
     * key 별로 숫자를 세어 저장한다.
     * @param okLogs
     * @param state
     * @return
     */
    private Map<String, Integer> countSomething(List<Log> okLogs, State state) {

        Map<String, Integer> countMap = new HashMap<>();

        for (Log log : okLogs) {
            String key = state.getState(log);
            int count = countMap.getOrDefault(key, 0);
            countMap.put(key, ++count);
        }

        return countMap;
    }

    /**
     * Log Value 를 추가합니다.
     * @param value
     */
    public void addLog(Log value) {

        Status key = value.getStatus();
        List<Log> logs = logMap.getOrDefault(key, new ArrayList<>());
        logs.add(value);
        logMap.put(key, logs);
    }

    /**
     * State 관점 분리 Interface
     * @param <T>
     */
    private interface State<T> {
        String getState(T t);
    }
}
