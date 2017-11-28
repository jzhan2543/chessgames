import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.beans.binding.Bindings;
import javafx.application.Platform;
import javafx.scene.control.Alert;


public class ChessGui extends Application {

    private TableView<ChessGame> table = new TableView<ChessGame>();
    Stage stage;

    private ChessDb dataBase = new ChessDb();
    private final ObservableList<ChessGame> data =
        FXCollections.observableArrayList(dataBase.getGames());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        table = createTable(data);
        Button viewButton = new Button();
        viewButton.setText("View Game");
        viewButton.setOnAction(e -> {
            ChessGame moves = table.getSelectionModel().getSelectedItem();
            viewMoves(moves);
        });
        viewButton.disableProperty()
            .bind(Bindings.isNull(table.getSelectionModel().selectedItemProperty()));

        Button dismissButton = new Button();
        dismissButton.setText("Dismiss");
        dismissButton.setOnAction(e -> Platform.exit());

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(viewButton , dismissButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table , entryBox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("ChessGame GUI");
        stage.show();
    }

    private TableView<ChessGame> createTable(ObservableList<ChessGame> cg) {
        TableView<ChessGame> table = new TableView<ChessGame>();
        table.setItems(cg);

        TableColumn event = new TableColumn("Event");
        event.setMinWidth(300);
        event.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("event"));
        TableColumn site = new TableColumn("Site");
        site.setMinWidth(200);
        site.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("site"));
        TableColumn date = new TableColumn("Date");
        date.setMinWidth(100);
        date.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("date"));
        TableColumn white = new TableColumn("White");
        white.setMinWidth(200);
        white.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("white"));
        TableColumn black = new TableColumn("Black");
        black.setMinWidth(200);
        black.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("black"));
        TableColumn result = new TableColumn("Result");
        result.setMinWidth(100);
        result.setCellValueFactory(
            new PropertyValueFactory<ChessGame, String>("result"));

        table.getColumns().addAll(event, site, date, white, black, result);
        return table;
    }

    private void viewMoves(ChessGame cg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(cg.getEvent());
        alert.setHeaderText("Moves");
        String moves = "";
        for (int i = 1; i < cg.size(); i++) {
            moves = moves + cg.getMove(i) + " ";
        }
        alert.setContentText(moves);
        alert.showAndWait();
    }
}
