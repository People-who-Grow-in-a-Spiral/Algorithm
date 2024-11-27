## 시간 복잡도
- 최악의 경우, n만큼 순회 + 최대 j-i크기 정렬 -> $O(n^2)$
- 순회하는 n의 최대값은 50, j-i의 최대값은 100이므로 시간은 충분하다.

## 문제 접근법

1. commands 배열을 순회한다.  
2. 배열의 인덱스대로 i, j, k를 정의한다.
3. array배열의 i-1번째 인덱스부터 j-1번째 인덱스까지 슬라이싱을 한 후 정렬한다.
4. 정렬한 배열의 k-1번째 인덱스를 정답 배열에 추가한다.


## 코드

```python
# Programmers
# Lv.1 - K번째수

def solution(array, commands):
    ans = []
    
    for command in commands:
        i, j, k = command
        ans.append(sorted(array[i - 1:j])[k - 1])
    
    return ans
```