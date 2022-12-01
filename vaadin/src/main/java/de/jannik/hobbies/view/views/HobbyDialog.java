package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.jannik.hobbies.model.enums.Gender;

public class HobbyDialog
{
  Dialog dialog = new Dialog();

  public HobbyDialog(String header)
  {

    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel", e -> dialog.close());

    TextField userNameTextField = new TextField();
    TextField hobbyTextField = new TextField();


    HorizontalLayout vl1 = new HorizontalLayout(userNameTextField, hobbyTextField);
    VerticalLayout hl1 = new VerticalLayout(vl1);

    dialog.setHeaderTitle(header);

    userNameTextField.setLabel("Name");
    hobbyTextField.setLabel("Hobby");


    dialog.add(hl1);

    dialog.getFooter().add(saveButton, cancelButton);
  }

  public void open()
  {
    dialog.open();
  }
}
