package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.model.enums.Gender;
import de.jannik.hobbies.service.CountryService;
import de.jannik.hobbies.service.UserService;
import de.jannik.hobbies.util.SpringContext;

@UIScope
@SpringComponent
public abstract class UserDialog extends Dialog
{

  private final User user;
  private final Binder<User> binder;
  private final TextField name;
  private final EmailField eMail;
  private final DatePicker birthday;
  private final ComboBox<Gender> gender;
  private final ComboBox<Country> country;
  CountryService countryService = SpringContext.getBean(CountryService.class);
  UserService userService = SpringContext.getBean(UserService.class);

  public UserDialog(User user)
  {
    // Declaring mandatory fields
    this.user = user;
    binder = new BeanValidationBinder<>(User.class);
    binder.setBean(user);

    // Init style
    setWidth("450px");
    setHeaderTitle("Borring plain text");

    // Declaring action buttons
    Button saveButton = new Button("Save", e -> saveOrUpdate());
    Button cancelButton = new Button("Cancel", e -> close());

    // Declaring user fields components
    name = new TextField("Name");
    eMail = new EmailField("E-Mail");
    birthday = new DatePicker("Birthday");

    gender = new ComboBox<>("Gender");
    gender.setItems(Gender.values());

    country = new ComboBox<>("Country");
    country.setItems(countryService.findAll());
    country.setItemLabelGenerator(Country::getCode);


    binder.bindInstanceFields(this);


    // Preparing container
    HorizontalLayout fieldContainers = new HorizontalLayout(name, eMail, birthday, gender, country);
    fieldContainers.getStyle().set("flex-wrap", "wrap").set("gap", "12px");

    // Add to the layout
    add(fieldContainers);
    getFooter().add(saveButton, cancelButton);
  }

  private void saveOrUpdate()
  {
    if(binder.validate().isOk())
    {
      userService.saveOrUpdate(user);
      entityWasSaved(user);
      close();
    }
  }

  public abstract void entityWasSaved(User updatedUser);

}

