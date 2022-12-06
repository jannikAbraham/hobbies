package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
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
import de.jannik.hobbies.service.UserService;
import de.jannik.hobbies.view.abstracts.EntityDialog;
import de.jannik.hobbies.view.abstracts.VaadinCrud;
import de.jannik.hobbies.view.abstracts.VaadinPage;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
@PageTitle("hobby View")
@Route(value = "Hobby", layout = AppView.class)
public class HobbyView extends VaadinCrud<Hobby> implements VaadinPage
{
  //toDo handle EntityDialog

  private final Grid<Hobby> hobbyGrid;
  private final HobbyService hobbyService;
  private final UserService userService;
  private EntityDialog<Hobby> entityDialog;

  public HobbyView(HobbyService hobbyService, UserService userService)
  {
    super(hobbyService);
    this.hobbyService = hobbyService;
    this.userService = userService;

    hobbyGrid = new Grid<>(Hobby.class, false);
    hobbyGrid.addColumn(Hobby::getName).setHeader("Name");
    hobbyGrid.addColumn(Hobby::getId).setHeader("Birthday");

    hobbyGrid.setItems(hobbyService.findAll());

    setGrid(hobbyGrid);

    handleEntityDialog();
  }

  private void handleEntityDialog()
  {
    entityDialog = new EntityDialog<Hobby>(new Hobby(), hobbyService, Hobby.class)
    {
      @Override
      protected List<Component> getComponentFields(Binder<Hobby> binder)
      {
        // Declaring user fields components
        TextField userName = new TextField("Name");

        TextField hobbyName = new TextField("Hobby");

        // Binding and validating component fields with user fields
        //ToDo validate this when clicking the Save button currently he is validating already when clicking the add button
       // binder.forField(userName).withValidator(n -> n.length() >= 3, "Name cant be empty").
            //bind(getUsername(Hobby::getId,userService), Hobby::setId);
        binder.forField(hobbyName).withValidator(n -> n.length() >= 3, "Hobby cant be empty").
            bind(Hobby::getName, Hobby::setName);

        ArrayList<Component> fieldsComponents = new ArrayList<>();
        fieldsComponents.add(userName);
        fieldsComponents.add(hobbyName);

        return fieldsComponents;
      }

      // abstract this
      @Override
      public void entityWasSaved(Hobby updatedEntity)
      {
        refreshData();
      }
    };
    setEntityDialog(entityDialog);
  }

  private void createNewHobby()
  {
    entityDialog.setEntity(new Hobby());
    entityDialog.open();
  }

  @Override
  protected Hobby createNewEntity()
  {
    return new Hobby();
  }

  private void deleteHobby()
  {
    hobbyService.delete(hobbyGrid.asSingleSelect().getValue());
    refreshData();
  }

  private void updateHobby()
  {
    entityDialog.setEntity(hobbyGrid.asSingleSelect().getValue());
    entityDialog.open();
  }

  private void refreshData()
  {
    hobbyGrid.setItems(hobbyService.findAll());
  }

  @Override
  public String getButtonText()
  {
    return "Hobby";
  }

  @Override
  public Icon getIcon()
  {
    return VaadinIcon.GOLF.create();
  }

  public String getUsername(Long id , UserService userService)
  {
    if (userService.findById(id).isPresent())
      return userService.findById(id).toString();
    return "";
  }
}

