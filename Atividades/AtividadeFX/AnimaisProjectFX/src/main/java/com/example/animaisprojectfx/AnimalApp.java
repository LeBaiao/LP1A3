package com.example.animaisprojectfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AnimalApp extends Application {

    private List<Animal> animalList;
    private ComboBox<String> comboBox;
    private TextArea textArea;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        // Criando a lista de animais com dados fictícios
        animalList = new ArrayList<>();
        animalList.add(new Animal(1, "Leão", 5));
        animalList.add(new Animal(2, "Tigre", 7));
        animalList.add(new Animal(3, "Elefante", 10));
        animalList.add(new Animal(4, "Girafa", 4));

        // Configurando a interface gráfica
        comboBox = new ComboBox<>();
        comboBox.setItems(FXCollections.observableArrayList(getAnimalNames()));
        Button button = new Button("Mostrar");
        textArea = new TextArea();
        textArea.setEditable(false);

        // Adicionando evento ao botão
        button.setOnAction(e -> showAnimalDetails());

        // Adicionando evento para atualizar a TextArea ao selecionar um novo animal no ComboBox
        comboBox.setOnAction(e -> {
            textArea.clear();
            showAnimalDetails();
        });

        // Configurando o layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(comboBox, button, textArea);

        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        // Configurando a cena
        Scene scene = new Scene(root, 300, 200);

        // Configurando o palco
        primaryStage.setTitle("Animal App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<String> getAnimalNames() {
        List<String> names = new ArrayList<>();
        for (Animal animal : animalList) {
            names.add(animal.getNome());
        }
        return names;
    }

    private void showAnimalDetails() {
        String selectedName = comboBox.getValue();
        for (Animal animal : animalList) {
            if (animal.getNome().equals(selectedName)) {
                textArea.appendText("ID: " + animal.getId() + "\n");
                textArea.appendText("Nome: " + animal.getNome() + "\n");
                textArea.appendText("Idade: " + animal.getIdade() + "\n");
                break;
            }
        }
    }

}