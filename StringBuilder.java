public class StringBuilder {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder ("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' '&& i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        //TIME COMPLEXITY O(26)
        String sb = new String("");
        for(char ch ='A';ch<='Z';ch++){
            sb+=ch;
        }
        System.out.println(sb);
        System.out.println(sb.length());
        /*String str = "hi, i am jyoshna";
        System.out.println(toUpperCase(str));*/
        
    }
}
