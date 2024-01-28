module com.cse360.hw1.joesdeli {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.cse360.hw1.joesdeli to javafx.fxml;
    exports com.cse360.hw1.joesdeli;
}