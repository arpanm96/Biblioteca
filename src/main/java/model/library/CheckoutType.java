package model.library;

import java.util.Collection;

/*
An enum containing the type of checkout being performed i.e checkout or return
*/

public enum  CheckoutType {
    CHECKOUT {
        @Override
        public void updateUserItemCheckoutList(Collection<Item> checkoutItemCollection, Item item) {
            checkoutItemCollection.add(item);
        }
    },
    RETURN {
        @Override
        public void updateUserItemCheckoutList(Collection<Item> checkoutItemCollection, Item item) {
            checkoutItemCollection.remove(item);
        }
    };
    abstract public void updateUserItemCheckoutList(Collection<Item> checkoutItemCollection, Item item);
}
