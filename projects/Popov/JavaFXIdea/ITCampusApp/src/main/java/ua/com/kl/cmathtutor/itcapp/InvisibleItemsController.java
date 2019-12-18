package ua.com.kl.cmathtutor.itcapp;

import javafx.scene.Node;
import ua.com.kl.cmathtutor.itcapp.component.UserTileComponent;

/**
 * Specific controller, which is responsible for binding <code>visible</code>
 * and <code>managed</code> properties over specified iterable of Nodes, so that when any of the specified Node
 * is invisible it will not take any place within parent view container.
 * For example of usage see {@link UserTileComponent}
 * @author Hryhorii_Popov
 *
 */
public abstract class InvisibleItemsController {

    /**
     * Method to call within <code>init</code> method of children controller
     */
    protected void bindVisibleProperties() {
	for (Node node : getAllNodesToBindVisibleProperty()) {
	    node.setManaged(node.isVisible());
	    node.managedProperty().bindBidirectional(node.visibleProperty());
	}
    }

    /**
     * 
     * @return the {@link java.lang.Iterable} of nodes to bind properties
     */
    protected abstract Iterable<? extends Node> getAllNodesToBindVisibleProperty();
}
