//
//  main.cpp
//  QuickSort
//
//  Created by Daniel Alfonso on 10/11/20.
//

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <chrono>

/**
 Prints the array.
 */
void printArray (int list [], int listSize) {
    
    for (int i = 0; i < listSize; i++) {
        
        std::cout << list[i] << " ";
    }
    
    std::cout << std::endl;
}

int partition (int list[], int front, int end)
{
    int pivot = list[end];
    int i = (front - 1); // Index of smaller element
  
    for (int j = front; j <= end - 1; j++) {
        
        // If current element is smaller than the pivot
        if (list[j] < pivot) {
            
            i++;
            
            // swaps the elements
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
    }
    
    // swaps the elements
    int temp = list[i + 1];
    list[i + 1] = list[end];
    list[end] = temp;
    
    return (i + 1);
}

/**
 Sorts an array passed into function by using quick sort.
 */
void sort (int list[], int front, int end) {
    
    if (front < end) {
        
        // Puts partition index in the right place.
        int part = partition(list, front, end);
        
        // Sorts recursively through.
        sort(list, front, part - 1);
        sort(list, part + 1, end);
    }
}

int main(int argc, const char * argv[]) {
    
    // Changes the seed for random number.
    srand(static_cast<unsigned int>(time(NULL)));
    
    // Initializes random integer used later to fill array.
    int myRandInt;
    
    // Initializing array.
    int myList[10];
    int arrSize = sizeof(myList)/sizeof(myList[0]);
    
    // For loop to fill an array with random integers.
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
    
    sort(testList, 0, arrSize - 1);
    
    auto end = std::chrono::steady_clock::now();
    
    double totalTime = double(std::chrono::duration_cast <std::chrono::nanoseconds> (end - start).count());
    
    // Prints the time in seconds
    std::cout << "Time it took: " << totalTime / 1e9 << std::endl;
    
    return 0;
}
