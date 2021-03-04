package com.itz.cloud.test.String1;

/**
 * 1道面试题
 *  基本数据类型传递的是值，引用数据类型传递的是地址
 *
 * @author CodeZhang
 * @date 2020/4/30 20:24
 */
public class StringTest1 {

    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest1 ex = new StringTest1();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str); //good
        System.out.println(ex.ch);  //best
    }
}
