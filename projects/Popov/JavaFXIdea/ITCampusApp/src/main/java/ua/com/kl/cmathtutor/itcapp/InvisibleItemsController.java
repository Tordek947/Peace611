package ua.com.kl.cmathtutor.itcapp;

import com.google.common.collect.Lists;
import javafx.scene.Node;

import javax.annotation.PostConstruct;

public abstract class InvisibleItemsController {

    protected void bindVisibleProperties() {
        for (Node node : getAllNodesToBindVisibleProperty()) {
            node.setManaged(node.isVisible());
            node.managedProperty().bindBidirectional(node.visibleProperty());
        }
    }

    protected abstract Iterable<? extends Node> getAllNodesToBindVisibleProperty();
}
