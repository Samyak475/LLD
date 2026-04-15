import entities.User;
import managers.StoreManager;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentManager {
    List<User> userList;
    List<StoreManager>storeManagers;

    public VehicleRentManager() {
        this.userList = new ArrayList<>();
        this.storeManagers = new ArrayList<>();
    }

    public StoreManager getStore(int storeId) {
        return storeManagers.stream().filter(store -> store.getStoreId() == storeId).findFirst().get();
    }

    public User getUser(int userId) {
        return userList.get(userId);
    }

    public void addStore(StoreManager store) {
        storeManagers.add(store);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeStore(int storeId) {
        storeManagers.remove(storeId);
    }

    public void removeUser(int userId) {
        userList.remove(userId);
    }

}
