package com.anonymtbj.tools.mathboxview;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anonym on 2018/2/28.
 */

public class MathRandom {

    @Nullable
    public static int[] repeat(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        int [] result = new int[quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<quantity; i++){
            int number = (int) (Math.random() * (max - min + 1) + min);
            result[i] = number;
        }

        if(sort){ Arrays.sort(result); }

        return result;
    }

    @Nullable
    public static String repeat_string(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        Integer [] result = new Integer[quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<quantity; i++){
            int number = (int) (Math.random() * (max - min + 1) + min);
            result[i] = number;
        }

        if(sort){ Arrays.sort(result); }

        String string = "";
        for(int i=0; i<result.length; i++){
            string += result[i];
            if(i+1<result.length){ string += ","; }
        }

        return string;
    }

    @Nullable
    public static ArrayList repeat_arraylist(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        Integer [] result = new Integer[quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<quantity; i++){
            int number = (int) (Math.random() * (max - min + 1) + min);
            result[i] = number;
        }

        if(sort){ Arrays.sort(result); }

        ArrayList arrayList = new ArrayList(Arrays.asList(result));

        return arrayList;
    }

    @Nullable
    public static int[] notrepeat(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        int new_quantity = quantity;
        if(min<0 && max<0){
            if(quantity > (Math.abs(min) - Math.abs(max)) + 1){
                new_quantity = (Math.abs(min) - Math.abs(max)) + 1;
            }
        }else{
            if(quantity > (Math.abs(min) + Math.abs(max) + 1)){
                new_quantity = (Math.abs(min) + Math.abs(max) + 1);
            }
        }

        int[] result = new int[new_quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<new_quantity; i++){
            result[i] = (int) (Math.random() * (max - min + 1) + min);
            for(int j=0; j<i; j++){
                if(result[i] == result[j]){
                    i--;
                    break;
                }
            }
        }

        if(sort){ Arrays.sort(result); }

        return result;
    }

    @Nullable
    public static String notrepeat_string(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        int new_quantity = quantity;
        if(min<0 && max<0){
            if(quantity > (Math.abs(min) - Math.abs(max)) + 1){
                new_quantity = (Math.abs(min) - Math.abs(max)) + 1;
            }
        }else{
            if(quantity > (Math.abs(min) + Math.abs(max) + 1)){
                new_quantity = (Math.abs(min) + Math.abs(max) + 1);
            }
        }

        Integer[] result = new Integer[new_quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<new_quantity; i++){
            result[i] = (int) (Math.random() * (max - min + 1) + min);
            for(int j=0; j<i; j++){
                if(result[i] == result[j]){
                    i--;
                    break;
                }
            }
        }

        if(sort){ Arrays.sort(result); }

        String string ="";
        for(int i=0; i<result.length; i++){
            string += result[i];
            if(i+1<result.length){ string += ","; }
        }

        return string;
    }

    @Nullable
    public static ArrayList notrepeat_arraylist(int min, int max, int quantity, boolean sort){

        if(quantity <= 0 || max < min){return null;}

        int new_quantity = quantity;
        if(min<0 && max<0){
            if(quantity > (Math.abs(min) - Math.abs(max)) + 1){
                new_quantity = (Math.abs(min) - Math.abs(max)) + 1;
            }
        }else{
            if(quantity > (Math.abs(min) + Math.abs(max) + 1)){
                new_quantity = (Math.abs(min) + Math.abs(max) + 1);
            }
        }

        Integer[] result = new Integer[new_quantity];
        if(min<0){ min--; }
        if(max<0){ max--; }
        for(int i=0; i<new_quantity; i++){
            result[i] = (int) (Math.random() * (max - min + 1) + min);
            for(int j=0; j<i; j++){
                if(result[i] == result[j]){
                    i--;
                    break;
                }
            }
        }

        if(sort){ Arrays.sort(result); }

        ArrayList arrayList = new ArrayList(Arrays.asList(result));

        return arrayList;
    }

}
