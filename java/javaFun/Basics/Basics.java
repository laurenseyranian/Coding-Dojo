import java.util.ArrayList;
import java.util.Arrays;

public class Basics{
    public void print1To255(){
        for(int num = 1 ; num < 256; num++) {
            System.out.println(num);
        }
    }
    public void printOdd1To255(){
        for(int num = 1 ; num < 256; num++) {
            if(num % 2 == 0){
            System.out.println(num);
            }
        }
    }
    public void printSum(){
        int sum = 0;
        for(int num = 0 ;  num < 256; num++) {
            sum = sum + num;
            System.out.println("New number: " + num + ", Sum: " + sum);
        }
    }
    public void findMax(int[] arr){
        int max = arr[0];
        for(int i = 0 ; i < arr.length; i++) {
            if (arr[0] < max){
                max = arr[i];
            }
        } 
        System.out.println(max);
    }
    public void getAvg(int[] arr){
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++) {
            sum = sum + arr[i];
        } 
        int avg = sum/arr.length;
        System.out.println(avg);
    }
    public ArrayList <Integer> arrayWithOddNums(){
        ArrayList <Integer> y = new ArrayList <Integer>();
        for(int i = 1 ; i < 256 ; i++){
            if(i % 2 == 0){
                continue;
            }else{
            y.add(i);
            }
        }
        return(y);
    }
    public void greaterThanY(int[] arr, int y){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]>y){
                count++;
            }
        }
        System.out.println(count);
    }
    public ArrayList <Integer> squareValues(int[] arr){
        ArrayList <Integer> x = new ArrayList <Integer>();
        for(int i = 0 ; i < arr.length ; i++){
            x.add(arr[i]*arr[i]);
        }
        return(x);
    }
    public int[] eliminateNegatives(int[] x){
        for(int i = 0 ; i < x.length;i++){
            if(x[i] < 0){
                x[i] = 0;
            }
        }
        return x;
    }
    public ArrayList <Object> maxMinAvg(int[] x){
        int minnum = x[0];
        int maxnum = x[0];
        double sum = 0;
        ArrayList <Object> new_arr = new ArrayList <Object>();
        for(int i = 0 ; i < x.length; i++){
            if(minnum > x[i]){
                minnum = x[i];
            }
            if(maxnum < x[i]){
                maxnum = x[i];
            }
            sum += x[i];
        }
        double avg = sum/x.length;
        new_arr.add(minnum);
        new_arr.add(maxnum);
        new_arr.add(avg);
        return(new_arr);
    }
    public int [] shiftValues(int[] x){
        for(int i = 0 ; i < x.length-1; i++){
            x[i] = x[i+1];
        }
        x[x.length-1] = 0;
        return x;
    }
}