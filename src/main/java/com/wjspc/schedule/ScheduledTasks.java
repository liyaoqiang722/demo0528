package com.wjspc.schedule;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 79445 on 2018/6/4.
 */
@Component
@Log4j2
public class ScheduledTasks {

    @Scheduled(cron = "0 7 11 ? * TUE")
    public void test01() {
        log.info("····················定时任务cron");
    }

    /**
     *  fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方
     *  5000毫秒执行一次,第一次执行延时8000毫秒
     */
    @Scheduled(fixedDelay = 5000, initialDelay=8000)
    public void fixedDelayAndInitialDelay() {
        log.info("····················定时任务fixedDelay、initialDelay");
    }

    /**
     * fixedRate:这个有点蛋疼...,举个例子：比如：假设有5个执行时间点 间隔是5000毫秒：分别是：
     * T1:14:00:00
     * T2:14:00:05
     * T3:14:00:10
     * T4:14:00:15
     * T5:14:00:20
     * 如果T1执行时间花了4秒，也就是到了14:00:04,那么你会看到14:00:05分就开始执行了T2,很正常，此时T1结束时间和T2开始时间只差1000毫秒，没毛病
     * 如果T1执行时间花了8秒，怎么办？这时T1执行完的时间是14:00:08，已经覆盖了T2的时间，T2在14:00:05到14:00:08是等等状态。现在是14:00:08,看起来接着是T3执行，
     * 但实际不是，而是立马执行T2，立马执行T2，立马执行T2（T2说:我不管，T1搞我超时了，我无论也是执行），这时你会发现T2的执行时间（也就是第2次执行时间 ）是：14:00:08，真的是立马。。。
     * 如此类推，只要时执行时间被覆盖了的，到它了就立马执行
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 5000)
    public void fixedRate() throws InterruptedException {
        log.info("····················定时任务fixedRate");
        Thread.sleep(8000);
        log.info("····················定时任务fixedRate2：sleep 8000");
    }
}
