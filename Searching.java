public class Searching {
    public static int linearSearch(int num[], int key){
        for(int i=0;i<num.length;i++){
            if(num[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int searchItem(String menu[], String item){
        for(int i=0;i<menu.length;i++){
            if(menu[i]==item){
                return i;
            }

        }
        return -1;
    }
    public static int binarySearch(int num[],int key){
        int start = 0;
        int end = num.length-1;
        while(start<=end){
            int mid =(start+end)/2;
            if(num[mid]==key){
                return mid;
            }
            if(num[mid]>key){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void reverseArray(int num[]){
        int start =0;
        int end = num.length-1;
    
        while(start<end){
            int temp = num[start];
          num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        int num[]= {2,4,5,6,8,10,13,15,16,19};
        int key = 10;
       int idxNum = binarySearch(num, key);
       // int index = linearSearch(num, key);
        if(idxNum==-1){
           System.out.println("NOT FOUND");
        }else{
        //System.out.println("key is at index "+ index);
        System.out.println("key is at index "+idxNum);
        }
       /*  reverseArray(num);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();*/
    // String menu[] ={"idly","vada","dosa","poori","pongal","upma","bonda"};
    // String item = "dosa";
    // int idx= searchItem(menu, item);
    // System.out.println(idx);
    }
}
