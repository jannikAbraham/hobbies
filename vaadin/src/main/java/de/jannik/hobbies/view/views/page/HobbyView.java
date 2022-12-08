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
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.service.HobbyService;
import de.jannik.hobbies.view.views.AppView;
import de.jannik.hobbies.view.views.abstracts.VaadinCrud;
import de.jannik.hobbies.view.views.abstracts.VaadinPage;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
@PageTitle("Hobby View")
@Route(value = "Hobby", layout = AppView.class)
public class HobbyView extends VaadinCrud<Hobby> implements VaadinPage
{
  public HobbyView(HobbyService hobbyService)
  {
    super(hobbyService, Hobby.class,false);
    handleGridColumns();
  }

  private void handleGridColumns()
  {
    getGrid().addColumns("name","id");
  }

  @Override
  public List<Component> getFields(Binder<Hobby> binder)
  {
    TextField hobbyName = new TextField("Hobby Name");
    TextField userName = new TextField("Username");

    binder.forField(hobbyName).withValidator(n -> n.length() >= 1, "Name cant be empty").bind(Hobby::getName,Hobby::setName);
    binder.forField(userName).withValidator(n -> n.length() >= 1, "Name cant be empty").bind(Hobby::getHelperText,Hobby::setHelperText);

    ArrayList<Component> fieldComponents = new ArrayList<>();
    fieldComponents.add(hobbyName);
    fieldComponents.add(userName);

    return fieldComponents;
  }

  @Override
  public Hobby getNewEntity()
  {
    return new Hobby();
  }

  @Override
  public String getButtonText()
  {
    return "Hobby";
  }

  @Override
  public Icon getIcon()
  {
    return VaadinIcon.HARDDRIVE.create();
  }
}