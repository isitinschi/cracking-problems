public class Islands {
	
	private static final int SEA = 0;
	private static final int LAND = 1;
	
	public int countIslands(int [][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		
		boolean [][] visited = new boolean[map.length][map[0].length];
		
		int counter = 0;
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[0].length; ++j) {
				if (map[i][j] == LAND && !visited[i][j]) {
					++counter;
					markVisited(map, visited, i, j);
				}
			}
		}
		return counter;
	}
	
	private void markVisited(int [][] map, boolean [][] visited, int i, int j) {
		if (i >= 0 && i < map.length && j >= 0 && j < map[0].length) {
			if (map[i][j] == LAND && !visited[i][j]) {
				visited[i][j] = true;
				markVisited(map, visited, i - 1, j);
				markVisited(map, visited, i, j - 1);
				markVisited(map, visited, i, j + 1);
				markVisited(map, visited, i + 1, j);
			}
		}
	}
	
	public static void main(String[] args) {
		int [][] map = new int [][] {
			{1,0,1,0},
			{0,0,0,1}
		};
		Islands islands = new Islands();
		System.out.println("Islands count = " + islands.countIslands(map));
	}
	
}