package gameOfLife;

import java.util.Random;

public class LifeModel {
	public int maxRijen = 22;
	public int maxKolommen = 32;
	public boolean[][] matrixGame = new boolean[maxRijen][maxKolommen];
	public boolean[][] matrixGameOud = new boolean[maxRijen][maxKolommen];

	public void initMatrix() {
		for (int rij = 0; rij < matrixGame.length; rij++) {
			for (int kolom = 0; kolom < matrixGame[0].length; kolom++) {
				Random generator = new Random();
				boolean boolAlive = true;
				int checkLeven = (generator.nextInt(10));

				if (checkLeven != 0 || kolom == 0 || kolom == matrixGame[0].length) {
					boolAlive = false;
				}
				matrixGame[rij][kolom] = boolAlive;
			}
		}
	}

	public boolean isLevend(int rij, int kolom) {
		boolean boolAlive = true;
		if (matrixGame[rij][kolom] == false) {
			boolAlive = false;
		}
		return boolAlive;
	}

	public void toon() {

		for (int rij = 1; rij < matrixGame.length - 1; rij++) {
			String showMatrix = "";
			for (int kolom = 1; kolom < matrixGame[0].length - 1; kolom++) {
				if (isLevend(rij, kolom)) {
					showMatrix += " X";
				} else
					showMatrix += " -";
			}
			System.out.println(showMatrix);

		}
	}

	private int telBuren(int rij, int kolom) {
		int aantalBuren = 0;
		for (int checkRij = rij - 1; checkRij < rij + 1; checkRij++) {
			for (int checkKolom = kolom - 1; checkKolom <= kolom + 1; checkKolom++) {
				if (matrixGame[checkRij][checkKolom])
					aantalBuren++;
			}

		}
		return aantalBuren;
	}

	private boolean evolueer(int rij, int kolom) {
		boolean isAlive = matrixGameOud[rij][kolom];

		if (isAlive) { //wanneer de cellen leven
			if (telBuren(rij, kolom) < 2 || telBuren(rij, kolom) > 3) {
				isAlive = false;
			}
		} else if (!isAlive) {//wanneer de cel dood is gebeurt er dit
			if (telBuren(rij, kolom) == 3)
				isAlive = true;
		}
		// matrixGame[rij][kolom] = isAlive;

		return isAlive;
	}

	public void volgendeGeneratie() {
		matrixGameOud = matrixGame;
		for (int rij = 1; rij < matrixGame.length - 1; rij++) {
			for (int kolom = 1; kolom < matrixGame[0].length - 1; kolom++) {

				matrixGame[rij][kolom] = evolueer(rij, kolom);

			}
		}
	}

}
