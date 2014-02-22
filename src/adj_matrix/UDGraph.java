package adj_matrix;

public class UDGraph {
	private boolean[][] adjMatrix;
	private int vertices;
	private int edges;
	
	public UDGraph(int n){
		vertices = n;
		edges = 0;
		adjMatrix = new boolean[n][n];
		for(int i = 0; i < vertices; i++){
			for(int j = 0; j < vertices; j++){
				adjMatrix[i][j] = false;
			}
		}
	}
	
	public int getNumVertices(){
		return vertices;
	}
	
	public int getNumEdges(){
		return edges;
	}
	
	public boolean validVertex(int v){
		return (v > 0 && v < vertices);
	}
	
	public boolean hasEdge(int origin, int dest){
		if (validVertex(origin) && validVertex(dest)){
			return adjMatrix[origin][dest];
		} else {
			return false;
		}
	}
	
	public void addEdge(int origin, int dest){
		if (validVertex(origin) && validVertex(dest)){
			if(!adjMatrix[origin][dest]){
				adjMatrix[origin][dest] = true;
				edges++;
			}
		}
	}
	
	public void removeEdge(int origin, int dest){
		if (validVertex(origin) && validVertex(dest)){
			if(adjMatrix[origin][dest]){
				adjMatrix[origin][dest] = false;
				edges--;
			}
		}
	}
	
}
