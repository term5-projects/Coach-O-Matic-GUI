module CoachOMatic_gui {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	requires CoachMatic.BE;
	
	opens application to javafx.graphics, javafx.fxml;
}
