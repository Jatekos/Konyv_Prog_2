package hu.unideb.prog2.webshop.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CsvRead {
	public Set<String[]> readar(String filename) throws FileNotFoundException {

		String[] line;
		Set<String[]> lineSet = new HashSet<>();
		Scanner scanner = new Scanner(new File(filename));

		while (scanner.hasNextLine()) {
			line = scanner.nextLine().split(",");

			if (!(line.length > 1))
				break;

			lineSet.add(line);

		}
		scanner.close();
		return lineSet;
	}

}
