public class test {


	public static void main(String[] args){
	
		cell cellul;
		labyrinth lab = new labyrinth(10,10);
	
		lab.afficher();
		
		
		lab.modif_mur_entre(0,0,1,0,false);
		
		lab.afficher();
	}

}
