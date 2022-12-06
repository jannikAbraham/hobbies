package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.service.CountryService;
import de.jannik.hobbies.service.HobbyService;
import de.jannik.hobbies.service.UserService;
import de.jannik.hobbies.util.SpringContext;

public abstract class HobbyDialog extends Dialog
{

  private final Hobby hobby;
  private final Binder<Hobby> binder;
  private final TextField userName;

  private final TextField hobbyName;

  HobbyService hobbyService = SpringContext.getBean(HobbyService.class);


  public HobbyDialog(Hobby hobby)
  {
    // Declaring mandatory fields
    this.hobby = hobby;
    binder = new BeanValidationBinder<>(Hobby.class);
    binder.setBean(hobby);

    // Init style
    setWidth("450px");
    setHeaderTitle("Borring plain text");

    // Declaring action buttons
    Button saveButton = new Button("Save", e -> saveOrUpdate());
    Button cancelButton = new Button("Cancel", e -> close());

    // Declaring user fields components
    userName = new TextField("Name");
    hobbyName = new TextField("Hobby");

    binder.bindInstanceFields(this);

    // Preparing container
    HorizontalLayout fieldContainers = new HorizontalLayout(userName, hobbyName);
    fieldContainers.getStyle().set("flex-wrap", "wrap").set("gap", "12px");

    // Add to the layout
    add(fieldContainers);
    getFooter().add(saveButton, cancelButton);
  }

  private void saveOrUpdate()
  {
    if (binder.validate().isOk())
    {
      hobbyService.saveOrUpdate(hobby);
      entityWasSaved(hobby);
      close();
    }
  }

  public abstract void entityWasSaved(Hobby updatedUser);

}

