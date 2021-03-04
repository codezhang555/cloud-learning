package com.itz.cloud.juc;

/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.juc
 * @Version 1.0
 * @date 2020/12/20 21:47
 */
public class TestTransferValue {
    public void changeValue1(int age){
        age = 30;
    }

    public void changeValue2(Person person){
        person.setName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age----------"+age);

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("name------"+person.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String-----"+str);
    }
}
