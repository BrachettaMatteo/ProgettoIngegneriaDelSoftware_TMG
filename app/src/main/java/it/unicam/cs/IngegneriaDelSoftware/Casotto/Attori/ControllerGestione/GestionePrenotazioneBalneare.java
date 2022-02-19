package it.unicam.cs.IngegneriaDelSoftware.Casotto.Attori.ControllerGestione;

import it.unicam.cs.IngegneriaDelSoftware.Casotto.Attori.Bagnino;
import it.unicam.cs.IngegneriaDelSoftware.Casotto.Attori.bagninoController;
import it.unicam.cs.IngegneriaDelSoftware.Casotto.Servizi.ComandaBalneare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class GestionePrenotazioneBalneare implements Initializable {

    @FXML
    private Button btnEvadiComnda;

    @FXML
    private TableColumn<ComandaBalneare, Timestamp> colDataComanda;

    @FXML
    private TableColumn<ComandaBalneare, String> colIdClienteComanda;

    @FXML
    private TableColumn<ComandaBalneare, String> colIdComanda;

    @FXML
    private TableColumn<ComandaBalneare, String> colMaterialeComanda;

    @FXML
    private TableColumn<ComandaBalneare, Integer> colNumOmbrelloneComanda;

    @FXML
    private TableColumn<ComandaBalneare, Integer> colQuantitaComanda;

    @FXML
    private TableColumn<ComandaBalneare, String> colStatusComanda;

    @FXML
    private TableView<ComandaBalneare> tabComande;

    private ObservableList<ComandaBalneare> ListaComande = FXCollections.observableArrayList();
    private static Bagnino bagnino;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bagnino = bagninoController.bagnino;

        ListaComande.addAll(bagnino.getListaOrdini());

        colDataComanda.setCellValueFactory(new PropertyValueFactory<>("data"));
        colIdClienteComanda.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        colMaterialeComanda.setCellValueFactory(new PropertyValueFactory<>("materiale"));
        colIdComanda.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumOmbrelloneComanda.setCellValueFactory(new PropertyValueFactory<>("numeroOmbrellone"));
        colQuantitaComanda.setCellValueFactory(new PropertyValueFactory<>("quantita"));
        colStatusComanda.setCellValueFactory(new PropertyValueFactory<>("Status"));
        if (!ListaComande.isEmpty())
            tabComande.setItems(ListaComande);

    }

    @FXML
    void evadiComanda(ActionEvent event) {
        ComandaBalneare cb = tabComande.getSelectionModel().getSelectedItem();
        bagnino.evadiComanda(cb.getId());
        this.ListaComande.remove(cb);
    }

}
