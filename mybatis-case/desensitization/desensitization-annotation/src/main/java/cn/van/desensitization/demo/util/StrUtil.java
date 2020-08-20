package cn.van.desensitization.demo.util;

public class StrUtil {
    public static final String EMPTY = "";

    /**
     * 截取字符串的指定长度的字符
     * @param str
     * @param len
     * @return
     */
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    /**
     * 替换字符串
     * @param str
     * @return
     */
    public static String rightPad(String str) {

        String lastName =  str.substring(1, str.length()-1);
        lastName =  lastName.replace(lastName, "*");
        return lastName;
    }
}
