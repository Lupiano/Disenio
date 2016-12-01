package ui;

import java.util.Optional;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class ControladorAtributos {
	
	@FXML private MenuButton verAtributos = new MenuButton();
	@FXML private Text atributoActual = new Text();
	@FXML private static Text nombreActual = new Text();
	@FXML private Text mostrarValor = new Text();
	@FXML private TextField valorAtributo = new TextField();
	@FXML private TableView<Contact> tablaEstimulo = new TableView<>();
	@FXML private TableColumn<Contact, String> columnaEstimulo = new TableColumn<>("Estimulo");
	
	@FXML
	private void asignarValor(){
		atributoActual.setText(Modelo.atribActual + valorAtributo.getText());
	}
	
	@FXML
	private void verPerformance(){
		atributoActual.setText("Performance: ");
		Modelo.nombreAtributo = "Performance";
		Modelo.atribActual= "Performance: ";
	}
	
	@FXML
	private void verUsabilidad(){
		atributoActual.setText("Usabilidad: " );
		Modelo.nombreAtributo = "Usabilidad";
		Modelo.atribActual= "Usabilidad: ";
	}
	
	@FXML
	private void verSeguridad(){
		atributoActual.setText("Seguridad: " );
		Modelo.nombreAtributo = "Seguridad";
		Modelo.atribActual= "Seguridad: ";
	}
	
	@FXML
	private void verDisponibilidad(){
		atributoActual.setText("Disponibilidad: " );
		Modelo.nombreAtributo = "Disponibilidad";
		Modelo.atribActual= "Disponibilidad: ";
	}
	
	@FXML
	private void verModificabilidad(){
		atributoActual.setText("Modificabilidad: " );
		Modelo.nombreAtributo = "Modificabilidad";
		Modelo.atribActual= "Modificabilidad: ";
	}
	
	@FXML
	private void verTestability(){
		atributoActual.setText("Testability: ");
		Modelo.nombreAtributo = "Testability";
		Modelo.atribActual= "Testability: ";
	}
	
	@FXML
	private void siguienteHaciaSolucion(){
		/*if (salir == false){
			JOptionPane.showMessageDialog(null, "Error: Debe llenar al menos un componente");
			System.out.println("Entraaa en Solución");
		}
		else*/
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Vista Solucion.fxml"));
				Modelo.primaryStage.setScene(new Scene(root));
				Modelo.primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	/*
	public enum Day { mon, tue, wed, thu, fri }

	public static class WorkDay {
        private final SimpleObjectProperty<Day> day;
  
        private WorkDay(Day day) {
            this.day = new SimpleObjectProperty<>(day);
        }
 
        public Day getDay() {
            return day.get();
        }
 
        public void setDay(Day day) {
            this.day.set(day);
        }
    }*/
	
	@FXML
	private void agregarEscenario(){
		
		try {
			Modelo.escenario.setTitle(Modelo.nombreAtributo);
			Modelo.escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Escenario Calidad.fxml"));
			Modelo.escenario.setScene(new Scene(root));
			
			/*
			TableColumn<WorkDay, Day> dayCol = new TableColumn<>("Work Day");
	        dayCol.setMinWidth(100);
	        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
	        dayCol.setCellFactory(ComboBoxTableCell.<WorkDay, Day>forTableColumn(Day.values()));
	        dayCol.setEditable(true);
	 
	        final ObservableList<WorkDay> data = FXCollections.observableArrayList(
	                new WorkDay(Day.mon),
	                new WorkDay(Day.fri),
	                new WorkDay(Day.thu)
	        );
	        
	        //TableView<WorkDay> table = new TableView<>();
	        tablaEstimulo.setEditable(true);
	        tablaEstimulo.setItems(data);
	        table.getColumns().addAll(dayCol);
	        Modelo.escenario.setScene(new Scene(table));
			
			/*tablaEstimulo.setEditable(true);
			
			columnaEstimulo.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
			columnaEstimulo.setCellFactory(ComboBoxTableCell.forTableColumn("Categoria 1", "Categoria 2", "Categoria 3"));
	        
			tablaEstimulo.getItems().addAll(
	            new Contact("Valor")
	        );*/
			
			Modelo.escenario.show();
			
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	@FXML
	private void salir(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Salir del Programa");
		alert.setContentText("¿Está seguro que desea salir? Los cambios no guardados se perderán.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.exit();
		} 		
	}
	
}
