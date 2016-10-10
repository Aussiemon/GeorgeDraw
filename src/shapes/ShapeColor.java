package shapes;

public enum ShapeColor {
	BLACK("Black"), RED("Red"), GREEN("Green"), BLUE("Blue");
	
	String niceName;
	
	ShapeColor(String niceName) {
		this.niceName = niceName;
	}
	
	public String toString() {
		return niceName;
	}
}
