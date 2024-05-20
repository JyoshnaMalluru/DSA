public class Strings {
    public static boolean validPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void getShortestPath(String str){
     int x=0; int y=0;
     for(int i=0;i<str.length();i++){
        char dir = str.charAt(i);
        //north
        if(dir=='N'){
            y++;
        }else if(dir=='S'){
            y--;
        }else if(dir=='E'){
            x++;
        }else{
            x--;
        }
        
     }
        int x2 =x*x;
        int y2 =y*y;
        System.out.println((float)Math.sqrt(x2+y2));
    }
    public static String compressed(String str){
        String newStr ="";
        for(int i=0;i<str.length();i++){
          Integer count =1;
          while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
            count++;
            i++;
          }
          newStr+=str.charAt(i);
          if(count>1){
            newStr+=count.toString();
          }
        }
    return newStr;
    }
public static void main(String args[]){
    //String str = "racecar";
    //System.out.println(validPalindrome(str));
    //String str = "WNEENESENNN";
    //getShortestPath(str);
    String str = "aabbccccddd";
    System.out.println(compressed(str));
}
}
