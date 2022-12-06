//package de.jannik.hobbies.view.views;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.spring.annotation.SpringComponent;
//import com.vaadin.flow.spring.annotation.UIScope;
//import de.jannik.hobbies.model.entity.Country;
//import de.jannik.hobbies.service.CountryService;
//import de.jannik.hobbies.service.EntityService;
//import de.jannik.hobbies.service.UserService;
//import de.jannik.hobbies.view.abstracts.VaadinCrud;
//import de.jannik.hobbies.view.abstracts.VaadinCrudTwo;
//import de.jannik.hobbies.view.abstracts.VaadinPage;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@SpringComponent
////@UIScope
////@PageTitle("country View")
////@Route(value = "Country", layout = AppView.class)
//public class CountryView extends VaadinCrudTwo<Country> implements VaadinPage
//{
//
//  public CountryView(EntityService<Country> service, Clas<Country> clazz)
//  {
//    super(new Country(),service, clazz);
//  }
//
//  @Override
//  public List<Component> getFields(Binder<Country> binder)
//  {
//    List<Component> componentList = new ArrayList<>();
//    //componentList.add();
//    return null;
//  }
//
//  @Override
//  public String getButtonText()
//  {
//    return "Country";
//  }
//
//  @Override
//  public Icon getIcon()
//  {
//    return VaadinIcon.AIRPLANE.create();
//  }
//}
//
////    this.countryService = countryService;
////    this.userService = userService;
////
////    Grid<Country> countryGrid = new Grid<>();
////    Button addButton = new Button("ADD");
////    Button deleteButton = new Button("DELETE");
////    Button updateButton = new Button("UPDATE");
////
////    countryGrid.addColumn(Country::getCode).setHeader("Country Code");
////    countryGrid.addColumn(Country::getId).setHeader("Username");
////
////    countryGrid.setItems(countryService.findAll());
////
////    CountryDialog addCountryDialog = new CountryDialog("Add country");
////    CountryDialog updateCountryDialog = new CountryDialog("Update Country");
////
////    addButton.addClickListener(e -> addCountryDialog.open());
////    updateButton.addClickListener(e -> updateCountryDialog.open());
////
////    HorizontalLayout vl1 = new HorizontalLayout(addButton, deleteButton, updateButton);
////    VerticalLayout hl1 = new VerticalLayout(countryGrid, vl1);
////
////    add(hl1);
////
////  }
////
////  @Override
////  public String getButtonText()
////  {
////    return "Country";
////  }
////
////  @Override
////  public Icon getIcon()
////  {
////    return VaadinIcon.AIRPLANE.create();
////  }
//
