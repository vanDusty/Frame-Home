package cn.van.spring.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @公众号： 风尘博客
 * @Classname StopWatchTest
 * @Description StopWatch 示例
 * @Date 2020/1/2 11:35 上午
 * @Author by Van
 */
@Slf4j
public class StopWatchTest {

    @Test
    public void stopWatchDemo() throws InterruptedException {

        StopWatch sw = new StopWatch();
        // start 开始记录指定任务
        sw.start("起床");
        Thread.sleep(1000);
        // stop 停止记录
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();
        // 输出代码执行耗时，以及执行时间百分比。
        log.info("all cost info:{}",sw.prettyPrint());
        // 统计输出总耗时
        log.info("all costTime:{}",sw.getTotalTimeMillis());
        // 返回简短的总耗时描述
        log.info("fff:{}",sw.shortSummary());
        // 最后一个任务的名称/耗时
        log.info("last taskName:{}",sw.getLastTaskName());
        log.info("last taskInfo:{}",sw.getLastTaskTimeMillis());
        // 返回统计时间任务的数量
        log.info("last taskCount:{}",sw.getTaskCount());
    }
}
