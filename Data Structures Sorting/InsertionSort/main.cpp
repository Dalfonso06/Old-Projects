//
//  main.cpp
//  InsertionSort
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
 Sorts an array passed into function by using insertion sort.
 */
void sort (int list [], int listSize) {
    
    // For every item on the array.
    for (int i = 1; i < listSize; i++) {
                
        int counter = 0;
                
        // Check every item before item[i].
        for (int u = (i - 1); u >= 0; u--) {
                    
            // Check if that item is greater than item at index i.
            if (list[u] > list[i]) {
                        
                // If so add to the counter.
                counter++;
            } else {
                        
                break;
            }
        }
                
        int temp = list[i]; // Hold the item at index i.
                
        // Shifts all items up until where list[i] belongs.
        for (int u = i; u > (i - counter); u--) {
                    
            list[u] = list[u - 1];
        }
                
        list[i - counter] = temp; // Adds that item to it's proper location.
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
    
    
    int testList[800000];
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
