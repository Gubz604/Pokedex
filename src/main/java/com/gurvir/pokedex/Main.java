package com.gurvir.pokedex;

import com.gurvir.pokedex.model.Pokemon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override 
    public void start(Stage stage) {
        // Construct and display interface
        Pokemon pokemon = new Pokemon(1, "Bulbasaur");
        String description = "#" + pokemon.getId() + " " + pokemon.getName();

        Label greeting = new Label(description);
        StackPane root = new StackPane(greeting);


        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Java Pokedex");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(final String[] args) {
        launch(args);
    }
}
