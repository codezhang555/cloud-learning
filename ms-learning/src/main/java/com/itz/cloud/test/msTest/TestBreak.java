package com.itz.cloud.test.msTest;

/**
 * 测试跳出多重嵌套循环
 * @PackageName: com.itz.cloud.test.exer
 * @ClassName: TestBreak
 * @Author: codeZhang
 * @DateTime: 2021/2/26 9:43
 * @Version 1.0
 */
public class TestBreak {
  public static void main(String[] args) {
    out:
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j == 5){
          break out;
        }
        System.out.println("j = "  + j);
      }
    }
  }
}
