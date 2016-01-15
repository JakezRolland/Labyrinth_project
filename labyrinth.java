import java.lang.Math; 




public class labyrinth{




	
	
	int columns ;
	int lines ; 
	cell [][] grille ;
	
	public labyrinth( int lines, int columns) {
	
		
		this.columns = columns;
		this.lines = lines;
		grille = new cell[lines][columns];
		for (int i=0 ; i < lines ; i++){
		
			for (int j = 0; j < columns ; j++){
			
				grille[i][j] = new cell(i*columns+j);
			
				
			
			}
			
		}
	}
	//on va ouvrir un mur entre deux cellules, il faut savoir quel mur ouvrir de quelle cellulee
	public  void modif_mur_entre(int i1, int j1 ,int i2, int j2, boolean statwall){

		
		System.out.println(grille[i1][j1].getNumber());
		System.out.println(grille[i2][j2].getNumber());
		
		if(grille[i1][j1].getNumber() == grille[i2][j2].getNumber() - 1){
		
			grille[i1][j1].setRightwall(statwall);
		} 
		
		else if(grille[i1][j1].getNumber() == grille[i2][j2].getNumber() + 1){
		
			grille[i2][j2].setRightwall(statwall);
		}
		
		else if(grille[i1][j1].getNumber() == grille[i2][j2].getNumber() - columns){
		
			grille[i1][j1].setBottomwall(statwall);
		} 
		
		else if(grille[i1][j1].getNumber() == grille[i2][j2].getNumber() + columns){
		
			grille[i2][j2].setBottomwall(statwall);
		} 
		
		else { System.out.println("Les cellules ne sont pas adjacentes");}
		
	}
		
	
	
	
	
	
	public void afficher() {
	
		System.out.println("");
		System.out.print("+");
		// display the up wall of the grille
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
			
			//condition on the rightwall
				//border condition
				if (j == columns-1) {

					System.out.print("   |");
				}
				//is there a wall?
				else if (grille[i][j].getRightwall() == true){
					
						System.out.print("   |");
				}
				//if not, do not print a wall
				else  {
						System.out.print("    ");
						}
			
			}
			System.out.println("");
			System.out.print("+");
			//dsplay bottomwall of the cell i j
			//condition on the bottomwall
			
			for (int j = 0; j < columns ; j++){
				//border condition
				if(i == lines-1) {
					System.out.print("---+");
					}
				//is there a wall?
				else if(grille[i][j].getBottomwall() == true){
						System.out.print("---+");
				}
				//if not, do not print a wall
				else 	System.out.print("   +");
			
			}
			
			
		}
		
		System.out.print("");
		
	}

	public int[][][] walls_list(){
	
		int[][][] walls = new int[10000][2][2];
		//indice wall
		int ind_w=0 ;

		for (int i=0 ; i < lines ; i++){
		
				for (int j = 0; j < columns ; j++){
			
					if (grille[i][j].getRightwall() == true) {
						
						walls[ind_w][0][0] = i;
					
						walls[ind_w][0][1] = j;
						walls[ind_w][1][0] = i;
						walls[ind_w][1][1] = j+1;
						ind_w++;
					}
					if (grille[i][j].getBottomwall() == true) {
						
						walls[ind_w][0][0] = i;
						walls[ind_w][0][1] = j;
						walls[ind_w][1][0] = i+1;
						walls[ind_w][1][1] = j;
						ind_w++;
					}
				
				
				}
	
		}
		
		
	return walls;
	}



}
