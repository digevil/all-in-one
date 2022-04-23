package org.digevil.test.idea.shortcut.cmd_p;

/**
 * @author t.d.huang
 * @date 2022/4/23
 * @apiNote
 */
public class TestCommandP {

    public static void main(String[] args) {
        // cmd + p 可以查看一个方法的入参类型和名字，顺序
        // 使用方法: 在下句括号范围内按 cmd + p
        overloadMethod(1);
    }

    public static void overloadMethod(int var1) {
    }

    public static void overloadMethod(int var1, int var2) {
    }

    public static void overloadMethod(int var1, int var2, String var3) {
    }


}
