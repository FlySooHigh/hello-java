package HomeTask1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    int bound = 100_000;

    @Test
    public void testBubble() {

        int[] ia = new int[bound];
        fillArray(ia);
        int[] arrToTest = new int[bound];
        System.arraycopy(ia, 0, arrToTest, 0, bound);

        Arrays.sort(ia);
        bubbleSort(arrToTest);

        Assert.assertArrayEquals(ia, arrToTest);
    }

    @Test
    public void testInsertion() {

        int[] ia = new int[bound];
        fillArray(ia);
        int[] arrToTest = new int[bound];
        System.arraycopy(ia, 0, arrToTest, 0, bound);

        Arrays.sort(ia);
        insertionSort(arrToTest);	

        Assert.assertArrayEquals(ia, arrToTest);
    }
    
    @Test
    public void testSelection() {

        int[] ia = new int[bound];
        fillArray(ia);
        int[] arrToTest = new int[bound];
        System.arraycopy(ia, 0, arrToTest, 0, bound);

        Arrays.sort(ia);
        selectionSort(arrToTest);

        Assert.assertArrayEquals(ia, arrToTest);
    }
    
    private void fillArray(int[] ia) {
        Random rnd = new Random();
        for (int idx = 0; idx < ia.length; idx++) {
            ia[idx] = rnd.nextInt(bound);
        }
    }
    
    private int[] bubbleSort(int[] arrToSort)			// O(n^2) 
    {
    	int sortedElements = 0;
    	while (sortedElements < arrToSort.length)
    	{
    		for (int i = 0; i < arrToSort.length - 1 - sortedElements; i++)
    		{
    			if (arrToSort[i] > arrToSort[i + 1]) 
    			{
    				swap(arrToSort, i, i + 1);
    			}
    		}	
    		sortedElements++;
    	}
    	return arrToSort;
    }
    
    private int[] insertionSort(int[] arrToSort)		// O(n^2) 
    {
    	boolean foundItsPlace = false;	// flag that we use in order not to use break in inner cycle, when we find proper place 
    									// for element insertion
    	int sortedElements = 1;
    	for (int i = 1; i < arrToSort.length; i++)
    	{
    		foundItsPlace = false;
    		for (int j = i - sortedElements; j < sortedElements && !foundItsPlace; j++)
    		{
    			if(arrToSort[i] < arrToSort[j])
    			{
    				int temp = arrToSort[i];
    				System.arraycopy(arrToSort, j, arrToSort, j + 1, i - j);
    				arrToSort[j] = temp;
    				foundItsPlace = true;
    			}
    		}
    		sortedElements++;
    	}
    	return arrToSort;
    }
    
    private int[] selectionSort(int[] arrToSort)		// O(n^2) 
    {
    	int sortedElements = 0;							// to keep score of sorted elements 
    	int minElementIndex = 0;						
    	while (sortedElements < arrToSort.length - 1)
    	{
    		minElementIndex = sortedElements;								// in the beginning of new cycle we reassign index of min 
    																		// element to the first unsorted element  
    		for (int i = sortedElements + 1; i < arrToSort.length; i++)
    		{
    			if (arrToSort[i] < arrToSort[minElementIndex]) {minElementIndex = i;}
    		}
    		if (minElementIndex != sortedElements)							// if min element index has changed, then we swap it  
    																		// with the first unsorted element
    		{
    			swap(arrToSort, sortedElements, minElementIndex);
    		}
    		sortedElements++;
    	}
    	return arrToSort;
    }
    
	private void swap(int[] arrToSort, int i, int j) {
		int temp = arrToSort[i];
		arrToSort[i] = arrToSort[j];
		arrToSort[j] = temp;
	}
}
