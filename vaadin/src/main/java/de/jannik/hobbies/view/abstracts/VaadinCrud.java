package de.jannik.hobbies.view.abstracts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import de.jannik.hobbies.model.entity.User;
import de.jannik.hobbies.service.EntityService;

public abstract class VaadinCrud<T> extends VerticalLayout
{

  private final Button updateButton;
  private final Button deleteButton;
  private final Button addButton;
  private Grid<T> grid;
  private final EntityService<T> service;
  private EntityDialog<T> entityDialog;

  public VaadinCrud(EntityService<T> service)
  {
    this.service = service;

    addButton = new Button("ADD", e -> openNewDialog());
    deleteButton = new Button("DELETE", e -> deleteUser());
    updateButton = new Button("UPDATE", e -> updateUser());
    deleteButton.setEnabled(false);
    updateButton.setEnabled(false);
  }

  @Override
  protected void onAttach(AttachEvent attachEvent)
  {
    HorizontalLayout vl1 = new HorizontalLayout(addButton, deleteButton, updateButton);
    VerticalLayout hl1 = new VerticalLayout(grid, vl1);
    add(hl1);
  }

  private void openNewDialog()
  {
    T newEntity = createNewEntity();
    entityDialog.setEntity(newEntity);
    entityDialog.open();
  }

  protected abstract T createNewEntity();

  private void deleteUser()
  {
    service.delete(grid.asSingleSelect().getValue());
    refreshData();
  }

  private void updateUser()
  {
    entityDialog.setEntity(grid.asSingleSelect().getValue());
    entityDialog.open();
    refreshData();
  }

  private void refreshData()
  {
    grid.setItems(service.findAll());
  }

  protected void gridWasSelected(SelectionEvent<Grid<T>, T> e)
  {
    if (e.isFromClient() && e.getFirstSelectedItem().isPresent())
    {
      deleteButton.setEnabled(true);
      updateButton.setEnabled(true);
    }
    else
    {
      deleteButton.setEnabled(false);
      updateButton.setEnabled(false);
    }
  }

  protected void setGrid(Grid<T> grid)
  {
    this.grid = grid;
    grid.addSelectionListener(this::gridWasSelected);
  }

  protected void setEntityDialog(EntityDialog<T> entityDialog)
  {
    this.entityDialog = entityDialog;
  }
}
