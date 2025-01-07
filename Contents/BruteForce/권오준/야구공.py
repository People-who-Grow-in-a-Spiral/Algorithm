# BOJ
# G4 - 17281(⚾)

from itertools import permutations
import sys
input = sys.stdin.readline

def play(seq, innings):
    idx = 0
    score = 0
    
    for inning in innings:
        out = 0
        b1 = b2 = b3 = 0
        while out < 3:
            hit = inning[seq[idx % 9]]
            idx += 1
            
            if hit == 0:
                out += 1
            elif hit == 1:
                score += b3
                b1, b2, b3 = 1, b1, b2
            elif hit == 2:
                score += b2 + b3
                b1, b2, b3 = 0, 1, b1
            elif hit == 3:
                score += b1 + b2 + b3
                b1, b2, b3 = 0, 0, 1
            else:
                score += b1 + b2 + b3 + 1
                b1 = b2 = b3 = 0
        
    return score

n = int(input())
innings = [list(map(int, input().split())) for _ in range(n)]
seqs = [p[:3] + (0,) + p[3:] for p in permutations(range(1, 9))]
ans = 0

for seq in seqs:
    ans = max(ans, play(seq, innings))

print(ans)