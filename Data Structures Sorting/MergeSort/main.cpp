//
//  main.cpp
//  MergeSort
//
//  Created by Daniel Alfonso on 10/10/20.
//

#include <iostream>
#include <ctime>
#include <cstdlib>

/**
 Prints the array.
 */
void printArray (int list [], int listSize) {
    
    for (int i = 0; i < listSize; i++) {
        
        std::cout << list[i] << " ";
    }
    
    std::cout << std::endl;
}

/**
 Method to be called later in sort function for merge sort.
 Merges to arrays together.
 */
void merge(int list[], int left, int middle, int right) {
    
    int leftSize = middle - left + 1;
    int rightSize = right - middle;
  
    // Arrays to hold the split.
    int leftArray[leftSize];
    int rightArray[rightSize];
  
    // Copying the contents into the left and right array.
    for(int i = 0; i < leftSize; i++) {
        
        leftArray[i] = list[left + i];
    }
    for(int j = 0; j < leftSize; j++) {
        
        rightArray[j] = list[middle + 1 + j];
    }
    
    // Indices for merging the arrays.
    int i = 0;
    int j = 0;
    int k = left;
      
    while (i < leftSize && j < rightSize)
    {
        if (leftArray[i] <= rightArray[j])
        {
            list[k] = leftArray[i];
            i++;
        }
        else
        {
            list[k] = rightArray[j];
            j++;
        }
        k++;
    }
  
    // Anything left put to the end of list[]
    while (i < leftSize)
    {
        list[k] = leftArray[i];
        i++;
        k++;
    }
  
    while (j < rightSize)
    {
        list[k] = rightArray[j];
        j++;
        k++;
    }
}
  
/**
 Sorting algorithm using the merge funciton.
 */
void sort(int list[], int left, int right)
{
    if (left < right)
    {
          
        // Gets the middle index depending on index.
        int middle = left + (right - left) / 2;
  
        // Sorts the two havles recursively.
        sort(list, left, middle);
        sort(list, middle + 1, right);
  
        // Brings the sorted lists together.
        merge(list, left, middle, right);
    }
}


int main(int argc, const char * argv[]) {
    
    // Changes the seed for random number.
    srand(static_cast<unsigned int>(time(NULL)));
    
    // Initializes random integer used later to fill array.
    int myRandInt;
    
    // Initializing array
    int myList[10];
    int arrSize = sizeof(myList) / sizeof(myList[0]);
    
    // For loop to fill an array with random integers
    for (int i = 0; i < arrSize; i++) {
        
        myRandInt = rand() % 100;
        myList[i] = myRandInt;
    }
    
    // To show that function does work.
    printArray(myList, arrSize);
    sort(myList, 0, arrSize - 1);
    printArray(myList, arrSize);
    
    
    // *****PROGRAM ASSIGNMENT START HERE*****
    
    
    int testList[1000000];
    arrSize = sizeof(testList)/sizeof(testList[0]);
    
    // For loop to fill an array with random integers
    for (int i = 0; i < arrSize; i++) {
        
        myRandInt = rand() % 1000001;
        testList[i] = myRandInt;
    }
    
    auto start = std::chrono::steady_clock::now();
    
    sort(testList, 0, arrSize);
    
    auto end = std::chrono::steady_clock::now();
    
    double totalTime = double(std::chrono::duration_cast <std::chrono::nanoseconds> (end - start).count());
    
    // Prints the time in seconds
    std::cout << "Time it took: " << totalTime / 1e9 << std::endl;
    
    return 0;
}
