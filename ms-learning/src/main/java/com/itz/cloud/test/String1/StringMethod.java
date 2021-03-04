package com.itz.cloud.test.String1;

import org.junit.Test;

/**
 * String常用方法类
 * int length():返回字符串的长度: return value.length
 * char charAt(int index):返回某索 引处的字符return value[index]
 * boolean isEmpty():判断是否是空字符串: return value.length == 0
 * String toLowerCase():使用默认语言环境，将String中的所有字符转换为小写
 * String toUpperCase():使用默认语言环境，将String中的所有字符转换为大写
 * String trim():返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
 * boolean equals(Object obj):比较字符串的内容是否相同
 * boolean equalsIgnoreCase(String anotherString):与jequals方法类似， 忽略大小写
 * String concat(String str):将指定字符串连接到此字符串的结尾。等价于用“+”
 * int compare To(String anotherString):比较两个字符串的大小
 * String substring(int beginIndex): 返回一个新的字符串，它是此字符串的从
   beginIndex开始截取到最后的一一个子字符串。
 * String substring(int beginIndex, int endIndex) :返回一一个新字符串，它是此字
   符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 *
 * @author CodeZhang
 * @date 2020/4/30 20:40
 */
public class StringMethod {

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());  //10
        System.out.println(s1.charAt(0)); //h
        System.out.println(s1.charAt(5)); //W

        System.out.println(s1.isEmpty()); //false

        String s2 = s1.toUpperCase();
        System.out.println(s1); //s1仍然是不可变的
        System.out.println(s2); //s2是改成小写以后的字符串

        String s3 = " h e  llo  wor  ld";
        String s4 = s3.trim();
        System.out.println("----"+s3+"----");
        System.out.println("----"+s4+"----");

    }

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));   //false
        System.out.println(s1.equalsIgnoreCase(s2));   //false

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);  //abcdef

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6)); // -1  负数当前对象小，正数当前对象大

        String s7 = "橙小猪是一头猪";
        String s8 = s7.substring(2);
        String s9 = s7.substring(2, 5);
        System.out.println(s7);  //橙小猪是一头猪
        System.out.println(s8);  //猪是一头猪
        System.out.println(s9);  //猪是一
    }


    /**
     * ●boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
     * ●boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset): 测试此字符串从指定索引开始的
       子字符串是否以指定前缀开始
     */

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        boolean b2 = str1.startsWith("He");
        System.out.println(b1);   //true
        System.out.println(b2);   //false
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);   //true
    }

    /**
     * boolean contains(CharSequence s):当且仅当此字符串包含指定的char值顺序时，返回true
     * int indexof(String str): 返回指定子字符串在此字符串中第一 次出现处的索引
     * int indexOf(String str, int fromlndex):返回指定子字符串在此字符串中第一-次出现处的索引，从指定的索引开始
     * int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引
     * int lastIndexOf(String str, int fromIndex):返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        注: indexOf和lastIndexOf方法如果 未找到都是返回-1
     */
    @Test
    public void test4() {
        String str1 = "helloworld";
        String str2 = "wo";
        System.out.println(str1.contains(str2)); // true

        System.out.println(str1.indexOf("lo"));  // 3
        System.out.println(str1.indexOf("lol"));  // -1  未找到

        System.out.println(str1.indexOf("lo", 5)); // -1

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or")); // 7
        System.out.println(str3.lastIndexOf("or", 6)); // 4

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        // 情况一：存在唯一的一个str  情况二：不存在str
    }
    /**
     * 替换：
     * String replace(char oldChar, char newChar):返回一个新的字符串，它是
     通过用newChar替换此字符串中出现的所有oldChar得到的。
     * String replace(CharSequence target, CharSequence replacement):
     使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     * String replaceAll(String regex, String replacement): 使用给定的
     replacement替换此字符串所有匹配给定的正则表达式的子字符串。
     * String replaceFirst(String regex, String replacement): 使用给定的
     replacement替换此字符串匹配给定的正则表达式的第一一个 子字符串。
     * 匹配：
     * boolean matches(String regex):告知此字符串是否匹配给定的正则表达式。
     * 切片：
     * StringD splt(String regex):根据给定正则表达式的匹配拆分此字符串。
     * StringD split(String regex, int limit): 根据匹配给定的正则表达式来拆分此
     字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后-个元素中。
     *
     */

    @Test
    public void test5(){
        String str1 = "橙小迪是一头猪";
        String str2 = str1.replace('小', '大');
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str1.replace("小迪", "大胖");
        System.out.println(str3);

        System.out.println("*****************");
        String str = "12hello34world5java7891mysql456";
        String str4 = str.replaceAll("\\d+", ",").replaceAll("^,|,$","");
        System.out.println(str4);

        System.out.println("*****************");
        String str5 = "123456";
        boolean matches = str5.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("*****************");
        String str6="hello|world|java";
        String[] strs = str6.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str7 = "hello,world,java";
        String[] strs2 = str7.split("\\,");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

    }

}
