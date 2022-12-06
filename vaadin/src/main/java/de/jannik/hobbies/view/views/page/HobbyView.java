package de.jannik.hobbies.view.views.page;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import de.jannik.hobbies.model.entity.Hobby;
import de.jannik.hobbies.service.EntityService;
import de.jannik.hobbies.service.HobbyService;
import de.jannik.hobbies.view.views.abstracts.VaadinCrud;
import de.jannik.hobbies.view.views.abstracts.VaadinPage;

import java.util.List;

public class HobbyView extends VaadinCrud<Hobby> implements VaadinPage
{
  public HobbyView(HobbyService hobbyService)
  {
    super(hobbyService, Hobby.class,false);
    handleGridColumns();
  }

  private void handleGridColumns()
  {
    getGrid().addColumns("Hobby Name","User id");
  }

  @Override
  public List<Component> getFields(Binder<Hobby> binder)
  {
    TextField HobbyName = new TextField("HobbyName");
    TextField userName = new TextField("Username");

    return null;
  }

  @Override
  public Hobby getNewEntity()
  {
    return null;
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