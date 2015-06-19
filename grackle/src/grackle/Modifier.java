package grackle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Modifier {
	static final ArrayList<String> modList = new ArrayList<String>(Arrays.asList(
		"Downy",	"Common",	"Greater",	"Lesser",	"Northern",	"Southern",
		"Western",	"Eastern",	"Arctic",	"Tufted",	"Rufous",	"Pileated",
		"Ground",	"Crowned",	"Collared",	"American",	"European",	"Asian",
		"Australian",	"African",	"Andean",	"Indian"
		));
	
	static String getModifier() {
		return getModifier(new Random());
	}
	
	static String getModifier(long seed) {
		return getModifier(new Random(seed));
	}
	
	static String getModifier(Random rand) {
		return modList.get(rand.nextInt(modList.size()));
	}
}
