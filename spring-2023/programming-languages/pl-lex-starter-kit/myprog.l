%%
true|false		printf("BOOLEAN\n");
;			printf("SEMICOLON\n");
[1-9][0-9]*             printf("INTEGER\n");
.			printf("Syntax Error!");
%%
