package com.van.dusty.velocity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:41
 **/
public class StringUtils {
    public StringUtils() {
    }

    public static String trim(String str) {
        try {
            if (str != null) {
                str = str.trim();
            } else if (str == null) {
                str = "";
            }

            return str;
        } catch (Exception var2) {
            return "";
        }
    }

    public static boolean isEmpty(String strVal) {
        boolean bEmpty = true;
        if (null != strVal && !"".equals(strVal)) {
            bEmpty = false;
        }

        return bEmpty;
    }

    public static boolean isNotEmpty(String strVal) {
        boolean bEmpty = false;
        if (null != strVal && !"".equals(strVal)) {
            bEmpty = true;
        }

        return bEmpty;
    }

    public static boolean isBlank(String strVal) {
        return isEmpty(strVal);
    }

    public static boolean isNotBlank(String strVal) {
        return isNotEmpty(strVal);
    }

    public static int toInteger(Object objVal, int defaultValue) {
        try {
            return Integer.valueOf(objVal.toString()).intValue();
        } catch (Exception var3) {
            return defaultValue;
        }
    }

    public static double toDouble(Object objVal, double defaultValue) {
        try {
            return Double.valueOf(objVal.toString()).doubleValue();
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public static String getRequestValue(Map<?, ?> map, String Key) {
        String paramValue = null;

        try {
            String[] paramArray = (String[])((String[])map.get(Key));
            if (0 < paramArray.length) {
                paramValue = paramArray[0];
            }
        } catch (Exception var4) {
            paramValue = "";
        }

        return paramValue;
    }

    public static String toString(Object objVal) {
        return objVal != null ? objVal.toString() : "";
    }

    public static String getBlankValue(String strValue) {
        return null == strValue ? "" : strValue;
    }

    public static String shieldKeyByMid(String strValue) {
        int keeplen = 3;
        if (isEmpty(strValue)) {
            return "";
        } else {
            String keepValue = strValue;
            String replaceValue = "";
            if (keeplen > strValue.length()) {
                return strValue;
            } else {
                if (2 * keeplen >= strValue.length()) {
                    keeplen = 1;
                }

                for(int i = 0; i < keepValue.length() - 2 * keeplen && i < 6; ++i) {
                    replaceValue = replaceValue + "*";
                }

                keepValue = keepValue.substring(0, keeplen) + replaceValue + keepValue.substring(keepValue.length() - keeplen, keepValue.length());
                return keepValue;
            }
        }
    }

    public static String shieldKeyByMid(String strValue, int keeplen) {
        if (isEmpty(strValue)) {
            return "";
        } else {
            try {
                byte[] tempStrValues = strValue.getBytes("GB2312");
                String replaceValue = "";
                if (keeplen > tempStrValues.length) {
                    return strValue;
                } else {
                    if (2 * keeplen >= tempStrValues.length) {
                        keeplen = 1;
                    }

                    for(int i = 0; i < tempStrValues.length - 2 * keeplen && i < 4; ++i) {
                        replaceValue = replaceValue + "*";
                    }

                    String preKeepValue = new String(tempStrValues, 0, keeplen, "GB2312");
                    String suKeepValue = new String(tempStrValues, tempStrValues.length - keeplen, keeplen, "GB2312");
                    String keepValue = preKeepValue + replaceValue + suKeepValue;
                    return new String(keepValue);
                }
            } catch (Exception var7) {
                return strValue;
            }
        }
    }

    public static String shieldEmailKeyByMid(String strValue) {
        if (isEmpty(strValue)) {
            return "";
        } else {
            int index = strValue.lastIndexOf("@");
            String emailHead = strValue;
            String emailTail = "";
            if (index > 0) {
                emailHead = strValue.substring(0, index);
                emailTail = strValue.substring(strValue.indexOf(emailHead) + emailHead.length());
            }

            return shieldKeyByMid(2, emailHead) + emailTail;
        }
    }

    public static String shieldKeyByMid(int length, String strValue) {
        int keeplen = length;
        if (isEmpty(strValue)) {
            return "";
        } else {
            String keepValue = strValue;
            String replaceValue = "";
            if (length > strValue.length()) {
                return strValue;
            } else {
                if (2 * length >= strValue.length()) {
                    keeplen = 1;
                }

                for(int i = 0; i < keepValue.length() - 2 * keeplen && i < 6; ++i) {
                    replaceValue = replaceValue + "*";
                }

                keepValue = keepValue.substring(0, keeplen) + replaceValue + keepValue.substring(keepValue.length() - keeplen, keepValue.length());
                return keepValue;
            }
        }
    }

    public static boolean isNumber(String str) {
        if (isEmpty(str)) {
            return false;
        } else {
            try {
                Integer.parseInt(str);
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    }

    public static boolean isBuildByNumber(String number) {
        if (number != null && !number.equals("")) {
            char[] charArray = number.toCharArray();

            for(int i = 0; i < charArray.length; ++i) {
                if (!Character.isDigit(charArray[i])) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static int isNumber(String str, int defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static String replaceString(String strData, String regex, String replacement) {
        if (strData == null) {
            return null;
        } else {
            int index = strData.indexOf(regex);
            String strNew = "";
            if (index < 0) {
                return strData;
            } else {
                while(index >= 0) {
                    strNew = strNew + strData.substring(0, index) + replacement;
                    strData = strData.substring(index + regex.length());
                    index = strData.indexOf(regex);
                }

                strNew = strNew + strData;
                return strNew;
            }
        }
    }

    public static String encodeString(String strData) {
        if (strData == null) {
            return "";
        } else {
            strData = replaceString(strData, "&", "&amp;");
            strData = replaceString(strData, "<", "&lt;");
            strData = replaceString(strData, ">", "&gt;");
            strData = replaceString(strData, "'", "&apos;");
            strData = replaceString(strData, "\"", "&quot;");
            return strData;
        }
    }

    public static String decodeString(String strData) {
        if (strData == null) {
            return "";
        } else {
            strData = replaceString(strData, "&lt;", "<");
            strData = replaceString(strData, "&gt;", ">");
            strData = replaceString(strData, "&apos;", "'");
            strData = replaceString(strData, "&quot;", "\"");
            strData = replaceString(strData, "&amp;", "&");
            return strData;
        }
    }

    public static boolean isEquals(String source, String target) {
        boolean result = false;
        if (source == null) {
            if (target == null) {
                result = true;
            }
        } else if (target != null) {
            result = source.equals(target);
        }

        return result;
    }

    public static String decodeUnicode(String theString) {
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        int x = 0;

        while(true) {
            while(true) {
                while(x < len) {
                    char aChar = theString.charAt(x++);
                    if (aChar == '\\') {
                        aChar = theString.charAt(x++);
                        if (aChar == 'u') {
                            int value = 0;

                            for(int i = 0; i < 4; ++i) {
                                aChar = theString.charAt(x++);
                                switch(aChar) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        value = (value << 4) + aChar - 48;
                                        break;
                                    case ':':
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                    case '?':
                                    case '@':
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                    case '[':
                                    case '\\':
                                    case ']':
                                    case '^':
                                    case '_':
                                    case '`':
                                    default:
                                        throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        value = (value << 4) + 10 + aChar - 65;
                                        break;
                                    case 'a':
                                    case 'b':
                                    case 'c':
                                    case 'd':
                                    case 'e':
                                    case 'f':
                                        value = (value << 4) + 10 + aChar - 97;
                                }
                            }

                            outBuffer.append((char)value);
                        } else {
                            if (aChar == 't') {
                                aChar = '\t';
                            } else if (aChar == 'r') {
                                aChar = '\r';
                            } else if (aChar == 'n') {
                                aChar = '\n';
                            } else if (aChar == 'f') {
                                aChar = '\f';
                            }

                            outBuffer.append(aChar);
                        }
                    } else {
                        outBuffer.append(aChar);
                    }
                }

                return outBuffer.toString();
            }
        }
    }

    public static String md5(String pwd) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bs = digest.digest(pwd.getBytes());
            String hexString = "";
            byte[] arr$ = bs;
            int len$ = bs.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                byte b = arr$[i$];
                int temp = b & 255;
                if (temp < 16 && temp >= 0) {
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }

            return hexString;
        } catch (NoSuchAlgorithmException var9) {
            var9.printStackTrace();
            return "";
        }
    }

    public static String add(Object arg1, Object arg2) {
        return arg1 + String.valueOf(arg2);
    }
}
