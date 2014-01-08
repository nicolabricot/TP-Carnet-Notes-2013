/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ensisa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
@Stateless
public class ApplicationBean implements ApplicationBeanLocal {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public Category createCategory(Category category) {
        em.persist(category);
        return category;
    }

    @Override
    public List<Category> listAllCategory() {
        Query query = em.createQuery("SELECT c FROM Category c ORDER BY c.name ASC");
        return query.getResultList();
    }

    @Override
    public Note createNote(Note note, Long categoryID) {
        Query query = em.createQuery("Select c FROM Category c WHERE c.id = :id");
        query.setParameter("id", categoryID);
        Category category = (Category) query.getSingleResult();
        category.getNotes().add(note);
        return note;
    }

    @Override
    public Note getNote(Long noteID) {
        Query query = em.createQuery("Select n FROM Note n WHERE n.id = :id");
        query.setParameter("id", noteID);
        return (Note) query.getSingleResult();
    }

    @Override
    public Category getCategory(Long categoryID) {
        return em.find(Category.class, categoryID);
    }

}
