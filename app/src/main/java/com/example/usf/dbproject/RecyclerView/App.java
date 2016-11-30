package com.example.usf.dbproject.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;

/**
 * Created by Abed on 30/11/2016.
 */

public class App extends Application {

        private static Context mContext;

        public static Context getContext() {
            return mContext;
        }

        public static void setContext(Context mContext1) {
            mContext = mContext1;
        }
}
