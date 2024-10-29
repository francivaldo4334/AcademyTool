package br.com.pwrftctrl.core.utils

import androidx.compose.runtime.Composable
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserX
class Vectors() {
    val ic_search
        @Composable
        get() = R.getVector("ic_search.svg")//Search

    val ic_checked
        @Composable
        get() = R.getVector("ic_check.svg")//Check
    
    val ic_check_check
        @Composable
        get() = R.getVector("ic_check_check.svg")//CheckCheck

    val ic_profile_add
        @Composable
        get() = R.getVector("ic_user_plus.svg")//UserPlus

    val ic_no_money
        @Composable
        get() = R.getVector("ic_bookmark_x.svg")//BookMarked

    val ic_money
        @Composable
        get() = R.getVector("ic_bookmark_check.svg")//BookmarkCheck
}
