package core;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
    private final StringProperty category = new SimpleStringProperty();

    public Contact(String category) {
        setCategory(category);
    }

    public final StringProperty categoryProperty() {
        return this.category;
    }


    public final String getCategory() {
        return this.categoryProperty().get();
    }


    public final void setCategory(final String category) {
        this.categoryProperty().set(category);
    }

}