package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CountryDialog
{
  Dialog dialog = new Dialog();

  public CountryDialog(String header)
  {

    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel", e -> dialog.close());

    TextField userNameTextField = new TextField();
    TextField countryTextField = new TextField();


    HorizontalLayout vl1 = new HorizontalLayout(userNameTextField, countryTextField);



    VerticalLayout hl1 = new VerticalLayout(vl1);

    dialog.setHeaderTitle(header);

    userNameTextField.setLabel("Name");
    countryTextField.setLabel("Country");


    dialog.add(hl1);

    dialog.getFooter().add(saveButton, cancelButton);
  }

  public void open()
  {
    dialog.open();
  }
}
