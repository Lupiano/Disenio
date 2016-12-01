package core;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Trabajo Diseño Final");
			primaryStage.getIcons().add(new Image("file:resources/imagen/icono.png"));
			Parent root = FXMLLoader.load(getClass().getResource("/ui/Vista Componente.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
