/****************************************************************************************
 * Copyright (c) 2018 Mike Hardy <mike@mikehardy.net>                                   *
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

package com.ichi2.anki

import java.lang.Exception
import java.lang.StringBuilder
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest

open class TestUtils {
    /** get the MD5 checksum (in hex) for the given filename  */
    companion object {
        @JvmStatic
        @Throws(Exception::class)
        fun getMD5(filename: String?): String {
            val md = MessageDigest.getInstance("MD5")
            md.update(Files.readAllBytes(Paths.get(filename)))
            val hex = StringBuilder()
            for (b in md.digest()) {
                hex.append(String.format("%02x", b))
            }
            return hex.toString()
        }
    }
}
