package controllers;

import entities.Pays;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import sessions.PaysFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.ColumnResizeEvent;

@Named("paysController")
@SessionScoped
public class PaysController implements Serializable {

    @EJB
    private sessions.PaysFacade ejbFacade;
    private List<Pays> items = null;
    private Pays selected;

    public PaysController() {
    }

    public void onResize(ColumnResizeEvent event) {
        FacesMessage msg = new FacesMessage("Column " + event.getColumn().getClientId() + " resized", "W:" + event.getWidth() + ", H:" + event.getHeight());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Pays getSelected() {
        return selected;
    }

    public void setSelected(Pays selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PaysFacade getFacade() {
        return ejbFacade;
    }

    public Pays prepareCreate() {
        selected = new Pays();
        initializeEmbeddableKey();
        return selected;
    }
    
    public List<Pays> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public void create() {
        try {
            selected = ejbFacade.findByNom(selected.getNom());
            if (selected != null) {
                JsfUtil.addSuccessMessage("Enregistrement déjà existant");
            } else {
                selected.setIdPays(ejbFacade.nextId());
                persist(PersistAction.CREATE, ResourceBundle.getBundle("/msg").getString("PaysCreated"));
                if (!JsfUtil.isValidationFailed()) {
                    items = null;    // Invalidate list of items to trigger re-query.
                }
            }

        } catch (Exception e) {
        }

    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/msg").getString("PaysUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/msg").getString("PaysDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msg").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/msg").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Pays getPays(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Pays> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Pays> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Pays.class)
    public static class PaysControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PaysController controller = (PaysController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "paysController");
            return controller.getPays(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pays) {
                Pays o = (Pays) object;
                return getStringKey(o.getIdPays());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Pays.class.getName()});
                return null;
            }
        }

    }

}
