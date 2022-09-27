package observerpattern;

class Order{
	int orderNo;
	String customerId;
	int productNo;
	int quantity;
}

class OrderObserver{
	
	GridData gridData;
	GraphData graphData;
	
	public OrderObserver(GridData gridData, GraphData graphData) {
		super();
		this.gridData = gridData;
		this.graphData = graphData;
	}
	
	public void receiveData() {
		gridData.updateGrid();
		graphData.updateGraph();
	}
}

class GridData{
	
	public void updateGrid() {
		System.out.println("Grid updated");
	}
}

class GraphData{
	
	public void updateGraph() {
		System.out.println("Graph updated");
	}
}

public class ObserverPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridData gridData = new GridData();
		GraphData graphData = new GraphData();
		OrderObserver observer = new OrderObserver(gridData, graphData);
		observer.receiveData();
	}

}





