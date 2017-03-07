package gameOfLife;

import java.io.IOException;

public class lifeApplication {

	public static void main(String[] args) throws IOException {
		LifeModel game = new LifeModel();
		game.initMatrix();
		game.toon();
		int i = 0;
		for (; ;)
		{ 
			i++;
			System.out.println("\n Generatie " + i);
			game.volgendeGeneratie();
			game.toon();			
			System.out.println("Druk op enter voor de volgende generatie");
			System.in.read();
				

		}

	}
}
