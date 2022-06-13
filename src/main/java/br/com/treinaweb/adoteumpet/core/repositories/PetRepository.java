package br.com.treinaweb.adoteumpet.core.repositories;

import br.com.treinaweb.adoteumpet.core.exceptions.PetNotFoundException;
import br.com.treinaweb.adoteumpet.core.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface PetRepository extends JpaRepository<Pet, Long> {
    default Pet findByIdOrElseThrow(Long id){
        /*var petOpcional = findById(id);
        if(petOpcional.isPresent()){
            return petOpcional.get();
        }
        throw new PetNotFoundException();*/
        return findById(id)
                .orElseThrow(PetNotFoundException::new);
    }
}
