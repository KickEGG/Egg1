package com.kickegg.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by 44935 on 2017-05-14.
 */
public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     */

    public static String getString(InputStream is) {

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String line = null;
        try {
            while ((line = bf.readLine()) != null) {
                sb.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
