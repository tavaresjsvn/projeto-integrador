package grupo_1.src.data_access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EnvLoader {
    private static final HashMap<String, String> env = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(
        	    new FileReader("C:\\Users\\José\\Documents\\Códigos Java\\faculdade\\src\\grupo_1\\.env")
        		)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#") && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    env.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo .env: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return env.get(key);
    }
}

