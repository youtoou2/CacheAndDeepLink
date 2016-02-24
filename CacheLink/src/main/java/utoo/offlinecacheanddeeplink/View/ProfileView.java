package utoo.offlinecacheanddeeplink.View;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import utoo.offlinecacheanddeeplink.R;
import utoo.offlinecacheanddeeplink.UserDao;
import utoo.offlinecacheanddeeplink.Utils.AppLog;
import utoo.offlinecacheanddeeplink.database.GreenDaoHelper;
import utoo.offlinecacheanddeeplink.module.UserExtend;

/**
 * 77777777777777777777777777777777777777777777777777777777777777777777777777777777
 * 77777777777777777777777777777777777777777777777777777777777777777777777777777777
 * 7777777777777777777777777..~~~~~~,..77777777777777777777777777777777777777777777
 * 777777777777777777777I.~~~~~~~~~~~~~~~.?777777777..~~~~~~~:.77777777777777777777
 * 7777777777777777777~.~~~~~~~~~~~~~~~~~~~=.777.~~~~~~~~~~~~~~~.777777777777777777
 * 777777777777777777.~~~~~~~~~~~~~~~~~~~~~~~,~~~~~~~~~~~~~~~~~~~~.7777777777777777
 * 7777777777777777:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.777777777777777
 * 777777777777777.~~~~~~~~~~~~~....,....~~~~~~,~~~~~~~~~~~~~~~~~~~~I77777777777777
 * 77777777777777.~~~~~~~~~~.~~~~~~~~~~~~~~:.~~~.~~~~~~~~~~~~~~~~~~~.77777777777777
 * 7777777777777.~~~~~~~~,~~~~~~~~~~~~~~~~~~~~~..:...:~~~~~~~~~~~....77777777777777
 * 777777777777~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~.7777777777
 * 777777777777~~~~~~~~~~~~~~~~~~~~~~~~~~.......~~.~~~~~~~~~~~~~~~~~~~~~~~~.7777777
 * 77777777777.~~~~~~~~~~~~~~~~~~~~,.~~~~~~:,:~~~~~~.~~~~~~.,~~~~~~~~~~~~~,.+777777
 * 7777777777.~~~~~~~~~~~~~~~~~~.~~~~,.~~~~~~~~~~~~..~:~~~~~:..~~~~~~~~~~~..~~.7777
 * 7777777:~~.~~~~~~~~~~~~~~~,~~~~.~~~~~~~~~~~~~~~~~~~:,~~~~~~~~~~~~~~~~~~~~~~.7777
 * 777777~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~:,..,~~.~~~~~~~~~:...,,.....:~~.77
 * 7777,~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~:..7 77777777777,~.,777777........777777.77
 * 777.~~~~~~~~~~~~~~~~~.~~~~~~~~~~..?77I.I7.....~777777 77777777..77 .....777777I7
 * 77,~~~~~~~~~~~~~~~~~~~~~~~.777777777,...?..I7... 777~77777777......:7 ...77  .77
 * 77.~~~~~~~~~~~~~~~~~~~~~~~~~,7 77777....... 7I..=7I.. 7777777...7I..:....77..777
 * 7.~~~~~~~~~~~~~~~~~~~~~~~~:~~~~:.+77....7.......~~~~.~~~~:..:.........~~~~~.7777
 * .~~~~~~~~~~~~~~~~~~~~~~~~~~~~,:~~~~~~~~~~~~~~~~~~,.~~~~~~~~~~~~~~~~~~~~~~=777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~,..,~~~:...:~~~.~~~~~~~~~~~~~~~~~~~~~~~.7777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~~.,777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~.~~~~~~~~...777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~,,~~~~~~~~~~~~~~~~~~~.~~~~~~~~,77777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.77777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.7777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~7777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:777777
 * ~~~~~~~~~~~~~~~~~~~~~~~.,~~~~~~~...:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~,:.77777
 * ~~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~...~~~~~~~~~~~~~~~~~~~~~~~~~,.~~~~~77777
 * ~~~~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~~~~~~~~~=:.............:~~~~~~~~~~.77777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:..~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.7777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~,...,:~~~~~~~~~~~~~~:,....~~=77777777
 * ~~~~~~~~~~~~~~~~~~~~~,..........,~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:77777777
 * ~~~~~~~~~~~~~~~~~.~~~~~~~~~~~~~~~~~~~,..~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:777777777
 * .~~~~~~~~~~~~~~~~~~.:~~~~~~~~~~~~~~~~~~~~~~~~~~~~:,.......,:~~~~~~:..77777777777
 * 7.:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.7777777777777777
 * ~~.~..~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.I77777777777777777
 * ~~~~.~~~..~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.77777777777777777777
 * ~~~~~~~.~~~~~:..~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~,=77777777777777777777777
 * ~~~~~~~~~~:.,~~~~~~~~:.....:~~~~~~~~~~~~~~~~~~~,....7777777777777777777777777777
 * ~~~~~~~~~~~~~~~~,.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.~~~:77777777777777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~,...,:~~~~~~~~~~:,....~~~~~~~~~~.77777777777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.777777777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.7777777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:.,77777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~..7777777777777777
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~....77777777777777
 * Created by youtoolaw on 24/2/16.
 */
public class ProfileView extends FrameLayout {
    private Context mContext;
    //layout
    private TextView profile_id,profile_gender,profile_name,profile_email,profile_username,
            profile_reg_time,profile_dob,profile_school,profile_mobile,profile_role,profile_rate,profile_rate_total;
    private ImageView profile_image;

    public ProfileView(Context context) {
        super(context);
        init(context);
    }
    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context mContext){
        this.mContext = mContext;
        inflate(getContext(), R.layout.view_profile_layout, this);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflateLayout();
    }
    private void inflateLayout(){
        profile_id = (TextView)findViewById(R.id.profile_id);
        profile_gender = (TextView)findViewById(R.id.profile_gender);
        profile_name = (TextView)findViewById(R.id.profile_name);
        profile_email = (TextView)findViewById(R.id.profile_email);
        profile_username = (TextView)findViewById(R.id.profile_username);
        profile_reg_time = (TextView)findViewById(R.id.profile_reg_time);
        profile_dob = (TextView)findViewById(R.id.profile_dob);
        profile_school = (TextView)findViewById(R.id.profile_school);
        profile_mobile = (TextView)findViewById(R.id.profile_mobile);
        profile_role = (TextView)findViewById(R.id.profile_role);
        profile_rate = (TextView)findViewById(R.id.profile_rate);
        profile_rate_total = (TextView)findViewById(R.id.profile_rate_total);
        profile_image = (ImageView)findViewById(R.id.profile_image);
    }
    public void setup(long id) {
        initViewBackground(id);
    }

    private void initViewBackground(long questionID){
        new AsyncInitViewTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,questionID);
    }

    private class AsyncInitViewTask extends AsyncTask<Long, Void, Boolean> {
        public AsyncInitViewTask() {
            super();
        }
        private UserExtend userExtend;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Long... params) {
            long id = params[0];
            UserDao mUserDao = GreenDaoHelper.getmUserDao();
            userExtend = new UserExtend(mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(id)).unique());
            if(userExtend!=null){
                return true;
            }else{
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean == true) {
                initView(userExtend);
            }
        }
    }

    private void initView(UserExtend dataExtend){
        AppLog.d("initView");
        dataExtend.assignView(mContext, profile_id,profile_gender,profile_name,profile_email,profile_username,
                profile_reg_time,profile_dob,profile_school,profile_mobile,profile_role,profile_rate,profile_rate_total,profile_image);
    }
}
