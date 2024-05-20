public class SegmentTrees {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int arr[], int i, int start, int end){
        if(start == end){
            tree[i] =arr[start]; 
            return arr[start];
        }
        int mid = (start+end)/2;
        buildST(arr, 2*i+1, start, mid);
        buildST(arr, 2*i+2, mid+1, end);
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }

    public static int getSumUtil(int i,int si, int sj, int qi,int qj){
        if(qj<=si || qi>=sj){
            return 0;
        }else if(qi<=si && qj>=sj){
            return tree[i];
        }else{
            int mid = (si+sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;

        }
    }
    public static int getSum(int arr[], int qi, int qj){
        int n= arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx>sj || idx<si){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);

        }
    }
    public static void update(int arr[], int idx,int newValue){
        int n = arr.length;
        int diff = newValue- arr[idx];
        arr[idx] = newValue;
        updateUtil(0, 0, n-1, idx, diff);

    }

    public static void buildmaxST(int i, int si, int sj, int arr[]){
        if(si==sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (sj+si)/2;
        buildmaxST(2*i+1, si, mid, arr);
        buildmaxST(2*i+2, mid+1, sj, arr);
        tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
    }

    public static int queryMax(int arr[], int qi,int qj){
        int n = arr.length;
        return queryMaxUtil(0, 0, n-1, qi, qj);
    }
    public static int queryMaxUtil(int i, int si, int sj,int qi, int qj){
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE;
        }else if(si>=qi && sj<=qj){
            return tree[i];
        }else{
            int mid =(sj+si)/2;
            int leftAns = queryMaxUtil(2*i+1, si, mid, qi, qj);
            int rightAns = queryMaxUtil(2*i+2, mid+1 , sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void updating(int arr[], int idx,int newValue){
        arr[idx] = newValue;
        int n = arr.length;
        updateUtil(0,0, n-1, idx, newValue);

    }
    public static void updatingUtil(int i, int si, int sj, int idx, int newValue){
       if(idx <si || sj <idx){
        return ;
       }
       if(si==sj){
        tree[i] = newValue;
       }
       if(si!= sj){
        tree[i] = Math.max(tree[i], newValue);
       int mid = (sj+si)/2;
       updatingUtil(2*i+1, si, mid, idx, newValue);
       updatingUtil(2*i+2,mid+1, sj, idx, newValue);
       }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        //int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        // System.out.println(getSum(arr, 2, 5));
        // update(arr, 2, 2);
        // System.out.println(getSum(arr, 2, 5));
        //buildmaxST(0, 0, n-1, arr);

        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }

        int max = queryMax(arr, 2, 5);
        System.out.println(max);
        updating(arr, 2, 100);
        max = queryMax(arr, 2, 5);
        System.out.println(max);
    }
}
