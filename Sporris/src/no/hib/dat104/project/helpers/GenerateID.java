package no.hib.dat104.project.helpers;
/*
 * Hjelpeklasse for å generere en random unik ID
 */
import java.util.Random;

import no.hib.dat104.project.model.UserEAO;

public class GenerateID {
	private static Random random = new Random();
	/*
	 * metode for å generere unik UserID
	 * @param userEAO
	 * @return ID
	 */
	public static int userIDInt(UserEAO userEAO){
		int ID;
		ID = random.nextInt();
		if(userEAO.findUser(ID)!=null){
			ID=random.nextInt();
		}
		return ID;
	}
}
