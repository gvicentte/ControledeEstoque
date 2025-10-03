package org.controledeestoque.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controledeestoque.model.Produto;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControledeEstoqueController implements Initializable {
    private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private TableColumn<Produto, String> nome;
    @FXML
    private TableColumn<Produto, Float> preco;
    @FXML
    private TableColumn<Produto, Integer> quantidade;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtPreco;

    public void adicionar() {
        Produto p = new Produto();
        p.setNome(txtNome.getText());
        p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        p.setPreco(Float.parseFloat(txtPreco.getText()));
        produtos.add(p); // já reflete direto na TableView
        limparCampos();
    }

    private void limparCampos() {
        txtNome.clear();
        txtQuantidade.clear();
        txtPreco.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        tableViewProdutos.setItems(produtos);
    }
}

