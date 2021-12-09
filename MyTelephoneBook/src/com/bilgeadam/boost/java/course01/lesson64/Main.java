package com.bilgeadam.boost.java.course01.lesson64;

import java.io.IOException;

import com.bilgeadam.boost.java.course01.lesson64.model.Person;
import com.bilgeadam.boost.java.course01.lesson64.view.PersonOverviewController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@SuppressWarnings("exports")
public class Main extends Application {
	private Stage primary;
	private BorderPane rootPane;
	private ObservableList<Person> people;
	
	public Stage getPrimary() {
		return primary;
	}
	
	public ObservableList<Person> getPeople() {
		if (this.people == null) {
			this.people = FXCollections.observableArrayList();
		}
		return this.people;
	}
	
	@Override
	public void start(Stage primaryStage) {
		initTelephoneEntries();
		initPrimaryStage(primaryStage);
		initRootLayout();
		showPersonOverview();
		
	}
	
	private void initTelephoneEntries() {
		this.getPeople().add(new Person("Babür", "Somer", "533 437 99 29", null, null, 0, null));
		this.getPeople().add(new Person.Builder().firstName("Burak").lastName("Güneş").city("Samatya").build());
		this.getPeople().add(new Person.Builder().firstName("Çağlayan").lastName("Kaya").build());
		this.getPeople().add(new Person.Builder().firstName("Çağrı").lastName("Türkmen").build());
		this.getPeople().add(new Person.Builder().firstName("Ali").lastName("Ergül").build());
		this.getPeople().add(new Person.Builder().firstName("Canan").lastName("Havva").build());
		this.getPeople().add(new Person.Builder().firstName("Mert Can").lastName("Aydın").build());
		this.getPeople().add(new Person.Builder().firstName("Görkem").lastName("Sönmez").build());
		this.getPeople().add(new Person.Builder().firstName("Gülten").lastName("Ulukal").build());
		this.getPeople().add(new Person.Builder().firstName("Melih").lastName("Dumanlı").build());
		this.getPeople().add(new Person.Builder().firstName("Mustafa").lastName("Öztürk").build());
		this.getPeople().add(new Person.Builder().firstName("Onur").lastName("Gündoğdu").build());
		this.getPeople().add(new Person.Builder().firstName("Recep").lastName("Ergan").build());
		this.getPeople().add(new Person.Builder().firstName("Sercan").lastName("Üstün").build());
		
		// for (Person person : people) {
		// System.out.println(person);
		//
		// }
		
	}
	
	private void initPrimaryStage(Stage primaryStage) {
		this.primary = primaryStage;
		this.primary.getIcons().add(new Image(getClass().getResourceAsStream("resources/phonebook.png")));
		this.primary.setTitle("Call Me Ishmael");
	}
	
	private void showPersonOverview() {
		FXMLLoader loader = new FXMLLoader(); // herhangi bir scene'i ekranda göstermek için, FXML'ini yüklemeniz
												// gerekli
		loader.setLocation(getClass().getResource("view/PersonOverview.fxml")); // FXML dosyası nerede belirtiyoruz
		try {
			AnchorPane personOverview = (AnchorPane) loader.load(); // FXML'i okuyoruz
			this.rootPane.setCenter(personOverview); // RootPane borderpane cinsinden olduğundan alt/üst/sağ/sol/orta
														// alanları bulunmakta
														// ORTA'ya personoverview'u ekliyoruz.
			PersonOverviewController controller = loader.getController(); // FXML dosyası içinde tanımlı controller'ı
																			// bir şekilde sınıfımıza dahil ediyoruz.
			controller.setMain(this); // controller'a main'in içerdiği bilgileri iletiliyor
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void initRootLayout() {
		try {
			this.rootPane = (BorderPane) FXMLLoader.load(getClass().getResource("view/TelephoneBook.fxml"));
			Scene scene = new Scene(rootPane, 400, 400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			this.primary.setScene(scene);
			// primaryStage.initStyle(StageStyle.UNDECORATED);
			this.primary.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
