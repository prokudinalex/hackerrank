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