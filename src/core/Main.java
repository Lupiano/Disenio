package core;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main {

	public static void main(String[] args) {
		
		Problema p1 = new Problema("1");
		p1.setValor("Vehiculo", "Auto");
		Caso c1 = new Caso(p1,"10");
		
		BaseDatos BD = new BaseDatos("postgres", "diseño");
		BD.conectar();
		
		Problema p2 = new Problema("2");
		p2.setValor("Vehiculo", "Moto");
		Caso c2 = new Caso(p2,"20");
		
		Problema p3 = new Problema("3");
		p3.setValor("Vehiculo", "Bici");
		Caso c3 = new Caso(p3,"30");
		
		ArrayList<Problema> p = new ArrayList<Problema>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		
		Problemas ps = new Problemas(p);
		
		Problema p0 = new Problema();
		p0.setValor("Vehiculo", "Moto");
		
		ArrayList<Problema> sol = ps.masCercanos(p0,3);
		
		for(Problema pAux: sol){
			System.out.println(pAux.valor("Vehiculo"));
		}
	}
	
	/*
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Trabajo Diseño Final");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("Vista Componente.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}*/

}
