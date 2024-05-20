public class DivideAndConquer {
    public static void printArray(int /*String*/ arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //PIVOT AND PARTITION
    public static void quickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //last element
        int pIdx = partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);//left
        quickSort(arr, pIdx+1, ei);//right
    }
    public static int partition(int arr[],int si,int ei){
        int pIdx= arr[ei];
        int i= si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pIdx){
                i++;
                //swap
                int temp = arr[j];
                arr[j]= arr[i];
                arr[i]=temp;
            }
        }
        i++;
                
                int temp = pIdx;
                arr[ei]= arr[i];
                arr[i]=temp;
                return i;
    }
    //DIVIDE AND CONQUER
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //work
        int mid = si+(ei-si)/2;//(si+ei)/2;
        mergeSort(arr, si, mid);//left part
        mergeSort(arr, mid+1, ei);//right part
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
       int temp[] = new int[ei-si+1];

       int i=si;//iteratot for left part
       int j= mid+1;//iteratot for right part
       int k =0;//iterator for temp;
       while(i<=mid && j<=ei){
       if(arr[i]<arr[j]){
          temp[k]=arr[i];
          i++;
       }else{
        temp[k]=arr[j];
        j++;
       }
       k++;
    }
    //left part
    while(i<=mid){
        temp[k++]=arr[i++];
    }
    //right par
    while(j<=ei){
        temp[k++]=arr[j++];
    }
    for(k=0,i=si;k<temp.length;k++,i++){
        arr[i]= temp[k];
    }
}
//ASSIGNMENT PROBLEMS
//1 QUESTION
public static boolean smaller(String a,String b){
    for(int i=0;i<Math.min(a.length(),b.length());i++){
        if(a.charAt(i)<b.charAt(i)){
            return true;
        }else{
            return false;
        }
    }
    if(a.length()<b.length()){
        return true;
    }else{
        return false;
    }
}
public static void mergeInOrder(String arr[],int si,int mid,int ei){
    String temp[] = new String[ei-si+1];

       int i=si;//iteratot for left part
       int j= mid+1;//iteratot for right part
       int k =0;//iterator for temp;
       while(i<=mid && j<=ei){
       if(smaller(arr[i],arr[j])==true){
          temp[k]=arr[i];
          i++;
       }else{
        temp[k]=arr[j];
        j++;
       }
       k++;
    }

    //left part
    while(i<=mid){
        temp[k++]=arr[i++];
    }
    //right par
    while(j<=ei){
        temp[k++]=arr[j++];
    }
    for(k=0,i=si;k<temp.length;k++,i++){
        arr[i]= temp[k];
    }
}
public static void wordsInSort(String arr[],int si,int ei){
    if(si>=ei){
            return ;
        }
        //work
        int mid = si+(ei-si)/2;//(si+ei)/2;
        wordsInSort(arr, si, mid);//left part
        wordsInSort(arr, mid+1, ei);//right part
        mergeInOrder(arr,si,mid,ei);
    }
    //DIVIDE AND CONQUER ASSIGNMENT PROBLEMS
    //2ND PROBLEM
    public static int getCount(int arr[],int left,int right,int target){
        int count=0;
       for(int idx=left;idx<=right;idx++){
        if(arr[idx]==target){
            count++;
        }
       }
       return count;
    }
    public static int mostRepeatedNum(int arr[],int left,int right){
        //base case
        if(left==right){
            return arr[left];
        }
        //divide
        int mid = left+(right-left)/2;
        int part1 = mostRepeatedNum(arr, left, mid);
        int part2 = mostRepeatedNum(arr, mid+1, right);
        int countA = getCount(arr,left,mid,part1);
        int countB = getCount(arr,mid+1,right,part2);
        if(countA>countB){
            return part1;
        }else{
            return part2;
        }
    }
    

    //3rd Assignment Problem
    public static int mergeSort1(int arr[],int si,int ei){
        if(si>=ei){
            return 0;
        }
        //work
        int ans=0;
        int mid = si+(ei-si)/2;//(si+ei)/2;
        ans += mergeSort1(arr, si, mid);//left part
        ans += mergeSort1(arr, mid+1, ei);//right part
        ans +=merge1(arr,si,mid,ei);
        return ans;
    }
    public static int merge1(int arr[],int si,int mid,int ei){
       int temp[] = new int[ei-si+1];
       int pairs=0;
       int i=si;//iteratot for left part
       int j= mid+1;//iteratot for right part
       int k =0;//iterator for temp;
       while(i<=mid && j<=ei){
       if(arr[i]<=arr[j]){
          temp[k]=arr[i];
          i++;k++;
       }else{
        pairs+=(mid-i+1);
        temp[k]=arr[j];
        j++;k++;
       }
    }
    //left part
    while(i<=mid){
        temp[k++]=arr[i++];
    }
    //right par
    while(j<=ei){
        temp[k++]=arr[j++];
    }
    for(i=si;i<=ei;i++){
        arr[i]= temp[i-si];
    }
    return pairs;
}
    public static void main(String args[]){
        int arr[] ={6,3,9,5,4,8,1};
        //TimeComplexity O(nLOGn) space complexity O(n)
        //mergeSort(arr,0,arr.length-1);
        //TimeComplexity O(nLOGn) space complexity O(1)
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
        //String arr[] = {"sun","earth","mars","pluto","mercury"};
        //String arr[] ={"p","s","q","c","a","b"};
        // wordsInSort(arr, 0, arr.length-1);
        // printArray(arr);
        // int arr[] = {1,2,3,3,3,5,5,4,6,6,7};
        // System.out.println(mostRepeatedNum(arr, 0, arr.length-1));
        // int arr[]={2,6,4,1,3,5};
        // System.out.println(mergeSort1(arr,0,arr.length-1));

    }
}
