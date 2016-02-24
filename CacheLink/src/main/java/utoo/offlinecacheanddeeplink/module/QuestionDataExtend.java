package utoo.offlinecacheanddeeplink.module;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import utoo.offlinecacheanddeeplink.QuestionData;

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
 * Created by youtoolaw on 23/2/16.
 */
public class QuestionDataExtend {
    private UserExtend asked_by;
    private UserExtend answered_by;
    private SubjectExtend subject;
    private long id;
    private String description;
    private String status;
    private Long user_id;
    private Long answer_tutor_id;
    private String created_at;
    private String picture_url;
    private Double user_rating;

    public QuestionDataExtend(QuestionData data){
        Gson gson = new Gson();
        this.asked_by = gson.fromJson(data.getAsked_by(),UserExtend.class);
        this.answered_by = gson.fromJson(data.getAnswered_by(),UserExtend.class);
        this.subject = gson.fromJson(data.getSubject(),SubjectExtend.class);
        this.id = data.getId();
        this.description = data.getDescription();
        this.status = data.getStatus();
        this.user_id = data.getUser_id();
        this.answer_tutor_id = data.getAnswer_tutor_id();
        this.created_at = data.getCreated_at();
        this.picture_url = data.getPicture_url();
        this.user_rating = data.getUser_rating();
    }

    public String getAsked_by() {
        Gson gson = new Gson();
        return gson.toJson(asked_by);
    }

    public void setAsked_by(UserExtend asked_by) {
        this.asked_by = asked_by;
    }

    public String getAnswered_by() {
        Gson gson = new Gson();
        return gson.toJson(answered_by);
    }

    public void setAnswered_by(UserExtend answered_by) {
        this.answered_by = answered_by;
    }

    public String getSubject() {
        Gson gson = new Gson();
        return gson.toJson(subject);
    }

    public void setSubject(SubjectExtend subject) {
        this.subject = subject;
    }

    public UserExtend getAskedByObject(){
        return asked_by;
    }
    public UserExtend getAnsweredByObject(){
        return answered_by;
    }
    public SubjectExtend getSubjectObject(){
        return subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAnswer_tutor_id() {
        return answer_tutor_id;
    }

    public void setAnswer_tutor_id(Long answer_tutor_id) {
        this.answer_tutor_id = answer_tutor_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Double getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(Double user_rating) {
        this.user_rating = user_rating;
    }

    public QuestionData readyDB(){

        QuestionData data = new QuestionData(
                getId(),
                getAsked_by(),
                getDescription(),
                getStatus(),
                getUser_id(),
                getAnswer_tutor_id(),
                getAnswered_by(),
                getCreated_at(),
                getSubject(),
                getPicture_url(),
                getUser_rating());
        return data;
    }
    public void assignView(Context mContext,TextView quest_id,TextView quest_student_id,
                           TextView quest_student_name,TextView quest_tutor_id,TextView quest_tutor_name,
                           TextView quest_desc,TextView quest_status,TextView quest_create_time,
                           TextView quest_subject,TextView quest_rating, ImageView quest_image){
        quest_id.setText(getId()+"");
        quest_student_id.setText(getUser_id()+"");
        quest_student_name.setText(getAskedByObject().getUsername());
        quest_tutor_id.setText(getAnswer_tutor_id()+"");
        quest_tutor_name.setText(getAnsweredByObject().getUsername());
        quest_desc.setText(getDescription());
        quest_status.setText(getStatus());
        quest_create_time.setText(getCreated_at());
        quest_subject.setText(getSubjectObject().getDescription());
        quest_rating.setText(getUser_rating()+"");
        Picasso.with(mContext).load(getPicture_url()).into(quest_image);
    }
}
