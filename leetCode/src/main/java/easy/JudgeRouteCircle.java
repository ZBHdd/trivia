package easy;

/**
 * @ClassName JudgeRouteCircle
 * @Description 最初，机器人位于(0, 0)处。 给定一系列动作，判断该机器人的移动轨迹是否是一个环，
 * 这意味着它最终会回到原来的位置。移动的顺序由字符串表示。 每个动作都由一个字符表示。
 * 有效的机器人移动是R（右），L（左），U（上）和D（下）。 输出应该为true或false，表示机器人是否回到原点。
 * @Author Satan
 **/
public class JudgeRouteCircle {
    private static Boolean dealRoute(String route){
        int rStep = 0;
        int uStep = 0;
        char[] chars = route.toCharArray();
        for (char aChar : chars) {
            switch (String.valueOf(aChar)){
                case "R":
                    rStep ++;break;
                case "L":
                    rStep --;break;
                case "U":
                    uStep ++;break;
                case "D":
                    uStep --;break;
                default:break;
            }
        }
        return rStep == 0 && uStep == 0;
    }


    public static void main(String[] args){
        System.out.println(dealRoute("UD"));
    }
}
