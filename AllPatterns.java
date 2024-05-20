public class AllPatterns {
    public static void hollowRectangle(int rows,int cols){
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(i==1||i==rows||j==1||j==cols){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    public static void invertedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("   ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void invertedHalfPyramidNum(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
            System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void invertedHalfNumberPyramidNum(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
            System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void floydsTriangle(int n){
        int num=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+"  ");
                num++;
            }
            System.out.println();
        }
    }
    public static void zeroOneTriangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(" 1 ");
                }
                else{
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }
    public static void butterflyPattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print("   ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print("   ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void solidRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollow_Rhombus(int n){
           for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }      

    }
    public static void diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
           for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
    public static void numberPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void palindromicPattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void HollowButterfly(int n){
        for(int i=1;i<=n;i++){
            System.out.print("*");
            for(int j=1;j<=i-2;j++){
              System.out.print(" ");
            }
            if(i>1){
              System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=1;j<=i-2;j++){
              System.out.print(" ");
            }
            if(i>1){
              System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            System.out.print("*");
            for(int j=1;j<=i-2;j++){
              System.out.print(" ");
            }
            if(i>1){
              System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=1;j<=i-2;j++){
              System.out.print(" ");
            }
            if(i>1){
              System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
      hollowRectangle(5,5 );
      invertedHalfPyramid(6);
      invertedHalfPyramidNum(5);
      invertedHalfNumberPyramidNum(5);
      floydsTriangle(5);
      zeroOneTriangle(5);
      butterflyPattern(5);
      solidRhombus(5);
      hollow_Rhombus(5);
      diamond(4);
      numberPyramid(5);
      palindromicPattern(5);
    HollowButterfly(5);
    }
}
