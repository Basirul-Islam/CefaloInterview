#include<iostream>
#include<regex>

using namespace std;

//char symbol[]={'I', 'V', 'X', 'L', 'C', 'D', 'M'};
int asciiValue[] = {73, 86, 88, 76, 67, 68, 77};
int temp[] = {1, 5, 10, 50, 100, 500, 1000};
int number[256];
int result = 0;

bool checkValidity(string str) {
    if (regex_match(str, regex("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))) {
        return true;
    } else return false;
}

void assignValue(string str) {
    for (int i = 0; i < 7; i++) {
        number[asciiValue[i]] = temp[i];
    }
}

int romanToNumber(string str) {

    if (str.size() == 0) return 0;

    assignValue(str);

    for (int i = 0; i < str.size(); i++) {
        //cout << "Hi: " << number[str[i]] << endl;
        result += number[str[i]];
    }

    //cout << "result: " << result << endl;
    for (int i = 1; i < str.size(); i++) {
        if ((str[i] == 'V' || str[i] == 'X') && str[i - 1] == 'I') {
            //cout << "dhukse" << endl;
            result -= 1 + 1;
        }

        if ((str[i] == 'L' || str[i] == 'C') && str[i - 1] == 'X') {
            //cout << "dhukse" << endl;
            result -= 10 + 10;
        }

        if ((str[i] == 'D' || str[i] == 'M') && str[i - 1] == 'C') {
            //cout << "dhukse" << endl;
            result -= 100 + 100;
        }
    }

    return result;

}

int main(void) {

    string str;
    cin >> str;

    if (checkValidity(str)) {
        cout << romanToNumber(str) << endl;
    } else {
        cout << -1 << endl;
    }

    return 0;
}


