package word.autocomplete;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import word.autocomplete.model.Name;
import word.autocomplete.repository.INameRepository;

@SpringBootApplication
public class BottomlineApplication implements CommandLineRunner {
	
	@Autowired
	INameRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BottomlineApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try (Scanner sc = new Scanner(new FileReader("BoyNames.txt")).useDelimiter("(?=[A-Z])")) {
			while (sc.hasNext()) {
				repository.save(new Name(sc.next().trim()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
