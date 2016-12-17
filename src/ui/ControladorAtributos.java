package ui;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;

import core.EscenarioDeCalidad;
import core.Propiedades;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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
	final static Button botonGuardarPropiedades = new Button("Guardar");
	final static Label notification = new Label ();
	final static TextField subject = new TextField("");
	final static TextArea text = new TextArea ("");
	  
	private static String address = " ";
	private static String valorDimension = "";
	private static String valorSubdimension = "";
	private static String valorValue = "";
	
	
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
	private static void PropiedadesProcedureCall(Group root){
		//Propiedades de Procedure Call
				MenuButton dimension = new MenuButton("Dimensión");
				dimension.setLayoutX(20);
				dimension.setLayoutY(40);
				dimension.setPrefWidth(105);
				root.getChildren().add(dimension);
				
				MenuButton subdimension = new MenuButton("Subdimensión");
				subdimension.setLayoutX(150);
				subdimension.setLayoutY(40);
				subdimension.setPrefWidth(120);
				
				
				MenuButton value = new MenuButton("Value");
				value.setLayoutX(300);
				value.setLayoutY(40);
				value.setPrefWidth(105);
				
				ObservableList<MenuItem> list = FXCollections.observableArrayList();

		        MenuItem item1 = new MenuItem("Parameters");
		        MenuItem item2 = new MenuItem("Entry Point");
		        MenuItem item3 = new MenuItem("Invocation");
		        MenuItem item4 = new MenuItem("Synchronicity");
		        MenuItem item5 = new MenuItem("Cardinality");
		        MenuItem item6 = new MenuItem("Accessibility");
		        
		        item1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	root.getChildren().add(subdimension);
		            	subdimension.getItems().clear();
		            	dimension.setText(item1.getText());
		            	valorDimension = dimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Data transfer");
		                MenuItem item2 = new MenuItem("Semantics");
		                MenuItem item3 = new MenuItem("Return values");
		                MenuItem item4 = new MenuItem("Invocation record");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item1.getText());
		        		        valorSubdimension = subdimension.getText();
		                		
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Reference");
		                        MenuItem item2 = new MenuItem("Value");
		                        MenuItem item3 = new MenuItem("Name");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		    value.setText(item1.getText());
		                        		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item2.getText());
		                    		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item3.getText());
		                    		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        list.addAll(item1,item2,item3);
		                        value.getItems().addAll(list);
		                        
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item2.getText());
		        		        valorSubdimension = subdimension.getText();
		        		        
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Default values");
		                        MenuItem item2 = new MenuItem("Keyword parameters");
		                        MenuItem item3 = new MenuItem("Inline parameters");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		    value.setText(item1.getText());
		                        		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item2.getText());
		                    		    valorValue = value.getText();
		                     
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item3.getText());
		                    		    valorValue = value.getText();
		                  
		                        	}
		                        });
		                        
		                        list.addAll(item1,item2,item3);
		                        value.getItems().addAll(list);
		                	}
		                });
		                
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item3.getText());
		        		        valorSubdimension = subdimension.getText();
		                		value.setText("NULL");
		                		valorValue = value.getText();
		                	}
		                });
		                
		                item4.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item4.getText());
		        		        valorSubdimension = subdimension.getText();
		                		
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Push from L to R");
		                        MenuItem item2 = new MenuItem("Push from R to L");
		                        MenuItem item3 = new MenuItem("Hash table");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		    value.setText(item1.getText()); 
		                        		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item2.getText());
		                    		    valorValue = value.getText();
		                     
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item3.getText());
		                    		    valorValue = value.getText();
		                  
		                        	}
		                        });
		                        
		                        list.addAll(item1,item2,item3);
		                        value.getItems().addAll(list);
		                	}
		                });

		                list.addAll(item1,item2,item3,item4);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        item2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	root.getChildren().add(subdimension);
		            	subdimension.getItems().clear();
		            	dimension.setText(item2.getText());
		            	valorDimension = dimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Multiple");
		                MenuItem item2 = new MenuItem("Single");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		subdimension.setText(item1.getText());
		        		        valorSubdimension = subdimension.getText();
		                		value.setText("No Value");
		                		valorValue = value.getText();
		                    }
		                });
		                        
		                 item2.setOnAction(new EventHandler<ActionEvent>(){
		                	 @Override
		                     public void handle(ActionEvent actionEvent) {
			                		subdimension.setText(item2.getText());
			        		        valorSubdimension = subdimension.getText();
			                		value.setText("No Value");
			                		valorValue = value.getText();
		                     }
		                 });

		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        item3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	
		            	root.getChildren().add(subdimension);
                		subdimension.getItems().clear();
                		
                		dimension.setText(item3.getText());
        		        valorDimension = dimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Explicit");
		                MenuItem item2 = new MenuItem("Implicit");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item1.getText());
		        		        valorSubdimension = subdimension.getText();
		        		        
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Method call");
		                        MenuItem item2 = new MenuItem("Macro call");
		                        MenuItem item3 = new MenuItem("Inline");
		                        MenuItem item4 = new MenuItem("System call");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		    value.setText(item1.getText());
		                        		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item2.getText());
		                    		    valorValue = value.getText();
		                     
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item3.getText()); 
		                    		    valorValue = value.getText();
		                  
		                        	}
		                        });
		                        
		                        item4.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item4.getText());
		                    		    valorValue = value.getText();
		                  
		                        	}
		                        });
		                        
		                        list.addAll(item1,item2,item3,item4);
		                        value.getItems().addAll(list);
		                        
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		
		                		root.getChildren().remove(value);
		                		value.setText("Value");
		                		root.getChildren().add(value);
		                		value.getItems().clear();
		                		subdimension.setText(item2.getText());
		        		        valorSubdimension = subdimension.getText();
		        		        
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Exceptions");
		                        MenuItem item2 = new MenuItem("Callbacks");
		                        MenuItem item3 = new MenuItem("Delegation");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		    value.setText(item1.getText()); 
		                        		    valorValue = value.getText();
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item2.getText());
		                    		    valorValue = value.getText();
		                     
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                    		    value.setText(item3.getText()); 
		                    		    valorValue = value.getText();
		                  
		                        	}
		                        });

		                        list.addAll(item1,item2,item3);
		                        value.getItems().addAll(list);
		                        
		                	}
		                });
		                
		                
		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        item4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	
		            	root.getChildren().add(value);
		            	value.getItems().clear();
		            	
		            	dimension.setText(item4.getText());
		            	valorDimension = dimension.getText();
		            	
		            	subdimension.setText("No Value");
				        valorSubdimension = subdimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Asynchronous");
		                MenuItem item2 = new MenuItem("Synchronous");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                		valorValue = value.getText();
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                		valorValue = value.getText();
		                	}
		                });
		            	
		                list.addAll(item1,item2);
		                value.getItems().addAll(list);	
		            }
		        });
		        
		        item5.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	root.getChildren().add(subdimension);
		            	subdimension.getItems().clear();
		            	dimension.setText(item5.getText());
		            	valorDimension = dimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Fan out");
		                MenuItem item2 = new MenuItem("Fan in");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		subdimension.setText(item1.getText());
		        		        valorSubdimension = subdimension.getText();
		                		value.setText("No Value");
		                		valorValue = value.getText();
		                    }
		                });
		                        
		                 item2.setOnAction(new EventHandler<ActionEvent>(){
		                	 @Override
		                     public void handle(ActionEvent actionEvent) {
			                		subdimension.setText(item2.getText());
			        		        valorSubdimension = subdimension.getText();
			                		value.setText("No Value");
			                		valorValue = value.getText();
		                     }
		                 });

		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        item6.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	
		            	root.getChildren().remove(subdimension);
		            	subdimension.setText("Subdimensión");
		            	
		            	root.getChildren().remove(value);
		            	value.setText("Value");
		            	
		            	root.getChildren().add(value);
		            	value.getItems().clear();
		            	
		            	dimension.setText(item6.getText());
		            	valorDimension = dimension.getText();
		            	
		            	subdimension.setText("No Value");
				        valorSubdimension = subdimension.getText();
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Private");
		                MenuItem item2 = new MenuItem("Protected");
		                MenuItem item3 = new MenuItem("Public");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                		valorValue = value.getText();
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                		valorValue = value.getText();
		                	}
		                });
		                
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item3.getText());
		                		valorValue = value.getText();
		                	}
		                });
		            	
		                list.addAll(item1,item2,item3);
		                value.getItems().addAll(list);	
		            }
		        });
		        
		        list.addAll(item1,item2,item3,item4,item5,item6);
		        dimension.getItems().addAll(list);
	}
	private static void PropiedadesEvent(Group root){
	 //Propiedades de Event
		MenuButton dimension = new MenuButton("Dimensión");
		dimension.setLayoutX(20);
		dimension.setLayoutY(40);
		dimension.setPrefWidth(105);
		root.getChildren().add(dimension);
		
		MenuButton subdimension = new MenuButton("Subdimensión");
		subdimension.setLayoutX(150);
		subdimension.setLayoutY(40);
		subdimension.setPrefWidth(120);
		root.getChildren().add(subdimension);
		
		MenuButton value = new MenuButton("Value");
		value.setLayoutX(300);
		value.setLayoutY(40);
		value.setPrefWidth(105);
		root.getChildren().add(value);
		
		ObservableList<MenuItem> list = FXCollections.observableArrayList();

        MenuItem item1 = new MenuItem("Cardinality");
        MenuItem item2 = new MenuItem("Delivery");
        MenuItem item3 = new MenuItem("Priority");
        MenuItem item4 = new MenuItem("Synchronicity");
        MenuItem item5 = new MenuItem("Notification");
        MenuItem item6 = new MenuItem("Causality");
        MenuItem item7 = new MenuItem("Mode");
        
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item1.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Producers");
                MenuItem item2 = new MenuItem("Observers");
                MenuItem item3 = new MenuItem("Event patterns");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item3.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                list.addAll(item1,item2,item3);
                subdimension.getItems().addAll(list);
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item2.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Best effort");
            	MenuItem item2 = new MenuItem("Exactly once");
            	MenuItem item3 = new MenuItem("At most once");
            	MenuItem item4 = new MenuItem("At least once");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item3.getText());
                	}
                });
                item4.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item4.getText());
                	}
                });
                
                list.addAll(item1,item2,item3,item4);
                value.getItems().addAll(list);
            }
        });

        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item3.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Outgoing");
                MenuItem item2 = new MenuItem("Incoming");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });
        
        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item4.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Synchronous");
            	MenuItem item2 = new MenuItem("Asynchronous");
            	MenuItem item3 = new MenuItem("Time out synchronous");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item3.getText());
                	}
                });

                list.addAll(item1,item2,item3);
                value.getItems().addAll(list);
            }
        });
        
        item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item5.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Polled");
            	MenuItem item2 = new MenuItem("Publish/subscribe");
            	MenuItem item3 = new MenuItem("Central update");
            	MenuItem item4 = new MenuItem("Queued dispatch");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item3.getText());
                	}
                });
                item4.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item4.getText());
                	}
                });
                
                list.addAll(item1,item2,item3,item4);
                value.getItems().addAll(list);
            }
        });
        
        item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item6.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Absolute");
            	MenuItem item2 = new MenuItem("Relative");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });
                
                list.addAll(item1,item2);
                value.getItems().addAll(list);
            }
        });

        item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item7.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Hardware");
                MenuItem item2 = new MenuItem("Software");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Page faults");
                        MenuItem item2 = new MenuItem("Interrupts");
                        MenuItem item3 = new MenuItem("Traps");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());

                        	}
                        });
                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Signals");
                        MenuItem item2 = new MenuItem("GUI input/output");
                        MenuItem item3 = new MenuItem("Triggers");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());

                        	}
                        });
                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });
        
        list.addAll(item1,item2,item3,item4,item5,item6,item7);
        dimension.getItems().addAll(list);
        valorDimension = dimension.getText();
        valorSubdimension = subdimension.getText();
        valorValue = value.getText();
	}
	private static void PropiedadesDataAcces(Group root){
		//Propiedades del Data Acces
				MenuButton dimension = new MenuButton("Dimensión");
				dimension.setLayoutX(20);
				dimension.setLayoutY(40);
				dimension.setPrefWidth(105);
				root.getChildren().add(dimension);
				
				MenuButton subdimension = new MenuButton("Subdimensión");
				subdimension.setLayoutX(150);
				subdimension.setLayoutY(40);
				subdimension.setPrefWidth(120);
				root.getChildren().add(subdimension);
				
				MenuButton value = new MenuButton("Value");
				value.setLayoutX(300);
				value.setLayoutY(40);
				value.setPrefWidth(105);
				root.getChildren().add(value);
				
				ObservableList<MenuItem> list = FXCollections.observableArrayList();
		        MenuItem item1 = new MenuItem("Locality");
		        MenuItem item2 = new MenuItem("Access");
		        MenuItem item3 = new MenuItem("Availability");
		        MenuItem item4 = new MenuItem("Accessibility");
		        MenuItem item5 = new MenuItem("Lifecycle");
		        MenuItem item6 = new MenuItem("Cardinality");
		        
		        item1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item1.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Thread specific");
		            	MenuItem item2 = new MenuItem("Process specific");
		            	MenuItem item3 = new MenuItem("Global");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item3.getText());
		                	}
		                });

		                list.addAll(item1,item2,item3);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item2.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Thread specific");
		            	MenuItem item2 = new MenuItem("Process specific");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	dimension.setText(item3.getText());
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Transient");
		                MenuItem item2 = new MenuItem("Persistent");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item1.getText());
		                		value.setText("Value");
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Register");
		                        MenuItem item2 = new MenuItem("Cache");
		                        MenuItem item3 = new MenuItem("DMA");
		                        MenuItem item4 = new MenuItem("Heap");
		                        MenuItem item5 = new MenuItem("Stack");

		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item1.getText());
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item2.getText());
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item3.getText());

		                        	}
		                        });
		                        item4.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item4.getText());

		                        	}
		                        });
		                        item5.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item5.getText());

		                        	}
		                        });
		                        list.addAll(item1,item2,item3,item4,item5);
		                        value.getItems().addAll(list); 
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item2.getText());
		                		value.setText("Value");
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Repository access");
		                        MenuItem item2 = new MenuItem("File I/O");
		                        MenuItem item3 = new MenuItem("Dynamic data exchange");
		                        MenuItem item4 = new MenuItem("Database Access");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item1.getText());
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item2.getText());
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item3.getText());

		                        	}
		                        });
		                        
		                        item4.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item3.getText());

		                        	}
		                        });
		                        list.addAll(item1,item2,item3,item4);
		                        value.getItems().addAll(list); 
		                	}
		                });
		                
		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        item4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item4.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Private");
		            	MenuItem item2 = new MenuItem("Protected");
		            	MenuItem item3 = new MenuItem("Public");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item3.getText());
		                	}
		                });

		                list.addAll(item1,item2,item3);
		                value.getItems().addAll(list);
		            }
		        });

		        item5.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item5.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Initialization");
		            	MenuItem item2 = new MenuItem("Termination");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item6.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	dimension.setText(item6.getText());
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		               
		            	MenuItem item1 = new MenuItem("Defines");
		                MenuItem item2 = new MenuItem("Uses");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent){
		                		subdimension.setText(item1.getText());
		                		value.setText("NULL");
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		subdimension.setText(item2.getText());
		                		value.setText("NULL");
		                	}
		                });
		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        list.addAll(item1,item2,item3,item4,item5,item6);
		        dimension.getItems().addAll(list);
		        valorDimension = dimension.getText();
		        valorSubdimension = subdimension.getText();
		        valorValue = value.getText();
	}
	private static void PropiedadesLinkage(Group root){
		//Propiedades del Data Acces
		MenuButton dimension = new MenuButton("Dimensión");
		dimension.setLayoutX(20);
		dimension.setLayoutY(40);
		dimension.setPrefWidth(105);
		root.getChildren().add(dimension);
		
		MenuButton subdimension = new MenuButton("Subdimensión");
		subdimension.setLayoutX(150);
		subdimension.setLayoutY(40);
		subdimension.setPrefWidth(120);
		root.getChildren().add(subdimension);
		
		MenuButton value = new MenuButton("Value");
		value.setLayoutX(300);
		value.setLayoutY(40);
		value.setPrefWidth(105);
		root.getChildren().add(value);
		
		ObservableList<MenuItem> list = FXCollections.observableArrayList();
        MenuItem item1 = new MenuItem("Reference");
        MenuItem item2 = new MenuItem("Granularity");
        MenuItem item3 = new MenuItem("Cardinality");
        MenuItem item4 = new MenuItem("Binding");

        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item1.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Implicit");
            	MenuItem item2 = new MenuItem("Explicit");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });

                list.addAll(item1,item2);
                value.getItems().addAll(list);
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item2.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
               
            	MenuItem item1 = new MenuItem("Unit");
                MenuItem item2 = new MenuItem("Syntactic");
                MenuItem item3 = new MenuItem("Semantic");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent){
                		subdimension.setText(item1.getText());
                    	value.getItems().clear();
                		value.setText("NULL");
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        
                    	MenuItem item1 = new MenuItem("Variable");
                        MenuItem item2 = new MenuItem("Procedure");
                        MenuItem item3 = new MenuItem("Function");
                        MenuItem item4 = new MenuItem("Constant");
                        MenuItem item5 = new MenuItem("Type");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });
                        item4.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item4.getText());
                        	}
                        });
                        item5.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item5.getText());
                        	}
                        });
                        
                        list.addAll(item1,item2,item3,item4,item5);
                        value.getItems().addAll(list);
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		subdimension.setText(item3.getText());
                		value.getItems().clear();
                		value.setText("NULL");
                	}
                });
                
                list.addAll(item1,item2,item3);
                subdimension.getItems().addAll(list);
            }
        });
        
        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item3.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Defines");
                MenuItem item2 = new MenuItem("Uses");
                MenuItem item3 = new MenuItem("Provides");
                MenuItem item4 = new MenuItem("Requires");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item3.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                item4.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item4.getText());
                		value.setText("Value");
                		value.setText("NULL");
                	}
                });
                
                list.addAll(item1,item2,item3,item4);
                subdimension.getItems().addAll(list);
            }
        });

        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item4.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Compile-time");
            	MenuItem item2 = new MenuItem("Run-time");
            	MenuItem item3 = new MenuItem("Pre-compile-time");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item3.getText());
                	}
                });

                list.addAll(item1,item2,item3);
                value.getItems().addAll(list);
            }
        });
        
        list.addAll(item1,item2,item3,item4);
        dimension.getItems().addAll(list);    
	}
	private static void PropiedadesSteam(Group root){
		//Propiedades del Steam
				MenuButton dimension = new MenuButton("Dimensión");
				dimension.setLayoutX(20);
				dimension.setLayoutY(40);
				dimension.setPrefWidth(105);
				root.getChildren().add(dimension);
				
				MenuButton subdimension = new MenuButton("Subdimensión");
				subdimension.setLayoutX(150);
				subdimension.setLayoutY(40);
				subdimension.setPrefWidth(120);
				root.getChildren().add(subdimension);
				
				MenuButton value = new MenuButton("Value");
				value.setLayoutX(300);
				value.setLayoutY(40);
				value.setPrefWidth(105);
				root.getChildren().add(value);
				
				ObservableList<MenuItem> list = FXCollections.observableArrayList();
		        MenuItem item1 = new MenuItem("Delivery");
		        MenuItem item2 = new MenuItem("Bounds");
		        MenuItem item3 = new MenuItem("Buffering");
		        MenuItem item4 = new MenuItem("Throughput");
		        MenuItem item5 = new MenuItem("State");
		        MenuItem item6 = new MenuItem("Identity");
		        MenuItem item7 = new MenuItem("Locality");
		        MenuItem item8 = new MenuItem("Synchronicity");
		        MenuItem item9 = new MenuItem("Format");
		        MenuItem item10 = new MenuItem("Cardinality");
		        
		        item1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item1.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Best effort");
		            	MenuItem item2 = new MenuItem("Exactly once");
		            	MenuItem item3 = new MenuItem("At most once");
		            	MenuItem item4 = new MenuItem("At least once");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });
		                
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item3.getText());
		                	}
		                });
		                
		                item4.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item4.getText());
		                	}
		                });

		                list.addAll(item1,item2,item3,item4);
		                value.getItems().addAll(list);
		            }
		        });

		        item2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item2.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Bounded");
		            	MenuItem item2 = new MenuItem("Unbounded");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });

		        item3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item3.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Buffered");
		            	MenuItem item2 = new MenuItem("Unbuffered");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });

		        item4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item4.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Atomic units");
		            	MenuItem item2 = new MenuItem("Higher-order units");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });

		        item5.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item5.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Stateless");
		            	MenuItem item2 = new MenuItem("Stateful");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });

		        item6.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item6.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Named");
		            	MenuItem item2 = new MenuItem("Unnamed");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item7.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item7.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Local");
		            	MenuItem item2 = new MenuItem("Remote");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item8.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item8.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Synchronous");
		            	MenuItem item2 = new MenuItem("Asynchronous");
		            	MenuItem item3 = new MenuItem("Time out synchronous");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });
		                
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item3.getText());
		                	}
		                });

		                list.addAll(item1,item2,item3);
		                value.getItems().addAll(list);
		            }
		        });

		        item9.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	value.getItems().clear();
		            	dimension.setText(item9.getText());
		            	subdimension.setText("NULL");
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		            	
		            	MenuItem item1 = new MenuItem("Raw");
		            	MenuItem item2 = new MenuItem("Structured");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());
		                	}
		                });

		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });
		        
		        item10.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	dimension.setText(item3.getText());
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Binary");
		                MenuItem item2 = new MenuItem("N-ary");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item1.getText());
		                		value.setText("NULL");
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item2.getText());
		                		value.setText("Value");
		                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                        MenuItem item1 = new MenuItem("Multi sender");
		                        MenuItem item2 = new MenuItem("Multi receiver");
		                        MenuItem item3 = new MenuItem("Multi sender/receiver");
		                        
		                        item1.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item1.getText());
		                        	}
		                        });
		                        
		                        item2.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item2.getText());
		                        	}
		                        });
		                        
		                        item3.setOnAction(new EventHandler<ActionEvent>(){
		                        	@Override
		                            public void handle(ActionEvent actionEvent) {
		                        		value.setText(item3.getText());

		                        	}
		                        });
		                        list.addAll(item1,item2,item3);
		                        value.getItems().addAll(list); 
		                	}
		                });
		                
		                list.addAll(item1,item2);
		                subdimension.getItems().addAll(list);
		            }
		        });
		        
		        list.addAll(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10);
		        dimension.getItems().addAll(list);
	}
	private static void PropiedadesArbitrator(Group root){
		//Propiedades del Steam
		MenuButton dimension = new MenuButton("Dimensión");
		dimension.setLayoutX(20);
		dimension.setLayoutY(40);
		dimension.setPrefWidth(105);
		root.getChildren().add(dimension);
		
		MenuButton subdimension = new MenuButton("Subdimensión");
		subdimension.setLayoutX(150);
		subdimension.setLayoutY(40);
		subdimension.setPrefWidth(120);
		root.getChildren().add(subdimension);
		
		MenuButton value = new MenuButton("Value");
		value.setLayoutX(300);
		value.setLayoutY(40);
		value.setPrefWidth(105);
		root.getChildren().add(value);
		
		ObservableList<MenuItem> list = FXCollections.observableArrayList();
        MenuItem item1 = new MenuItem("Fault Handing");
        MenuItem item2 = new MenuItem("Concurrency");
        MenuItem item3 = new MenuItem("Transactions");
        MenuItem item4 = new MenuItem("Security");
        MenuItem item5 = new MenuItem("Scheduling");
        
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	value.getItems().clear();
            	dimension.setText(item1.getText());
            	subdimension.setText("NULL");
            	
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
            	
            	MenuItem item1 = new MenuItem("Authoritative");
            	MenuItem item2 = new MenuItem("Voting");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item1.getText());
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.setText(item2.getText());
                	}
                });

                list.addAll(item1,item2);
                value.getItems().addAll(list);
            }
        });
        
        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item2.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Mechanism");
                MenuItem item2 = new MenuItem("Weight");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Semaphore");
                        MenuItem item2 = new MenuItem("Rendezvous");
                        MenuItem item3 = new MenuItem("Monitor");
                        MenuItem item4 = new MenuItem("Lock");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());

                        	}
                        });
                        
                        item4.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item4.getText());

                        	}
                        });

                        list.addAll(item1,item2,item3,item4);
                        value.getItems().addAll(list);
                        
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Light");
                        MenuItem item2 = new MenuItem("Multi receiver");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });

                        list.addAll(item1,item2);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });
        
        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item3.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Nesting");
                MenuItem item2 = new MenuItem("Awareness");
                MenuItem item3 = new MenuItem("Isolation");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Single");
                        MenuItem item2 = new MenuItem("Multiple");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });

                        list.addAll(item1,item2);
                        value.getItems().addAll(list);
                        
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("None");
                        MenuItem item2 = new MenuItem("Supported");
                        MenuItem item3 = new MenuItem("Required");
                        MenuItem item4 = new MenuItem("New");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });
                        item4.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item4.getText());
                        	}
                        });

                        list.addAll(item1,item2,item3,item4);
                        value.getItems().addAll(list); 
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item3.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Read");
                        MenuItem item2 = new MenuItem("Write");
                        MenuItem item3 = new MenuItem("Read/Write");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });

                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2,item3);
                subdimension.getItems().addAll(list);
            }
        });
        
        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item4.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Authentication");
                MenuItem item2 = new MenuItem("Authorization");
                MenuItem item3 = new MenuItem("Privacy");
                MenuItem item4 = new MenuItem("Integrity");
                MenuItem item5 = new MenuItem("Durability");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("NULL");
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Capabilities");
                        MenuItem item2 = new MenuItem("Access control lists");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });


                        list.addAll(item1,item2);
                        value.getItems().addAll(list); 
                	}
                });
                
                item3.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item3.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Encryption");
                        MenuItem item2 = new MenuItem("Information padding");
                        MenuItem item3 = new MenuItem("Screening");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });

                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                item4.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item4.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Redundancy check");
                        MenuItem item2 = new MenuItem("Certificates");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
  
                        list.addAll(item1,item2);
                        value.getItems().addAll(list); 
                	}
                });

                item5.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item5.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Single session");
                        MenuItem item2 = new MenuItem("Multi session");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
  
                        list.addAll(item1,item2);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2,item3,item4,item5);
                subdimension.getItems().addAll(list);
            }
        });
        list.addAll(item1,item2,item3,item4,item5);
        dimension.getItems().addAll(list);
	}
	private static void PropiedadesAdaptor(Group root){
		//Propiedades de Adaptor
				MenuButton dimension = new MenuButton("Dimensión");
				dimension.setLayoutX(20);
				dimension.setLayoutY(40);
				dimension.setPrefWidth(105);
				root.getChildren().add(dimension);
				
				MenuButton subdimension = new MenuButton("Subdimensión");
				subdimension.setLayoutX(150);
				subdimension.setLayoutY(40);
				subdimension.setPrefWidth(120);
				root.getChildren().add(subdimension);
				
				MenuButton value = new MenuButton("Value");
				value.setLayoutX(300);
				value.setLayoutY(40);
				value.setPrefWidth(105);
				root.getChildren().add(value);
				
				ObservableList<MenuItem> list = FXCollections.observableArrayList();
		        MenuItem item1 = new MenuItem("Invocation Conversion");
		        MenuItem item2 = new MenuItem("Packaging Conversion");
		        MenuItem item3 = new MenuItem("Protocol Conversion");
		        MenuItem item4 = new MenuItem("Presentation Conversion");
		       
		        item1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("Subdimensión");
		            	value.setText("Value");
		            	dimension.setText(item1.getText());
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Address mapping");
		                MenuItem item2 = new MenuItem("Marshalling");
		                MenuItem item3 = new MenuItem("Translation");
		                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item1.getText());
		                		value.setText("NULL");
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item2.getText());
		                		value.setText("NULL");
		                	}
		                });
		                
		                item3.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.getItems().clear();
		                		subdimension.setText(item3.getText());
		                		value.setText("NULL");
		                	}
		                });
		                
		                list.addAll(item1,item2,item3);
		                subdimension.getItems().addAll(list);
		            }
		        });

		        item2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("NULL");
		            	value.setText("Value");
		            	dimension.setText(item2.getText());
		            	
		            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
		                MenuItem item1 = new MenuItem("Wrappers");
		                MenuItem item2 = new MenuItem("Packagers");
	                
		                item1.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item1.getText());
		                	}
		                });
		                
		                item2.setOnAction(new EventHandler<ActionEvent>(){
		                	@Override
		                    public void handle(ActionEvent actionEvent) {
		                		value.setText(item2.getText());		                	}
		                });
		                
		                list.addAll(item1,item2);
		                value.getItems().addAll(list);
		            }
		        });

		        item3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("NULL");
		            	value.getItems().clear();
		            	value.setText("NULL");
		            	dimension.setText(item3.getText());
		            }
		        });

		        item4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	subdimension.getItems().clear();
		            	subdimension.setText("NULL");
		            	value.getItems().clear();
		            	value.setText("NULL");
		            	dimension.setText(item4.getText());
		            }
		        });
		        
		        list.addAll(item1,item2,item3,item4);
		        dimension.getItems().addAll(list);
	}
	private static void PropiedadesDistributor(Group root){
		//Propiedades de Distributor
		MenuButton dimension = new MenuButton("Dimensión");
		dimension.setLayoutX(20);
		dimension.setLayoutY(40);
		dimension.setPrefWidth(105);
		root.getChildren().add(dimension);
		
		MenuButton subdimension = new MenuButton("Subdimensión");
		subdimension.setLayoutX(150);
		subdimension.setLayoutY(40);
		subdimension.setPrefWidth(120);
		root.getChildren().add(subdimension);
		
		MenuButton value = new MenuButton("Value");
		value.setLayoutX(300);
		value.setLayoutY(40);
		value.setPrefWidth(105);
		root.getChildren().add(value);
		
		ObservableList<MenuItem> list = FXCollections.observableArrayList();
        MenuItem item1 = new MenuItem("Naming");
        MenuItem item2 = new MenuItem("Delivery");
        MenuItem item3 = new MenuItem("Routing");

        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item3.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Structure based");
                MenuItem item2 = new MenuItem("Attribute based");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Hierarchical");
                        MenuItem item2 = new MenuItem("Flat");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        list.addAll(item1,item2);
                        value.getItems().addAll(list); 
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("NULL");
                	}
                });

                
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item2.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Semantics");
                MenuItem item2 = new MenuItem("Mechanism");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Best effort");
                        MenuItem item2 = new MenuItem("Exactly once");
                        MenuItem item3 = new MenuItem("At most once");
                        MenuItem item4 = new MenuItem("At least once");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());

                        	}
                        });
                        
                        item4.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item4.getText());

                        	}
                        });

                        list.addAll(item1,item2,item3,item4);
                        value.getItems().addAll(list);
                        
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Unicast");
                        MenuItem item2 = new MenuItem("Multicast");
                        MenuItem item3 = new MenuItem("Broadcast");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });

                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });
        
        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            	subdimension.getItems().clear();
            	subdimension.setText("Subdimensión");
            	value.setText("Value");
            	dimension.setText(item3.getText());
            	ObservableList<MenuItem> list = FXCollections.observableArrayList();
                MenuItem item1 = new MenuItem("Membership");
                MenuItem item2 = new MenuItem("Path");
                
                item1.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item1.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Bounded");
                        MenuItem item2 = new MenuItem("Ad-hoc");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        list.addAll(item1,item2);
                        value.getItems().addAll(list);
                        
                	}
                });
                
                item2.setOnAction(new EventHandler<ActionEvent>(){
                	@Override
                    public void handle(ActionEvent actionEvent) {
                		value.getItems().clear();
                		subdimension.setText(item2.getText());
                		value.setText("Value");
                		ObservableList<MenuItem> list = FXCollections.observableArrayList();
                        MenuItem item1 = new MenuItem("Static");
                        MenuItem item2 = new MenuItem("Cached");
                        MenuItem item3 = new MenuItem("Dynamic");
                        
                        item1.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item1.getText());
                        	}
                        });
                        
                        item2.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item2.getText());
                        	}
                        });
                        
                        item3.setOnAction(new EventHandler<ActionEvent>(){
                        	@Override
                            public void handle(ActionEvent actionEvent) {
                        		value.setText(item3.getText());
                        	}
                        });

                        list.addAll(item1,item2,item3);
                        value.getItems().addAll(list); 
                	}
                });
                
                list.addAll(item1,item2);
                subdimension.getItems().addAll(list);
            }
        });
        
        list.addAll(item1,item2,item3);
        dimension.getItems().addAll(list);
	}
	
	
	@FXML
	public static void AgregarPropiedades(){
		Modelo.agregarPropiedades.setTitle("Agregar Propiedades del Conector: " + Modelo.conectorActual.getNombre());
		Modelo.agregarPropiedades.getIcons().add(new Image("file:resources/imagen/icono.png"));
		notification.setText("");
		Scene scene = new Scene(new Group(), 500, 300);
				       
        GridPane grid = new GridPane();   
             	        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        Modelo.agregarPropiedades.setScene(scene);
        Modelo.agregarPropiedades.show();
        
        Label labelDimension = new Label();
        labelDimension.setText("Dimensión: ");
        labelDimension.setLayoutX(20);
        labelDimension.setLayoutY(10);
        labelDimension.setFont(new Font("Arial", 18));
        root.getChildren().add(labelDimension);
        
        Label labelSubdimension = new Label();
        labelSubdimension.setText("Subdimension: ");
        labelSubdimension.setLayoutX(150);
        labelSubdimension.setLayoutY(10);
        labelSubdimension.setFont(new Font("Arial", 18));
        root.getChildren().add(labelSubdimension);
        
        Label labelValue = new Label();
        labelValue.setText("Value: ");
        labelValue.setLayoutX(300);
        labelValue.setLayoutY(10);
        labelValue.setFont(new Font("Arial", 18));
        root.getChildren().add(labelValue);
		
        if(Modelo.conectorActual.getTipo() == "Procedure Call"){
        	PropiedadesProcedureCall(root);
        }
        if(Modelo.conectorActual.getTipo() == "Event"){
        	PropiedadesEvent(root);
        }
        if(Modelo.conectorActual.getTipo() == "Data Access"){
        	PropiedadesDataAcces(root);
        }
        if(Modelo.conectorActual.getTipo() == "Linkage"){
        	PropiedadesLinkage(root);
        }
        if(Modelo.conectorActual.getTipo() == "Stream"){
        	PropiedadesSteam(root);
        }
        if(Modelo.conectorActual.getTipo() == "Arbitator"){
        	PropiedadesArbitrator(root);
        }
        if(Modelo.conectorActual.getTipo() == "Adaptor"){
        	PropiedadesAdaptor(root);
        }
        if(Modelo.conectorActual.getTipo() == "Adaptor"){
        	PropiedadesAdaptor(root);
        }
        
        botonGuardarPropiedades.setLayoutX(40);
        botonGuardarPropiedades.setLayoutY(250);
		root.getChildren().add(botonGuardarPropiedades);
		
        botonGuardarPropiedades.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	ArrayList<Propiedades> prop = Modelo.conectorActual.getPropiedades();
            	Propiedades p = new Propiedades();
            	p.setDimension(valorDimension);
            	p.setSubdimension(valorSubdimension);
            	p.setValue(valorValue);
            	prop.add(p);
            	notification.setText("Las propiedades se han guardado con éxito");
            	ControladorComponentes.agregarListaPropiedades();
            }
        });
		
		notification.setLayoutX(130);
		notification.setLayoutY(250);
		root.getChildren().add(notification);
	}
	
	@FXML
	public static void agregarEscenario(){
		Modelo.escenario.setTitle(Modelo.nombreAtributo);
		Modelo.escenario.getIcons().add(new Image("file:resources/imagen/icono.png"));
		notification.setText("");
		
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
