package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

public class DialogStructure
{

  Dialog dialog = new Dialog();

  public DialogStructure(String header)
  {
    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel", e -> dialog.close());

    dialog.setHeaderTitle(header);
    dialog.getFooter().add(saveButton, cancelButton);
  }

  public void open()
  {
    dialog.open();
  }

}
