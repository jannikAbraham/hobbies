package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.service.EntityService;
import de.jannik.hobbies.service.UserService;
import de.jannik.hobbies.util.SpringContext;
import de.jannik.hobbies.view.abstracts.VaadinCrudTwo;
import de.jannik.hobbies.view.abstracts.VaadinPage;

import java.util.ArrayList;
import java.util.List;

public class CountryViewTwo extends VaadinCrudTwo<Country> implements VaadinPage
{
  public CountryViewTwo(Country newEntity, EntityService<Country> service, Class<Country> clazz)
  {
    super(newEntity, service, clazz);
  }

  @Override
  public List<Component> getFields(Binder<Country> binder)
  {
    UserService userService = SpringContext.getBean(UserService.class);

    TextField countryName = new TextField("CountryName");
    TextField userName = new TextField("Username");





    binder.forField(countryName).withValidator(n -> n.length() >= 1, "Name cant be empty").bind(Country::getCode,Country::setCode);
    binder.forField(userName).withValidator(n -> n.length() >= 1, "Name cant be empty").bind(,Country::setCode);

    ArrayList<Component> fieldComponents = new ArrayList<>();
    fieldComponents.add(countryName);
    fieldComponents.add(userName);
    return fieldComponents;
  }

  @Override
  public String getButtonText()
  {
    return "Country";
  }

  @Override
  public Icon getIcon()
  {
    return VaadinIcon.STAR_HALF_LEFT_O.create();
  }
}
