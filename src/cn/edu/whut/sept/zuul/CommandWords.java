package cn.edu.whut.sept.zuul;

/**
 * 设置所有有效游戏.
 */
public class CommandWords {
    private static final String[] VALIDCOMMANDS = {
            "go", "quit", "help"
    };

    /**
     * 判断指令是否是有效指令.
     * @param aString 用户输入的命令前部，由解析器产生.
     * @return 如果是有效指令返回true,否则返回false.
     */
    public boolean isCommand(String aString) {
        for (int i = 0; i < VALIDCOMMANDS.length; i++) {
            if (VALIDCOMMANDS[i].equals(aString)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 输出所有有效指令.
     */
    public void showAll() {
        for (String command : VALIDCOMMANDS) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}