/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.car.setupwizardlib.util;

import android.app.Activity;
import android.view.View;

import androidx.core.util.Preconditions;

/** Utilities to aid in UI for car setup wizard flow. */
public final class CarSetupWizardUiUtils {
    private static final String TAG = CarSetupWizardUiUtils.class.getSimpleName();

    /** Hide system UI */
    public static void hideSystemUI(Activity activity) {
        maybeHideSystemUI(activity);
    }

    /** Hide system UI
     * @deprecated Use {@code hideSystemUI}
     **/
    @Deprecated
    public static void maybeHideSystemUI(Activity activity) {
        Preconditions.checkNotNull(activity);

        // See https://developer.android.com/training/system-ui/immersive#EnableFullscreen
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private CarSetupWizardUiUtils() {
    }
}
