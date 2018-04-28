package easy;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        long begin =System.currentTimeMillis();
        String copy = new String(s);
        int i = 1;
        String sub = copy.substring(0, i);
        while (sub.length() <= s.length()/2) {
            if (copy.indexOf(sub) == 0) {
                System.out.println("index::"+String.valueOf(System.currentTimeMillis() - begin));
                //相等则该子字符串可以整分字符串s
                if (!copy.equals(sub)) {
                    copy = copy.substring(i);
                } else {
                    System.out.println(System.currentTimeMillis() - begin);
                    //相等则该子字符串为自身，不符合条件
                    return !sub.equals(s);
                }
            } else {
                //子字符串长度加一，初始化子字符串
                i++;
                copy = new String(s);
                sub = copy.substring(0, i);
            }
        }
        return false;
    }

    /**
     * S = s + s
     * S[1,-1] 去掉首尾，得到S2
     * 如果S2中包含s则s是由重复子字符串组合而成
     */
    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).substring(1, (s.length() * 2 - 1)).contains(s);
    }

}
