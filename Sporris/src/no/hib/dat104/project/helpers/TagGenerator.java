package no.hib.dat104.project.helpers;
import java.util.Random;
/*
 * metode for å generere unik spørris-TAG på 6 tegn
 * @param userEAO
 * @return tag
 * @author Carl-Trygve
 */
public class TagGenerator {
	private static final char[] symbols;
	static{
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch){
			tmp.append(ch);
		}
		for (char ch = 'a'; ch <= 'z'; ++ch){
			tmp.append(ch);
		}
		for (char ch = 'A'; ch <= 'Z'; ++ch){
			tmp.append(ch);
		}
		symbols = tmp.toString().toCharArray();
	}   

	final static Random random = new Random();

	static char[] tag = new char[6];

	public static String nyTag() {
		for (int i = 0; i < tag.length; ++i){
			tag[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(tag);
	}
}