//
//  map.hpp
//  FinalProject
//
//  Created by Daniel Alfonso on 11/27/20.
//

#ifndef danielalfonso_graph//.h
#define danielalfonso_graph//.h

#include <stdio.h>
#include <queue>
#include <vector>
#include "d_matrix.h"
#include "d_except.h"

#define LARGE 10000

// Attempt at making an adjacency matrix that holds linked lists for any nodes next to eachother.
struct graph {
    
    struct node {
        node(int i, int j);
        int x;
        int y;
    };
    
    struct edge {
        node node1;
        node node2;
    };
    
    int numVertices;
    vector<node> nodes;
    matrix<int> adjMatrix;
    matrix<int> map;
    matrix<bool> visited;
    void fillAdjMatrix();
    void resetVisited();
    void printNodes();
    int minDistance(stack<int> moves);
    
};

// Fills in the adjacency matrix
void graph::fillAdjMatrix() {
    
    for (int i = 0; i < nodes.size(); i++) {
        for (int j = 0; j < nodes.size(); j++) {
            
            if ((nodes[i].x == (nodes[j].x - 1) || (nodes[i].x == (nodes[j].x + 1))) && nodes[i].y == nodes[j].y) {
                adjMatrix[i][j] = 1;
            } else if ((nodes[i].y == (nodes[j].y - 1) || (nodes[i].y == (nodes[j].y + 1))) && nodes[i].x == nodes[j].x) {
                adjMatrix[i][j] = 1;
            } else {
                adjMatrix[i][j] = 0;
            }
        }
    }
}

void graph::printNodes() {// DELETE LATER
    
    for (int i = 0; i < nodes.size(); i++) {
        cout << nodes[i].x << " " << nodes[i].y << endl;
    }
}

// Resets all the visited path to all false.
void graph::resetVisited() {
    for (int i = 0; i < visited.rows(); i++) {
        for (int j = 0; j < visited.cols(); j++) {
            visited[i][j] = false;
        }
    }
}

// Constructor for node struct
graph::node::node(int i, int j) {
    x = i;
    y = j;
}

// Class provided
class map
{
public:
    map(ifstream &fin);//                                       DONE
    void print(graph &g, stack<int> &moves);//
    bool isLegal(int i, int j);//                               DONE
    void setMap(int i, int j, int n);
    int getMap(int i, int j) const;
    int getReverseMapI(int n) const;//                          DONE
    int getReverseMapJ(int n) const;//                          DONE
    void mapToGraph(graph &g);//                                DONE
    bool findPathRecursive(graph &g, stack<int> &moves);//      DONE
    bool findPathNonRecursive1(graph &g, stack<int> &moves);//  DONE
    bool findPathNonRecursive2(graph &g, queue<int> &moves);//  DONE
    bool findShortestPath1(graph &g, stack<int> &bestMoves);//  DONE
    bool findShortestPath2(graph &g, vector<int> &bestMoves);
    void printPath(stack<int> &s);//                            DONE
    int numRows(){return rows;};//                              DONE
    int numCols(){return cols;};//                              DONE
private:
    int rows; // number of latitudes/rows in the map            FILLED
    int cols; // number of longitudes/columns in the map        FILLED
    matrix<bool> value;//                                       FILLED
    matrix<int> mapping; // Mapping from latitude and longitude co-ordinates (i,j) values to node index values
    vector<int> reverseMapI; // Mapping from node index values to map latitude i value
    vector<int> reverseMapJ; // Mapping from node index values to map longitude j value
};

// Constructor
map::map(ifstream &fin) {
    
    // To read and fill in row and col values.
    char c = fin.get();
    std::string temp;
    
    /* Used to grab the rows and columns to later resize the matrix */
    do {
        temp += c;
        c = fin.get();
    } while (c != '\n');
    
    rows = std::stoi(temp);
    temp = "";
    
    do {
        temp += c;
        c = fin.get();
    } while (c != '\n');
    
    cols = std::stoi(temp);
    c = fin.get(); // Get the next value for the next while loop.
    
    // Set the size of the matrix
    value.resize(rows, cols);
    
    // Fills in the values matrix.
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < (cols + 1); j++) { // cols + 1 takes into account '\n'
            if (c == 'O') {
                value[i][j] = true; // If there is a viable path set to true
                c = fin.get();
            } else {
                c = fin.get(); // The rest of the array is set to false, no need to re-declare.
            }
        }
    }
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (value[i][j]) {
                cout << "O ";
            } else {
                cout << "X ";
            }
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}

// Returns whether a position on the map is valid.
bool map::isLegal(int i, int j) {
    
    return value[i][j];
}

// Gets value from reverseMapI at index n
int map::getReverseMapI(int n) const {
    
    return reverseMapI[n];
}

// Gets value from reverseMapJ at index n
int map::getReverseMapJ(int n) const {
    
    return reverseMapJ[n];
}

void map::mapToGraph(graph &g) {
    
    g.map.resize(rows, cols);
    g.visited.resize(rows, cols);
    int numNodes = 0;
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            
            // Fills in map.
            if (isLegal(i, j)) {
                g.map[i][j] = 1;
            } else {
                g.map[i][j] = 0;
            }
            
            if (isLegal(i, j)) {
                g.nodes.push_back(graph::node(i,j));
                numNodes++;
            }
        }
    }
    g.adjMatrix.resize(numNodes, numNodes); // Creates the adjacency matrix.
    g.numVertices = numNodes;
    g.fillAdjMatrix();
}

// Finds path to the end recursively using dft
bool map::findPathRecursive(graph &g, stack<int> &moves) {
    
    int x = 0;
    int y = 0;
    stack<int> m;
    
    if (moves.empty()) {
        g.resetVisited();
        g.visited[y][x] = true;
    }
    
    while (!moves.empty()) {
        m.push(moves.top());
        moves.pop();
    }
    
    while (!m.empty()) {
        moves.push(m.top());
        switch (m.top()) {
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
            case 4:
                y++;
                break;
        }
        g.visited[y][x] = true;
        m.pop();
    }
    
    if (x == (cols - 1) && y == (rows - 1)) {
        
        return true;
    }
    
    if ((x + 1) < cols && g.map[y][x + 1] && !g.visited[y][x + 1]) { // RIGHT
        moves.push(1);
    } else if ((y + 1) < rows && g.map[y + 1][x] && !g.visited[y + 1][x]) { // DOWN
        moves.push(4);
    } else if (y > 0 && g.map[y - 1][x] && !g.visited[y - 1][x]) { // UP
        moves.push(2);
    } else if (x > 0 && g.map[y][x - 1] && !g.visited[y][x - 1]) { // LEFT
        moves.push(3);
    } else {
        moves.pop();
    }
    
    findPathRecursive(g, moves);
    
    return true;
}

bool map::findPathNonRecursive1(graph &g, stack<int> &moves) {
    
    int x = 0;
    int y = 0;
    g.resetVisited(); // Reset all the visited positions to false.
    g.visited[y][x] = true;
    
    // While the end hasn't been reached
    while (x != (cols - 1) || y != (rows - 1)) {
        
        if ((x + 1) < cols && g.map[y][x + 1] && !g.visited[y][x + 1]) { // RIGHT
            moves.push(1);
            x++;
        } else if ((y + 1) < rows && g.map[y + 1][x] && !g.visited[y + 1][x]) { // DOWN
            moves.push(4);
            y++;
        } else if (y > 0 && g.map[y - 1][x] && !g.visited[y - 1][x]) { // UP
            moves.push(2);
            y--;
        } else if (x > 0 && g.map[y][x - 1] && !g.visited[y][x - 1]) { // LEFT
            moves.push(3);
            x--;
        } else {
            switch (moves.top()) { // Backtracking
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x++;
                    break;
                case 4:
                    y--;
                    break;
            }
            moves.pop();
        }
        
        g.visited[y][x] = true;
    }
    return true;
}

bool map::findPathNonRecursive2(graph &g, queue<int> &moves) {
    
    int x = 0;
    int y = 0;
    g.resetVisited();
    g.visited[y][x] = true;
    queue<int> path;
    
    for (int k = 0; k < path.size(); k++) {
        
    }
    
    while (x != (cols - 1) || y != (rows - 1)) {
        
        if ((x + 1) < cols && g.map[y][x + 1] && !g.visited[y][x + 1]) { // RIGHT
            moves.push(1);
            x++;
        } else if ((y + 1) < rows && g.map[y + 1][x] && !g.visited[y + 1][x]) { // DOWN
            moves.push(4);
            y++;
        } else if (y > 0 && g.map[y - 1][x] && !g.visited[y - 1][x]) { // UP
            moves.push(2);
            y--;
        } else if (x > 0 && g.map[y][x - 1] && !g.visited[y][x - 1]) { // LEFT
            moves.push(3);
            x--;
        } else {
            
            while (!moves.empty()) {
                path.push(moves.front());
                moves.pop();
            }
            while (!path.empty()) {
                if (path.size() == 1) {
                    switch (path.front()) { // Backtracking
                        case 1:
                            x--;
                            break;
                        case 2:
                            y++;
                            break;
                        case 3:
                            x++;
                            break;
                        case 4:
                            y--;
                            break;
                    }
                    path.pop();
                } else {
                    moves.push(path.front());
                    path.pop();
                }
            }
        }
        g.visited[y][x] = true;
    }
    
    // Prints the path using a queue
    while (!moves.empty()) {
        switch (moves.front()) {
            case 1:
                std::cout << "right, ";
                break;
            case 2:
                std::cout << "up, ";
                break;
            case 3:
                std::cout << "left, ";
                break;
            case 4:
                std::cout << "down, ";
                break;
        }
        moves.pop();
    }
    std::cout << std::endl;
    
    return true;
}

bool map::findShortestPath1(graph &g, stack<int> &bestMoves) {
    
    int cost[g.numVertices][g.numVertices];
    int distance[g.numVertices];
    int pred[g.numVertices];
    int visited[g.numVertices];
    int count;
    int minDistance;
    int nextNode = 0;
    stack<int> moves;
    
    for (int i = 0; i < g.numVertices; i++) {
        for (int j = 0; j < g.numVertices; j++) {
            if (g.adjMatrix[i][j] == 0) {
                cost[i][j] = LARGE;
            } else {
                cost[i][j] = g.adjMatrix[i][j];
            }
        }
    }
    for (int i = 0; i < g.numVertices; i++) {
        distance[i] = cost[0][i];
        pred[i] = 0;
        visited[i] = 0;
    }
    distance[0] = 0;
    visited[0] = 1;
    count = 1;
    while(count < g.numVertices - 1) {
        minDistance = LARGE;
        for (int i = 0; i < g.numVertices; i++) {
            if (distance[i] < minDistance && !visited[i]) {
                minDistance = distance[i];
                nextNode = i;
            }
        }
        visited[nextNode] = 1;
        for (int i = 0; i < g.numVertices; i++) {
            if (!visited[i]) {
                if (minDistance + cost[nextNode][i] < distance[i]) {
                    distance[i] = minDistance + cost[nextNode][i];
                    pred[i] = nextNode;
                }
            }
        }
        count++;
    }
    
    int j = g.numVertices - 1;
    
    // Adds the last move to moves
    if (g.nodes[j].y == g.nodes[j - 1].y + 1 && g.nodes[j].x == g.nodes[j - 1].x) {
        moves.push(1);
    } else if (g.nodes[j].y == g.nodes[j - 1].y && g.nodes[j].x == (g.nodes[j - 1].x + 1)) {
        moves.push(4);
    }
    
    do {
        
        j = pred[j];
        
        if (g.nodes[j].y > g.nodes[pred[j]].y) { // moved to the right.
            moves.push(1);
        } else if (g.nodes[j].y < g.nodes[pred[j]].y) { // moved to the left.
            moves.push(3);
        } else if (g.nodes[j].x > g.nodes[pred[j]].x) { // moved down.
            moves.push(4);
        } else if (g.nodes[j].x < g.nodes[pred[j]].x) { // moved up.
            moves.push(2);
        }
        
    } while (j != 0);
    
    while (!moves.empty()) {
        bestMoves.push(moves.top());
        moves.pop();
    }
    
    return true;
}

void map::print(graph &g, stack<int> &moves) {
    
    int x = 0;
    int y = 0;
    stack<int> newMoves;
    
    while (!moves.empty()) {
        newMoves.push(moves.top());
        moves.pop();
    }
    
    while (!newMoves.empty()) {
        g.map[y][x] = 2; // 2 means traversed
        switch (newMoves.top()) {
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
                break;
            case 4:
                y++;
                break;
        }
        newMoves.pop();
    }
    g.map[y][x] = 2;
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (g.map[i][j] == 2) {
                cout << "+ ";
            } else if (g.map[i][j] == 1) {
                cout << "O ";
            } else {
                cout << "X ";
            }
        }
        cout << endl;
    }
}

void map::printPath(stack<int> &moves) {
    
    stack<int> path;
    while (!moves.empty()) {
        path.push(moves.top());
        moves.pop();
    }
    // Prints out the elements of the array.
    while (!path.empty()) {
        switch (path.top()) {
            case 1:
                std::cout << "right, ";
                break;
            case 2:
                std::cout << "up, ";
                break;
            case 3:
                std::cout << "left, ";
                break;
            case 4:
                std::cout << "down, ";
                break;
        }
        path.pop();
    }
    std::cout << std::endl;
}

#endif /* danielalfonso_graph.h */
