package net.nopainnocode.log.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by no_pain_no_code on 2015. 11. 30..
 */
public class UrlInfoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_serviceID_apikey_apiQuery_null_mainUrl_정상() throws Exception {

        // given
        String testUrl = "http://apis.daum.net/search/aaaaapikey=wejf&q=daum";

        // when
        UrlInfo testUrlInfo = UrlInfo.build(testUrl);

        // then
        Assert.assertEquals(testUrlInfo.getMainUrl(), "http://apis.daum.net/search/");
        Assert.assertNull(testUrlInfo.getServiceID());
        Assert.assertNull(testUrlInfo.getApiKey());
        Assert.assertNull(testUrlInfo.getApiQuery());
    }

    @Test
    public void test_serviceID_apikey_대문자_나머지_정상() {

        // given
        String testUrl = "http://apis.daum.net/search/VClip?apikey=23Jf&q=daum";

        // given
        UrlInfo testUrlInfo = UrlInfo.build(testUrl);

        // when
        Assert.assertEquals(testUrlInfo.getMainUrl(), "http://apis.daum.net/search/");
        Assert.assertEquals(testUrlInfo.getMainUrl(), "http://apis.daum.net/search/");
        Assert.assertEquals(testUrlInfo.getServiceID(), "vclip");
        Assert.assertEquals(testUrlInfo.getApiKey(), "23jf");
        Assert.assertEquals(testUrlInfo.getApiQuery(), "daum");
    }

    @Test
    public void test_에이피아이_NULL_나머지_정상(){

        // given
        String testUrl = "http://apis.daum.net/search/blog?q=daum";

        // when
        UrlInfo testUrlInfo = UrlInfo.build(testUrl);

        // when
        Assert.assertEquals(testUrlInfo.getMainUrl(), "http://apis.daum.net/search/");
        Assert.assertEquals(testUrlInfo.getServiceID(), "blog");
        Assert.assertNull(testUrlInfo.getApiKey());
        Assert.assertEquals(testUrlInfo.getApiQuery(), "daum");
    }

    @Test
    public void test_다른_root_URL_정상작동(){

        //given
        String testUrl = "http://apis.naver.com/search/vclip?apikey=23Jf&q=naver";

        //when
        UrlInfo testUrlInfo = UrlInfo.build(testUrl);

        //then
        Assert.assertEquals(testUrlInfo.getMainUrl(), "http://apis.naver.com/search/");
        Assert.assertEquals(testUrlInfo.getServiceID(), "vclip");
        Assert.assertEquals(testUrlInfo.getApiKey(), "23jf");
        Assert.assertEquals(testUrlInfo.getApiQuery(), "naver");
    }

    @Test
    public void test_유효하지_않는_URL(){

        //given
        String testUrl = "Monkey D. Luffy";

        //when
        UrlInfo testUrlInfo = UrlInfo.build(testUrl);

        //then
        Assert.assertNull(testUrlInfo.getMainUrl());
        Assert.assertNull(testUrlInfo.getServiceID());
        Assert.assertNull(testUrlInfo.getApiKey());
        Assert.assertNull(testUrlInfo.getApiQuery());
    }
}
