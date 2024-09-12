package de.fspeer.cgn244javarestapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public List <RickAndMortyApiResponseResults> getAllCharacters (){
        RickAndMortyApiResponse response = this.restClient.get().uri("/character").retrieve().body(RickAndMortyApiResponse.class); //Hier wird die GET Anfrage geschickt
        assert response != null;
        return response.results();

    }

    public RickAndMortyApiResponseResults getCharacterById (int id){
       return this.restClient.get().uri("/character/"+ id).retrieve().body(RickAndMortyApiResponseResults.class); //Hier wird die GET Anfrage geschickt
    }

    public RickAndMortyApiResponseResults getCharactersByAliveStatus (){
        return this.restClient.get().uri("/character/?name=rick&status=alive").retrieve().body(RickAndMortyApiResponseResults.class);
    }

//    public static void main(String[] args){
//        RestClient.Builder restClient1 = RestClient.builder();
//        RickAndMortyApiService service = new RickAndMortyApiService(restClient1);
//
//        service.getAllCharacters();
//    }

}
