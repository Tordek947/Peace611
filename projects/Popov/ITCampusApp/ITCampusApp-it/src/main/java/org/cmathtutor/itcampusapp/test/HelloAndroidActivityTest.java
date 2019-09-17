package org.cmathtutor.itcampusapp.test;

import android.test.ActivityInstrumentationTestCase2;
import org.cmathtutor.itcampusapp.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    public HelloAndroidActivityTest() {
        super(HelloAndroidActivity.class); 
    }

    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
    }
}

