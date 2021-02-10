package com.cybertek.tests.day7_testing;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {


    @Test
    public void test1(){

        System.out.println("First Test");   // test code here...
    }

    @Test
    public void test2(){
        System.out.println("Second Test");
    }

    @Ignore     //Ignore this test using this keyword or just use // comment out...
    @Test
    public void test3(){
        System.out.println("Third Test");
    }
}
