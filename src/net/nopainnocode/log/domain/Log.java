package net.nopainnocode.log.domain;

import net.nopainnocode.log.domain.type.Status;
import net.nopainnocode.log.domain.type.WebBrower;

import java.util.Date;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * Log 의 정보를 담는 클래스입니다.
 */
public class Log {

    private Status status;

    private UrlInfo urlInfo;

    private WebBrower webBrower;

    private Date date;

    public Log(Status status, UrlInfo urlInfo, WebBrower webBrower, Date date) {
        this.status = status;
        this.urlInfo = urlInfo;
        this.webBrower = webBrower;
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public UrlInfo getUrlInfo() {
        return urlInfo;
    }

    public WebBrower getWebBrower() {
        return webBrower;
    }

    public Date getDate() {
        return date;
    }
}
