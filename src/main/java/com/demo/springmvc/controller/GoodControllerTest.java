package com.demo.springmvc.controller;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

/**
 * Created by dell on 2017/2/20.
 */
public class GoodControllerTest extends TestCase {
    @Test
    public void test() {
        Date date = new Date();
        String s = date.toString();
        System.out.println(s);
    }
}