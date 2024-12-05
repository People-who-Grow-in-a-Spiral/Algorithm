## 시간 복잡도
 - CCW 공식을 이용하여 $O(1)$의 시간 복잡도가 발생합니다.

## 문제 접근법
 - CCW(Counter-clockwise)는 편명상의 3개의 점과 관련된 점들의 위치 관계를 판단하는 알고리즘 입니다.
 - 벡터의 외적을 이용하며 세 점 A(X1, Y1), B(X2, Y2), C(X3, Y3)가 존재할 때 공식은 다음과 같습니다.

> $CCW = (X1Y2 + X2Y3 + X3Y1) - (X2Y1 + X3Y2 + X1Y3)$

## 코드

```cpp
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <stack>
#include <deque>
#include <queue>
#include <string>
#include <climits>
#include <map>
#include <unordered_map>
#include <set>
#include <unordered_set>

using namespace std;

using int32 = long;
using int64 = long long;

static vector<int> v;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int x1, y1, x2, y2, x3, y3;
    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

    int ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

    if (ccw > 0)
        ccw = 1;
    else if (ccw < 0)
        ccw = -1;

    cout << ccw;

    return 0;
}


```