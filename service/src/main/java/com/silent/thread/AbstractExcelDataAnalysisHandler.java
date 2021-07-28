package com.silent.thread;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author liutao
 * Date 2019/10/9 10:50 上午
 * Description:
 * Version: 1.0
 **/
public class AbstractExcelDataAnalysisHandler extends AbstractIdenDataAnalysisHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractExcelDataAnalysisHandler.class);


    /**
     * @param filePath 文件路径
     * @return 数据集合
     */
    public static List<String> readSingleExcelByStringFomFilePath(String filePath) {
        // 创建返回信息
        List<String> dataListMap;
        // 解析监听器
        try (InputStream inputStream = new FileInputStream(filePath)) {
            // 创建文件流
            dataListMap = readExcelBySingleStringFromInputStream(inputStream);

        } catch (Exception e) {
            throw new EasyExcelException("readExcelByModel from filePath failed." + e, e);
        }
        return dataListMap;
    }

    /**
     * @param filePath 文件路径
     * @return 数据集合
     */
    public static List<List<String>> readMultiExcelByStringFomFilePath(String filePath) {
        // 创建返回信息
        List<List<String>> dataList;
        // 解析监听器
        try (InputStream inputStream = new FileInputStream(filePath)) {
            // 创建文件流
            dataList = readExcelMultiByStringFromInputStream(inputStream);

        } catch (Exception e) {
            throw new EasyExcelException("readExcelByModel from filePath failed." + e, e);
        }
        return dataList;
    }


    /**
     * 解析自定义 excel ,多列 只解析第一个 sheet
     * 里层的 List<String> 中值的下标和 excel 中列的顺序一致
     *
     * @param inputStream 文件流
     * @return 数据集合
     */
    public static List<List<String>> readExcelMultiByStringFromInputStream(InputStream inputStream) {
        // 创建返回信息
        List<List<String>> listArrayList = new ArrayList<>();
        // 解析监听器
        StringMultiExcelListener excelListener = new StringMultiExcelListener();
        try {
            // 创建文件流
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, excelListener);
            // 得到所有工作表
            List<Sheet> sheets = excelReader.getSheets();
            // 取所有工作表数据
            if (sheets.size() > 0) {
                // 工作表名称
                // 读取Excel数据
                excelReader.read(sheets.get(0));
                // 返回明细数据
                List<List<String>> sheetDataInfo = Lists.newArrayList(excelListener.getDataList());
                // 将工作表数据放入工作薄
                listArrayList.addAll(sheetDataInfo);
                // 清除缓存数据
                excelListener.clear();
            }
        } catch (Exception e) {
            throw new EasyExcelException("readExcelByStringFromInputStream from inputStream failed." + e, e);
        }
        return listArrayList;
    }

    /**
     * 通过String类,读取工作表数据 , 只读取第一行数据
     *
     * @param inputStream 文件流
     * @return 数据集合
     */
    public static List<String> readExcelBySingleStringFromInputStream(InputStream inputStream) {
        // 创建返回信息
        List<String> dataList = new ArrayList<>();
        // 解析监听器
        StringSingleExcelListener excelListener = new StringSingleExcelListener();
        try {
            // 创建文件流
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, excelListener);
            // 得到所有工作表
            List<Sheet> sheets = excelReader.getSheets();
            // 取所有工作表数据
            if (sheets.size() > 0) {
                // 读取Excel数据
                excelReader.read(sheets.get(0));
                // 返回明细数据
                List<String> sheetDataInfo = Lists.newArrayList(excelListener.getDataList());
                // 将工作表数据放入工作薄
                dataList.addAll(sheetDataInfo);
                // 清除缓存数据
                excelListener.clear();
            }

        } catch (Exception e) {
            throw new EasyExcelException("readExcelByStringFromInputStream from inputStream failed." + e, e);
        }
        return dataList;
    }

    public static void main(String[] args) {
        List<List<String>> map = readMultiExcelByStringFomFilePath("/Users/liutao/Downloads/aaaaa.xlsx");
        System.out.println(map);
    }

    /**
     * 解析多列 ,
     */
    private static class StringMultiExcelListener extends AnalysisEventListener<List<String>> {
        /**
         * 自定义用于暂时存储data 可以通过实例获取该值
         */
        private List<List<String>> dataList = Lists.newArrayList();

        @Override
        public void invoke(List<String> rowInfo, AnalysisContext context) {
            // 数据存储到list，供批量处理，或后续自己业务逻辑处理。
            if (context.getCurrentRowNum() > 0) {
                dataList.add(rowInfo);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            //解析结束销毁不用的资源
        }

        private List<List<String>> getDataList() {
            return dataList;
        }

        private void setDataList(List<List<String>> dataList) {
            this.dataList = dataList;
        }

        private void clear() {
            dataList.clear();
        }
    }

    /**
     * 解析单列
     */
    private static class StringSingleExcelListener extends AnalysisEventListener<List<String>> {
        /**
         * 自定义用于暂时存储data 可以通过实例获取该值
         */
        private List<String> dataList = Lists.newArrayList();

        @Override
        public void invoke(List<String> rowInfo, AnalysisContext context) {
            // 数据存储到list，供批量处理，或后续自己业务逻辑处理。
            if (context.getCurrentRowNum() > 0) {
                dataList.addAll(rowInfo);
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            //解析结束销毁不用的资源
        }

        private List<String> getDataList() {
            return dataList;
        }

        private void setDataList(List<String> dataList) {
            this.dataList = dataList;
        }

        private void clear() {
            dataList.clear();
        }
    }

    /**
     * EasyExcelException
     */
    public static class EasyExcelException extends RuntimeException {

        private static final long serialVersionUID = -5456062088984840434L;

        public EasyExcelException() {
            super();
        }

        public EasyExcelException(String message) {
            super(message);
        }

        public EasyExcelException(String message, Throwable cause) {
            super(message, cause);
        }

        public EasyExcelException(Throwable cause) {
            super(cause);
        }
    }

}
