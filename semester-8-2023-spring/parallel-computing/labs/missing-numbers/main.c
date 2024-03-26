#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <inttypes.h> // Include for PRIu64

// #define MAX_NUM 100000000
#define MAX_NUM 99999999
#define BYTE_SIZE 8
#define BIT_VECTOR_SIZE (MAX_NUM / BYTE_SIZE)

void setBit(uint8_t *bitVector, uint64_t number) {
    bitVector[number / BYTE_SIZE] |= 1 << (number % BYTE_SIZE);
}

int checkBit(uint8_t *bitVector, uint64_t number) {
    return bitVector[number / BYTE_SIZE] & (1 << (number % BYTE_SIZE));
}

int main() {
    FILE *file;
    uint64_t number;
    uint8_t *bitVector = (uint8_t *)calloc(BIT_VECTOR_SIZE, sizeof(uint8_t));
    if (!bitVector) {
        perror("Memory allocation failed");
        return EXIT_FAILURE;
    }

    // Open the binary file
    file = fopen("random_numbers.bin", "rb");
    if (file == NULL) {
        perror("Error opening file");
        free(bitVector);
        return EXIT_FAILURE;
    }

    while (fread(&number, sizeof(number), 1, file) == 1) {
        if (number > 0 && number <= MAX_NUM) { 
            setBit(bitVector, number - 1); 
        } else {
            printf("Encountered unexpected number: %" PRIu64 "\n", number);
        }
    }
    fclose(file);

    /*
    */
    // Find all missing numbers
    int foundMissing = 0;
    printf("Missing numbers: \n");
    for (uint64_t i = 0; i < MAX_NUM; ++i) {
        if (!checkBit(bitVector, i)) {
            printf("%" PRIu64 "\n", i + 1); 
            foundMissing = 1;
        }
    }

    if (!foundMissing) {
        printf("No missing numbers.\n");
    }

    free(bitVector);
    
    return EXIT_SUCCESS;
}
