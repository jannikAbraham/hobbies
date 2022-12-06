package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.model.enums.Gender;
import de.jannik.hobbies.service.CountryService;
import de.jannik.hobbies.service.UserService;
import de.jannik.hobbies.util.SpringContext;
import de.jannik.hobbies.view.abstracts.VaadinCrudTwo;
import de.jannik.hobbies.view.abstracts.VaadinPage;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
@PageTitle("User View")
@Route(value = "User", layout = AppView.class)
public class UserView extends VaadinCrudTwo<User> implements VaadinPage
{
  public UserView(UserService userService)
  {
    super(new User(), userService, User.class);
  }

  @Override
  public List<Component> getFields(Binder<User> binder)
  {
    CountryService countryService = SpringContext.getBean(CountryService.class);


    TextField name = new TextField("Name");
    Label nameStatus = new Label();

    EmailField eMail = new EmailField("E-Mail");
    DatePicker birthday = new DatePicker("Birthday");

    ComboBox<Gender> gender = new ComboBox<>("Gender");
    gender.setItems(Gender.values());

    ComboBox<Country> country = new ComboBox<>("Country");
    country.setItems(countryService.findAll());
    country.setItemLabelGenerator(Country::getCode);

    // Binding and validating component fields with user fields
    //ToDo validate this when clicking the Save button currently he is validating already when clicking the add button
    binder.forField(name).withValidator(n -> n.length() >= 3, "Name cant be empty").bind(User::getName, User::setName);
    binder.forField(eMail).withValidator(n -> !n.isEmpty(), "Please enter an e mail").bind(User::geteMail, User::seteMail);
    binder.forField(birthday).withValidator(n -> !n.toString().isBlank(), "Date cant be empty").bind(User::getBirthday, User::setBirthday);
    binder.forField(gender).withValidator(n -> !n.toString().isBlank(), "Please select something").bind(User::getGender, User::setGender);
    binder.forField(country).withValidator(n -> !n.toString().isBlank(), "Please select something").bind(User::getCountry, User::setCountry);

    ArrayList<Component> fieldsComponents = new ArrayList<>();
    fieldsComponents.add(name);
    fieldsComponents.add(eMail);
    fieldsComponents.add(birthday);
    fieldsComponents.add(country);
    fieldsComponents.add(gender);

    return fieldsComponents;
  }
//
//  private ValidationResult validateName(String s, ValueContext valueContext)
//  {
//    return ValidationResult.ok();
//  }

  @Override
  public String getButtonText()
  {
    return "User";
  }

  @Override
  public Icon getIcon()
  {
    return VaadinIcon.USER.create();
  }
}
