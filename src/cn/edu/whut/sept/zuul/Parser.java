package cn.edu.whut.sept.zuul;

import java.util.Scanner;

import java.util.Scanner;

/**
 * 设计解析器，解析用户输入.
 */
public class Parser {

    private CommandWords commands;
    private Scanner reader;

    /**
     * 创建解析器.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * 读取并解析用户输入,根据第一个单词是否有效选择创建Command对象.
     * @return 若指令有前部返回Command(word1, word2)，否则返回Command(null, word2).
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        //获得用户输入单词，最多两个，忽略其他
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();       //get the first word entered
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();   //get the second word entered
                tokenizer.close();
            }
        }

        if (commands.isCommand(word1)) {
            //if there is word1, we creat Command(word1,word2)
            return new Command(word1, word2);
        } else {
            //if there is no word1, we creat Command(null,word2)
            return new Command(null, word2);
        }
    }

    /**
     * 向用户显示所有有效指令.
     */
    public void showCommands() {
        commands.showAll();
    }
}
