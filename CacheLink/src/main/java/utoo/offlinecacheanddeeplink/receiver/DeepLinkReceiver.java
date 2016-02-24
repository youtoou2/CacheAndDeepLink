package utoo.offlinecacheanddeeplink.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.airbnb.deeplinkdispatch.DeepLinkActivity;

import utoo.offlinecacheanddeeplink.Utils.AppLog;

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
public class DeepLinkReceiver extends BroadcastReceiver {
    private static final String TAG = DeepLinkReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        //for logging
        String deepLinkUri = intent.getStringExtra(DeepLinkActivity.EXTRA_URI);
        if (intent.getBooleanExtra(DeepLinkActivity.EXTRA_SUCCESSFUL, false)) {
            AppLog.d( "Success deep linking: " + deepLinkUri);
        } else {
            String errorMessage = intent.getStringExtra(DeepLinkActivity.EXTRA_ERROR_MESSAGE);
            AppLog.d( "Error deep linking: " + deepLinkUri + " with error message +" + errorMessage);
        }
    }
}