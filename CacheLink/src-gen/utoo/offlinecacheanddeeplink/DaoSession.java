package utoo.offlinecacheanddeeplink;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import utoo.offlinecacheanddeeplink.User;
import utoo.offlinecacheanddeeplink.UserRole;
import utoo.offlinecacheanddeeplink.QuestionData;
import utoo.offlinecacheanddeeplink.SubjectData;
import utoo.offlinecacheanddeeplink.RegionData;

import utoo.offlinecacheanddeeplink.UserDao;
import utoo.offlinecacheanddeeplink.UserRoleDao;
import utoo.offlinecacheanddeeplink.QuestionDataDao;
import utoo.offlinecacheanddeeplink.SubjectDataDao;
import utoo.offlinecacheanddeeplink.RegionDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig userRoleDaoConfig;
    private final DaoConfig questionDataDaoConfig;
    private final DaoConfig subjectDataDaoConfig;
    private final DaoConfig regionDataDaoConfig;

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;
    private final QuestionDataDao questionDataDao;
    private final SubjectDataDao subjectDataDao;
    private final RegionDataDao regionDataDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        userRoleDaoConfig = daoConfigMap.get(UserRoleDao.class).clone();
        userRoleDaoConfig.initIdentityScope(type);

        questionDataDaoConfig = daoConfigMap.get(QuestionDataDao.class).clone();
        questionDataDaoConfig.initIdentityScope(type);

        subjectDataDaoConfig = daoConfigMap.get(SubjectDataDao.class).clone();
        subjectDataDaoConfig.initIdentityScope(type);

        regionDataDaoConfig = daoConfigMap.get(RegionDataDao.class).clone();
        regionDataDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        userRoleDao = new UserRoleDao(userRoleDaoConfig, this);
        questionDataDao = new QuestionDataDao(questionDataDaoConfig, this);
        subjectDataDao = new SubjectDataDao(subjectDataDaoConfig, this);
        regionDataDao = new RegionDataDao(regionDataDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(UserRole.class, userRoleDao);
        registerDao(QuestionData.class, questionDataDao);
        registerDao(SubjectData.class, subjectDataDao);
        registerDao(RegionData.class, regionDataDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        userRoleDaoConfig.getIdentityScope().clear();
        questionDataDaoConfig.getIdentityScope().clear();
        subjectDataDaoConfig.getIdentityScope().clear();
        regionDataDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserRoleDao getUserRoleDao() {
        return userRoleDao;
    }

    public QuestionDataDao getQuestionDataDao() {
        return questionDataDao;
    }

    public SubjectDataDao getSubjectDataDao() {
        return subjectDataDao;
    }

    public RegionDataDao getRegionDataDao() {
        return regionDataDao;
    }

}