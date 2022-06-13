package homework7;


public class SomeTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void test2A() {
        System.out.println("Test 2A");
    }

    @Test(priority = 2)
    public void test2B() {
        System.out.println("Test 2B");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}