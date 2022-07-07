#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void removeItem (char *arg[]) {

	int i = 1;

	// while it's not the last item.
	while (arg[i+1] != NULL) {
		arg[i] = arg[i+1];
		i++;;
	}
	arg[i] = NULL;
}

int main (int argc, char *argv[]) {

	char *args[] = {"./EXEC", NULL};
	char *newArgv[argc + 1];

	for (int i = 0; i < argc + 1; i++) {

		if (i != argc) {
			newArgv[i] = argv[i];
		} else {
			newArgv[i] = NULL;
		}
	}

	/* To print what is being held in the array
	for(int i = 0; i < argc; i++) {
		printf("argv = %s\n", argv[i]);
	}
	for(int i = 0; i < argc + 1; i++) {
		printf("newArgv = %s\n", newArgv[i]);
	} */

	// If there are no arguments
	if (argc < 2) {
		printf("Please write and argument.\n");

	// If there's only one command
	} else if (argc == 2) { 
		execlp(argv[1], newArgv[1], (char*)NULL);

	// If it's greater than 2
	} else {
		char* childCommand = newArgv[1];
		removeItem(newArgv);

		/* Print what was in the array
		for(int i = 0; i < argc; i++) {
		printf("newArgv = %s\n", newArgv[i]);
		} */

		int fd[2];
		pipe(fd);
		
		pid_t pid;
		pid = fork();

		// Child running
		if (pid == 0) { //Child
			dup2(fd[1], 1);
			close(fd[0]);
			close(fd[1]);
			execlp(childCommand, childCommand, (char*)NULL);
			perror("exec Child failed");
			exit(-1);

		// Parent running
		}  else {
			dup2(fd[0], 0);
			close(fd[0]);
			close(fd[1]);
			execvp(newArgv[0], newArgv);
			perror("exec Parent failed");
			exit(-1);
		}
	}
}


