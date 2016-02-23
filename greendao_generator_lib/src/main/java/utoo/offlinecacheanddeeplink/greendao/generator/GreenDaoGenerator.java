package utoo.offlinecacheanddeeplink.greendao.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "utoo.offlinecacheanddeeplink");
        //Create table "Label" 新建數據庫的表,叫Label
        addUser(schema);
        addUserRole(schema);
        addQuestionData(schema);
        addSubjectData(schema);
        addRegionData(schema);
        //Generate DAO Class to the Android project
        new DaoGenerator().generateAll(schema, "../CacheLink/src-gen");
    }

    private static void addUser(Schema schema){
        Entity note = schema.addEntity("User");
        //Add table columns 定義表的欄
        note.addLongProperty("id").unique().notNull();
        note.addStringProperty("gender");
        note.addStringProperty("name"); //Name should be a json object containning first and last
        note.addStringProperty("email");
        note.addStringProperty("username");
        note.addLongProperty("registered");
        note.addLongProperty("dob");
        note.addStringProperty("school");
        note.addStringProperty("country_code");
        note.addStringProperty("phone");
        note.addStringProperty("profile_pic_url");
        note.addStringProperty("role");
        note.addDoubleProperty("rating");
        note.addDoubleProperty("rating_total");
    }
    private static void addUserRole(Schema schema){
        Entity note = schema.addEntity("UserRole");
        note.addLongProperty("id").unique().notNull();
        note.addStringProperty("name");
    }

    private static void addQuestionData(Schema schema){
        Entity note = schema.addEntity("QuestionData");
        note.addLongProperty("id").unique().notNull();
        note.addStringProperty("asked_by");//a simplified user data represent the less data needed
        note.addStringProperty("description");
        note.addStringProperty("status");
        note.addLongProperty("user_id");
        note.addLongProperty("answer_tutor_id");
        note.addStringProperty("answered_by");//a simplified user data represent the less data needed
        note.addStringProperty("created_at");//why using full yyyy-MM-dd here other then timestamp? for timezone? maybe.umm.
        note.addStringProperty("subject");
        note.addStringProperty("picture_url");
        note.addDoubleProperty("user_rating");
    }

    private static void addSubjectData(Schema schema){
        Entity note = schema.addEntity("SubjectData");
        note.addLongProperty("id").unique().notNull();
        note.addStringProperty("abbr");
        note.addStringProperty("description");
        note.addStringProperty("region"); //region object
    }

    private static void addRegionData(Schema schema){
        Entity note = schema.addEntity("RegionData");
        note.addLongProperty("id").unique().notNull();
        note.addStringProperty("name");
        note.addStringProperty("full_name");
    }
}
