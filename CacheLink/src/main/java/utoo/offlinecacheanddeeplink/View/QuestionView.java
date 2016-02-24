package utoo.offlinecacheanddeeplink.View;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import utoo.offlinecacheanddeeplink.QuestionDataDao;
import utoo.offlinecacheanddeeplink.R;
import utoo.offlinecacheanddeeplink.Utils.AppLog;
import utoo.offlinecacheanddeeplink.database.GreenDaoHelper;
import utoo.offlinecacheanddeeplink.module.QuestionDataExtend;

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
public class QuestionView extends FrameLayout {
    private Context mContext;
    //layout
    private TextView quest_id,quest_student_id,quest_student_name,quest_tutor_id,quest_tutor_name,
            quest_desc,quest_status,quest_create_time,quest_subject,quest_rating;
    private ImageView quest_image;

    public QuestionView(Context context) {
        super(context);
        init(context);
    }
    public QuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public QuestionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context mContext){
        this.mContext = mContext;
        inflate(getContext(), R.layout.view_question_layout, this);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflateLayout();
    }
    private void inflateLayout(){
        quest_id = (TextView)findViewById(R.id.quest_id);
        quest_student_id = (TextView)findViewById(R.id.quest_student_id);
        quest_student_name = (TextView)findViewById(R.id.quest_student_name);
        quest_tutor_id = (TextView)findViewById(R.id.quest_tutor_id);
        quest_tutor_name = (TextView)findViewById(R.id.quest_tutor_name);
        quest_desc = (TextView)findViewById(R.id.quest_desc);
        quest_status = (TextView)findViewById(R.id.quest_status);
        quest_create_time = (TextView)findViewById(R.id.quest_create_time);
        quest_subject = (TextView)findViewById(R.id.quest_subject);
        quest_rating = (TextView)findViewById(R.id.quest_rating);
        quest_image = (ImageView)findViewById(R.id.quest_image);
    }
    public void setup(long questionID) {
        initViewBackground(questionID);
    }

    private void initViewBackground(long questionID){
        new AsyncInitViewTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,questionID);
    }

    private class AsyncInitViewTask extends AsyncTask<Long, Void, Boolean> {
        public AsyncInitViewTask() {
            super();
        }
        private QuestionDataExtend questionDataExtend;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Long... params) {
            long questID = params[0];
            QuestionDataDao mQuestionDataDao = GreenDaoHelper.getmQuestionDataDao();
            questionDataExtend = new QuestionDataExtend(mQuestionDataDao.queryBuilder().where(QuestionDataDao.Properties.Id.eq(questID)).unique());
            if(questionDataExtend!=null){
                return true;
            }else{
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean == true) {
                initView(questionDataExtend);
            }
        }
    }

    private void initView(QuestionDataExtend dataExtend){
        AppLog.d("initView");
        dataExtend.assignView(mContext,quest_id,quest_student_id,quest_student_name,quest_tutor_id,
                quest_tutor_name,quest_desc,quest_status,quest_create_time,quest_subject,quest_rating,
                quest_image);
    }
}
