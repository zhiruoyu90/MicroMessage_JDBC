package com.imooc.bean;

/**
 * Created by Administrator on 2016-03-08.
 */
public class Message {

//    主键id
    public int id;
//    命令
    public String command;
//    描述
    public String description;
//    回复内容
    public String content;

    public void setId(int id) {
        this.id = id;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {

        return description;
    }

}
