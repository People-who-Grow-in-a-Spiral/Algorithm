## 시간 복잡도
- 파일 입력 -> $O(n + m)$
- 파일 갯수 확인 -> $O(n + m)$
- 쿼리 실행 -> $O(q)$
- 쿼리마다 파일 갯수를 확인한다.
- 최종 시간 복잡도 -> $O(q + (n + m))$

## 문제 접근법
- 딕셔너리에 `{폴더명: [(하위 폴더 or 파일, 폴더 및 파일 구분)]}`과 같이 입력받는다.
- 쿼리를 받으면, `/`로 경로를 나누어 가장 마지막 폴더를 탐색한다.
- 현재 폴더를 탐색하면서, deque에 현재 폴더를 삽입하고 딕셔너리에서 현재 폴더를 key로 하는 value 배열을 탐색한다.
- 배열에서 폴더가 존재하는 경우, deque에 추가하고, 파일이 존재하는 경우 갯수를 세어준다.
- deque은 폴더가 나오는 경우 해당 폴더의 하위 파일까지 탐색하기 때문에 모든 파일을 탐색할 수 있다.
- set을 통해 파일 종류가 몇 개인지, cnt를 통해 갯수가 몇 개인지 확인한 후 출력한다.


## 코드

```python
# BOJ
# G3 - 22860(폴더 정리 small)

from collections import defaultdict, deque

def find_files(d, folder):
    q = deque([folder])
    files = set()
    file_cnt = 0
    
    while q:
        p = q.popleft()
        for f, c in d[p]:
            if c == "1":
                q.append(f)
            else:
                files.add(f)
                file_cnt += 1
    
    return len(files), file_cnt

n, m = map(int, input().split())
d = defaultdict(list)

for _ in range(n + m):
    p, f, c = input().split()
    d[p].append((f, c))

q = int(input())

for _ in range(q):
    folder = input().split("/")[-1]
    files, cnt = find_files(d, folder)
    print(files, cnt)
```