import sys
input = sys.stdin.readline

n, t = map(int, input().split())
bus = [map(int, input().split()) for _ in range(n)]

all_bus = []
for (s, i, c) in bus:
    for time in range(c):
        all_bus.append(s + i * time)
all_bus.sort()

if all_bus[-1] < t:
    print(-1)
else:
    start, end = 0, len(all_bus) - 1
    while start < end:
        mid = (start + end) // 2
        
        if all_bus[mid] >= t:
            end = mid
        else:
            start = mid + 1
    print(all_bus[start] - t)