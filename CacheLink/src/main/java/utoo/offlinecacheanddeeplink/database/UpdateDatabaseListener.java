package utoo.offlinecacheanddeeplink.database;

/**
 * Created by youtoolaw on 3/8/15.
 */
public interface UpdateDatabaseListener {
        void onFinish(long id);
        void onError();

}
