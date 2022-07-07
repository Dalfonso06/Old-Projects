//
//  main.cpp
//  BubbleSort
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
 Sorts an array passed into function by using bubble sort.
 */
void sort (int list [], int listSize) {
    
    if (listSize > 2) {
        
        for (int i = 0; i < (listSize - 1); i++){
            
            if (list[i] > list[i + 1]) {
                
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
            }
        }
        
        sort(list, listSize - 1);
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
    
    
    int testList[400000];
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
