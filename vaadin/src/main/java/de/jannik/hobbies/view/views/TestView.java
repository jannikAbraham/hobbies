package de.jannik.hobbies.view.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
@Route("/")
@PageTitle("Test view")
public class TestView extends VerticalLayout
{

  public TestView()
  {
    add("Test view");
  }
}
