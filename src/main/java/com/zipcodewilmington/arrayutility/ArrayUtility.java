package com.zipcodewilmington.arrayutility;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] array){
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        ArrayList<T> newList = new ArrayList<>();
        newList.addAll(Arrays.asList(array));
        newList.addAll(Arrays.asList(arrayToMerge));
        return Collections.frequency(newList, valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        ArrayList<T> newList = new ArrayList<>();
        T mostCommon = null;
        Integer count = Integer.MIN_VALUE;
        newList.addAll(Arrays.asList(array));
        newList.addAll(Arrays.asList(arrayToMerge));
        for (T t : newList){
            Integer currentVal = Collections.frequency(newList, t);
            if (currentVal > count){
                mostCommon = t;
                count = currentVal;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        ArrayList<T> newList = new ArrayList<>();
        newList.addAll((Arrays.asList(array)));
        return Collections.frequency(newList, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove){
        int numOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] newArr = Arrays.copyOf(array, array.length - numOccurrences);
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length; i++){
            if (array[i] != valueToRemove){
                newArr[j] = array[i];
                j++;
            }
        }
        return newArr;
    }


}
