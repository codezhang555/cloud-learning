package com.itz.cloud.juc;

/**
 *
 * 何为lambda表达式
 * 1.口诀
 *     拷贝小括号，写死右箭头，落地大括号
 * 2. @FunctionalInterface
 * 3.接口里面允许方法的实现吗？   default
 *   java8之前不可以
 *   java7之前可以
 *
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/16 21:58
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        //匿名内部类
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("*********Hello********");
//            }
//        };
//        foo.sayHello();
        //lambda表达式
        Foo foo = (x,y) -> {
            return x + y;
        };
        System.out.println(foo.add(3, 5));
        System.out.println(foo.div(10, 5));
        System.out.println(Foo.mv(3, 5));
    }
}

interface  Foo{
//    public void sayHello();

    public int add(int x, int y);

    default int div(int x, int y){
        return x/y;
    }

    public static int mv(int x, int y){
        return x * y;
    }
}
