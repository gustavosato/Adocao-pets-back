package br.com.treinaweb.adoteumpet.api.adocao.mappers;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.models.Adocao;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoMapper {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public Adocao toModel(AdocaoRequest adocaoRequest){
        /*var adocao = new Adocao();
        adocao.setEmail(adocaoRequest.getEmail());
        adocao.setValor(adocaoRequest.getValor());
        adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()));

        return adocao;*/
        return Adocao.builder()
                .email(adocaoRequest.getEmail())
                .valor(adocaoRequest.getValor())
                .pet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()))
                .build();
    }

    public AdocaoResponse toResponse(Adocao adocao){
        /*var adocaoReponse = new AdocaoResponse();
        adocaoReponse.setId(adocao.getId());
        adocaoReponse.setEmail(adocao.getEmail());
        adocaoReponse.setValor(adocao.getValor());
        adocaoReponse.setPet(petMapper.toResponse(adocao.getPet()));

        return adocaoReponse;*/
        return AdocaoResponse.builder()
                .id(adocao.getId())
                .email(adocao.getEmail())
                .valor(adocao.getValor())
                .pet(petMapper.toResponse(adocao.getPet()))
                .build();
    }
}
