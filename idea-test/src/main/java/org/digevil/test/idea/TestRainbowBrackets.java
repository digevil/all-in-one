package org.digevil.test.idea;

/**
 * rainbowBrackets 插件测试：
 * 使用 cmd + 鼠标右键 点击 某个括号范围域：彩色背景色高亮（高亮颜色和括号颜色一致）
 * 使用 alt(Option) + 鼠标右键 点击 某个括号范围域：专注模式（括号范围外区域置灰）
 * @author t.d.huang
 * @date 2022/4/23
 * @apiNote
 */
public class TestRainbowBrackets {

    private static void test(int var1, int var2, String var3, boolean var4) {
        if (var4) {
            if (var1 == 1) {
                if (var2 == 10) {
                    if (var3.equals("hello")) {
                        System.out.println("hello * 10");
                    }
                } else {
                    System.out.println("goodbye * 10");
                }
            } else if (var1 == 2) {
                if (var3.equals("hello")) {
                    System.out.println("hello * 2");
                }
            } else if (var1 == 3) {

            } else {

            }
        }
    }
}
