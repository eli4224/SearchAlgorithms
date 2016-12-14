/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchalgorithms;

import static java.lang.Integer.MAX_VALUE;
import java.util.Arrays;

/**
 *
 * @author elicowa
 */
public class SearchAlgorithms {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test = {1, 3, 0, -5, 6, 100};
        System.out.println(Arrays.toString(mergeSort(test)));
        // TODO code application logic here
    }
    public static int[] bubbleSort(int[] tosort) {
        for (int i = 1; i < tosort.length; i++) {
            for (int j = i; j > 0 && tosort[j] < tosort[j - 1]; j--) {
                tosort[j] ^= tosort[j - 1];
                tosort[j - 1] ^= tosort[j];
                tosort[j] ^= tosort[j - 1];
            }
        }
        return tosort;
    }
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] arr1 = new int[arr.length / 2];
        int[] arr2 = new int[arr.length / 2 + arr.length % 2];
        int i = 0;
        while (i < arr1.length) {
            arr1[i] = arr[i++];
        }
        while (i < arr.length) {
            arr2[i - arr1.length] = arr[i++];
        }
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        int ind1 = 0, ind2 = 0;
        while (ind1 < arr1.length && ind2 < arr2.length) {
            if (arr1[ind1] > arr2[ind2]) {
                arr[ind1 + ind2] = arr2[ind2++];
            } else {
                arr[ind1 + ind2] = arr1[ind1++];
            }
        }
        while (ind1 < arr1.length) {
            arr[ind1 + ind2] = arr1[ind1++];
        }
        while (ind2 < arr2.length) {
            arr[ind1 + ind2] = arr2[ind2++];
        }
        return arr;
    }
    public static int[] sort(int[] tosort) {
        int onhold = MAX_VALUE;
        int tosortsize = tosort.length;
        int forloc = 0;
        int onholdloc = 1;
        if (tosort.length == 1 || tosort.length == 0) {
            return tosort;
        }
        //int[] temp = new int[tosort.length];
        for (int k = 0; k < tosortsize - 1; k++) {
            for (int i = forloc; i < tosort.length - 1; i++) {
                if (tosort[i] < onhold) {
                    onhold = tosort[i];
                    onholdloc = i;
                }
            }
            tosort[onholdloc] = tosort[k];
            tosort[k] = onhold;
            onholdloc = 0;
            onhold = MAX_VALUE;
            forloc++;
        }
        return tosort;
    }
}
