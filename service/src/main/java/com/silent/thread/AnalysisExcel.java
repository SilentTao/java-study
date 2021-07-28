package com.silent.thread;


import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Author liutao
 * Date 2019/11/30 9:36 上午
 * Description:
 * Version: 1.0
 **/
public class AnalysisExcel implements Callable<String> {

    private String url;

    public AnalysisExcel(String url) {
        this.url = url;
    }


    @Override
    public String call() throws Exception {
        Long startTime = System.currentTimeMillis() / 1000;
       // List<String> stringList = AbstractExcelDataAnalysisHandler.readSingleExcelByStringFomFilePath(url);
        Long endTime = System.currentTimeMillis() / 1000;
        Thread.sleep(2000);
        System.out.println("excelInputStream花费时间为:" + (startTime - endTime));
        return url;
    }
}
