public class Main {
    public static void main(String[] args) {
        String[] strs={"latac","lampa", "lambda"};
        String result=findLongestPrefiks(strs);
        System.out.println(result);
    }

    private static String findLongestPrefiks(String[] strs) {
        String prefix=strs[0];
        for (int i=0;i<strs.length;i++){
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }

        }
        return prefix;
    }
}
