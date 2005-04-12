/*
 * Created on Jul 22, 2004
 *
 * @author Fabio Zadrozny
 */
package org.python.pydev.editor.actions.codefolding;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.python.pydev.editor.actions.PyAction;
import org.python.pydev.editor.actions.PySelection;
import org.python.pydev.editor.codefolding.PyProjectionAnnotation;

/**
 * @author Fabio Zadrozny
 */
public class PyCollapseAll extends PyAction {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action) {
		PySelection ps = new PySelection ( getTextEditor ( ) );

		ProjectionAnnotationModel model = (ProjectionAnnotationModel) getTextEditor ( )
                .getAdapter(ProjectionAnnotationModel.class);
        
        if (model != null) {
            ArrayList collapsed = new ArrayList();
            //put annotations in array list.
            Iterator iter = model.getAnnotationIterator();
            while (iter != null && iter.hasNext()) {
                PyProjectionAnnotation element = (PyProjectionAnnotation) iter.next();
                Position position = model.getPosition(element);
                
                model.collapse(element);
            }
            
        }
    }
}
