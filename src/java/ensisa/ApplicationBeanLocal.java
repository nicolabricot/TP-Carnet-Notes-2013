/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ensisa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nicolas Devenet <nicolas@devenet.info>
 */
@Local
public interface ApplicationBeanLocal {
    
    Category createCategory(Category category);
    List<Category> listAllCategory();
    Category getCategory(Long categoryID);
    
    Note createNote(Note note, Long categoryID);
    Note getNote(Long noteID);
    
}
