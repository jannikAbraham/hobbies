package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.model.entity.Hobby;

@SpringComponent
@UIScope
@PageTitle("hobby View")
@Route(value = "Hobby", layout = AppView.class)
public class HobbyView extends VerticalLayout implements VaadinPage
{

  public HobbyView()
  {
    Grid<Hobby> hobbyGrid = new Grid<>();
    Button addButton = new Button("ADD");
    Button deleteButton = new Button("DELETE");
    Button updateButton = new Button("UPDATE");

    HobbyDialog addHobbyDialog = new HobbyDialog("Add Hobby");
    HobbyDialog updateHobbyDialog = new HobbyDialog("Update Hobby");

    addButton.addClickListener(e -> addHobbyDialog.open());
    updateButton.addClickListener( e -> updateHobbyDialog.open());

    HorizontalLayout vl1 = new HorizontalLayout(addButton, deleteButton, updateButton);
    VerticalLayout hl1 = new VerticalLayout(hobbyGrid, vl1);

    add(hl1);

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
}
