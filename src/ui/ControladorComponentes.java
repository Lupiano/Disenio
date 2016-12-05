package ui;

import java.util.ArrayList;
import java.util.Optional;
import javax.swing.JOptionPane;

import core.EscenarioDeCalidad;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ControladorComponentes {
	
	private boolean salir = false;
	private final ComboBox<String> atributosCalidad = new ComboBox<String>();
	private static String address = "";
	private final TextField valorAtributo = new TextField("");
	private final TextField valorNombreConector = new TextField("");
	private final TextField nombreAtributo = new TextField("");
	private final Button buttonAgregar = new Button ("Agregar Escenario");
	private final static Button buttonEditar = new Button ("Editar Escenario");
	private final static Button buttonBorrar = new Button ("Borrar Escenario");
	private final static Button idAgregarComponente = new Button();
	private final static Button botonCerrarAtributos = new Button ("Guardar Edici�n");


	Scene scene = new Scene(new Group(), 800, 600);
	static GridPane grid = new GridPane();
	
	final static Button botonGuardarConector = new Button("Guardar");
	final static Button botonGuardarEscenario = new Button ("Guardar");
	final static Button botonEditarPropiedades = new Button ("Editar Propiedades");
	final static Label notification = new Label ();
	final static TextField subject = new TextField("");
	final static TextArea text = new TextArea ("");
	
    
	private static ComboBox<String> valorEstimuloComboBox = new ComboBox<String>();
    private static ComboBox<String> valorRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorFuenteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorAmbienteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorMedidaRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorArtefactoAfectadoComboBox = new ComboBox<String>();
  
	
	@FXML
	private void salir(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Salir del Programa");
		alert.setContentText("�Est� seguro que desea salir? Los cambios no guardados se perder�n.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.exit();
		} 		
	}
	
	@FXML
	private String getAddress(){
		return address;
	}
	
	@FXML
	private void siguienteHaciaAtributos(){
		if (salir == false){
			JOptionPane.showMessageDialog(null, "Error: Debe llenar al menos un componente");
			System.out.println("Entraaa en siguiente");
		}
		else
			try {
				/*Parent root = FXMLLoader.load(getClass().getResource("Vista Atributos Calidad.fxml"));
				Modelo.primaryStage.setScene(new Scene(root));*/
				Modelo.primaryStage.setTitle("Editar Conector");
				Modelo.primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
				
				grid.setVgap(4);
			    grid.setHgap(10);
			    Group root = (Group)scene.getRoot();
			    root.getChildren().add(grid);
			    Modelo.primaryStage.setScene(scene);
			    grid.setPadding(new Insets(6, 6, 6, 6));
				
		       
		        Label l1 = new Label();
		        l1.setText("Atributos de Calidad");
		        l1.setFont(new Font("Arial", 24));
		        grid.add(l1, 0, 5);
		        
		        atributosCalidad.setPromptText("Atributos de Calidad:");
		        atributosCalidad.setEditable(true);        
		        atributosCalidad.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
		        
		      //ComboBox AtributosCalidad
		        atributosCalidad.getItems().addAll(
		            "Performance",
		            "Seguridad",
		            "Modificabilidad",
		            "Testability",
		            "Disponibilidad",
		            "Usabilidad"
		        );
		        
		        grid.add(atributosCalidad, 0, 9);
		        
		        Label l2 = new Label();
		        l2.setText("Valor");
		        l2.setFont(new Font("Arial", 24));
		        grid.add(l2, 0, 18);
		        
		        valorAtributo.setPrefWidth(50);
		        valorAtributo.setLayoutX(10);
		        valorAtributo.setLayoutY(160);
		        root.getChildren().add(valorAtributo);
		        
		       // grid.add (valorAtributo, 0,20);
		        /*nombreAtributo.setPrefWidth(250);
		        nombreAtributo.setFont(new Font("Arial", 24));
		        nombreAtributo.setDisable(true);
		        grid.add(nombreAtributo, 5, 5);*/
		        
		        atributosCalidad.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	nombreAtributo.setText(atributosCalidad.getValue());
		            	Modelo.nombreAtributo = atributosCalidad.getValue();
		            	ControladorComponentes.borrarBotonesEscenarios();
		            	Modelo.numero = 1;
		            	Modelo.listaBotones = Modelo.hashAtributos.get(Modelo.nombreAtributo);
		            	if(Modelo.listaBotones != null){
			            	ControladorComponentes.generarBotonesEscenarios();
		            	}
		            	else{
		            		Modelo.listaBotones = new ArrayList<ArrayList<Labeled>>();
		            	}
		            }
		          }
		        );
		        
		        valorAtributo.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	if ((atributosCalidad.getValue() != null && !atributosCalidad.getValue().toString().isEmpty())){
		            		nombreAtributo.setText(atributosCalidad.getValue() + ": " + valorAtributo.getText());
		            	}
		            }
		        });
		        
		        Label l3 = new Label();
		        l3.setText("(entre 0 y 1)");
		        l3.setFont(new Font("Arial", 16));
		        l3.setLayoutX(70);
		        l3.setLayoutY(160);
		        root.getChildren().add(l3);
		        
		        Label l4 = new Label();
		        l4.setText("Escenarios de Calidad");
		        l4.setFont(new Font("Arial", 24));
		        grid.add(l4, 0, 30);
		        
		        Label l5 = new Label();
		        l5.setText("Propiedades");
		        l5.setFont(new Font("Arial", 24));
		        grid.add(l5,7, 5);
		        
		        grid.add(botonEditarPropiedades, 7, 9);
		        grid.add(buttonAgregar, 1,30);
		        
		        botonEditarPropiedades.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	ControladorAtributos.editarPropiedades();
		            }
		        });
		        
		        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	ControladorAtributos.agregarEscenario();
		            }
		        });
		        		        
		        botonCerrarAtributos.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	Modelo.primaryStage.close();
		            }}
		        );
		        
		        botonCerrarAtributos.setLayoutX(650);
		        botonCerrarAtributos.setLayoutY(500);
		        root.getChildren().add(botonCerrarAtributos);
		        
		        Modelo.primaryStage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	

	@FXML
	public void siguienteHaciaSolucion(){
		try {
			Modelo.primaryStage.setTitle("Soluci�n Arquitectura");
			Parent root = FXMLLoader.load(getClass().getResource("/ui/Vista Solucion.fxml"));
			Modelo.primaryStage.setScene(new Scene(root));
			Modelo.primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
		}
	}
		
	public static void agregarListaEscenario(){
		
        Label l1 = new Label();
        String nombrefinal = "Escenario" + Modelo.numero;
        l1.setText(nombrefinal);
        l1.setFont(new Font("Arial", 18)); 
        l1.setId(Integer.toString(Modelo.numeroId));
        Modelo.numeroId ++;

    	Button buttonEditar = new Button ("Editar Escenario");
    	
    	Button buttonBorrar = new Button ("Borrar Escenario");
    	buttonBorrar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				ArrayList<Labeled> aBorrar = new ArrayList<Labeled>();
				
				//Se borran todos los botones de la interfaz.
				Modelo.fila -= Modelo.listaBotones.size() * 4;
				for(ArrayList<Labeled> arr: Modelo.listaBotones){
					grid.getChildren().removeAll(arr);
					//Se borran los botones a eliminar de la lista de botones.
					if(arr.contains(l1)){
						aBorrar = arr;
					}
				}

				Modelo.listaBotones.remove(aBorrar);
				
				generarBotonesEscenarios();
				
			}	
			
    	});
    	
    	buttonEditar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				//Se obtiene el escenario de calidad que corresponde a este boton.
				EscenarioDeCalidad escenarioAEditar = Modelo.conectorActual.getEscenariosCalidad().get(Modelo.nombreAtributo).get(l1.getId());
				editarEscenario(escenarioAEditar.getValores(), l1.getId());
			}	
			
    	});
    	
        grid.add(l1, 0, Modelo.fila);
        grid.add(buttonEditar, 1, Modelo.fila);
        grid.add(buttonBorrar, 2, Modelo.fila);
        
        ArrayList<Labeled> aux = new ArrayList<Labeled>();
        aux.add(l1);
        aux.add(buttonEditar);
        aux.add(buttonBorrar);
        Modelo.listaBotones.add(aux);
        
        Modelo.hashAtributos.remove(Modelo.nombreAtributo);
        Modelo.hashAtributos.put(Modelo.nombreAtributo, Modelo.listaBotones);
        
        Modelo.numero++;
        Modelo.fila+= 4;
        
	}
	
	private static void editarEscenario(ArrayList<String> valores, String id){
		Modelo.escenario.setTitle("Editar " + Modelo.nombreAtributo);
		Modelo.escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
		
        Scene scene = new Scene(new Group(), 500, 300);
        boolean hayValores = true;
        
        if(valores == null){
        	hayValores = false;
        }
        
        //ComboBox Est�mulo
        
        valorEstimuloComboBox.getItems().addAll(
                "valorEstimulo1",
                "valorEstimulo2",
                "valorEstimulo3"
            );
        
        if(hayValores){
            valorEstimuloComboBox.setValue(valores.get(0));
        }
        
        valorEstimuloComboBox.setPromptText("Valor Est�mulo");
        valorEstimuloComboBox.setEditable(true);        
        valorEstimuloComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Respuesta
        valorRespuestaComboBox.getItems().addAll(
            "valorRespuesta1",
            "valorRespuesta2",
            "valorRespuesta3"
        );
        
        if(hayValores){
        	valorRespuestaComboBox.setValue(valores.get(1));
        	notification.setText("");
        }
        valorRespuestaComboBox.setPromptText("Valor Respuesta");
        valorRespuestaComboBox.setEditable(true);        
        valorRespuestaComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
      //ComboBox Fuente
        valorFuenteComboBox.getItems().addAll(
            "valorFuente1",
            "valorFuente2",
            "valorFuente3"
        );

        if(hayValores){
        	valorFuenteComboBox.setValue(valores.get(2));
        }
        valorFuenteComboBox.setPromptText("Valor Fuente del Est�mulo");
        valorFuenteComboBox.setEditable(true);        
        valorFuenteComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
      //ComboBox Medida de Respuesta
        valorMedidaRespuestaComboBox.getItems().addAll(
            "valorMedidaRespuesta1",
            "valorMedidaRespuesta2",
            "valorMedidaRespuesta3"
        );

        if(hayValores){
        	valorMedidaRespuestaComboBox.setValue(valores.get(3));
        }
        valorMedidaRespuestaComboBox.setPromptText("Valor Medida de la Respuesta");
        valorMedidaRespuestaComboBox.setEditable(true);        
        valorMedidaRespuestaComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Artefacto Afectado
        valorArtefactoAfectadoComboBox.getItems().addAll(
            "valorArtefactoAfectado1",
            "valorArtefactoAfectado2",
            "valorArtefactoAfectado3"
        );

        if(hayValores){
        	valorArtefactoAfectadoComboBox.setValue(valores.get(4));
        }
        valorArtefactoAfectadoComboBox.setPromptText("Valor Artefacto Afectado");
        valorArtefactoAfectadoComboBox.setEditable(true);        
        valorArtefactoAfectadoComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        //ComboBox Ambiente
        valorAmbienteComboBox.getItems().addAll(
            "valorAmbienteComboBox1",
            "valorAmbienteComboBox2",
            "valorAmbienteComboBox3"
        );

        if(hayValores){
        	valorAmbienteComboBox.setValue(valores.get(5));
        }
        valorAmbienteComboBox.setPromptText("Valor Ambiente");
        valorAmbienteComboBox.setEditable(true);        
        valorAmbienteComboBox.valueProperty().addListener((ChangeListener<String>) (ov, t, t1) -> address = t1);
        
        botonGuardarEscenario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((valorEstimuloComboBox.getValue() != null && !valorEstimuloComboBox.getValue().toString().isEmpty()) &&
                		(valorRespuestaComboBox.getValue() != null && !valorRespuestaComboBox.getValue().toString().isEmpty())&&
                			(valorFuenteComboBox.getValue() != null && !valorFuenteComboBox.getValue().toString().isEmpty())&&
                				(valorMedidaRespuestaComboBox.getValue() != null && !valorMedidaRespuestaComboBox.getValue().toString().isEmpty())&&
                					(valorArtefactoAfectadoComboBox.getValue() != null && !valorArtefactoAfectadoComboBox.getValue().toString().isEmpty())&&
                						(valorAmbienteComboBox.getValue() != null && !valorAmbienteComboBox.getValue().toString().isEmpty())){
                        
                		//Se guardan los valores en el objecto EscenarioDeCalidad.
                		EscenarioDeCalidad aEditar = Modelo.conectorActual.getEscenariosCalidad().get(Modelo.nombreAtributo).get(id);
                		ArrayList<String> arrAux = new ArrayList<String>();
                		arrAux.add(valorEstimuloComboBox.getValue());
                		arrAux.add(valorRespuestaComboBox.getValue());
                		arrAux.add(valorFuenteComboBox.getValue());
                		arrAux.add(valorMedidaRespuestaComboBox.getValue());
                		arrAux.add(valorArtefactoAfectadoComboBox.getValue());
                		arrAux.add(valorAmbienteComboBox.getValue());
                		aEditar.setValores(arrAux);
                		
                        notification.setText("El escenario se ha editado con �xito");
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
        grid.add(new Label("Est�mulo: "), 0, 2);
        grid.add(valorEstimuloComboBox, 1, 2);
        grid.add(new Label("Respuesta: "), 0, 3);
        grid.add(valorRespuestaComboBox, 1,3);
        grid.add(new Label("Fuente del Est�mulo: "), 0, 4);
        grid.add(valorFuenteComboBox, 1,4);
        grid.add(new Label("Medida de la Respuesta: "), 0, 5);
        grid.add(valorMedidaRespuestaComboBox, 1,5);
        grid.add(new Label("Artefacto Afectado: "), 0, 6);
        grid.add(valorArtefactoAfectadoComboBox, 1,6);
        grid.add(new Label("Ambiente: "), 0, 7);
        grid.add(valorAmbienteComboBox, 1,7);
        grid.add(botonGuardarEscenario, 0,13);
        grid.add (notification, 1,13, 13, 1);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        Modelo.escenario.setScene(scene);
        Modelo.escenario.show();
	}
	
	public static void borrarBotonesEscenarios(){
		//Se borran todos los botones de la interfaz.
		Modelo.fila -= Modelo.listaBotones.size() * 4;
		for(ArrayList<Labeled> arr: Modelo.listaBotones){
			grid.getChildren().removeAll(arr);
		}
	}
	
	public static void generarBotonesEscenarios(){
		Modelo.numero = 1;
		//Se vuelven a generar los botones.
		for(ArrayList<Labeled> arr: Modelo.listaBotones){
			arr.get(0).setText("Escenario" + Modelo.numero);
			grid.add(arr.get(0), 0, Modelo.fila);
			grid.add(arr.get(1), 1, Modelo.fila);
			grid.add(arr.get(2), 2, Modelo.fila);
	        Modelo.fila += 4;
	        Modelo.numero ++;
		}
	}
	
	@FXML
	private void agregarConector(){
		Modelo.conector.setTitle("Agregar Conector");
		Modelo.conector.getIcons().add(new Image("file:resources/imagen/icono.png"));
		
		Scene scene = new Scene(new Group(), 400, 250);
		
        botonGuardarConector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	notification.setText("El conector se ha guardado con �xito");                        
                subject.clear();
                text.clear();
            }
        });
        
        
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(6, 6, 6, 6));
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
       
        Label l1 = new Label();
        l1.setText("Nombre del conector: ");
        l1.setFont(new Font("Arial", 18));
        l1.setLayoutX(10);
        l1.setLayoutY(40);
        root.getChildren().add(l1);
        
        TextField valorNombreConector = new TextField();
        valorNombreConector.setPrefWidth(180);
          valorNombreConector.setFont(new Font("Arial", 18));
        valorNombreConector.setLayoutX(190);
        valorNombreConector.setLayoutY(35);
        root.getChildren().add(valorNombreConector);
        
        
        Label l2 = new Label();
        l2.setText("Tipo del conector: ");
        l2.setFont(new Font("Arial", 18));
        l2.setLayoutX(10);
        l2.setLayoutY(80);
        root.getChildren().add(l2);
        
        
        
        Label l3 = new Label();
        l3.setText("Componente Origen: ");
        l3.setFont(new Font("Arial", 18));
        l3.setLayoutX(10);
        l3.setLayoutY(120);
        root.getChildren().add(l3);
        
        TextField valorOrigenConector = new TextField();
        valorOrigenConector.setPrefWidth(180);
        valorOrigenConector.setFont(new Font("Arial", 18));
        valorOrigenConector.setLayoutX(190);
        valorOrigenConector.setLayoutY(110);
        root.getChildren().add(valorOrigenConector);
        
        Label l4 = new Label();
        l4.setText("Componente Destino: ");
        l4.setFont(new Font("Arial", 18));
        l4.setLayoutX(10);
        l4.setLayoutY(160);
        root.getChildren().add(l4);
        
        TextField valorDestinoConector = new TextField();
        valorDestinoConector.setPrefWidth(180);
        valorDestinoConector.setFont(new Font("Arial", 18));
        valorDestinoConector.setLayoutX(190);
        valorDestinoConector.setLayoutY(150);
        root.getChildren().add(valorDestinoConector);
        
        botonGuardarConector.setLayoutX(300);
        botonGuardarConector.setLayoutY(200);
        root.getChildren().add(botonGuardarConector);
        
        notification.setLayoutX(70);
        notification.setLayoutY(205);
        root.getChildren().add(notification);
        

        Modelo.conector.setScene(scene);
        Modelo.conector.show();
	}
	
	@FXML
	private void eliminarComponente(){
	}
}