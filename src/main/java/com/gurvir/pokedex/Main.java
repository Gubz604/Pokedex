package com.gurvir.pokedex;

import com.gurvir.pokedex.model.Pokemon;
import com.gurvir.pokedex.ui.PokedexView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override 
    public void start(Stage stage) {
        ObservableList<Pokemon> pokemon = FXCollections.observableArrayList(
            new Pokemon(1, "Bulbasaur"),
            new Pokemon(4, "Charmander"),
            new Pokemon(7, "Squirtle")
        );

        PokedexView view = new PokedexView(pokemon);

        Scene scene = new Scene(view.getRoot(), 800, 600);
        stage.setTitle("Java Pokedex");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(final String[] args) {
        launch(args);
    }
}
