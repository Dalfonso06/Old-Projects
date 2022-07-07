#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "mylist.h"

struct node_t {

	char* str;
	struct node_t* prev;
	struct node_t* next;
} *head, *tail;

void insert(char* str) {

	struct node_t* nextNode = (struct node_t*)malloc(sizeof(struct node_t));
	nextNode -> str = (char*)malloc((strlen(str) + 1) * sizeof(char));
	strcpy(nextNode -> str,str);
	nextNode -> next = NULL;

	// If the list is empty
	if (head == NULL) {

		head = nextNode;
		tail = nextNode;
		head -> prev = NULL;
		return;
	}

	// If nextNode is less than (in a string)
	if (strcmp(nextNode -> str, head -> str) < 0) {

		nextNode -> prev = NULL;
		head -> prev = nextNode;
		nextNode -> next = head;
		head = nextNode;
		return;
	}

	// If nextNode is greater than (in a string)
	if (strcmp(nextNode -> str, head -> str) > 0) {

		nextNode -> prev = tail;
		tail -> next = nextNode;
		tail = nextNode;
		return;
	}

	struct node_t *temp = head -> next;

	while(strcmp(temp -> str, nextNode -> str) < 0) {

		temp = temp -> next;
	}

	(temp -> prev) -> next = nextNode;
	nextNode -> prev = temp -> prev;
	temp -> prev = nextNode;
	nextNode -> next = temp;
	
}

void delete (char* str) {

	struct node_t *temp = head;

	// If the list is empty
	if (head == NULL) {

		printf("List is empty... Element: \n");
		return;
	}

	while (strcmp(temp -> str, str) != 0) {

		// If the node doesn't exist
		if(temp == NULL) {

			printf("Cannot find node.\n");
			return;
		}

		temp = temp -> next;
	}

	// If there's one element in the list.
	if (temp == head && head == tail) {

		head = NULL;
		tail = NULL;
		printf("Empty list.\n");
		return;
	}

	if (temp == head) {

		head = temp -> next;
		printf("Head of node deleted.\n");
		return;
	}

	if (temp -> next != NULL) {

		temp -> next -> prev = temp -> prev;
	}
	if (temp -> prev != NULL) {

		temp -> prev -> next = temp -> next;
	}
}

void list (int backwards) {

	int numOfNode = 0;

	if (backwards == 0) {

		struct node_t *temp = (struct node_t*)malloc(sizeof(struct node_t));

		// If list is empty.
		if (head == NULL) {

			printf("Empty list.\n");

		} else {

			temp = head;

			while (temp != NULL) {

				printf("Contents of node %d = %s\n", numOfNode, temp -> str);
				numOfNode++;

				temp = temp -> next;
			}
		}

	} else {

		struct node_t *temp = (struct node_t*)malloc(sizeof(struct node_t));

		if (tail == NULL) {

			printf("Empty list.\n");

		} else {

			temp = tail;

			while (temp != NULL) {

				printf("Inside of node -%d = %s\n", numOfNode, temp->str);
				numOfNode++;

				temp = temp -> prev;
			}
		}
	}
}






















