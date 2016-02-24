package utoo.offlinecacheanddeeplink.module;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import utoo.offlinecacheanddeeplink.User;
import utoo.offlinecacheanddeeplink.UserRole;
import utoo.offlinecacheanddeeplink.Utils.TimeHelper;

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
public class UserExtend{
    private long id;
    private String gender;
    private Name name;
    private String email;
    private String username;
    private Long registered;
    private Long dob;
    private String school;
    private String country_code;
    private String phone;
    private String profile_pic_url;
    private Double rating;
    private Double rating_total;
    private UserRole role;

    public UserExtend(User data){
        Gson gson = new Gson();
        this.id = data.getId();
        this.gender = data.getGender();
        this.name = gson.fromJson(data.getName(),Name.class);
        this.email = data.getEmail();
        this.username = data.getUsername();
        this.registered = data.getRegistered();
        this.dob = data.getDob();
        this.school = data.getSchool();
        this.country_code = data.getCountry_code();
        this.phone = data.getPhone();
        this.profile_pic_url = data.getProfile_pic_url();
        this.rating = data.getRating();
        this.rating_total = data.getRating_total();
        this.role = gson.fromJson(data.getRole(),UserRole.class);;
    }

    public String getRole() {
        Gson gson = new Gson();
        return gson.toJson(role);
    }
    public UserRole getRoleObject(){
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        Gson gson = new Gson();
        return gson.toJson(name);
    }
    public Name getNameObject(){
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRegistered() {
        return registered;
    }

    public void setRegistered(Long registered) {
        this.registered = registered;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating_total() {
        return rating_total;
    }

    public void setRating_total(Double rating_total) {
        this.rating_total = rating_total;
    }

    public String getFormattedDOB(){
        return TimeHelper.getFormattedyyyyMMMdd(getDob());
    }

    public String getFormattedRegTime(){
        return TimeHelper.getFormattedyyyyMMMdd(getRegistered());
    }
    public User readyDB(){
        User data = new User(
                getId(),
                getGender(),
                getName(),
                getEmail(),
                getUsername(),
                getRegistered(),
                getDob(),
                getSchool(),
                getCountry_code(),
                getPhone(),
                getProfile_pic_url(),
                getRole(),
                getRating(),
                getRating_total());
        return data;
    }

    public void assignView(Context mContext, TextView profile_id, TextView profile_gender, TextView profile_name, TextView profile_email,
                           TextView profile_username, TextView profile_reg_time, TextView profile_dob, TextView profile_school,
                           TextView profile_mobile, TextView profile_role, TextView profile_rate, TextView profile_rate_total,
                           ImageView profile_image){
        profile_id.setText(getId()+"");
        profile_gender.setText(getGender());
        profile_name.setText(getNameObject().getFirst()+" "+getNameObject().getLast());
        profile_email.setText(getEmail());
        profile_username.setText(getUsername());
        profile_reg_time.setText(getFormattedRegTime());
        profile_dob.setText(getFormattedDOB());
        profile_school.setText(getSchool());
        profile_mobile.setText(getCountry_code()+"-"+getPhone());
        profile_role.setText(getRoleObject().getName());
        profile_rate.setText(getRating()+"");
        profile_rate_total.setText(getRating_total()+"");
        Picasso.with(mContext).load(getProfile_pic_url()).into(profile_image);
    }
}
