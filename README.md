# SSAFY_Algorithm
SSAFY 서울10반 알고리즘 스터디 

### PriorityQueue 정렬
```
PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1]) {
            return o1[0] - o2[0];
        }else {
            return o2[1] - o1[1];
        }
    }
});
```