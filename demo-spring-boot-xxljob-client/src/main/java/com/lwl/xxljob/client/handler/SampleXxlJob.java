package com.lwl.xxljob.client.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * XxlJob开发示例（Bean模式）
 * <p>
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Component
@Slf4j
public class SampleXxlJob {
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("sampleHandler")
    public ReturnT<String> demoJobHandler(String dateString) throws Exception {
        log.info("开始执行sampleHandler，接受到的参数为：{}", dateString);
        LocalDateTime localDateTime;
        if (!StringUtils.isEmpty(dateString)) {
            localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            localDateTime = LocalDateTime.now();
        }
        try {
            log.info("执行任务：{} 哈哈哈哈", localDateTime);
        } catch (Exception e) {
            log.error("执行任务异常", e);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }


    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime);
    }
//    /**
//     * 2、分片广播任务
//     */
//    @XxlJob("shardingJobHandler")
//    public ReturnT<String> shardingJobHandler(String param) throws Exception {
//
//        // 分片参数
//        ShardingUtil.ShardingVO shardingVO = ShardingUtil.getShardingVo();
//        XxlJobLogger.log("分片参数：当前分片序号 = {}, 总分片数 = {}", shardingVO.getIndex(), shardingVO.getTotal());
//
//        // 业务逻辑
//        for (int i = 0; i < shardingVO.getTotal(); i++) {
//            if (i == shardingVO.getIndex()) {
//                XxlJobLogger.log("第 {} 片, 命中分片开始处理", i);
//            } else {
//                XxlJobLogger.log("第 {} 片, 忽略", i);
//            }
//        }
//
//        return ReturnT.SUCCESS;
//    }
//
//
//    /**
//     * 3、命令行任务
//     */
//    @XxlJob("commandJobHandler")
//    public ReturnT<String> commandJobHandler(String param) throws Exception {
//        String command = param;
//        int exitValue = -1;
//
//        BufferedReader bufferedReader = null;
//        try {
//            // command process
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
//            bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
//
//            // command log
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                XxlJobLogger.log(line);
//            }
//
//            // command exit
//            process.waitFor();
//            exitValue = process.exitValue();
//        } catch (Exception e) {
//            XxlJobLogger.log(e);
//        } finally {
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//        }
//
//        if (exitValue == 0) {
//            return IJobHandler.SUCCESS;
//        } else {
//            return new ReturnT<String>(IJobHandler.FAIL.getCode(), "command exit value("+exitValue+") is failed");
//        }
//    }
//
//
//    /**
//     * 4、跨平台Http任务
//     */
//    @XxlJob("httpJobHandler")
//    public ReturnT<String> httpJobHandler(String param) throws Exception {
//
//        // request
//        HttpURLConnection connection = null;
//        BufferedReader bufferedReader = null;
//        try {
//            // connection
//            URL realUrl = new URL(param);
//            connection = (HttpURLConnection) realUrl.openConnection();
//
//            // connection setting
//            connection.setRequestMethod("GET");
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setUseCaches(false);
//            connection.setReadTimeout(5 * 1000);
//            connection.setConnectTimeout(3 * 1000);
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            connection.setRequestProperty("Accept-Charset", "application/json;charset=UTF-8");
//
//            // do connection
//            connection.connect();
//
//            //Map<String, List<String>> map = connection.getHeaderFields();
//
//            // valid StatusCode
//            int statusCode = connection.getResponseCode();
//            if (statusCode != 200) {
//                throw new RuntimeException("Http Request StatusCode(" + statusCode + ") Invalid.");
//            }
//
//            // result
//            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//            StringBuilder result = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                result.append(line);
//            }
//            String responseMsg = result.toString();
//
//            XxlJobLogger.log(responseMsg);
//            return ReturnT.SUCCESS;
//        } catch (Exception e) {
//            XxlJobLogger.log(e);
//            return ReturnT.FAIL;
//        } finally {
//            try {
//                if (bufferedReader != null) {
//                    bufferedReader.close();
//                }
//                if (connection != null) {
//                    connection.disconnect();
//                }
//            } catch (Exception e2) {
//                XxlJobLogger.log(e2);
//            }
//        }
//
//    }
//
//    /**
//     * 5、生命周期任务示例：任务初始化与销毁时，支持自定义相关逻辑；
//     */
//    @XxlJob(value = "demoJobHandler2", init = "init", destroy = "destroy")
//    public ReturnT<String> demoJobHandler2(String param) throws Exception {
//        XxlJobLogger.log("XXL-JOB, Hello World.");
//        return ReturnT.SUCCESS;
//    }
//    public void init(){
//        logger.info("init");
//    }
//    public void destroy(){
//        logger.info("destory");
//    }


}
