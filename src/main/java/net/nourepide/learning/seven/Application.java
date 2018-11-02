package net.nourepide.learning.seven;

import net.nourepide.learning.seven.annotation.AfterSuit;
import net.nourepide.learning.seven.annotation.BeforeSuit;
import net.nourepide.learning.seven.annotation.Test;

public class Application {

    @BeforeSuit
    public void before() {
        System.out.println("Before");
    }

    @Test(priority = 0)
    public void testMethodOne() {
        System.out.println("Test one");
    }

    @Test(priority = 2)
    public void testMethodTwo() {
        System.out.println("Test two");
    }

    @Test(priority = 1)
    public void testMethodThree() {
        System.out.println("Test three");
    }

    @AfterSuit
    public void after() {
        System.out.println("After");
    }

    /*
    * Output:
    *
    * Before
    * Test one
    * Test three
    * Test two
    * After
    *
    * */
}
