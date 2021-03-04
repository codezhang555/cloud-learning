package com.itz.cloud.test.debugTest;

import org.junit.Test;

/**
 * @author CodeZhang
 * @date 2020/5/2 15:07
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); // 4

        System.out.println(sb); // "null"

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
