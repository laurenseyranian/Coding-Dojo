import java.util.ArrayList;
import java.util.Arrays;

public class BasicsTest{
    public static void main(String[] args){
        Basics iD = new Basics();
        //iD.print1To255();
        //iD.printOdd1To255();
        //iD.printSum();
        // int [] new_arr = {1,3,5,7,9,13};
        // iD.iterateThroughArray(new_arr);
        // int [] new_arr = {2,10,3};
        // // iD.findMax(new_arr);
        // iD.getAverage(new_arr);
        // ArrayList <Integer> list = iD.arrayWithOddNums();
        // System.out.println(list);
        // int [] arr = {1,3,5,7};
        // int y = 3;
        // iD.greaterThanY(arr, y);
        // int[] arr= {1,5,10,-2};
        // ArrayList <Integer> x = iD.squareValues(arr);
        // System.out.println(x);
        int[] arr = {5,7,7};
        // System.out.println(Arrays.toString(iD.eliminateNegatives(arr)));
        // System.out.println(iD.maxMinAvg(arr));
        System.out.println(Arrays.toString(iD.shiftValues(arr)));
    }
}