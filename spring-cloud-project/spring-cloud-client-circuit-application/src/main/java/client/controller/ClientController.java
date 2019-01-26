package client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@Slf4j
public class ClientController {


    private String h(){
        int i = RandomUtils.nextInt(2000);
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i+",你好";
    }

    @HystrixCommand(
            fallbackMethod = "hiErrorBack",
            commandProperties = {
                    @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,
                            value = "1000")
            }
    )
    @GetMapping("/hi")
    public String hi(){
        return h();
    }


    @GetMapping("/hi2")
    public String hi2(){

        ExecutorService executorService =  new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("线程%d").daemon(true).build());
        Future<String> future = executorService.submit(()-> h());
        try {
            String s = future.get(1000, TimeUnit.MILLISECONDS);
            return s;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.info("超时了");
            future.cancel(true);
            return hiErrorBack();
        }
    }


    volatile Semaphore semaphore = null;
    @GetMapping("/hi3")
    public String hi3(){
        if(semaphore==null) {
            synchronized (this){
                if(semaphore==null){
                    semaphore = new Semaphore(1);
                }
            }
        }
        try {
            if (semaphore.tryAcquire()) {
                return h();
            } else {
                return hiErrorBack();
            }
        }finally{
            semaphore.release();
        }
    }


    public String hiErrorBack(){
        return "出差了";
    }




}
