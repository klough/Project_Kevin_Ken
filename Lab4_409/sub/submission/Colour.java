


class Colour
{
    private String colour;
    
	public Colour(String s) {
		colour = new String(s);
	}

	public String getColour()
	{
		return this.colour;
	}
    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}
	
	public boolean equals(Object o)
	{
		return o instanceof Colour && this.colour == ((Colour)o).getColour();
	}
}
