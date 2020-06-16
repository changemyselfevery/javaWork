package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/13 13:04
 * @version: 1.0
 * @modified By:
 */
public class Utils {
    //产生随机数,产生随机数，产生min到max-1的随机数
    //min:0 max:2 ,产生随机数0(不砍) 1（砍）
    private static int min=0;
    private static int max=2;
    public static int randomMonsterChop(){
        return (int)(Math.random()*(max-min)+min);
    }
}
