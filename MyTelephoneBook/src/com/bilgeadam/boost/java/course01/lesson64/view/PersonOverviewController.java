package com.bilgeadam.boost.java.course01.lesson64.view;

import java.util.Optional;

import com.bilgeadam.boost.java.course01.lesson64.Main;
import com.bilgeadam.boost.java.course01.lesson64.model.Person;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
	
	private Main main;
	
	@FXML
	private TableView<Person> tblPerson;
	@FXML
	private TableColumn<Person, String> colFirstName;
	@FXML
	private TableColumn<Person, String> colLastName;
	
	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label lblTelephone;
	@FXML
	private Label lblCity;
	@FXML
	private Label lblStreet;
	@FXML
	private Label lblZip;
	@FXML
	private Label lblBirthday;
	
	public PersonOverviewController() {
		super();
	}
	
	@FXML
	private void initialize() {
		colFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
		colLastName.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
		
		showPersonDetails(null); // ayrıntılı bilgileri sıfırla
		
		// seçili satırın özelliklerine bir changeListener ekliyor
		tblPerson.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	
	public void setMain(Main main) {
		this.main = main;
		tblPerson.setItems(main.getPeople());
		;
	}
	
	private void showPersonDetails(Person person) {
		if (person == null) {
			lblFirstName.setText("");
			lblLastName.setText("");
			lblTelephone.setText("");
			lblCity.setText("");
			lblStreet.setText("");
			lblZip.setText("");
			lblBirthday.setText("");
		} else {
			lblFirstName.setText(person.getFirstName());
			lblLastName.setText(person.getLastName());
			lblTelephone.setText(person.getTelephone());
			lblCity.setText(person.getCity());
			lblStreet.setText(person.getStreet());
			lblZip.setText("" + person.getZip());
			lblBirthday.setText(person.getFormattedDate(person.getBirthday()));
			
		}
	}
	
	@FXML
	private void delete() {
		int selected = tblPerson.getSelectionModel().getSelectedIndex();
		if (selected > 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initOwner(this.main.getPrimary());
			
			Optional<ButtonType> type = alert.showAndWait();
			if(type.get().getText().equalsIgnoreCase("OK"))
				tblPerson.getItems().remove(selected);
			
			tblPerson.getItems().remove(selected);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(main.getPrimary());
			alert.setTitle("DİKKAT");
			alert.setHeaderText("Kişi seçili değil!");
			alert.setContentText("Lütfen bir kişi seçiniz.");
			alert.show();
		}
	}
	
}
