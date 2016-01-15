
public class cell {


	//class cell

	
	boolean rightwall ;
	boolean bottomwall;
	int number;
	
	
	//constructor of the "cell" objects
	
	public cell(int number) {
		this.rightwall = true;
		this.bottomwall = true;
		this.number = number;
	}

	//methods

	//setters
	public void setRightwall(boolean rightwall){
	
		this.rightwall = rightwall;
		
	}
	
	public void setBottomwall(boolean bottomwall){
	
		this.bottomwall = bottomwall;
		
	}
	//getters

	public boolean getRightwall(){
		return rightwall ;
	}

	public boolean getBottomwall(){
		return bottomwall ;
	}
	
	public int getNumber(){
		return number ;
	}
	
	//print
	
	public String toString(){
	
		return "presence of rightwall is " + getRightwall() + ", presence of bottomwall is " + getBottomwall() + ", number of cell is " + 			getNumber();
	}
}
