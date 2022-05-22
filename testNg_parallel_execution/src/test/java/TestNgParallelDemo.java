import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestNgParallelDemo {

    private static final String DEV_BY =  "https://devby.io/";
    private static final String GOOGLE =  "https://google.com/";
    private static final String ON_LINER =  "https://www.onliner.by/";
    private static final Integer TIME_TO_WAIT = 3000;

    @Test
    void test1() throws InterruptedException {
        open(GOOGLE);
        Thread.sleep(TIME_TO_WAIT);
        System.out.println("-->1 | thread id ->" + Thread.currentThread().getId());
        closeWebDriver();
    }

    @Test
    void test2() throws InterruptedException {
        open(DEV_BY);
        Thread.sleep(TIME_TO_WAIT);
        System.out.println("-->2 | thread id ->" + Thread.currentThread().getId());
        closeWebDriver();
    }

    @Test
    void test3() throws InterruptedException{
        open(ON_LINER);
        Thread.sleep(TIME_TO_WAIT);
        System.out.println("-->3 | thread id ->" + Thread.currentThread().getId());
        closeWebDriver();
    }

    @Test(threadPoolSize = 3, invocationCount = 9,  timeOut = 10000)
    void test4(){
        System.out.println("-->4 | thread id ->" + Thread.currentThread().getId());
    }
}
