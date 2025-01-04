## 시간 복잡도
- $O(n^2)$

## 문제 접근법

1. sliceArray()로 배열을 자른다.
2. sortedArray로 배열을 정리한다.
3. 범위를 산정 시 outOfIndex를 방지하기 위해서 -1을 넣어서 정답을 산출한다.

## 코드

```kotlin
// Programmers
// Lv.1 - K번째수

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        
        for(i in commands.indices){
            var answerArray = array.sliceArray(IntRange(commands[i][0] - 1 , commands[i][1] - 1)).sortedArray()
            answer[i] = answerArray[commands[i][2]-1]
        }
        return answer
    }
}
```