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
    private final ObservableList<Produto> produtos = FXCollections.observableArrayList();
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
    Produto [] vetor = new Produto[]{
            new Produto("Monitor LG 27 Polegadas",850.00,17),
            new Produto("Camiseta Flamengo 2025",325.00,80),
            new Produto("Trident Menta",1.25,100),
            new Produto("Agua Mineral",2.75,150),
            new Produto("Teclado Gamer",125.99,15)

    };
    List<Produto> array = new ArrayList<Produto>(List.of(vetor));
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtQuantidade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableViewProdutos.setItems(produtos);
        produtos.addAll(array);
        calcularValorTotalEstoque();
    }

    public void carregarProdutos(){
        produtos.add(array.getLast());
        calcularValorTotalEstoque();
    }

    public void calcularValorTotalEstoque(){
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        lblValorTotal.setText(String.format("Valor Total de Estoque: R$ %.2f",total));
    }

    public void btnSalvar(){
        Produto verify = tableViewProdutos.getSelectionModel().getSelectedItem();
        if(verify!=null){
            verify.setNome(txtNome.getText());
            verify.setPreco(Double.parseDouble(txtPreco.getText()));
            verify.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            tableViewProdutos.refresh();
            txtNome.clear();
            txtPreco.clear();
            txtQuantidade.clear();
            tableViewProdutos.getSelectionModel().clearSelection();
        }
        else {
            tableViewProdutos.getSelectionModel().clearSelection();
            verify = new Produto();
            verify.setNome(txtNome.getText());
            verify.setPreco(Double.parseDouble(txtPreco.getText()));
            verify.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            array.add(verify);
            txtNome.clear();
            txtPreco.clear();
            txtQuantidade.clear();
            carregarProdutos();
        }
        calcularValorTotalEstoque();
    }

    public void atualizarItem(){
        Produto aux = tableViewProdutos.getSelectionModel().getSelectedItem();
        if(aux!=null){
            txtNome.setText(aux.getNome());
            txtPreco.setText(Double.toString(aux.getPreco()));
            txtQuantidade.setText(Integer.toString(aux.getQuantidade()));
        }
        else {
            System.out.println("Nenhum item foi selecionado!");
        }
    }

    public void deletarItem(){
        Produto produto = tableViewProdutos.getSelectionModel().getSelectedItem();
        if(produto != null){
            tableViewProdutos.getItems().remove(produto);
        }
        else {
            System.out.println("Nenhum item foi selecionado!");
        }
        calcularValorTotalEstoque();
        tableViewProdutos.getSelectionModel().clearSelection();
    }

    public void fechar(){
        System.exit(0);
    }
}

