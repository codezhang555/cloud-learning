package com.itz.cloud.test.StringExer;

import org.junit.Test;

/**
 * @author CodeZhang
 * @date 2020/5/2 14:50
 */
public class StringDemo2 {

    int count = 0;
    int index = 0;
    /**
     * 获取一个字符串在另一个字符串中出现的次数
     *  比如：获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
     *
     */
    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (mainLength >= subLength){
            //方式一：
            while((index = mainStr.indexOf(subStr)) != -1){
                count++;
                mainStr = mainStr.substring(index+subStr.length());
            }
            return count;
        }else {
            return 0;
        }
    }

    public int getCount1(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (mainLength >= subLength){
            //方式二：
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;

            }
            return count;
        }else {
            return 0;
        }
    }

    @Test
    public void testCount(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

    @Test
    public void testCount1(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount1(mainStr, subStr);
        System.out.println(count);
    }
}
