package cn.edu.whut.sept.zuul;

public class Command {

    private String commandWord;  //转化得到的指令前部
    private String secondWord;   //转化得到的指令后部

    /**
     * 将用户输入的单词转化为指令
     * @param firstWord 由Parser分离出来的用户输入的第一个单词.
     * @param secondWord 由Parser分离出来的用户输入的第二个单词.
     */
    public Command(String firstWord, String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * @return 返回指令前部.
     */
    public String getCommandWord() {
        return commandWord;
    }

    /**
     * @return 返回指令后部.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * 判断指令前部是否为空
     * @return 若指令前部为空返回true,否则返回false
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }

    /**
     * 判断指令后部是否不为空
     * @return 若指令后部不为空返回true,否则返回false
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
