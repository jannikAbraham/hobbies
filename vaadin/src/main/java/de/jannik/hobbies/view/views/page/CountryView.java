package de.jannik.hobbies.view.views.page;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.model.entity.Country;
import de.jannik.hobbies.service.CountryService;
import de.jannik.hobbies.view.views.AppView;
import de.jannik.hobbies.view.views.abstracts.VaadinCrud;
import de.jannik.hobbies.view.views.abstracts.VaadinPage;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
@PageTitle("Country View")
@Route(value = "Country", layout = AppView.class)
public class CountryView extends VaadinCrud<Country> implements VaadinPage
{
  public CountryView(CountryService countryService)
  {
    super(countryService, Country.class, false);
    handelGridColumns();
  }

  private void handelGridColumns()
  {
    getGrid().addColumns("id", "code");
  }

  @Override
  public List<Component> getFields(Binder<Country> binder)
  {
    TextField countryName = new TextField("CountryName");
    TextField userName = new TextField("Username");

    binder.forField(countryName).withValidator(n -> n.length() >= 1, "Name cant be empty").bind(Country::getCode, Country::setCode);
    binder.forField(userName).withValidator(n -> n.length() >= 1, "Name cant be empty") .bind(Country::getHelperText, Country::setHelperText);

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

  @Override
  public Country getNewEntity()
  {
    return new Country();
  }
}
