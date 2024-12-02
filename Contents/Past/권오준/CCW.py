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