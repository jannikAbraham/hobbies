package de.jannik.hobbies.view.views.abstracts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.jannik.hobbies.service.EntityService;

import java.util.List;

@UIScope
@SpringComponent
public abstract class VaadinCrud<Entity> extends VerticalLayout
{
  private Grid<Entity> grid;
  private EntityDialog<Entity> entityDialog;

  private EntityService<Entity> service;
  private Class<Entity> clazz;

  public VaadinCrud(EntityService<Entity> service, Class<Entity> clazz)
  {
    init(service,clazz,true);
  }

  public VaadinCrud(EntityService<Entity> service, Class<Entity> clazz,Boolean autoCreateColumns)
  {
    init(service,clazz,autoCreateColumns);
  }

  private void init(EntityService<Entity> service, Class<Entity> clazz,Boolean autoCreateColumns)
  {
    this.service = service;
    this.clazz = clazz;

    grid = new Grid<>(clazz, autoCreateColumns);
    grid.setItems(service.findAll());

    handleEntityDialog();
    add(grid, getActionsButtons());
  }

  private HorizontalLayout getActionsButtons()
  {
    Button newButton = new Button("New", e -> createNewEntity());
    Button deleteButton = new Button("Delete", e -> deleteEntity());
    Button editButton = new Button("Edit", e -> updateEntity());

    deleteButton.setEnabled(false);
    editButton.setEnabled(false);

    grid.addSelectionListener(e -> {
      if (e.isFromClient() && e.getFirstSelectedItem().isPresent())
      {
        deleteButton.setEnabled(true);
        editButton.setEnabled(true);
      }
      else
      {
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
      }
    });

    return new HorizontalLayout(newButton, deleteButton, editButton);
  }

  private void handleEntityDialog()
  {
    entityDialog = new EntityDialog<Entity>(service, clazz)
    {
      @Override
      protected List<Component> getComponentFields(Binder<Entity> binder)
      {
        return getFields(binder);
      }

      @Override
      public void entityWasSaved(Entity updatedEntity)
      {
        refreshData();
      }

      @Override
      public Entity getNewEntity()
      {
        return VaadinCrud.this.getNewEntity();
      }
    };
  }

  private void createNewEntity()
  {
    entityDialog.setEntity(getNewEntity());
    entityDialog.open();
  }

  private void deleteEntity()
  {
    service.delete(grid.asSingleSelect().getValue());
    refreshData();
  }

  private void updateEntity()
  {
    entityDialog.setEntity(grid.asSingleSelect().getValue());
    entityDialog.open();
  }

  public Grid<Entity> getGrid()
  {
    return grid;
  }

  private void refreshData()
  {
    grid.setItems(service.findAll());
  }

  public abstract Entity getNewEntity();

  public abstract List<Component> getFields(Binder<Entity> binder);
}
