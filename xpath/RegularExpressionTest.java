import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class RegularExpressionTest {
	public static void main(String[] args) {
		String input = "I have a cat, but I like my dog better.";

		Pattern p = Pattern.compile("(mouse|cat|dog|wolf|bear|human)");
		Matcher m = p.matcher(input);

		List<String> animals = new ArrayList<String>();
		while (m.find()) {
			System.out.println("Found a " + m.group() + ".");
			animals.add(m.group());
		}
	}
}
