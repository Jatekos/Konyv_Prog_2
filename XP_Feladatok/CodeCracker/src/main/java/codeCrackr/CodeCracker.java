package codeCrackr;

public class CodeCracker {

	String[] ABC = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z", };

	public String coder(String key, String message) {
		// TODO Auto-generated method stub
		if (key == null)
			return message;

		String[] keySplited = key.split(" ");

		return coding(ABC, keySplited, message);
	}

	public String coder(String[] key, String abc, String message) {
		// TODO Auto-generated method stub
		 if(key == null)
			return message;
		
		String[] ABC = key;
		String[] keySplited = abc.split(" ");

		return coding(ABC, keySplited, message);
	}

	private String coding(String[] ABC, String[] keySplited, String message) {
		// TODO Auto-generated method stub
		String coded = "";

		for (int i = 0; i < message.length(); i++) {
			int j = 0;
			while ((message.charAt(i) != ABC[j].charAt(0))) {
				j++;
				if (!(j < ABC.length)) {
					break;
				}

			}
			if ((j < keySplited.length)) {
				coded += keySplited[j];
			} else {
				coded += message.toCharArray()[i];
			}
		}
		return coded;
	}

	public String deCoder(String key, String message) {
		// TODO Auto-generated method stub
		return coder(ABC, key, message);
	}

}
