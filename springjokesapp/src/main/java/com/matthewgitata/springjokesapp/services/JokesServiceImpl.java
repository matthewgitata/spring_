package com.matthewgitata.springjokesapp.services;

/**
 * created by @matthewgitata on 17/03/2023.
 */
@Service
public class JokesServiceImpl implements JokesService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokesServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
