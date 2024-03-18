import java.util.PriorityQueue;

class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<Link> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Link[][] table = new Link[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                table[i][j] = new Link(Integer.MAX_VALUE, i, j);
                minHeap.add(table[i][j]);
            }
        }
        minHeap.remove(table[0][0]);
        table[0][0].distance = 0;
        minHeap.add(table[0][0]);
        while (!minHeap.isEmpty()) {
            Link temp1 = minHeap.poll();
            Link temp2;
            if (temp1.i - 1 >= 0 && !visited[temp1.i - 1][temp1.j]) {
                temp2 = table[temp1.i - 1][temp1.j];
                int calc = temp1.distance + checkCost(4, grid[temp1.i][temp1.j]);
                if (calc < temp2.distance) {
                    temp2.distance = calc;
                    minHeap.remove(temp2);
                    minHeap.add(temp2);
                }
            }
            if (temp1.i + 1 < grid.length && !visited[temp1.i + 1][temp1.j]) {
                temp2 = table[temp1.i + 1][temp1.j];
                int calc = temp1.distance + checkCost(3, grid[temp1.i][temp1.j]);
                if (calc < temp2.distance) {
                    temp2.distance = calc;
                    minHeap.remove(temp2);
                    minHeap.add(temp2);
                }
            }
            if (temp1.j - 1 >= 0 && !visited[temp1.i][temp1.j - 1]) {
                temp2 = table[temp1.i][temp1.j - 1];
                int calc = temp1.distance + checkCost(2, grid[temp1.i][temp1.j]);
                if (calc < temp2.distance) {
                    temp2.distance = calc;
                    minHeap.remove(temp2);
                    minHeap.add(temp2);
                }
            }
            if (temp1.j + 1 < grid[0].length && !visited[temp1.i][temp1.j + 1]) {
                temp2 = table[temp1.i][temp1.j + 1];
                int calc = temp1.distance + checkCost(1, grid[temp1.i][temp1.j]);
                if (calc < temp2.distance) {
                    temp2.distance = calc;
                    minHeap.remove(temp2);
                    minHeap.add(temp2);
                }
            }
            visited[temp1.i][temp1.j] = true;
        }
        return table[grid.length - 1][grid[0].length - 1].distance;
    }

    private int checkCost(int location, int direction) {
        if (location == direction) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Link implements Comparable {
    int distance;
    int i;
    int j;

    public Link(int distance, int i, int j) {
        this.distance = distance;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Object o) {
        if (distance > ((Link) o).distance) {
            return 1;
        } else if (distance < ((Link) o).distance) {
            return -1;
        } else {
            return 0;
        }
    }
}