public class Solution {    

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();        

        if (buildings == null || buildings.length == 0 || buildings[0].length != 3) {
            return points;
        }        

        List<int []> criticalPoints = new ArrayList<>();       

        for (int i = 0; i < buildings.length; ++i) {
            int [] criticalPoint = new int [] {buildings[i][0], buildings[i][2], buildings[i][2]};
            criticalPoints.add(criticalPoint);           

            criticalPoint = new int [] {buildings[i][1], 0, buildings[i][2]};
            criticalPoints.add(criticalPoint);
        }        

        Collections.sort(criticalPoints, new Comparator<int []> () {            

            @Override
            public int compare(int [] a1, int [] a2) {
                return Integer.valueOf(a1[0]).compareTo(a2[0]);
            }            

        });        

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < criticalPoints.size();) {
            int pos = criticalPoints.get(i)[0];
            
            // we need to process all rectangles for current position
            while (i < criticalPoints.size() && pos == criticalPoints.get(i)[0]) {
                int y = criticalPoints.get(i)[1];
                int rectHeight = criticalPoints.get(i)[2];
                if (y != 0) {
                    queue.add(rectHeight);
                } else {
                    queue.remove(rectHeight);
                }               

                ++i;
            }           

            if (queue.isEmpty()) {
                points.add(new int [] {pos, 0});
            } else {
                // check if on the same line as previous point
                if (points.isEmpty() || points.get(points.size() - 1)[1] != queue.peek()) {
                    points.add(new int [] {pos, queue.peek()});
                }
            }
        }        

        return points;
    }

}