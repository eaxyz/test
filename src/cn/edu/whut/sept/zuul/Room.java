package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

/**
 * 设置房间.
 */
public class Room {

    private String description;
    private HashMap<String, Room> exits;

    /**
     * 创建一个描述为description的无出口房间.
     * @param description 系统定义的房间描述.
     * “description”有点像一个“厨房”或“露天庭院”.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 设置房间的出口.
     * @param direction 房间出口的方向.
     * @param neighbor 房间出口方向对应房间.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
        switch (direction) {
            case "east":neighbor.exits.put("west", this); break;
            case "west":neighbor.exits.put("east", this); break;
            case "north":neighbor.exits.put("south", this); break;
            case "south":neighbor.exits.put("north", this); break;
            default: break;
        }
    }

    /**
     *@return 返回房间简单描述description.
     */
    public String getShortDescription() {
        return description;
    }

    /**
     *@return 返回房间详细描述：你在_description_ 出口方向：__.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     *@return 返回房间出口方向.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * @param direction 出口方向
     *@return 返回出口方向对应的房间
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}


