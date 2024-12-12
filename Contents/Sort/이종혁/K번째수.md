## 시간 복잡도
 - C++의 sort 함수를 이용하면 $O(nlogn)$의 시간 복잡도가 발생합니다.
 - 배열의 최대 길이가 100이므로 시간 복잡도는 충분합니다.

## 문제 접근법
 - 배열의 $i$번째 부터 $j$번째 까지 정렬을 수행합니다.
 - 정렬된 구간의 $k$번째 수는 배열의 첫 번째로부터 $i+k$ 번째에 있습니다.


## 코드

```cpp
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(vector<int> c : commands)
    {
        vector<int> v(array);
        int start=c[0]-1;
        int end=c[1];
        int k=c[2]-1;
        
        sort(v.begin()+start, v.begin()+end);
        answer.push_back(v[start+k]);
    }
    
    
    return answer;
}
```