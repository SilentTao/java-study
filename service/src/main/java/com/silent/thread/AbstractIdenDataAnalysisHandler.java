package com.silent.thread;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author liutao
 * Date 2019/9/30 3:25 下午
 * Description: excel .mos 数据解析,发送标识转换
 * Version: 1.0
 **/
public abstract class AbstractIdenDataAnalysisHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 下载文件转成文件流
     *
     * @param fileUrl 文件下载链接
     * @return
     * @throws Exception
     */
    protected InputStream getIS(String fileUrl) throws Exception {
        HttpURLConnection urlCon = null;
        try {
            URL url = new URL(fileUrl);
            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setConnectTimeout(5000);
            urlCon.setReadTimeout(30000);
        } finally {
            if (urlCon != null) IOUtils.close(urlCon);
        }
        return urlCon.getInputStream();
    }

}
