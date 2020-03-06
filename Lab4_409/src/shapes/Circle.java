package shapes;



class Circle extends Shape{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}


	@Override
	public int compareTo(Shape o) {
		
		if(o instanceof Circle && this.getOrigin().equals(o.getOrigin()) && this.get_radius()== ((Circle)o).get_radius() && this.getName().equals(o.getName()))
		{
			return 0;
		}
		return -1;
	}
}