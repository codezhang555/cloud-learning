package com.itz.cloud.test.Enum;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个、确定的、我们称此类为枚举类
 * 2.当需要定义一组常量时，建议使用枚举类
 * 3.如果枚举类中只有一个对象，可以作为单例模式的实现方式
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0时，可以使用enum关键字定义枚举类
 *
 * 三、Enum类中的常用方法
 * values()方法:返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举体。
 * valueOf(String str):可以把一 一个字符串转为对应的枚举类对象。要求字符
           串必须是枚举类对象的“名字”。如不是，会有运行时异常:illegalArgumentException.
 * toString(): 返回当前枚举类对象常量的名称。
 *
 * @author CodeZhang
 * @date 2020/5/3 15:25
 */
public class SeasonTest {
}
