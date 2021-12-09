module MyTelephoneBook {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.bilgeadam.boost.java.course01.lesson64.view to javafx.graphics, javafx.fxml;
	
	
	exports com.bilgeadam.boost.java.course01.lesson64.view to javafx.graphics, javafx.fxml;
	exports com.bilgeadam.boost.java.course01.lesson64;

}
