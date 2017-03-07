import java.util.Random;

public class Turven {

	public int maxOgen = 18;
	public int maxWorpen = 200;
	public int maxOgenInArray = maxOgen + 1;
	public int aantalDobbelstenen = 3;
	public int[] aantalKeer = new int[maxOgenInArray];



	public  void gooi() {

		Random generator = new Random();
		int aantalWorpen = 0;
		int totaalWorp = 0;
		while (aantalWorpen <= maxWorpen) {

			for (int dobbelstenen = 0; dobbelstenen < aantalDobbelstenen; dobbelstenen++) {
				int worp = (generator.nextInt(6) + 1);
				totaalWorp =+ worp;
			}
			aantalKeer[totaalWorp]++;
			totaalWorp = 0;
		}

	}

	public  void print() {
		for (int aantalOgen = 3; aantalOgen <= maxOgen; aantalOgen++) {
			int totaalWaarde = 0;
			String stringOgen = aantalOgen + " :";
			while (totaalWaarde < aantalKeer[aantalOgen]) {
				stringOgen += "X"; 
				totaalWaarde++;
			}
			System.out.println(stringOgen); 
			
			// hij print nu helemaal niks meer uit, waarom???
		}
	}
	
}
