/*
 * @Author: 丑牛
 * @Date: 2021-10-15 11:25:05
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 11:26:53
 * @Description: file content
 */
package spock.example.demo.util;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import spock.example.demo.entity.RequestHeaderVO;

public class HttpContextUtils {
    private static final int CONTEXT_DEFAULT_SIZE = 64;
    private static final ThreadLocal<Map<String, Object>> CONTEXT = new ThreadLocal<Map<String, Object>>() {
        protected Map<String, Object> initialValue() {
            return new ConcurrentHashMap(CONTEXT_DEFAULT_SIZE);
        }
    };

    public static final String REQUEST_HEAD_KEY = "Request_Head";

    public static void initialize(RequestHeaderVO requestHead) {
        if (CONTEXT.get().containsKey(REQUEST_HEAD_KEY)) {
            (CONTEXT.get()).remove(REQUEST_HEAD_KEY);
        }
        CONTEXT.get().put(REQUEST_HEAD_KEY, requestHead);
    }

    private static RequestHeaderVO getRequestHead() {
        return (RequestHeaderVO)CONTEXT.get().get(REQUEST_HEAD_KEY);
    }

    /**
     * 获取当前币种
     *
     * @return
     */
    public static String getCurrentCurrency() {
        RequestHeaderVO requestHead = getRequestHead();
        return Optional.of(requestHead).map(RequestHeaderVO::getCurrency).orElse(null);
    }

    /**
     * 获取当前来源: APP,WAP(H5),ONLINE(PC)
     *
     * @return
     */
    public static String getCurrentSource() {
        RequestHeaderVO requestHead = getRequestHead();
        return Optional.of(requestHead).map(RequestHeaderVO::getSource).orElse(null);
    }
}

