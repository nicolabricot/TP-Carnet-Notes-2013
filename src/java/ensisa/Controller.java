/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ensisa;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
@ManagedBean
@SessionScoped
public class Controller {

    @EJB
    private ApplicationBeanLocal appBean;
    private Category category = new Category();
    private Note note = new Note();

    public Category getCategory() {
        return category;
    }

    public Note getNote() {
        return note;
    }

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    public String doCreateCategory() {
        category = new Category();
        return "createCategory.xhtml";
    }

    public String doAddCategory() {
        category = appBean.createCategory(category);
        return "index.xhtml";
    }

    public List<Category> getCategories() {
        return appBean.listAllCategory();
    }

    public String doCreateNote(Long categoryID) {
        note = new Note();
        category = appBean.getCategory(categoryID);
        return "createNote.xhtml";
    }

    public String doAddNote() {
        note = appBean.createNote(note, category.getId());
        return "index.xhtml";
    }
    
    public String doShowNote(Long id) {
        note = appBean.getNote(id);
        return "note.xhtml";
    }
}
