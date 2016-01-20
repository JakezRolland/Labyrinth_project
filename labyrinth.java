import java.lang.Math; 
import java.util.ArrayList;



public class labyrinth{




	
	player player1;
	int columns ;
	int lines ; 
	cell [][] grille ;
	int[] numbers ;
	ArrayList<Integer> areas = new ArrayList<Integer>();
	
	
	
	public labyrinth( int lines, int columns) {
	
		player player1 = new player(3,4,"jakez");
		System.out.println(player1.getX());
		this.columns = columns;
		this.lines = lines;
		numbers = new int[columns*lines];
		for (int k = 0;k<lines*columns;k++){numbers[k] = k;}
		for (int k = 0;k<lines*columns;k++){areas.add(k);}
		
		areas = this.getAreas();
		//grille initialization
		grille = new cell[lines][columns];
		for (int i=0 ; i < lines ; i++){
		
			for (int j = 0; j < columns ; j++){
			
				grille[i][j] = new cell(i*columns+j);
			
				
			
			}
			
		}
	}
	//on va ouvrir un mur entre deux cellules, il faut savoir quel mur ouvrir de quelle cellulee
	public  void modif_mur_entre(int i1, int j1 ,int i2, int j2, boolean statwall){

		
		//System.out.println(grille[i1][j1].getNumber());
		//System.out.println(grille[i2][j2].getNumber());
		
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
		
	
	
	public ArrayList<Integer> getAreas(){
		
		int k=0;
		boolean alreadyexist = false;
		ArrayList<Integer> areas = new ArrayList<Integer>();
		for (int i=0 ; i < lines ; i++){
			
			for (int j = 0; j < columns ; j++){
			
				while ( k < areas.size()){
					if(areas.get(k) == grille[i][j].getArea()){
						alreadyexist=true;
						k = 100000;
					}
					else {
						k++;
					}
				}
				
				if (alreadyexist = false){
				areas.add(grille[i][j].getArea());
				areas.get(0);
				}
			
				
				
			
			}
			
		}
		return areas;
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
			
			//display the indesctructible left wall
			System.out.println("");
			System.out.print("|");
			
			//display rightwall of the cell i j
			
			for (int j = 0; j < columns ; j++){
			
			//condition on the rightwall
				//border condition
				
				
				if (j == columns-1) {
					
					if(i==3 && j==4){
						System.out.print(" A");
						System.out.print(" |");
						}
					else System.out.print("   |");
				}
				//is there a wall?
				else if (grille[i][j].getRightwall() == true){
						
						if(i==3 && j==4){
						System.out.print(" A");
						System.out.print(" |");
						}
						else System.out.print("   |");
						
						
				}
				//if not, do not print a wall
				else  {
						if(i==3 && j==4){
						System.out.print(" A");
						System.out.print("  ");
						}
						else System.out.print("    ");
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


	// this function find the walls in the grid and gives the coordintes of the walls
	public ArrayList<int[][]> walls_list(){
		ArrayList<int[][]> walls = new ArrayList<int[][]>() ;
		
	
	
		//indice wall
		int ind_w=0 ;
	
		for (int i=0 ; i < lines ; i++){
		
				for (int j = 0; j < columns ; j++){
			
					if (grille[i][j].getRightwall() == true) {
						int[][] tmp = new int[2][2];
						
						if(j!=columns-1 && grille[i][j].getArea()!=grille[i][j+1].getArea()){
						tmp[0][0] = i;
						tmp[0][1] = j;
						tmp[1][0] = i;
						tmp[1][1] = j+1;
						walls.add(tmp);
						ind_w++;
						}
					}
					if (grille[i][j].getBottomwall() == true) {
						int[][] tmp = new int[2][2];
					
						if (i!=lines-1 && grille[i][j].getArea()!=grille[i+1][j].getArea()){
						tmp[0][0] = i;
						tmp[0][1] = j;
						tmp[1][0] = i+1;
						tmp[1][1] = j;
						walls.add(tmp);
						ind_w++;
						}
					}
				
				
			
				
				}
	
		}
		
		
		for (int i = 0; i< walls.size() ; i++){
			
			
			/*
			System.out.print(" "+walls.get(i)[0][0]);
			System.out.print(" "+walls.get(i)[0][1]);
			System.out.print(" "+walls.get(i)[1][0]);
			System.out.println(" "+walls.get(i)[1][1]);
			*/
			
		}
		
			
		
	
		
		
	return walls;
	}
	
	public void labyrinth_shaper(){
		
		ArrayList<int[][]> wallslist = this.walls_list(); ;
		int rand;
		cell cell1;
		cell cell2;
		int area1;
		int area2;
		ArrayList<Integer> areaslab = areas;
		
		
		while (wallslist.size() >1){
			
			
			
			rand = (int)Math.floor(Math.random()*wallslist.size());
			
			cell1=grille[wallslist.get(rand)[0][0]][wallslist.get(rand)[0][1]];
			cell2=grille[wallslist.get(rand)[1][0]][wallslist.get(rand)[1][1]];
			//we found out what type of wall we are studying
			
			
			if (cell1.getArea() != cell2.getArea()){
				//this.afficher();
				this.modif_mur_entre(wallslist.get(rand)[0][0],wallslist.get(rand)[0][1],wallslist.get(rand)[1][0],wallslist.get(rand)[1][1], false);
				area1 = grille[wallslist.get(rand)[0][0]][wallslist.get(rand)[0][1]].getArea();
				area2 = grille[wallslist.get(rand)[1][0]][wallslist.get(rand)[1][1]].getArea();
				
				//change the area code of the cells
				for (int i=0 ; i < lines ; i++){
		
					for (int j = 0; j < columns ; j++){
			
						if (grille[i][j].getArea() == area2){
							grille[i][j].setArea(area1);
						}
			
				
			
					}
			
				}
				//update areas
				areaslab = this.getAreas();
				wallslist = this.walls_list();
			}
			
		}
	}
	
}
	




