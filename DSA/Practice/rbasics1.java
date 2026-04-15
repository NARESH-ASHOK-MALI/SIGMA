public class rbasics1 {

    public static void main(String[] args) {
         int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
         int key =2;
         occurence(arr,key,0);
    }
    public static void occurence(int arr[],int key,int idx){
        if(idx==arr.length){
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        idx++;
        occurence(arr,key,idx);
    }
}
