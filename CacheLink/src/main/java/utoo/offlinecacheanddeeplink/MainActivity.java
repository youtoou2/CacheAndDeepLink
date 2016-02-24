package utoo.offlinecacheanddeeplink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import utoo.offlinecacheanddeeplink.fragment.ProfileCacheCheckFragment;
import utoo.offlinecacheanddeeplink.fragment.QuestionCacheCheckFragment;

public class MainActivity extends AppCompatActivity {
    public static String ERROR_NUM = "ERROR_NUM";

    private String[] mTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ERROR_TYPE error_type;

    public enum ERROR_TYPE{
        NORMAL,
        INVAILD_DEEPLINK;

        public static ERROR_TYPE from(int i){
            switch (i){
                case 0:
                    return NORMAL;
                case 1:
                    return INVAILD_DEEPLINK;
                default:
                    return null;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if(intent!=null && intent.getExtras()!=null) {
            error_type = ERROR_TYPE.from(intent.getExtras().getInt(ERROR_NUM));
        }
        mTitles = getResources().getStringArray(R.array.drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.item_drawer_list, mTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    protected void onStart() {
        super.onStart();
        errorNumHandler();
        selectItem(0);
    }

    private void errorNumHandler(){
        if(error_type!=null){
            switch (error_type){
                case INVAILD_DEEPLINK:
                    Toast.makeText(this,"Invaild deep link URI",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new QuestionCacheCheckFragment();
                break;
            case 1:
                fragment = new ProfileCacheCheckFragment();
                break;
            default:
                fragment = new QuestionCacheCheckFragment();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        if(getActionBar()!=null) {
            getActionBar().setTitle(title);
        }else{
            super.setTitle(title);
        }
    }
}
