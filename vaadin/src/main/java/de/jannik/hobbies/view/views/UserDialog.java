package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.jannik.hobbies.model.enums.Gender;

public class UserDialog
{
  Dialog dialog = new Dialog();

  public UserDialog(String header)
  {

    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel", e -> dialog.close());

    TextField nameTextField = new TextField();
    TextField emailTextField = new TextField();
    DatePicker birthdayDatePicker = new DatePicker();
    ComboBox<Gender> genderComboBox = new ComboBox<>();
    TextField countryTextField = new TextField();

    HorizontalLayout vl1 = new HorizontalLayout(nameTextField, birthdayDatePicker);
    HorizontalLayout vl2 = new HorizontalLayout(genderComboBox, emailTextField);
    HorizontalLayout vl3 = new HorizontalLayout(countryTextField);

    VerticalLayout hl1 = new VerticalLayout(vl1, vl2, vl3);

    dialog.setHeaderTitle(header);

    nameTextField.setLabel("Name");
    birthdayDatePicker.setLabel("Birthday");
    genderComboBox.setLabel("Gender");
    genderComboBox.setItems(Gender.values());
    emailTextField.setLabel("E-Mail");
    countryTextField.setLabel("Country");

    dialog.add(hl1);

    dialog.getFooter().add(saveButton, cancelButton);
  }

  public void open()
  {
    dialog.open();
  }
}
