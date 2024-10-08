package de.fspeer.cgn244javarestapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping ("/api/characters")
public class RickAndMortyController {
    RestClient.Builder builder = RestClient.builder();
    private final RickAndMortyApiService rickAndMortyApiService = new RickAndMortyApiService(builder);

    @GetMapping
    public List<RickAndMortyApiResponseResults> getAllCharacters (){
        return rickAndMortyApiService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public RickAndMortyApiResponseResults getCharacter (@PathVariable int id){
        return rickAndMortyApiService.getCharacterById(id);
    }

    @GetMapping("/?name=rick&status=alive")
    public RickAndMortyApiResponseResults getCharactersByAliveStatus (){
        return rickAndMortyApiService.getCharactersByAliveStatus();
    }

}
