public class StringsAssignment {
    public static void subString(String str,int si,int ei){
        String substr = "";
        for(int i=si;i<ei;i++){
            substr +=str.charAt(i);
        }
        System.out.println(substr);
    }
    public static void main(String args[]){
        //String str = "HelloWorld";
        //System.out.println(str.substring(0,5));
       //subString(str, 0, 5);
       String fruits[]={"apple","mango","banana","pomegranate"};
       //timecomplexity O(x*N)  x=no. of letters in largest string   N=no.of strings
       String largest = fruits[0];
       for(int i=1;i<fruits.length;i++){
        if(largest.compareTo(fruits[i])<0){
           largest=fruits[i];
        }
       }
       System.out.println(largest);
    }
    
}
