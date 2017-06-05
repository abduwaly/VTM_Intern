/**
 * Created by admin on 2017/5/19.
 */
public class toolsTest {

    public static void main(String[] args) {
        String s = "YK.txt";
        String s1 = "huige";

        System.out.println(s.substring(s.lastIndexOf(".")+1));

        if(s1.split(".").length>1){
            System.out.println(s1.substring(s1.lastIndexOf(".")+1));
        }


    }
}
