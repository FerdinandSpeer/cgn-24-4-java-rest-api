package de.fspeer.cgn244javarestapi;

import java.util.List;

public record RickAndMortyApiResponse(
        List<RickAndMortyApiResponseResults> results
) {

}
