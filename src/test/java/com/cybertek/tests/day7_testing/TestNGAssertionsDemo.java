package com.cybertek.tests.day7_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
            // if assertion 1 fails, TestNG stops running and not go to next assertion...
            // after method will run anyway and browser will close anyway...

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        System.out.println("Second test case");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";
        //verify that your title is starts with cyb

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title start with ");
        Assert.assertTrue(2>1);
    }
    // if our test pass, no message extra we get...

    @Test
    public void test4(){
        //verify that email contains @
        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"),"Verify email has @ sign");
    }
    @Test
    public void test5(){
        //verify sth is false
        Assert.assertFalse(0>1,"verify that 0 is NOT greater than 1");
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }

}
