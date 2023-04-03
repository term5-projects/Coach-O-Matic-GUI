module CoachOMatic_gui {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	requires org.controlsfx.controls;
	
	opens coach_o_matic_fe to javafx.graphics, javafx.fxml;
}
