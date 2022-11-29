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
import de.jannik.hobbies.model.entity.Country;

@SpringComponent
@UIScope
@PageTitle("country View")
@Route(value = "Country", layout = AppView.class)
public class CountryView extends VerticalLayout implements VaadinPage
{

  public CountryView()
  {
    Grid<Country> userGrid = new Grid<>();
    Button addButton = new Button("ADD");
    Button deleteButton = new Button("DELETE");
    Button updateButton = new Button("UPDATE");

    HorizontalLayout vl1 = new HorizontalLayout(addButton, deleteButton, updateButton);
    VerticalLayout hl1 = new VerticalLayout(userGrid, vl1);

    add(hl1);

  }

  @Override
  public String getButtonText()
  {
    return "Country";
  }

  @Override
  public Icon getIcon()
  {
    return VaadinIcon.AIRPLANE.create();
  }
}
