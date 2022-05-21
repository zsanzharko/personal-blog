package kz.astrium.personalblog.handler.abstracts;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class WebInfo {

    private final String WebName;
    private final String MAIN_URL;
    private final List<?> SECONDS_URL;

    public WebInfo(String webName, String main_url, List<?> seconds_url) {
        WebName = webName;
        MAIN_URL = main_url;
        SECONDS_URL = seconds_url;
    }
}
