#include <iostream>

void ioRun() {
    int a;
    int b;
    int c;
    std::cin >> a >> b >> c;
    std::cout << a + b + c << std::endl;
}

void dataTypesRun() {
    int i;
    long l;
    char ch;
    float fl;
    double dbl;
    scanf("%d %ld %c %f %lf", &i, &l, &ch, &fl, &dbl);
    printf("%d\n%ld\n%c\n%.3f\n%.9lf\n", i, l, ch, fl, dbl);
}

void conditionalRun() {
    long n;
    std::cin >> n;

    std::string s;
    if (1 == n) {
        s = "one";
    } else if (2 == n) {
        s = "two";
    } else if (3 == n) {
        s = "three";
    } else if (4 == n) {
        s = "four";
    } else if (5 == n) {
        s = "five";
    } else if (6 == n) {
        s = "six";
    } else if (7 == n) {
        s = "seven";
    } else if (8 == n) {
        s = "eight";
    } else if (9 == n) {
        s = "nine";
    } else {
        s = "Greater than 9";
    }
    std::cout << s << std::endl;
}