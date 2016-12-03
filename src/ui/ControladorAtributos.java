package ui;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;

import core.EscenarioDeCalidad;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.event.EventHandler;

public class ControladorAtributos {
	
	@FXML private MenuButton verAtributos = new MenuButton();
	@FXML private Text atributoActual = new Text();
	@FXML private static Text nombreActual = new Text();
	@FXML private Text mostrarValor = new Text();
	@FXML private TextField valorAtributo = new TextField();
	@FXML private TableView<Contact> tablaEstimulo = new TableView<>();
	@FXML private TableColumn<Contact, String> columnaEstimulo = new TableColumn<>("Estimulo");
	
	final static Button button = new Button ("Guardar");
	final static Label notification = new Label ();
	final static TextField subject = new TextField("");
	final static TextArea text = new TextArea ("");
	  
	private static String address = " ";
	
	
	//ComboBoxs
    private static ComboBox<String> valorEstimuloComboBox = new ComboBox<String>();
    private static ComboBox<String> valorRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorFuenteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorAmbienteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorMedidaRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorArtefactoAfectadoComboBox = new ComboBox<String>();
    
	public String getAddres(){
		return address;
	}
    
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
	
	@FXML
	public static void agregarEscenario(){
		Modelo.escenario.setTitle(Modelo.nombreAtributo);
		Modelo.escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
		
        Scene scene = new Scene(new Group(), 500, 300);
        
        //ComboBox Estímulo
        valorEstimuloComboBox.getItems().addAll(
                "valorEstimulo1",
                "valorEstimulo2",
                "valorEstimulo3"
            );
        
        valorEstimuloComboBox.setPromptText("Valor Estímulo");
        valorEstimuloComboBox.setEditable(true);        
        valorEstimuloComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Respuesta
        valorRespuestaComboBox.getItems().addAll(
            "valorRespuesta1",
            "valorRespuesta2",
            "valorRespuesta3"
        );
        
        valorRespuestaComboBox.setPromptText("Valor Respuesta");
        valorRespuestaComboBox.setEditable(true);        
        valorRespuestaComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
      //ComboBox Fuente
        valorFuenteComboBox.getItems().addAll(
            "valorFuente1",
            "valorFuente2",
            "valorFuente3"
        );
        
        valorFuenteComboBox.setPromptText("Valor Fuente del Estímulo");
        valorFuenteComboBox.setEditable(true);        
        valorFuenteComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
      //ComboBox Medida de Respuesta
        valorMedidaRespuestaComboBox.getItems().addAll(
            "valorMedidaRespuesta1",
            "valorMedidaRespuesta2",
            "valorMedidaRespuesta3"
        );

        valorMedidaRespuestaComboBox.setPromptText("Valor Medida de la Respuesta");
        valorMedidaRespuestaComboBox.setEditable(true);        
        valorMedidaRespuestaComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Artefacto Afectado
        valorArtefactoAfectadoComboBox.getItems().addAll(
            "valorArtefactoAfectado1",
            "valorArtefactoAfectado2",
            "valorArtefactoAfectado3"
        );
        
        valorArtefactoAfectadoComboBox.setPromptText("Valor Artefacto Afectado");
        valorArtefactoAfectadoComboBox.setEditable(true);        
        valorArtefactoAfectadoComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Ambiente
        valorAmbienteComboBox.getItems().addAll(
            "valorAmbienteComboBox1",
            "valorAmbienteComboBox2",
            "valorAmbienteComboBox3"
        );
        
        valorAmbienteComboBox.setPromptText("Valor Ambiente");
        valorAmbienteComboBox.setEditable(true);        
        valorAmbienteComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((valorEstimuloComboBox.getValue() != null && !valorEstimuloComboBox.getValue().toString().isEmpty()) &&
                		(valorRespuestaComboBox.getValue() != null && !valorRespuestaComboBox.getValue().toString().isEmpty())&&
                			(valorFuenteComboBox.getValue() != null && !valorFuenteComboBox.getValue().toString().isEmpty())&&
                				(valorMedidaRespuestaComboBox.getValue() != null && !valorMedidaRespuestaComboBox.getValue().toString().isEmpty())&&
                					(valorArtefactoAfectadoComboBox.getValue() != null && !valorArtefactoAfectadoComboBox.getValue().toString().isEmpty())&&
                						(valorAmbienteComboBox.getValue() != null && !valorAmbienteComboBox.getValue().toString().isEmpty())){
                        
                		EscenarioDeCalidad aGuardar = new EscenarioDeCalidad();
                		ArrayList<String> arrAux = new ArrayList<String>();
                		arrAux.add(valorEstimuloComboBox.getValue());
                		arrAux.add(valorRespuestaComboBox.getValue());
                		arrAux.add(valorFuenteComboBox.getValue());
                		arrAux.add(valorMedidaRespuestaComboBox.getValue());
                		arrAux.add(valorArtefactoAfectadoComboBox.getValue());
                		arrAux.add(valorAmbienteComboBox.getValue());
                		aGuardar.setValores(arrAux);
                		
                		if(Modelo.conectorActual.getEscenariosCalidad().get(Modelo.nombreAtributo) != null){
                			Modelo.conectorActual.getEscenariosCalidad().get(Modelo.nombreAtributo).put(Integer.toString(Modelo.numeroId), aGuardar);
                		}
                		else {
                			Hashtable<String,EscenarioDeCalidad> hashAux = new Hashtable<String,EscenarioDeCalidad>();
                			hashAux.put(Integer.toString(Modelo.numeroId), aGuardar);
                			Modelo.conectorActual.getEscenariosCalidad().put(Modelo.nombreAtributo, hashAux);
                		}
                		
                		
                		
                		notification.setText("El escenario se ha guardado con éxito");                        
                        valorEstimuloComboBox.setValue(null);
                        valorRespuestaComboBox.setValue(null);
                        valorFuenteComboBox.setValue(null);
                        valorMedidaRespuestaComboBox.setValue(null);
                        valorArtefactoAfectadoComboBox.setValue(null);
                        valorAmbienteComboBox.setValue(null);
                        subject.clear();
                        text.clear();
                        ControladorComponentes.agregarListaEscenario();
                }
                else {
                    notification.setText("Debes completar todos los campos antes de guardar"); 
                }
            }
        });
 
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(6, 6, 6, 6));
        grid.add(new Label("Agregar Escenario de Calidad: "), 0, 0);
        grid.add(new Label("Estímulo: "), 0, 2);
        grid.add(valorEstimuloComboBox, 1, 2);
        grid.add(new Label("Respuesta: "), 0, 3);
        grid.add(valorRespuestaComboBox, 1,3);
        grid.add(new Label("Fuente del Estímulo: "), 0, 4);
        grid.add(valorFuenteComboBox, 1,4);
        grid.add(new Label("Medida de la Respuesta: "), 0, 5);
        grid.add(valorMedidaRespuestaComboBox, 1,5);
        grid.add(new Label("Artefacto Afectado: "), 0, 6);
        grid.add(valorArtefactoAfectadoComboBox, 1,6);
        grid.add(new Label("Ambiente: "), 0, 7);
        grid.add(valorAmbienteComboBox, 1,7);
        grid.add(button, 0,13);
        grid.add (notification, 1,13, 13, 1);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        Modelo.escenario.setScene(scene);
        Modelo.escenario.show();
	}
		
		
		
		
		/*try {
			Modelo.escenario.setTitle(Modelo.nombreAtributo);
			Modelo.escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Escenario Calidad.fxml"));
			Modelo.escenario.setScene(new Scene(root));			
			Modelo.escenario.show();
			
		} catch(Exception e) {
		e.printStackTrace();
		}*/
	
	
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
