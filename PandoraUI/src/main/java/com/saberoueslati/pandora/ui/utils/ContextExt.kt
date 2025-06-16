package com.saberoueslati.pandora.ui.utils

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import androidx.core.net.toUri
import com.saberoueslati.pandora.ui.R

/**
 * Opens the system Settings screen for the current application, allowing the user to manage permissions.
 *
 * If [revokedPermissions] is not empty, a [Toast] message is shown prompting the user to grant
 * the listed permissions via settings. The permissions will be displayed without the `android.permission.` prefix.
 *
 * @param revokedPermissions Optional list of revoked permissions to include in the toast message.
 */
fun Context.goToSettings(revokedPermissions: List<String> = emptyList()) {
    if (revokedPermissions.isNotEmpty()) {
        Toast.makeText(
            this,
            this.getString(
                R.string.provide_permissions_via_settings,
                revokedPermissions.joinToString(
                    transform = { it.replace("android.permission.", "") },
                    separator = ", "
                )
            ),
            Toast.LENGTH_LONG
        ).show()
    }

    startActivity(
        Intent().apply {
            action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            data = "package:$packageName".toUri()
        }
    )
}
