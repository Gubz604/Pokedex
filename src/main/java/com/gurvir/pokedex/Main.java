package com.gurvir.pokedex;

import com.gurvir.pokedex.api.PokeApiClient;
import com.gurvir.pokedex.api.PokemonJsonParser;
import com.gurvir.pokedex.data.ApiPokemonRepository;
import com.gurvir.pokedex.data.PokemonRepository;
import com.gurvir.pokedex.model.Pokemon;
import com.gurvir.pokedex.ui.PokedexView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.concurrent.Task;

import java.util.List;

public class Main extends Application {

    @Override 
    public void start(Stage stage) {
        PokemonRepository repository = new ApiPokemonRepository(new PokeApiClient(), new PokemonJsonParser());
        ObservableList<Pokemon> pokemon = FXCollections.observableArrayList();

        PokedexView view = new PokedexView(pokemon);

        Task<List<Pokemon>> loadTask = new Task<>() {
            @Override
            protected List<Pokemon> call() throws Exception {
                return repository.findAll();
            }
        };

        loadTask.setOnSucceeded(event -> {
            pokemon.setAll(loadTask.getValue());

            view.setStatus("Loaded " + pokemon.size() + " Pokemon");
        });
        loadTask.setOnFailed(event -> {
            view.setStatus("Could not load Pokemon. Please try again later.");
            loadTask.getException().printStackTrace();
        });
        view.setStatus("Loading Pokemon...");

        Scene scene = new Scene(view.getRoot(), 800, 600);
        stage.setTitle("Java Pokedex");
        stage.setScene(scene);
        stage.show();

        Thread worker = new Thread(loadTask, "pokemon-loader");
        worker.setDaemon(true);
        worker.start();
    }
    public static void main(final String[] args) {
        launch(args);
    }
}
