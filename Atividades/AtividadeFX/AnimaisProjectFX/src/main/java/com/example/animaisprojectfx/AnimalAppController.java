package com.example.animaisprojectfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class AnimalAppController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea textArea;

    private List<Animal> animalList;

    public void initialize() {
        // Criando a lista de animais com dados fictícios
        animalList = new ArrayList<>();
        animalList.add(new Animal(1, "Leão", 5));
        animalList.add(new Animal(2, "Tigre", 7));
        animalList.add(new Animal(3, "Elefante", 10));
        animalList.add(new Animal(4, "Girafa", 4));

        // Preenchendo o ComboBox com os nomes dos animais
        List<String> animalNames = new ArrayList<>();
        for (Animal animal : animalList) {
            animalNames.add(animal.getNome());
        }
        comboBox.setItems(FXCollections.observableArrayList(animalNames));
    }

    @FXML
    private void showAnimalDetails(ActionEvent event) {
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