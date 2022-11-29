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
import de.jannik.hobbies.model.entity.User;

@SpringComponent
@UIScope
@PageTitle("User View")
@Route(value = "User", layout = AppView.class)
public class UserView extends VerticalLayout implements VaadinPage
{

  public UserView()
  {
    Grid<User> userGrid = new Grid<>();
    Button addButton = new Button("ADD");
    Button deleteButton = new Button("DELETE");
    Button updateButton = new Button("UPDATE");

    UserDialog addUserDialog = new UserDialog("Add User");
    UserDialog updateUserDialog = new UserDialog("Update User");

    addButton.addClickListener(e -> addUserDialog.open());
    updateButton.addClickListener(e -> updateUserDialog.open());


    HorizontalLayout vl1 = new HorizontalLayout(addButton, deleteButton, updateButton);
    VerticalLayout hl1 = new VerticalLayout(userGrid, vl1);

    add(hl1);
  }

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
