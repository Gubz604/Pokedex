package com.gurvir.pokedex;

import com.gurvir.pokedex.model.Pokemon;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

    @Override 
    public void start(Stage stage) {
        // Construct and display interface
        Label detailLabel = new Label("Select a Pokemon");

        ObservableList<Pokemon> pokemon = FXCollections.observableArrayList(
            new Pokemon(1, "Bulbasaur"),
            new Pokemon(4, "Charmander"),
            new Pokemon(7, "Squirtle")
        );
        ListView<Pokemon> pokemonList = new ListView<>(pokemon);
        pokemonList.getSelectionModel()
            .selectedItemProperty()
            .addListener((observable, oldPokemon, newPokemon) -> {
                if (newPokemon == null) {
                    System.out.println("Selection cleared: null branch reached");
                    detailLabel.setText("Select a Pokemon");
                } else {
                    detailLabel.setText("#" + newPokemon.getId() + " " + newPokemon.getName());
                }
            });

        pokemonList.setPrefWidth(220);

        BorderPane root = new BorderPane();
        root.setLeft(pokemonList);
        root.setCenter(detailLabel);


        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Java Pokedex");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(final String[] args) {
        launch(args);
    }
}
