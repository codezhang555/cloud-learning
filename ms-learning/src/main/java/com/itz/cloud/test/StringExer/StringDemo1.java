package com.itz.cloud.test.StringExer;

import org.junit.Test;

/**
 * String常见算法题
 * @author CodeZhang
 * @date 2020/5/2 13:37
 */
public class StringDemo1 {

    /**2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg"反转为"abfedcg"
     *
     *   方式一：转换为char[]
     */
    public String reverse(String str,int startIndex,int endIndex){
        if (str!=null){
            char[] arr = str.toCharArray();
            for (int x = startIndex,y = endIndex;x<y;x++,y--){
                char temp = arr[x];
                arr [x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }
    //方式二：使用String的拼接操作
    public String reverse1(String str,int startIndex,int endIndex){
        if (str!=null){
            //第一部分
            String reverseStr = str.substring(0,startIndex);
            //第二部分
            for (int i = endIndex;i>=startIndex;i--){
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }

    //方式三；使用StringBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if (str!=null){
            StringBuilder builder = new StringBuilder(str.length());

            //第一部分
            builder.append(str.substring(0,startIndex));
            //第二部分
            for (int i = endIndex;i>=startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex+1));

            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
    }

    @Test
    public void testReverse1(){
        String str = "abcdefg";
        String reverse = reverse1(str, 2, 5);
        System.out.println(reverse);
    }

    @Test
    public void testReverse2(){
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }
}
