package com.kickegg.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by 44935 on 2017-05-14.
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将URL编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target = null;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 将URL解码
     */

    public static String decodeURL(String source){
        String targer = null;

        try {
            targer = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return targer;
    }
}
