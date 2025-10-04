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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
        Produto [] array = new Produto[]{
                new Produto("Monitor LG 27 Polegadas",850.00,17),
                new Produto("Camiseta Flamengo 2025",325.00,80),
                new Produto("Trident Menta",1.25,100),
                new Produto("Agua Mineral",2.75,150),
                new Produto("Teclado Gamer",125.99,15)

        };
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

    public void fechar(){
        System.exit(0);
    }
}

