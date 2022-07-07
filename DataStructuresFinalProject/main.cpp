//
//  main.cpp
//  FinalProject
//
//  Created by Daniel Alfonso on 11/25/20.
//

#include <iostream>
#include <fstream>
#include <vector>
#include "danielalfonso_graph.h"

int main(int argc, const char * argv[]) {
    
    stack<int> moves;
    queue<int> queueMoves;
    
    /*
    queue<int> test1;
    queue<int> test2;
    
    for (int i = 0; i < 10; i++) {
        test1.push(i);
    }
    
    std::cout << "test1.size(): " << test1.size() << std::endl;
    
    while(!test1.empty()) {
        std::cout << "test1.front(): " << test1.front() << std::endl;
        test1.pop();
    }
    
    std::cout << "test1.size(): " << test1.size() << std::endl;
    */
    
    
    // File for the class to read
    std::ifstream fin ("map2.txt", std::ifstream::in);
    
    graph myGraph;
    map myMap(fin);
    myMap.mapToGraph(myGraph);
    myMap.findPathRecursive(myGraph, moves);
    myMap.printPath(moves);
    myMap.findPathNonRecursive2(myGraph, queueMoves);
    myMap.findPathNonRecursive1(myGraph, moves);
    myMap.printPath(moves);
    myMap.findShortestPath1(myGraph, moves);
    // myMap.printPath(moves);
    myMap.print(myGraph, moves);
    
    // char **grid = create2DArray(20, 20);
    
    // printGrid(grid, 20, 20);
    
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
