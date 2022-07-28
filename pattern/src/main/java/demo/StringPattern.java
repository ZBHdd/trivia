package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hang.jia
 */
public class StringPattern {

    public static final Pattern DATATYPE_PATTERN = Pattern.compile("^char\\(\\d+\\)$", Pattern.DOTALL);

    public static final Pattern URL_PATTERN = Pattern.compile(".*\\s\"(?<URL>.{1,10}\\s.+?)((\\?)|(\\s)).*\"(\\s).*", Pattern.DOTALL);

    public static void datatypePattern() {
        Matcher matcher = URL_PATTERN.matcher("");
        if(matcher.find()) {
            System.out.println(matcher.group("URL"));
        }
    }

    public static void main(String[] args) {
        datatypePattern();
    }
}
