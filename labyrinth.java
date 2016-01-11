
public class labyrinth{




	
	
	int columns ;
	int lines ; 
	cell [][] labyrinth ;
	
	public labyrinth( int lines, int columns) {
	
		
		this.columns = columns;
		this.lines = lines;
		labyrinth = new cell[lines][columns];
		for (int i=0 ; i < lines ; i++){
		
			for (int j = 0; j < columns ; j++){
			
				labyrinth[i][j] = new cell(2*(i)+j+1);
			
				
			
			}
			
		}
	}
	
	public void afficher() {
	
		System.out.print("+");
		// display the up wall of the labyrinth
		for (int j = 0; j < columns ; j++){
			
				System.out.print("---+");
			
			}
		// display the 2 walls of each cell
		for (int i=0 ; i < lines ; i++){
			
			//display the left wall
			System.out.println("");
			System.out.print("|");
			
			//display rightwall of the cell i j
			for (int j = 0; j < columns ; j++){
			
				//System.out.print("   |");
				System.out.print(" "+ labyrinth[i][j].getNumber() +" |");
			
			}
			System.out.println("");
			System.out.print("+");
			//dsplay bottomwall of the cell i j
			for (int j = 0; j < columns ; j++){
			
				System.out.print("---+");
			
			}
			
			
		}
		
		System.out.print("");
		
	
	
	
	
	
	}




}
