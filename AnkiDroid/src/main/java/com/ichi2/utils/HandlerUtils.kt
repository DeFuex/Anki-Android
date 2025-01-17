/****************************************************************************************
 *                                                                                      *
 * Copyright (c) 2021 Shridhar Goel <shridhar.goel@gmail.com>                           *
 *                                                                                      *
 * This program is free software; you can redistribute it and/or modify it under        *
 * the terms of the GNU General Public License as published by the Free Software        *
 * Foundation; either version 3 of the License, or (at your option) any later           *
 * version.                                                                             *
 *                                                                                      *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY      *
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A      *
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.             *
 *                                                                                      *
 * You should have received a copy of the GNU General Public License along with         *
 * this program.  If not, see <http://www.gnu.org/licenses/>.                           *
 ****************************************************************************************/

package com.ichi2.utils

import android.os.Handler
import android.os.Looper

object HandlerUtils {

    /**
     * Add runnable to message queue and run on the thread to which this handler is attached.
     * This will run on the main thread if called from the main thread.
     *
     * @param function The function which needs to be executed.
     */
    fun executeFunctionUsingHandler(function: () -> Unit) {
        Handler(Looper.getMainLooper()).post {
            function()
        }
    }

    /**
     * Execute a function after a certain delay.
     * This will run on the main thread if called from the main thread.
     *
     * @param function The function which needs to be executed.
     * @param time The time by which the function execution needs to be delayed.
     */
    fun executeFunctionWithDelay(function: () -> Unit, time: Long) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                function()
            },
            time
        )
    }
}
