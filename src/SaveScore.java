import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class SaveScore {
	//private String name;

	public void writeToFile(String name, int score) throws IOException {
		String comboyo = name + "," + score;
		List<String> lines = new ArrayList<>();
		lines.add(comboyo);
		try {
			Path file = Paths.get("./src", "abc.txt");//bytas namn eventuellt
			Files.write(file, lines);
			System.out.println("Sparat filen yao");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public TreeMap<String, Integer> readFromFile() throws FileNotFoundException {
		TreeMap<String, Integer> hm = new TreeMap<String, Integer>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/abc.txt"));
			String line = br.readLine();
			String[] splittext = line.split(",");
			String nameFromFile = splittext[0];
			int scoreFromFile = Integer.parseInt(splittext[1]);
			hm.put(nameFromFile, scoreFromFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return hm;

	}
}
