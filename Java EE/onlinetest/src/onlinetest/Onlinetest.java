/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinetest;

import java.util.ArrayList;

/**
 *
 * @author Danny
 */
public class Onlinetest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1 }, 12);
        if (indices == null)
        {
            System.out.println("null");
        }
        else
        {
                for (int i = 0; i < indices.length; i+=2)
                {
                    System.out.println(indices[i] + " " + indices[i+1]);
                }
        }
    }
    
    public static int[] findTwoSum(int[] list, int sum) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < list.length - 1; i++)
        {
            for (int j = i +1; j < list.length; j++)
            {
                if (i != list.length && list[i] + list[j] == sum){
                    results.add(i);
                    results.add(j);
                    results.add(j);
                    results.add(i);
                }
            }
        }
        if (results.isEmpty())
        {
            return null;
        }
        else
        {
                int s = results.size();
                int[] resultsArray = new int[s];
                for (int i = 0; i < s; i++) {
                    resultsArray[i] = results.get(i);
                }
            return resultsArray;
        }

    }

}
