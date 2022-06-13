package br.com.treinaweb.adoteumpet;

import br.com.treinaweb.adoteumpet.core.models.Pet;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdoteUmPetApplication implements CommandLineRunner {

    @Autowired
    private PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdoteUmPetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var pet = new Pet();
        pet.setNome("Bidu");
        pet.setHistoria("Historia Teste");
        pet.setFoto("https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462__340.jpg");
        petRepository.save(pet);
    }
}
