module you.count.youcountdesktopalpha {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.base;


    opens you.count.youcountdesktopalpha to javafx.fxml;
    exports you.count.youcountdesktopalpha;
    exports you.count.youcountdesktopalpha.interfaces;
    opens you.count.youcountdesktopalpha.interfaces to javafx.fxml;
}