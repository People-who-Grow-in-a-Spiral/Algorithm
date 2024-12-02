## 시간 복잡도
- $O(1)$

## 문제 접근법

- $P_1, P_2, P_3$을 순서대로 이은 선분의 방향은 두 벡터 $ \overrightarrow{P_1, P_2} $, $ \overrightarrow{P_2, P_3} $의 외적이다.
- $ \overrightarrow{P_1, P_2} $은 $P_2 - P_1$, $ \overrightarrow{P_2, P_3} $는 $P_3 - P_2$이고, 두 벡터를 외적하면 된다.

<br>

- $P_1 = (x_1, y_1)$, $P_2 = (x_2, y_2)$, $P_3 = (x_3, y_3)$
- $ \overrightarrow{P_1, P_2} = (x_2 - x_1, y_2 - y_1) $, $ \overrightarrow{P_2, P_3} = (x_3 - x_2, y_3 - y_2)$
- 외적 -> $ \overrightarrow{P_1, P_2} \times \overrightarrow{P_2, P_3} =  (x_2 - x_1) \times (y_3 - y_2) - (x_3 - x_2) \times (y_2 - y_1) $

<br>

- 외적의 결과가 양수이면 시계 방향, 음수이면 반시계 방향이다.
- 따라서 양수면 1, 음수면 -1, 0이면 0을 출력하면 된다.


## 코드

```python
# BOJ
# G5 - 11758(CCW)

x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

p_12 = (x2 - x1, y2 - y1)
p_23 = (x3 - x2, y3 - y2)
ans = p_12[0] * p_23[1] - p_12[1] * p_23[0]

if ans > 0:
    print(1)
elif ans < 0:
    print(-1)
else:
    print(0)
```