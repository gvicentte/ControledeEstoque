package org.controledeestoque.controller;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controledeestoque.model.Produto;
import org.controledeestoque.utils.PathFXML;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TelaPrincipalController implements Initializable {
    private ObservableList<Produto> produtos = FXCollections.observableArrayList();
    @FXML
    private TableView<Produto> tableViewProdutos;
    @FXML
    private TableColumn<Produto, String> nome;
    @FXML
    private TableColumn<Produto, Double> preco;
    @FXML
    private TableColumn<Produto, Integer> quantidade;
    @FXML
    private Label lblValorTotal;
    @FXML
    private TextArea txtNome;
    @FXML
    private TextArea txtPreco;
    @FXML
    private TextArea txtQuantidade;
    private List<Produto> array = new ArrayList<Produto>();

    //private static final ObservableList<Produto> listaDeProdutos =
    //            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableViewProdutos.setItems(produtos);
        carregarProdutos();
    }

    public void carregarProdutos(){
        produtos.addAll(array);
        calcularValorTotalEstoque();
    }

    public void calcularValorTotalEstoque(){
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        lblValorTotal.setText(String.format("Valor Total de Estoque: R$ %.2f",total));
    }

    public void salvarForms(){
        Produto produto = new Produto();
        produto.setNome(txtNome.getText());
        produto.setPreco(Double.parseDouble(txtPreco.getText()));
        produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        array.add(produto);
        txtNome.clear();
        txtPreco.clear();
        txtQuantidade.clear();
        carregarProdutos();
    }

    public void fechar(){
        System.exit(0);
    }
}

