//
//  main.cpp
//  HeapSort
//
//  Created by Daniel Alfonso on 10/11/20.
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
 Function to create a new heap.
 */
void heapify(int list[], int n, int i) {
    
    int largest = i; // Initialize largest as root
    int left = (2 * i) + 1;
    int right = (2 * i) + 2;
  
    // If left child is larger than root
    if (left < n && list[left] > list[largest])
        largest = left;
  
    // If right child is larger than largest so far
    if (right < n && list[right] > list[largest])
        largest = right;
  
    // If largest is not root
    if (largest != i) {
        // swaps elements in array
        int temp = list[i];
        list[i] = list[largest];
        list[largest] = temp;
  
        
        heapify(list, n, largest);
    }
}

/**
 Sorts an array passed into function by using heap sort.
 */
void sort (int list[], int listSize) {
    
    // Rearranges the array (heapify).
    for (int i = listSize / 2 - 1; i >= 0; i--)
        heapify(list, listSize, i);
      
    // Taking an element from the heap.
    for (int i = listSize - 1; i > 0; i--) {
        
        // Swap elements
        int temp = list[0];
        list[0] = list[i];
        list[i] = temp;
        
        // heapify to the reduced tree.
        heapify(list, i, 0);
    }
}

int main(int argc, const char * argv[]) {
    
    // Changes the seed for random number.
    srand(static_cast<unsigned int>(time(NULL)));
    
    // Initializes random integer used later to fill array.
    int myRandInt;
    
    // Initializing array
    int myList[10];
    int arrSize = sizeof(myList)/sizeof(myList[0]);
    
    // For loop to fill an array with random integers
    for (int i = 0; i < arrSize; i++) {
        
        myRandInt = rand() % 100;
        myList[i] = myRandInt;
    }
    
    // To show that function does work.
    printArray(myList, arrSize);
    sort(myList, arrSize);
    printArray(myList, arrSize);
    
    
    // *****PROGRAM ASSIGNMENT START HERE*****
    
    
    int testList[10000];
    arrSize = sizeof(testList)/sizeof(testList[0]);
    
    // For loop to fill an array with random integers
    for (int i = 0; i < arrSize; i++) {
        
        myRandInt = rand() % 1000001;
        testList[i] = myRandInt;
    }
    
    auto start = std::chrono::steady_clock::now();
    
    sort(testList, arrSize);
    
    auto end = std::chrono::steady_clock::now();
    
    double totalTime = double(std::chrono::duration_cast <std::chrono::nanoseconds> (end - start).count());
    
    // Prints the time in seconds
    std::cout << "Time it took: " << totalTime / 1e9 << std::endl;
    
    return 0;
}

