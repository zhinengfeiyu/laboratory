package com.example.mylaboratory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ShineMo-177 on 2016/1/11.
 */
public class JavaMain {
    public static void main(String[] args) {
        String patternStr = "//d{3}";
        String str = "123";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            System.out.println("匹配成功！");
        else
            System.out.println("抱歉，匹配失败");
    }
}
