import java.util.*;

public class PractiseQuesArrays {

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct
    public static boolean TwiceTrue(int nums[]){
    for(int i =0; i<nums.length; i++){
        for(int j=i+1; j<nums.length; j++){
            if(nums[i] == nums[j]){
                return true;
            }
        }
    }
    return false;
}

//Search Target in rotated sorted array 
public static void SearchinRotatedSortedarr(int arr[], int target){
}
//Pivot element 
public int minsearch(int arr[]){

    int left = 0; 
    int right = arr.length-1;
    
    while(left<right){
        int mid = left + (right - left)/2;

        if( arr[mid] > 0 && arr[mid-1] > arr[mid]){
            return mid;
        } else if(arr[mid] >= arr[left] && arr[mid] > arr[right]){
            left = mid+1;
        } else{
            right = mid-1;
        }
    }
    return left;
}
//Search for the target value 
public void search(int arr[], int target){
    int indexofmin = minsearch(arr);

    
    if(target >arr[indexofmin] && target< arr[arr.length-1]){
        BinarySearch(arr , indexofmin, arr.length-1, target);// This lead to search in right sorted part of arr
    }else{
        BinarySearch(arr, 0, indexofmin,target);// This lead to search in left sorted part of arr
    }
}
//Binary Search 
public int BinarySearch(int arr[], int left, int right, int target){

    while(left <= right){
    int mid = left +(right-left)/2;
    if(arr[mid] == target){
        return mid;
    }else if( target >arr[mid]){
        left = mid+1;
    }else{
        right = mid-1;
    }
  }
  return -1;
}


//Maximum Profit 
public static int MaxPro(int price[]){
    int buyprice = Integer.MAX_VALUE;
    int maxprofit = 0;

    for(int i = 0; i<price.length; i++){
        if(buyprice < price[i]){
            int profit = price[i] - buyprice;
            maxprofit = Math.max(maxprofit, profit);
        } 
        else if(buyprice> price[i]){
            buyprice = price[i];
        }
    }
    return maxprofit;
}
//Trapped Water
public static int TrappedWater(int height[]){
    int n = height.length;
    //LeftMax
    int leftmax[] = new int[n];
    leftmax[0] = height[0];
    for(int i = 1; i<n; i++){
        leftmax[i] = Math.max(height[i], leftmax[i-1]);
    }

    //RightMax
    int rightmax[] = new int[n];
    rightmax[n-1] = height[n-1];
    for(int i =n-2; i>=0 ;i--){
        rightmax[i] = Math.max(height[i], rightmax[i+1]);
    }

    int trappedwater= 0;

    //Water Level
    for(int i =0; i<n; i++){
        int waterlevel = Math.min(leftmax[i], rightmax[i]);
        trappedwater += waterlevel- height[i];
    }
    return trappedwater;
}

    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //Ques1
        int nums[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(TwiceTrue(nums));

        //Ques2
        int arr[] = {4,5,6,7,0,1,2};
        int target = 1;
        SearchinRotatedSortedarr(arr,target);

        //Ques3
        int prices[] = {7, 6, 4,  3, 1};
        System.out.println(MaxPro(prices));

        //Ques4
        int height[] = {4, 2, 0, 3, 2, 5};
        System.out.println(TrappedWater(height));
        
    } 
}

