import java.io.*;
import java.util.StringTokenizer;
public class A {
    static long inv=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,0,(n-1));
        StringBuilder narr=new StringBuilder();
        for(int i=0;i<n;i++){
            narr.append(arr[i]).append(" ");
        }
        pw.println(inv);
        pw.println(narr);
        pw.flush();
    }

    static int[] mergeSort(int[] arr, int l, int r){
        if(l>=r) return arr;
        int mid=l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
        return arr;
    }

    static void merge(int[] arr, int l, int mid, int r){
        int[] temp=new int[r-l+1];
        int i=l, j=mid+1, k=0;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]) temp[k++]=arr[i++];
            else{ 
                temp[k++]=arr[j++]; 
                inv+=mid-i+1; 
            }
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];
        for(i=0;i<k;i++) arr[l+i]=temp[i];
    }
}