package ui;

import java.net.URL;
import java.util.ResourceBundle;

import core.Propiedades;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControladorPropiedadesDelConector implements Initializable{

	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		switch (Modelo.conectorActual.getTipo()){
		case "Procedure Call": MenuButtonProcedureCall(); break;
		case "Event": MenuButtonEvent(); break;
		case "Data Access": MenuButtonDataAccess(); break;
		case "Linkage": MenuButtonLinkage(); break;
		case "Stream": MenuButtonStream(); break;
		case "Arbitrator": MenuButtonArbitrator(); break;
		case "Adaptor": MenuButtonAdaptor(); break;
		case "Distributor": MenuButtonDistributor(); break;
		}
	}

	ControladorAtributos cA = Modelo.controladorAtributo;
	@FXML private AnchorPane panelPropiedadesConector;
	@FXML private Text l1 = new Text("");
	@FXML private MenuButton MenuButtonDimension = new MenuButton();
	@FXML private MenuButton MenuButtonSubdimension = new MenuButton();
	@FXML private MenuButton MenuButtonValor = new MenuButton();
	
	private void MenuButtonProcedureCall(){
		MenuButtonDimension.getItems().removeAll();
		ObservableList<MenuItem> listaProcedureCall = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Parameters");
		MenuItem item2 = new MenuItem("Entry Point");
		MenuItem item3 = new MenuItem("Invocation");
		MenuItem item4 = new MenuItem("Synchronicity PC");
		MenuItem item5 = new MenuItem("Cardinality PC");
		MenuItem item6 = new MenuItem("Accessibility");
		listaProcedureCall.addAll(item1,item2,item3,item4,item5,item6);
		MenuButtonDimension.getItems().addAll(listaProcedureCall);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setDisable(false);
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonValor.setText("Opciones");
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaParameters = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Data Transfer");
        		MenuItem item2 = new MenuItem("Semantics");
        		MenuItem item3 = new MenuItem("Return Values");
        		MenuItem item4 = new MenuItem("Invocation Record");
        		listaParameters.addAll(item1,item2,item3,item4);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	
                    	ObservableList<MenuItem> listaDataTransfer = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Reference");
                		MenuItem item2 = new MenuItem("Value");
                		MenuItem item3 = new MenuItem("Name");
                		listaDataTransfer.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaDataTransfer);	
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	ObservableList<MenuItem> listaSemantics = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Default Values");
                		MenuItem item2 = new MenuItem("Keyword Parameters");
                		MenuItem item3 = new MenuItem("Inline Parameters");
                		listaSemantics.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaSemantics);	
                    	
                    }
                });
        		
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonSubdimension.setText(item3.getText());
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonValor.setDisable(true);
                    }
                });
        		
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item4.getText());
                    	
                    	ObservableList<MenuItem> listaInvocationRecord = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Push From L To R");
                		MenuItem item2 = new MenuItem("Push From R To L");
                		MenuItem item3 = new MenuItem("Hash Table");
                		listaInvocationRecord.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaInvocationRecord);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaParameters);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonValor.setDisable(false);
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaEntryPoint = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Multiple");
        		MenuItem item2 = new MenuItem("Single");
        		listaEntryPoint.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaEntryPoint);
            }
        });

		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaInvocation = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Explicit");
        		MenuItem item2 = new MenuItem("Implicit");
        		listaInvocation.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	
                    	ObservableList<MenuItem> listaExplicit = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Method call");
                		MenuItem item2 = new MenuItem("Macro call");
                		MenuItem item3 = new MenuItem("Inline");
                		MenuItem item4 = new MenuItem("System call");
                		listaExplicit.addAll(item1,item2,item3,item4);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		MenuButtonValor.getItems().addAll(listaExplicit);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	ObservableList<MenuItem> listaImplicit = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Exceptions");
                		MenuItem item2 = new MenuItem("Callbacks");
                		MenuItem item3 = new MenuItem("Delegation");
                		listaImplicit.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		MenuButtonValor.getItems().addAll(listaImplicit);	
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaInvocation);
            }
        });

		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaSynchronicity = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Asynchronous");
        		MenuItem item2 = new MenuItem("Synchronous");
        		listaSynchronicity.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaSynchronicity);	
            }
        });
	
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaCardinality = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Fan out");
        		MenuItem item2 = new MenuItem("Fan in");
        		listaCardinality.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaCardinality);   	
            }
        });

		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {   
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaAccesibility = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Private");
        		MenuItem item2 = new MenuItem("Protected");
        		MenuItem item3 = new MenuItem("Public");
        		listaAccesibility.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaAccesibility);
            }
        });
	}
	
	private void MenuButtonEvent(){
		MenuButtonDimension.getItems().removeAll();
		ObservableList<MenuItem> listaEvent = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Cardinality E");
		MenuItem item2 = new MenuItem("Delivery");
		MenuItem item3 = new MenuItem("Priority");
		MenuItem item4 = new MenuItem("Synchronicity E");
		MenuItem item5 = new MenuItem("Notification");
		MenuItem item6 = new MenuItem("Causality");
		MenuItem item7 = new MenuItem("Mode");
		listaEvent.addAll(item1,item2,item3,item4,item5,item6,item7);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaCardinalityE = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Producers");
        		MenuItem item2 = new MenuItem("Observers");
        		MenuItem item3 = new MenuItem("Event patterns");
        		listaCardinalityE.addAll(item1,item2,item3);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item3.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaCardinalityE);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaDelivery = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Best effort");
        		MenuItem item2 = new MenuItem("Exactly once");
        		MenuItem item3 = new MenuItem("At most once");
        		MenuItem item4 = new MenuItem("At least once");
        		listaDelivery.addAll(item1,item2,item3,item4);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item4.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaDelivery);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaPriority = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Outgoing");
        		MenuItem item2 = new MenuItem("Incoming");
        		listaPriority.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaPriority);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaSynchronicityE = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Synchronous");
        		MenuItem item2 = new MenuItem("Asynchronous");
        		MenuItem item3 = new MenuItem("Time out synchronous");
        		listaSynchronicityE.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonSubdimension.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonValor.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonSubdimension.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonValor.setText(item2.getText());
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonSubdimension.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonValor.setText(item3.getText());
                    }
                });
        		MenuButtonValor.getItems().addAll(listaSynchronicityE);
            }
        });
		
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaNotification = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Polled");
        		MenuItem item2 = new MenuItem("Publish/subscribe");
        		MenuItem item3 = new MenuItem("Central update");
        		MenuItem item4 = new MenuItem("Queued dispatch");
        		listaNotification.addAll(item1,item2,item3,item4);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item4.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaNotification);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaCausality = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Absolute");
        		MenuItem item2 = new MenuItem("Relative");
        		listaCausality.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaCausality);
            }
        });
		
		item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {           
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item7.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaPriority = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Hardware");
        		MenuItem item2 = new MenuItem("Software");
        		listaPriority.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	
                    	ObservableList<MenuItem> listaHardware = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Page faults");
                		MenuItem item2 = new MenuItem("Interrupts");
                		MenuItem item3 = new MenuItem("Traps");
                		listaHardware.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaHardware);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	ObservableList<MenuItem> listaSoftware = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Signals");
                		MenuItem item2 = new MenuItem("GUI input/output");
                		MenuItem item3 = new MenuItem("Triggers");
                		listaSoftware.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaSoftware);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaPriority);
            }
        });
		MenuButtonDimension.getItems().addAll(listaEvent);
	}
	
	private void MenuButtonDataAccess(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaDataAccess = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Locality");
		MenuItem item2 = new MenuItem("Access");
		MenuItem item3 = new MenuItem("Availability");
		MenuItem item4 = new MenuItem("Accessibility DA");
		MenuItem item5 = new MenuItem("Lifecycle");
		MenuItem item6 = new MenuItem("Cardinality DA");
		listaDataAccess.addAll(item1,item2,item3,item4,item5,item6);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaLocalty = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Thread specific");
        		MenuItem item2 = new MenuItem("Process specific");
        		MenuItem item3 = new MenuItem("Global");
        		listaLocalty.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaLocalty);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaAccess = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Accessor");
        		MenuItem item2 = new MenuItem("Mutator");
        		listaAccess.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaAccess);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaAvailability = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Transient");
        		MenuItem item2 = new MenuItem("Persistent");
        		listaAvailability.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	
                    	ObservableList<MenuItem> listaTransient = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Register");
                		MenuItem item2 = new MenuItem("Cache");
                		MenuItem item3 = new MenuItem("DMA");
                		MenuItem item4 = new MenuItem("Heap");
                		MenuItem item5 = new MenuItem("Stack");
                		listaTransient.addAll(item1,item2,item3,item4,item5);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item5.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item5.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaTransient);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	ObservableList<MenuItem> listaPersistent = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Repository access");
                		MenuItem item2 = new MenuItem("File I/O");
                		MenuItem item3 = new MenuItem("Dynamic data exchange");
                		MenuItem item4 = new MenuItem("Database Access");
                		listaPersistent.addAll(item1,item2,item3,item4);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });		
                		MenuButtonValor.getItems().addAll(listaPersistent);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaAvailability);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaAccessibilityDA = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Private");
        		MenuItem item2 = new MenuItem("Protected");
        		MenuItem item3 = new MenuItem("Public");
        		listaAccessibilityDA.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		MenuButtonValor.getItems().addAll(listaAccessibilityDA);
            }
        });
		
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaLifecycle = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Initialization");
        		MenuItem item2 = new MenuItem("Termination");
        		listaLifecycle.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaLifecycle);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaCardinalityDA = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Defines");
        		MenuItem item2 = new MenuItem("Uses");
        		listaCardinalityDA.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaCardinalityDA);
            }
        });
	MenuButtonDimension.getItems().addAll(listaDataAccess);	
	}
	
	private void MenuButtonLinkage(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaLinkage = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Reference");
		MenuItem item2 = new MenuItem("Granularity");
		MenuItem item3 = new MenuItem("Cardinality Linkage");
		MenuItem item4 = new MenuItem("Binding");;
		listaLinkage.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaReference = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Implicit");
        		MenuItem item2 = new MenuItem("Explicit");
        		listaReference.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaReference);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaGranularity= FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Unit");
        		MenuItem item2 = new MenuItem("Syntactic");
        		MenuItem item3 = new MenuItem("Semantic");
        		listaGranularity.addAll(item1,item2,item3);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	
                    	ObservableList<MenuItem> listaSyntactic = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Variable");
                		MenuItem item2 = new MenuItem("Procedure");
                		MenuItem item3 = new MenuItem("Function");
                		MenuItem item4 = new MenuItem("Constant");
                		MenuItem item5 = new MenuItem("Type");
                		listaSyntactic.addAll(item1,item2,item3,item4,item5);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item5.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item5.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		MenuButtonValor.getItems().addAll(listaSyntactic);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item3.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaGranularity);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaCardinalityLinkage= FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Defines");
        		MenuItem item2 = new MenuItem("Uses");
        		MenuItem item3 = new MenuItem("Provides");
        		MenuItem item4 = new MenuItem("Requires");
        		listaCardinalityLinkage.addAll(item1,item2,item3,item4);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item3.getText());
                    }
                });
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.getItems().clear();
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item4.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaCardinalityLinkage);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaBinding = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Compile-time");
        		MenuItem item2 = new MenuItem("Run-time");
        		MenuItem item3 = new MenuItem("Pre-compile-time");
        		listaBinding.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });	
        		MenuButtonValor.getItems().addAll(listaBinding);
            }
        });
	MenuButtonDimension.getItems().addAll(listaLinkage);
	}
	
	private void MenuButtonStream(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaStream = FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Delivery Stream");
		MenuItem item2 = new MenuItem("Bounds");
		MenuItem item3 = new MenuItem("Buffering");
		MenuItem item4 = new MenuItem("Throughput");;
		MenuItem item5 = new MenuItem("State");
		MenuItem item6 = new MenuItem("Identity");
		MenuItem item7 = new MenuItem("Locality Stream");
		MenuItem item8 = new MenuItem("Synchronicity Stream");;
		MenuItem item9 = new MenuItem("Format");
		MenuItem item10 = new MenuItem("Cardinality Stream");
		listaStream.addAll(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaDeliveryStream= FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Best effort");
        		MenuItem item2 = new MenuItem("Exactly once");
        		MenuItem item3 = new MenuItem("At most once");
        		MenuItem item4 = new MenuItem("At least once");
        		listaDeliveryStream.addAll(item1,item2,item3,item4);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });	
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item4.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });	
        		MenuButtonValor.getItems().addAll(listaDeliveryStream);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaBounds = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Bounded");
        		MenuItem item2 = new MenuItem("Unbounded");
        		listaBounds.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaBounds);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaBuffering = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Buffered");
        		MenuItem item2 = new MenuItem("Unbuffered");
        		listaBuffering.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaBuffering);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaThroughput = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Atomic units");
        		MenuItem item2 = new MenuItem("Higher-order units");
        		listaThroughput.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaThroughput);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaState = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Stateless");
        		MenuItem item2 = new MenuItem("Stateful");
        		listaState.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaState);
            }
        });
		
		item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item6.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaIdentity = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Named");
        		MenuItem item2 = new MenuItem("Unnamed");
        		listaIdentity.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaIdentity);
            }
        });
		
		item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item7.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaLocalityStream = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Local");
        		MenuItem item2 = new MenuItem("Remote");
        		listaLocalityStream.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaLocalityStream);
            }
        });
		
		item8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item8.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaSynchronicityStream = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Synchronous");
        		MenuItem item2 = new MenuItem("Asynchronous");
        		MenuItem item3 = new MenuItem("Time out synchronous");
        		listaSynchronicityStream.addAll(item1,item2,item3);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item3.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });	
        		MenuButtonValor.getItems().addAll(listaSynchronicityStream);
            }
        });
		item9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item9.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaFormat = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Raw");
        		MenuItem item2 = new MenuItem("Structured");
        		listaFormat.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaFormat);
            }
        });
		
		item10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item10.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaCardinalityStream= FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Binary");
        		MenuItem item2 = new MenuItem("N-ary");
        		listaCardinalityStream.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaNary = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Multi sender");
                		MenuItem item2 = new MenuItem("Multi receiver");
                		MenuItem item3 = new MenuItem("Multi sender/receiver");
                		listaNary.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });		
                		MenuButtonValor.getItems().addAll(listaNary);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaCardinalityStream);
            }
        });
	MenuButtonDimension.getItems().addAll(listaStream);
	}
	
	private void MenuButtonArbitrator(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaArbitrator= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Fault Handling");
		MenuItem item2 = new MenuItem("Concurrency");
		MenuItem item3 = new MenuItem("Transactions");
		MenuItem item4 = new MenuItem("Security");
		MenuItem item5 = new MenuItem("Scheduling");;
		listaArbitrator.addAll(item1,item2,item3,item4,item5);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {		
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaFaultHandling = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Authoritative");
        		MenuItem item2 = new MenuItem("Voting");
        		listaFaultHandling.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });		
        		MenuButtonValor.getItems().addAll(listaFaultHandling);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaConcurrency = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Mechanism");
        		MenuItem item2 = new MenuItem("Weight");
        		listaConcurrency.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	ObservableList<MenuItem> listaMechanism= FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Semaphore");
                		MenuItem item2 = new MenuItem("Rendezvous");
                		MenuItem item3 = new MenuItem("Monitor");
                		MenuItem item4 = new MenuItem("Lock");
                		listaMechanism.addAll(item1,item2,item3,item4);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaMechanism);
                    	
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaWeight = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Light");
                		MenuItem item2 = new MenuItem("Heavy");
                		listaWeight.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaWeight);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaConcurrency);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaTransactions = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Nesting");
        		MenuItem item2 = new MenuItem("Awareness");
        		MenuItem item3 = new MenuItem("Isolation");
        		listaTransactions.addAll(item1,item2,item3);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaNesting= FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Single");
                		MenuItem item2 = new MenuItem("Multiple");
                		listaNesting.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaNesting);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaAwareness= FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("None");
                		MenuItem item2 = new MenuItem("Supported");
                		MenuItem item3 = new MenuItem("Required");
                		MenuItem item4 = new MenuItem("New");
                		listaAwareness.addAll(item1,item2,item3,item4);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaAwareness);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaIsolation= FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Read");
                		MenuItem item2 = new MenuItem("Write");
                		MenuItem item3 = new MenuItem("Read/Write");
                		listaIsolation.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaIsolation);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaTransactions);
            	
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaSecurity = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Authentication");
        		MenuItem item2 = new MenuItem("Authorization");
        		MenuItem item3 = new MenuItem("Privacy");
        		MenuItem item4 = new MenuItem("Integrity");
        		MenuItem item5 = new MenuItem("Durability");
        		listaSecurity.addAll(item1,item2,item3,item4,item5);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaAuthorization = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Capabilities");
                		MenuItem item2 = new MenuItem("Access control lists");
                		listaAuthorization.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaAuthorization);
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item3.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaPrivacy = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Encryption");
                		MenuItem item2 = new MenuItem("Information padding");
                		MenuItem item3 = new MenuItem("Screening");
                		listaPrivacy.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });		
                		MenuButtonValor.getItems().addAll(listaPrivacy);
                    }
                });
        		item4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item4.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaIntegrity = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Redundancy check");
                		MenuItem item2 = new MenuItem("Certificates");
                		listaIntegrity.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaIntegrity);
                    	
                    }
                });
        		item5.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item5.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaDurability= FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Single session");
                		MenuItem item2 = new MenuItem("Multi session");
                		listaDurability.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaDurability);
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaSecurity);
            }
        });
		item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item5.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaScheduling = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Time");
        		MenuItem item2 = new MenuItem("Weight");
        		listaScheduling.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaScheduling);
            	
            }
        });
	MenuButtonDimension.getItems().addAll(listaArbitrator);
	}
	
	private void MenuButtonAdaptor(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaAdaptor= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Invocation conversion");
		MenuItem item2 = new MenuItem("Packaging conversion");
		MenuItem item3 = new MenuItem("Protocol conversion");
		MenuItem item4 = new MenuItem("Presentation conversion");
		listaAdaptor.addAll(item1,item2,item3,item4);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listanvocationConversion = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Address mapping");
        		MenuItem item2 = new MenuItem("Marshalling");
        		MenuItem item3 = new MenuItem("Translation");
        		listanvocationConversion.addAll(item1,item2,item3);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    }
                });
        		item3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item3.getText());
                    	MenuButtonValor.getItems().clear();
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listanvocationConversion);
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	MenuButtonValor.getItems().clear();
            	
            	ObservableList<MenuItem> listaPackagingConversion = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Wrappers");
        		MenuItem item2 = new MenuItem("Packagers");
        		listaPackagingConversion.addAll(item1,item2);
        		
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item1.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setText(item2.getText());
                    	panelPropiedadesConector.getChildren().remove(l1);
                    }
                });	
        		MenuButtonValor.getItems().addAll(listaPackagingConversion);
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("NULL");
            	MenuButtonValor.setDisable(true);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
		
		item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("NULL");
            	MenuButtonSubdimension.setDisable(true);
            	MenuButtonValor.setText("NULL");
            	MenuButtonValor.setDisable(true);
            	MenuButtonDimension.setText(item4.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            }
        });
	MenuButtonDimension.getItems().addAll(listaAdaptor);
	}
	
	private void MenuButtonDistributor(){
		MenuButtonDimension.getItems().clear();
		ObservableList<MenuItem> listaDistributor= FXCollections.observableArrayList();
		MenuItem item1 = new MenuItem("Naming");
		MenuItem item2 = new MenuItem("Delivery Distributor");
		MenuItem item3 = new MenuItem("Routing");
		listaDistributor.addAll(item1,item2,item3);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item1.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaNaming = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Structure based");
        		MenuItem item2 = new MenuItem("Attribute based");
        		listaNaming.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaStructureBased = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Hierarchical");
                		MenuItem item2 = new MenuItem("Flat");
                		listaStructureBased.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaStructureBased);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(true);
                    	MenuButtonValor.setText("NULL");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear(); 	
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaNaming);
            	
            }
        });
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item2.getText());
            	panelPropiedadesConector.getChildren().remove(l1);
            	
            	ObservableList<MenuItem> listaDeliveryDistributor = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Semantics Distributor");
        		MenuItem item2 = new MenuItem("Mechanism Distributor");
        		listaDeliveryDistributor.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaSemanticsDistributor = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Best effort");
                		MenuItem item2 = new MenuItem("Exactly once");
                		MenuItem item3 = new MenuItem("At most once");
                		MenuItem item4 = new MenuItem("At least once");
                		listaSemanticsDistributor.addAll(item1,item2,item3,item4);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		item4.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item4.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		MenuButtonValor.getItems().addAll(listaSemanticsDistributor);
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaMechanismDistributor = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Unicast");
                		MenuItem item2 = new MenuItem("Multicast");
                		MenuItem item3 = new MenuItem("Broadcast");
                		listaMechanismDistributor.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		MenuButtonValor.getItems().addAll(listaMechanismDistributor);
                    	
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaDeliveryDistributor);     	
            }
        });
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        		MenuButtonSubdimension.getItems().clear();
            	MenuButtonSubdimension.setText("Opciones");
            	MenuButtonSubdimension.setDisable(false);
            	MenuButtonValor.setText("Opciones");
            	MenuButtonValor.setDisable(false);
            	MenuButtonDimension.setText(item3.getText());
            	panelPropiedadesConector.getChildren().remove(l1);;
            	
            	ObservableList<MenuItem> listaRouting = FXCollections.observableArrayList();
        		MenuItem item1 = new MenuItem("Membership");
        		MenuItem item2 = new MenuItem("Path");
        		listaRouting.addAll(item1,item2);
        		item1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item1.getText());
                    	MenuButtonValor.getItems().clear();
                    	
                    	ObservableList<MenuItem> listaMembership = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Bounded");
                		MenuItem item2 = new MenuItem("Ad-hoc");
                		listaMembership.addAll(item1,item2);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		MenuButtonValor.getItems().addAll(listaMembership);
                    	
                    }
                });
        		
        		item2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    	MenuButtonValor.setDisable(false);
                    	MenuButtonValor.setText("Opciones");
                    	panelPropiedadesConector.getChildren().remove(l1);
                    	MenuButtonSubdimension.setText(item2.getText());
                    	MenuButtonValor.getItems().clear();
                    	ObservableList<MenuItem> listaPath = FXCollections.observableArrayList();
                		MenuItem item1 = new MenuItem("Static");
                		MenuItem item2 = new MenuItem("Cached");
                		MenuItem item3 = new MenuItem("Dynamic");
                		listaPath.addAll(item1,item2,item3);
                		
                		item1.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item1.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		
                		item2.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item2.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });	
                		item3.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                            	MenuButtonValor.setText(item3.getText());
                            	panelPropiedadesConector.getChildren().remove(l1);
                            }
                        });
                		MenuButtonValor.getItems().addAll(listaPath);
                    	
                    }
                });
        		MenuButtonSubdimension.getItems().addAll(listaRouting);
            }
        });
	MenuButtonDimension.getItems().addAll(listaDistributor);
	}
	
	//--------------------------------------------------------------------------------------
	@FXML
	private void guardarPropiedadesDelConector(){
		panelPropiedadesConector.getChildren().remove(l1);
		
		l1.setLayoutX(50);
		l1.setLayoutY(130);
			
		if((!MenuButtonDimension.getText().equals("Opciones")) &&
				(!MenuButtonSubdimension.getText().equals("Opciones")) &&
					(!MenuButtonValor.getText().equals("Opciones"))){
						l1.setText("Las propiedades se han guardado con exíto");						
						Propiedades nueva = new Propiedades();
						nueva.setDimension(MenuButtonDimension.getText());
						nueva.setSubdimension(MenuButtonSubdimension.getText());
						nueva.setValue(MenuButtonValor.getText());
						Modelo.conectorActual.getPropiedades().add(nueva);
						cA.actualizarListaPropiedades();					
		}
		else
			l1.setText("Debes completar todos los campos");
		panelPropiedadesConector.getChildren().add(l1);
	}
}
