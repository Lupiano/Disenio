package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import core.EscenarioDeCalidad;
import core.Propiedades;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ControladorComponentes implements Initializable{
	
	private boolean salir = true;
	private final MenuButton atributosCalidad = new MenuButton("Atributo de calidad...");

	private final Button botonAgregarAtributo = new Button ("Agregar");
	private final MenuButton atributosCalidadTradeOff = new MenuButton("Trade Off con...");
	private final MenuButton tipoConector = new MenuButton("Tipo del conector...");
	
	@FXML private MenuButton verConectores = new MenuButton();

	private static String address = "";
	private final TextField valorAtributo = new TextField("");
	private final static TextField nombreAtributo = new TextField("");
	private final Button botonAgregarEscenario = new Button ("Agregar Escenario");
	private final static Button botonCerrarAtributos = new Button ("Guardar Edici�n");
	
	Scene scene = new Scene(new Group(), 930, 600);
	static GridPane grid = new GridPane();
	
	private final CheckBox tradeOff = new CheckBox("Trade off");
	private final Button botonGuardarConector = new Button("Guardar");
	private static final Button botonGuardarEscenario = new Button ("Guardar");
	private Button botonAgregarPropiedades = new Button ("Agregar Propiedades");
	
	final static Label notification = new Label ();
	final static TextField subject = new TextField("");
	final static TextArea text = new TextArea ("");
	
	private static ComboBox<String> valorEstimuloComboBox = new ComboBox<String>();
    private static ComboBox<String> valorRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorFuenteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorAmbienteComboBox = new ComboBox<String>();
    private static ComboBox<String> valorMedidaRespuestaComboBox = new ComboBox<String>();
    private static ComboBox<String> valorArtefactoAfectadoComboBox = new ComboBox<String>();
    @FXML private AnchorPane idPanelConectores;
	
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }
    
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
				Modelo.primaryStage.setTitle("Editar Conector");
				Modelo.primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
				
				grid.setVgap(4);
			    grid.setHgap(10);
			    Group root = (Group)scene.getRoot();
			    root.getChildren().add(grid);
			    Modelo.primaryStage.setScene(scene);
			    grid.setPadding(new Insets(20, 6, 6, 20));
				
		        Label l1 = new Label();
		        l1.setText("Atributos de Calidad");
		        l1.setFont(new Font("Arial", 24));
		        grid.add(l1, 0, 5);
		        
		        Label labelElegirAtributos = new Label();
		        labelElegirAtributos.setText("Elija un atributo de calidad:");
		        labelElegirAtributos.setFont(new Font("Arial", 14));
		        grid.add(labelElegirAtributos, 0, 7);
		        
		        ObservableList<MenuItem> list = FXCollections.observableArrayList();

		        MenuItem item1 = new MenuItem("Performance");
		        MenuItem item2 = new MenuItem("Seguridad");
		        MenuItem item3 = new MenuItem("Modificabilidad");
		        MenuItem item4 = new MenuItem("Testability");
		        MenuItem item5 = new MenuItem("Disponibilidad");
		        MenuItem item6 = new MenuItem("Usabilidad");
		        
		        item1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Performance");
		            	atributosCalidad.setText("Performance");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Performance") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Performance")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });
		        
		        item2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Seguridad");
		            	atributosCalidad.setText("Seguridad");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Seguridad") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Seguridad")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });
		        
		        item3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Modificabilidad");
		            	atributosCalidad.setText("Modificabilidad");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Modificabilidad") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Modificabilidad")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });
		        
		        item4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Testability");
		            	atributosCalidad.setText("Testability");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Testability") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Testability")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });
		        
		        item5.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Disponibilidad");
		            	atributosCalidad.setText("Disponibilidad");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Disponibilidad") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Disponibilidad")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });
		        
		        item6.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	ControladorComponentes.cambiarAtributo("Usabilidad");
		            	atributosCalidad.setText("Usabilidad");
		            	if(Modelo.conectorActual.getAtributosCalidad().get("Usabilidad") != null){
		            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get("Usabilidad")));
		            	}
		            	else{
		            		valorAtributo.setText("0");
		            	}
		            }
		        });  
		        
		        list.addAll(item1,item2,item3,item4,item5,item6);
		        atributosCalidad.getItems().addAll(list);

		        grid.add(atributosCalidad, 0, 9);
		        
		        botonAgregarAtributo.setPrefWidth(60);
		        botonAgregarAtributo.setLayoutX(20);
		        botonAgregarAtributo.setLayoutY(140);
		        root.getChildren().add(botonAgregarAtributo);
		        
		        botonAgregarAtributo.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	agregarAtributo();
		            }
		        });
		        
		        Label l2 = new Label();
		        l2.setText("Valor");
		        l2.setFont(new Font("Arial", 24));
		        l2.setLayoutX(20);
		        l2.setLayoutY(180);
		        root.getChildren().add(l2);
		        
		        Label labelElegirValor = new Label();
		        labelElegirValor.setText("Elija un valor entre 0 y 1:");
		        labelElegirValor.setFont(new Font("Arial", 14));
		        labelElegirValor.setLayoutX(20);
		        labelElegirValor.setLayoutY(210);
		        root.getChildren().add(labelElegirValor);
		        
		        valorAtributo.setPrefWidth(50);
		        valorAtributo.setLayoutX(20);
		        valorAtributo.setLayoutY(230);
		        root.getChildren().add(valorAtributo);
		        
		        valorAtributo.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	if ((Modelo.nombreAtributo != null && !Modelo.nombreAtributo.toString().isEmpty())){
		            		nombreAtributo.setText(Modelo.nombreAtributo + ": " + valorAtributo.getText());
		            		if(Modelo.conectorActual.getAtributosCalidad().get(Modelo.nombreAtributo) != null){
		            			Modelo.conectorActual.getAtributosCalidad().replace(Modelo.nombreAtributo, Float.parseFloat((valorAtributo.getText())));
		            		}
		            		else {
		            			Modelo.conectorActual.getAtributosCalidad().put(Modelo.nombreAtributo, Float.parseFloat(valorAtributo.getText()));
		            		}
		            	}
				        tradeOff.setLayoutX(180);
				        tradeOff.setLayoutY(100);
				        root.getChildren().add(tradeOff);
				        		        
				        tradeOff.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								//Trade off
								
								if (tradeOff.isSelected()){
									
									atributosCalidadTradeOff.setLayoutX(260);
									atributosCalidadTradeOff.setLayoutY(97);
									atributosCalidadTradeOff.setPrefWidth(150);
									root.getChildren().add(atributosCalidadTradeOff);
			        		
					        		for(String s: Modelo.conectorActual.getAtributosCalidad().keySet()){
					        			MenuItem item = new MenuItem(s);
					        			item.setOnAction(new EventHandler<ActionEvent>() {
					        	            @Override
					        	            public void handle(ActionEvent actionEvent) {
					        	            	atributosCalidadTradeOff.setText(s);
					        	            }
					        			});
					        		}
								}
								else
									root.getChildren().remove(atributosCalidadTradeOff);
							}});
		            }
		         });
		        
		        Label escenariosCalidad = new Label();
		        escenariosCalidad.setText("Escenarios de Calidad");
		        escenariosCalidad.setFont(new Font("Arial", 24));
		        escenariosCalidad.setLayoutX(20);
		        escenariosCalidad.setLayoutY(270);
		        root.getChildren().add(escenariosCalidad);
		        
		        botonAgregarEscenario.setLayoutX(270);
		        botonAgregarEscenario.setLayoutY(270);
		        root.getChildren().add(botonAgregarEscenario);
		        
		        Label l5 = new Label();
		        l5.setText("Propiedades");
		        l5.setFont(new Font("Arial", 24));
		        l5.setLayoutX(500);
		        l5.setLayoutY(40);
		        root.getChildren().add(l5);
		        
		        botonAgregarPropiedades.setLayoutX(500);
		        botonAgregarPropiedades.setLayoutY(90);
		        root.getChildren().add(botonAgregarPropiedades);

		        botonAgregarPropiedades.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	ControladorAtributos.AgregarPropiedades();
		            }
		        });
		        
		        botonAgregarEscenario.setOnAction(new EventHandler<ActionEvent>() {
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
		        
		        atributosCalidad.setPrefWidth(150);
		        atributosCalidad.setLayoutX(20);
		        atributosCalidad.setLayoutY(98);
		        root.getChildren().add(atributosCalidad);
		        
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
		
	public static void agregarListaPropiedades(){
		
		ArrayList<Propiedades> lista = Modelo.conectorActual.getPropiedades();
		
		int filaPropiedad = 20;
		
		for(Propiedades p : lista){
				Label l1 = new Label();
				String nombredimensi�n = p.getDimension() + " ->";
				l1.setText(nombredimensi�n);
		        l1.setFont(new Font("Arial", 18));
		        l1.setId(Integer.toString(Modelo.numeroIdPropiedad));
		        grid.add(l1, 19, filaPropiedad);
		        Modelo.numeroIdPropiedad ++;
		        
				Label l2 = new Label();
		        String nombreSubdimension = p.getSubdimension() + " ->";
		        l2.setText(nombreSubdimension);
		        l2.setFont(new Font("Arial", 18)); 
		        l2.setId(Integer.toString(Modelo.numeroIdPropiedad));
		        grid.add(l2, 20, filaPropiedad);
		        Modelo.numeroIdPropiedad ++;
		        	        
				Label l3 = new Label();
		        String nombreValue = p.getValue();
		        l3.setText(nombreValue);
		        l3.setFont(new Font("Arial", 18)); 
		        l3.setId(Integer.toString(Modelo.numeroIdPropiedad));
		        grid.add(l3, 21, filaPropiedad);
		        Modelo.numeroIdPropiedad ++;
		        
		        Button buttonBorrar = new Button ("Borrar");
		        grid.add(buttonBorrar, 22, Modelo.filaPropiedad);
		        
		        filaPropiedad+=4;		        
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
        
        valorNombreConector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	Modelo.hayNombreConector = true;
            	Modelo.conectorActual.setNombre(valorNombreConector.getText());
            }
        });
        
        Label l2 = new Label();
        l2.setText("");
        l2.setText("Tipo del conector: ");
        l2.setFont(new Font("Arial", 18));
        l2.setLayoutX(10);
        l2.setLayoutY(80);
        root.getChildren().add(l2);
        
        ObservableList<MenuItem> list = FXCollections.observableArrayList();

        MenuItem item1 = new MenuItem("Procedure Call");
        MenuItem item2 = new MenuItem("Event");
        MenuItem item3 = new MenuItem("Data Access");
        MenuItem item4 = new MenuItem("Linkage");
        MenuItem item5 = new MenuItem("Stream");
        MenuItem item6 = new MenuItem("Arbitator");
        MenuItem item7 = new MenuItem("Adaptor");
        MenuItem item8 = new MenuItem("Distributor");
        
        list.addAll(item1,item2,item3,item4,item5,item6,item7,item8);
        tipoConector.getItems().addAll(list);
        
        tipoConector.setLayoutX(190);
        tipoConector.setLayoutY(75);
        tipoConector.setPrefWidth(180);
        root.getChildren().add(tipoConector);
       
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Procedure Call");
            	Modelo.conectorActual.SetTipo(item1.getText());
            }
        });
        
        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Event");
            	Modelo.conectorActual.SetTipo(item2.getText());
            }
        });
        
        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Data Access");
            	Modelo.conectorActual.SetTipo(item3.getText());
            }
        });
        
        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Linkage");
            	Modelo.conectorActual.SetTipo(item4.getText());
            }
        });
        
        item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Stream");
            	Modelo.conectorActual.SetTipo(item5.getText());
            }
        });
        
        item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Arbitator");
            	Modelo.conectorActual.SetTipo(item6.getText());
            }
        });
        
        item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Adaptor");
            	Modelo.conectorActual.SetTipo(item7.getText());
            }
        });
        
        item8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	tipoConector.setText("Distributor");
            	Modelo.conectorActual.SetTipo(item8.getText());
            }
        });

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
           
        valorOrigenConector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	Modelo.hayNombreOrigen = true;	
            	Modelo.conectorActual.setComponenteOrigen(valorOrigenConector.getText());
            }
        });
        
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
        
        valorDestinoConector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	Modelo.conectorActual.setComponenteOrigen(valorDestinoConector.getText());
            	Modelo.hayNombreDestino = true;
            }
        });
        
        botonGuardarConector.setLayoutX(300);
        botonGuardarConector.setLayoutY(200);
        root.getChildren().add(botonGuardarConector); 
        
        botonGuardarConector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {            	
            	if (Modelo.hayNombreConector && (tipoConector.getText()!= "Tipo del conector...")
            			&& Modelo.hayNombreDestino && Modelo.hayNombreOrigen){
	            	notification.setText("El conector se ha guardado con �xito");
	            	
	            	//Agrego en la lista de Conectores disponibles
	            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
	                MenuItem conector = new MenuItem(valorNombreConector.getText());
	                list.addAll(conector);
	                verConectores.getItems().addAll(list);
	                
	                conector.setOnAction(new EventHandler<ActionEvent>() {
	                    @Override
	                    public void handle(ActionEvent e) {
	                    	verConectores.setText(conector.getText());
	                    	
	                    }
	                });
	                //Limpio botones
	                valorNombreConector.clear();
	                tipoConector.setText("Tipo del conector...");
	                valorOrigenConector.clear();
	                valorDestinoConector.clear();
	                Modelo.hayNombreConector = false;
	                Modelo.hayNombreDestino = false;
	                Modelo.hayNombreOrigen = false;
	                
            	}
            	else
            		notification.setText("Debes completar todos los campos");
            }
        });
        
        notification.setLayoutX(70);
        notification.setLayoutY(205);
        root.getChildren().add(notification);
        notification.setText("");

        Modelo.conector.setScene(scene);
        Modelo.conector.show();
	}
		
	@FXML
	private void editarConector(){
		siguienteHaciaAtributos();
	}
	
	private static void cambiarAtributo(String elegido){
        nombreAtributo.setText(elegido);
    	Modelo.nombreAtributo = elegido;
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
	
	private void agregarAtributo(){
		Stage escenario = new Stage();
		escenario.setTitle("Nuevo atributo");
		escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
		
        Scene scene = new Scene(new Group(), 250, 120);

        Group root = (Group)scene.getRoot();
        
        TextField nombreNuevoAtributo = new TextField("");
        Label labelNuevoAtributo = new Label("Ingrese el nombre del nuevo atributo:");
        Button botonAgregar = new Button("Agregar");
        
        
        labelNuevoAtributo.setLayoutX(10);
        labelNuevoAtributo.setLayoutY(10);
        
        nombreNuevoAtributo.setPrefWidth(130);
        nombreNuevoAtributo.setLayoutX(10);
        nombreNuevoAtributo.setLayoutY(35);
        
        botonAgregar.setPrefWidth(60);
        botonAgregar.setLayoutX(170);
        botonAgregar.setLayoutY(80);
        
        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	String value = nombreNuevoAtributo.getText();
            	if(value == ""){
            		JOptionPane.showMessageDialog(null, "Complete el nombre del atributo.");
            	}
            	else {
                	char primero = value.charAt(0);
                	String primString = primero + "";
                	value = primString.toUpperCase() + value.substring(1, value.length()).toLowerCase();
                	Float cero = new Float(0);             	
                	Modelo.conectorActual.getAtributosCalidad().put(value, cero);     	
                	actualizarListaAtributos();
                	escenario.close();
            	}
            	
            }
        });
        
        root.getChildren().add(nombreNuevoAtributo);
        root.getChildren().add(labelNuevoAtributo);
        root.getChildren().add(botonAgregar);
        escenario.setScene(scene);
        escenario.show();
        
	}
	
	private void actualizarListaAtributos(){

		ObservableList<MenuItem> list1 = FXCollections.observableArrayList();
		ObservableList<MenuItem> list2 = FXCollections.observableArrayList();
		
		for(String s: Modelo.conectorActual.getAtributosCalidad().keySet()){
			MenuItem item1 = new MenuItem(s);
			MenuItem item2 = new MenuItem(s);
			item1.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent actionEvent) {
	            	ControladorComponentes.cambiarAtributo(s);
	            	atributosCalidad.setText(s);
	            	if(Modelo.conectorActual.getAtributosCalidad().get(s) != null){
	            		valorAtributo.setText(Float.toString(Modelo.conectorActual.getAtributosCalidad().get(s)));
	            	}
	            	else{
	            		valorAtributo.setText("0");
	            	}
	            }
	        });
			
			item2.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent actionEvent) {
	            	atributosCalidadTradeOff.setText(s);
	            }
	        });
			list1.add(item1);
			list2.add(item2);
		}
		
        atributosCalidad.getItems().addAll(list1);
    	atributosCalidadTradeOff.getItems().addAll(list2);
	}	
}