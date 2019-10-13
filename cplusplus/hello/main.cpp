#include <iostream>

#include "../io/io.h"

int printHello() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}

int main() {
    return ioRun();
}